package easy;

public class FindTheIndexOfTheFirstOccurrenceInAString28 {
    public int strStr(String haystack, String needle) {
        if(haystack.isEmpty() || needle.isEmpty())
            return -1;

        int len1 = haystack.length();
        int len2 = needle.length();

        if(len1 < len2)
            return -1;

        for (int i = 0; i <= len1 - len2; i++) {
            if (haystack.charAt(i) == needle.charAt(0) && !(len1 < (len2 + i))) {
                if (haystack.substring(i, (i + (len2))).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
