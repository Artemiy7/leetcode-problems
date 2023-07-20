package easy;

public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        int last = digits.length - 1;
        if (digits[last] != 9) {
            digits[last] = digits[last] + 1;
            return digits;
        } else {
            for (int i = last; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                    if (i == 0) {
                        int [] res = new int[digits.length + 1];
                        res[0] = 1;
                        return res;
                    }
                } else {
                    digits[i] += 1;
                    break;
                }
            }
        }
        return digits;
    }
}
