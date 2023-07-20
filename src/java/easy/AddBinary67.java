package easy;

public class AddBinary67 {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int a1 = 0;
            int a2 = 0;
            if (i >= 0)
                a1 = (a.charAt(i) - '0');
            if (j >= 0)
                a2 = (b.charAt(j) - '0');

            int summ = a1 + a2 + carry;
            stringBuilder.append(summ % 2);
            carry = (summ / 2);
            i--;
            j--;
        }
        if (carry != 0) stringBuilder.append(carry);
        return stringBuilder.reverse().toString();
    }
}
