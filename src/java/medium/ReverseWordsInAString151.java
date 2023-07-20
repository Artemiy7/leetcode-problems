package medium;

public class ReverseWordsInAString151 {
    public String reverseWords(String s) {
        boolean space = false;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                stringBuilder.insert(0, s.charAt(i));
                space = true;
            } else {
                if (space) {
                    stringBuilder.append(" ");
                    space = false;
                    res.append(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                }
            }
        }
        res.append(stringBuilder);

        if (s.charAt(0) == ' ')
            res.delete(res.length() - 1, res.length());

        return res.toString();
    }
}
