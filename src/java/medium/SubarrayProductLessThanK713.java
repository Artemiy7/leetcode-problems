package java.medium;

public class SubarrayProductLessThanK713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int count = 0;
        int left = 0;
        int product = 1;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product = product / nums[left++];
                if (left == nums.length) {
                    return count;
                }
            }
            count = count + (right - left) + 1;
        }
        return count;
    }
}