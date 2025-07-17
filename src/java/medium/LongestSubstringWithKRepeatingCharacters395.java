package medium;

public class LongestSubstringWithKRepeatingCharacters395 {

    public static int longestSubstring(String s, int k) {
        int n = s.length();
        int [] letterCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letterCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (letterCount[s.charAt(i) - 'a'] < k) {
                int left = longestSubstring(s.substring(0, i), k);
                int right = longestSubstring(s.substring(i), k);

                return Math.max(left, right);
            }
        }

        return n;
    }
}

