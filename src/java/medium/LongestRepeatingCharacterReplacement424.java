package medium;

public class LongestRepeatingCharacterReplacement424 {

    public int characterReplacement(String s, int k) {
        byte[] freq = new byte[26];
        int left = 0;
        int max = 0;
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            int letterFreqIndex = s.charAt(right) - 'A';
            freq[letterFreqIndex]++;

            max = Math.max(max, freq[letterFreqIndex]);

            int windowSize = right - left + 1;
            if (windowSize - max > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, res - left + 1);

        }
        return res;
    }
}