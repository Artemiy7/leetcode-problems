package medium;

public class PermutationInString567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if(freq1[i] == freq2[i]) {
                matches++;
            }
        }

        int left = 0;

        for (int right = s1.length(); right < s2.length(); right++) {
            if(matches == 26) {
                return true;
            }
            int index = s2.charAt(right) - 'a';
            freq2[index]++;
            if (freq1[index] == freq2[index]) {
                matches++;
            } else if (freq1[index] + 1 == freq2[index]) {
                matches--;
            }

            index = s2.charAt(left) - 'a';
            freq2[index]--;
            if (freq1[index] == freq2[index]) {
                matches++;
            } else if (freq1[index] - 1 == freq2[index]) {
                matches--;
            }
            left++;
        }
        return matches == 26;
    }
}