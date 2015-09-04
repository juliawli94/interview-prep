package interviewprep;

import java.util.HashMap;

/**
 * Given two words as Strings, determine if they are isomorphic. Two words are called isomorphic
 * if the letters in one word can be remapped to get the second word. Remapping a letter means replacing all
 * occurrences of it with another letter while the ordering of the letters remains unchanged. No two letters
 * may map to the same letter, but a letter may map to itself.
 *
 * Example:
 *   given "foo", "app"; returns true
 *     we can map 'f' -> 'a' and 'o' -> 'p'
 *
 *   given "foo", "boa"; returns false
 *     we can map 'f' -> 'b', 'o' -> 'o', we can't map 'o' -> 'a'
 *
 *   given "bar", "foo"; returns false
 *     we can't map both 'a' and 'r' to 'o'
 *
 *   given "turtle", "tletur"; returns true
 *     we can map 't' -> 't', 'u' -> 'l', 'r' -> 'e', 'l' -> 'u', 'e' ->'r'
 *
 *   given "ab", "ca"; returns true
 *     we can map 'a' -> 'c', 'b' -> 'a'
 */

public class IsIsomorphicLinkedIn {

    public static boolean isIsomorphic(String firstWord, String secondWord) {
 
        if (firstWord.length() != secondWord.length()) return false;
 
        HashMap<Character, Character> map = new HashMap<Character, Character>();
 
        for (int i = 0; i < firstWord.length(); i++) {
 
            char first = firstWord.charAt(i);
            char second = secondWord.charAt(i);

            if (map.containsKey(first)) {
                if (second != map.get(first)) return false;
            } else {
                if (map.containsValue(second)) return false;
                else {
                    map.put(first, second);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Expecting true");
        System.out.println(isIsomorphic("foo", "app"));
        System.out.println(isIsomorphic("turtle", "tletur"));
        System.out.println(isIsomorphic("ab", "ca"));

        System.out.println("Expecting false");
        System.out.println(isIsomorphic("foo", "boa"));
        System.out.println(isIsomorphic("bar", "foo"));
    }
}
