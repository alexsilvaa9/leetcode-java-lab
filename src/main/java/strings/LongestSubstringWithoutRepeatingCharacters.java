package strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String input = "abcabcbbhujnkf";

        System.out.println(lengthOfLongestSubstring(input));
    }

    private static int lengthOfLongestSubstring(String input) {
        Map<Character, Integer> lastSeenIndex = new HashMap<>();
        int longest = 0;
        int left = 0;

        for (int right = 0; right < input.length(); right++) {
            char current = input.charAt(right);

            if (lastSeenIndex.containsKey(current)) {
                left = Math.max(left, lastSeenIndex.get(current) + 1);
            }

            lastSeenIndex.put(current, right);
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}