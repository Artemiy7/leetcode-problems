package medium;

public class ArithmeticSlices413 {
    
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        int tempCount = 0;
        int totalCount = 0;
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                tempCount++;
                totalCount += tempCount;
            } else {
                tempCount = 0;
            }
        }
        return totalCount;
    }
}