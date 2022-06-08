package ru.maxvagan;

import java.util.*;

public class Main {

    private static void printOnlyOddNumbers(List<Integer> inpListOfInteger) {
        List<Integer> listOfOdds = new ArrayList<Integer>();
        for (Integer listMember : inpListOfInteger) {
            if (listMember % 2 != 0) listOfOdds.add(listMember);
        }
        System.out.println("List of only Odds:");
        System.out.println(listOfOdds);
    }

    private static void printOnlyEvenUniqNumbersAsc(List<Integer> inpListOfInteger) {
        List<Integer> listOfUniqEvens = new ArrayList<Integer>();
        for (Integer listMember : inpListOfInteger) {
            if (listMember % 2 == 0 && !listOfUniqEvens.contains(listMember)) listOfUniqEvens.add(listMember);
        }
        listOfUniqEvens.sort(Comparator.naturalOrder());
        System.out.println("List of only Uniq Evens Sorted Asc:");
        System.out.println(listOfUniqEvens);
    }

    private static List<String> generatorWords(String inpStringOfWords) {
        String[] arrayOfWords = inpStringOfWords.split(" ");
        List<String> stringsOut = new ArrayList<>();
        Random rnd = new Random(); int wordsCount = rnd.nextInt(arrayOfWords.length) + 2;
        while (stringsOut.size() < wordsCount) {
            stringsOut.add(arrayOfWords[rnd.nextInt(arrayOfWords.length)]);
        }
        return stringsOut;
    }

    private static void printOnlyUniqWords(List<String> inpListOfWords) {
        Set<String> listOfUniqWords = new HashSet<>(inpListOfWords);
        System.out.println("Set of Uniq Words:");
        System.out.println(listOfUniqWords);
    }

    private static void printCountDuplicatedWords(List<String> inpListOfWords) {
        Map<String, Integer> duplicateCounts = new HashMap<>();
        List<String> copyOfListOfWords = new ArrayList<>(inpListOfWords);
        int countCurrentWord;
        for (String Word1 : inpListOfWords) {
            countCurrentWord = 0;
            for (String Word2 : copyOfListOfWords) {
                if (Word1.equals(Word2)) countCurrentWord++;
            }
            if (countCurrentWord > 1) duplicateCounts.put(Word1, countCurrentWord);
        }
        if (duplicateCounts.size() == 0) duplicateCounts.put("Duplicates", 0);
        System.out.println("Map of Duplicated Words:");
        System.out.println(duplicateCounts);
    }

    public static void main(String[] args) {
        // Task 1
        System.out.println("-------------- Task 1 --------------");
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        printOnlyOddNumbers(nums);
        // Task 2
        System.out.println("-------------- Task 2 --------------");
        printOnlyEvenUniqNumbersAsc(nums);
        // Task 3
        System.out.println("-------------- Task 3 --------------");
        List<String> words = new ArrayList<String>(generatorWords("The most misunderstand in this World is that It can be understood! Albert Einstein"));
        System.out.println("Source List of Words");
        System.out.println(words);
        printOnlyUniqWords(words);
        // Task 4
        System.out.println("-------------- Task 4 --------------");
        printCountDuplicatedWords(words);
    }
}
