package easy;

public class MaximumAverageSubarrayI643 {

    
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }

        for (int i = k; i < nums.length; i++) {
            int tempSum = maxSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, tempSum);
        }

        return (double) maxSum/k;
    }
}