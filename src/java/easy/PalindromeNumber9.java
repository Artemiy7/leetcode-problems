package easy;

public class PalindromeNumber9 {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int reversed = getReverseInt(x);
        if(x == reversed)
            return true;
        return false;
    }

    public int getReverseInt(int value) {
        int resultNumber = 0;
        for (int i = value; i !=0; i /= 10) {
            resultNumber = resultNumber * 10 + i % 10;
        }
        return resultNumber;
    }
}
