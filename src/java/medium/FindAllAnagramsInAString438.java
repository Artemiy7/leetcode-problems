package medium;

import java.util.*;

public class FindAllAnagramsInAString438 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return List.of();
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < p.length(); i++) {
            freq1[s.charAt(i) - 'a']++;
            freq2[p.charAt(i) - 'a']++;
        }

        List<Integer> res = new ArrayList<>();

        int left = 0;

        for (int right = p.length(); right <= s.length(); right++) {
            if (Arrays.equals(freq1, freq2)) {
                res.add(left);
            }
            if (right == s.length()) {
                return res;
            }
            freq1[s.charAt(left) - 'a']--;
            freq1[s.charAt(right) - 'a']++;
            left++;
        }
        return res;
    }
}