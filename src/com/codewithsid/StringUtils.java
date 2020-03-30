package com.codewithsid;

import java.util.*;

public class StringUtils {

    public static int countVowels(String string) {
        if (string == null)
            return 0;


        int count = 0;

        String vowels = "aeiou";
        for (var ch : string.toLowerCase().toCharArray()) {
            if (vowels.indexOf(ch) != -1) //vowels.contains(Character.toString(ch))
                count++;
        }

//
//        HashSet<Character> vowels1 = new HashSet<>();
//        vowels1.add('a');
//        vowels1.add('e');
//        vowels1.add('i');
//        vowels1.add('o');
//        vowels1.add('u');
//
//        for (char ch : string.toCharArray())
//            if(vowels1.contains(ch))
//                count++;

        return count;
    }


    public static String reverseAString(String string) {
        Stack<Character> stack = new Stack<>();

        for (char ch : string.toCharArray()) {
            stack.add(ch);
        }

        StringBuilder stringBuilder = new StringBuilder();

        Iterator<Character> stackIterator = stack.iterator();

        while (stackIterator.hasNext())
            stringBuilder.append(stack.pop());

        return stringBuilder.toString();
    }

    public static String reverseAString1(String string) {
        if (string == null)
            throw new IllegalArgumentException();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = string.length() - 1; i >= 0; i--)
            stringBuilder.append(string.charAt(i));

        return stringBuilder.toString();
    }

    public static String reverseASentence(String string) {
        if (string == null)
            throw new IllegalArgumentException();


        String[] words = string.split(" ");

        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);

//        StringBuilder stringBuilder = new StringBuilder();
//        List<String> listOfWords =  Arrays.asList(words);
//        Collections.reverse(listOfWords);
//
//        for(String item : listOfWords) {
//            stringBuilder.append(item + " ");
//        }

//
//
//        return stringBuilder.toString();
    }

    public static boolean areRotations(String str1, String str2) {

        if (str1 == null || str2 == null)
            return false;


        if (str1.length() != str2.length())
            return false;

        if (!(str1 + str2).contains(str2))
            return false;

        return true;
    }

    public static String removeDuplicates(String string) {
        if (string == null)
            throw new IllegalArgumentException();

        StringBuilder output = new StringBuilder();
        Set<Character> set = new HashSet<>();

        for (var ch : string.toCharArray()) {
            if (!set.contains(ch)) {
                set.add(ch);
                output.append(ch);
            }
        }

        return output.toString();
    }

    public static Character getMaxOccurencies(String string) {
        Map<Character, Integer> frequencies = new HashMap<>();

        for (var ch : string.toCharArray()) {
            if (frequencies.containsKey(ch)) {
                frequencies.replace(ch, frequencies.get(ch) + 1);
            } else {
                frequencies.put(ch, 1);
            }
        }

        return 'a';
    }

    public static Character getMaxOccurencies1(String string) {
        if (string == null || string.isEmpty())
            throw new IllegalArgumentException();


        final int ASCIISIZE = 256;
        int[] frequencies = new int[ASCIISIZE];

        for (var ch : string.toCharArray()) {
            frequencies[ch]++;
        }

        int max = 0;
        char result = ' ';
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > max) {
                max = frequencies[i];
                result = (char) i;
            }
        }
        return result;
    }

    public static String capitalizeEachWordInASentence(String sentence) {
        if (sentence == null && sentence.trim().isEmpty())
            return null;


        String[] words = sentence.trim().replaceAll(" +", " ").split(" ");

        for (var i = 0; i < words.length; i++)
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(i).toLowerCase();

        return String.join(" ", words);
    }

    public static boolean areAnograms(String first, String second) {

        if (first == null || second == null || first.length() != second.length())
            return false;


        var array1 = first.toLowerCase().toCharArray();
        Arrays.sort(array1);

        var array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    public static boolean areAnograms1(String first, String second) {
        if (first == null || second == null || first.length() != second.length())
            return false;

        final int ENGLISH_ALPHABETS = 26;
        int[] frequencies = new int[ENGLISH_ALPHABETS];

        first = first.toLowerCase();
        for (var i = 0; i < first.length(); i++)
            frequencies[first.charAt(i) - 'a']++;


        second = second.toLowerCase();
        for (var i = 0; i < second.length(); i++) {
            int index = second.charAt(i) - 'a';
            if (frequencies[index] == 0)
                return false;
            frequencies[index]--;
        }

        return true;
    }

    public static boolean isItAPalindrome(String word) {
        StringBuilder input = new StringBuilder(word);
        input.reverse();

        return input.toString().equals(word);
    }

    public static boolean isItAPalindrome1(String word) {
        if(word == null)
            return false;

        word = word.toLowerCase();

        int left = 0;
        int right = word.length() - 1;

        while(left < right)
            if (word.charAt(left++) != word.charAt(right--))
                return false;


        return true;
    }

}
