package java.medium;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1)
            return 1;

        int longest = 0;
        int[] arr = new int[128];
        for(int left = 0, right = 0; right < s.length(); right++) {
            if(left < arr[s.charAt(right)])
                left = arr[s.charAt(right)];

            if(longest < right - left + 1)
                longest = right - left + 1;

            arr[s.charAt(right)] = right + 1;
        }

        return longest;
    }
}