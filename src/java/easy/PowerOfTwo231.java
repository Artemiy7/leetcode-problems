package easy;

public class PowerOfTwo231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        else if (n == 1)
            return true;

        if (n % 2 == 0 && isPowerOfTwo(n / 2))
            return true;
        else
            return false;
    }
}
