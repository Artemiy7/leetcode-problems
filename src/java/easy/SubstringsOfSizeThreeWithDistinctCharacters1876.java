package easy;

public class SubstringsOfSizeThreeWithDistinctCharacters1876 {

    public int countGoodSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }
        int[] freq = new int[26];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 2;
        if (freq[s.charAt(right) - 'a'] == 1 && freq[s.charAt(left) - 'a'] == 1) {
            count++;
        }
        while (right < s.length() - 1) {
            freq[s.charAt(++right) - 'a']++;
            freq[s.charAt(left++) - 'a']--;
            if (freq[s.charAt(right) - 'a'] == 1 && freq[s.charAt(left) - 'a'] == 1) {
                count++;
            }
        }
        return count;
    }
}