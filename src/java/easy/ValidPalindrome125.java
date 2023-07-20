package easy;

public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1)
            return true;

        int len1 = 0;
        int len2 = s.length() - 1;
        for (;len1 <= len2;) {
            char c1 = s.charAt(len1);
            char c2 = s.charAt(len2);
            if (!Character.isLetterOrDigit(c1)) {
                len1++;
            } else if (!Character.isLetterOrDigit(c2)) {
                len2--;
            } else {
                if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                    return false;
                }
                len1++;
                len2--;
            }

        }
        return true;
    }
}
