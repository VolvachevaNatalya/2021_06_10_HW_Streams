package company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        String s = "cat";
        List<String> words = Arrays.asList("cat", "dragon", "zebra", "dog", "rabbit", "elephant", "bird", "pig");

        task1(n);
        task2(n);
        task3(n);
        task4(n);
        System.out.println("Task 5 " + ifContains(words, s));
    }

    //1. Есть лист строк, найти количество слов в листе, длина которых меньше n
    private static void task1(int n) {
        List<String> words = Arrays.asList("cat", "dragon", "zebra", "dog", "rabbit", "cat", "elephant", "bird", "cat", "pig");
        List<String> newWords = words
                .stream()
                .filter(s -> s.length() < n)
                .collect(Collectors.toList());
        System.out.println("Task 1 " + newWords.size());
    }

    //2. Есть лист строк, вернуть лист строк, длина которых меньше n, исключить повторения  //use .collect(Collectors.toList());
    private static void task2(int n) {
        List<String> words = Arrays.asList("cat", "dragon", "zebra", "dog", "rabbit", "elephant", "bird", "pig");
        List<String> newWords = words
                .stream()
                .distinct()
                .filter(s -> s.length() < n)
                .collect(Collectors.toList());
        System.out.println("Task 2 " + newWords);
    }

    //3. Есть лист строк. составить одну строку из листа длиной больше n, ToUpperCase, исключить повторения и отсортировать а-я
    private static void task3(int n) {
        List<String> words = Arrays.asList("cat", "dragon", "zebra", "dog", "rabbit", "elephant", "bird", "pig");
        String newString = words
                .stream()
                .distinct()
                .filter(s -> s.length() > n)
                .map(String::toUpperCase)
                .sorted(String::compareTo)
//                .sorted((o1, o2) -> o1.compareTo(o2))
                .reduce(" ", (s, s2) -> s + s2);
        System.out.println("Task 3 " + newString);
    }

    //4. Есть лист строк, найти количество строк в списке длина которых меньше n
    private static void task4(int n) {
        List<String> words = Arrays.asList("cat", "dragon", "zebra", "dog", "rabbit", "elephant", "bird", "pig");
        System.out.println("Task 4 " + words
                .stream()
                .filter(s -> s.length() < n).count());
    }

    //        5. Есть лист строк, узнать содержится в списке переданное слово, используя stream API.
    private static boolean ifContains(List<String> wordsList, String word) {
        return (wordsList
                .stream()
                .anyMatch((s) -> s.equals(word))
        );
    }
}

