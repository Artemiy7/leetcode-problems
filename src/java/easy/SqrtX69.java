package easy;

public class SqrtX69 {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            // Check if x is present at mid
            if (mid * mid == x)
                return (int) mid;
            // If x greater, ignore left half
            if (mid * mid < x)
                left = mid;
                // If x is smaller, ignore right half
            else
                right = mid;
        }
        if (right * right == x)
            return (int) right;
        // If we reach here, then element was
        // not present
        return (int) left;
    }
}
