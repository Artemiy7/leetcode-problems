package easy;

public class LengthOfLastWord58 {
    public int lengthOfLastWord(String s) {
        int wordEnd = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                wordEnd = i;
                break;
            }
        }

        for (int i = wordEnd - 1; i >= 0; i--) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                return wordEnd - i;
            }
        }
        return ++wordEnd;
    }
}
