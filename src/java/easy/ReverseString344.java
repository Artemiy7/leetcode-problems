package easy;

public class ReverseString344 {
    public void reverseString(char[] s) {
        char [] c = new char[s.length];
        System.arraycopy(s, 0, c, 0, s.length);
        int j = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            s[j] = c[i];
            j++;
        }
    }
}
