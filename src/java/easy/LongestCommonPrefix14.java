package easy;

import java.util.Arrays;

public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        if (first.isEmpty() || last.isEmpty())
            return "";

        int indx = 0;

        while (first.length() > indx && last.length() > indx) {
            if (first.charAt(indx) == last.charAt(indx))
                indx++;
            else
                break;
        }

        return first.substring(0, indx);
    }
}
