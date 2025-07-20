package easy;

import java.util.Arrays;

public class LongestHarmoniousSubsequence594 {

    public int findLHS(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int count = 0;

        for (int right = 1;right < nums.length; right++) {
            for (;nums[right] - nums[left] > 1;) {
                left++;
            }
            if (nums[right] - nums[left] == 1) {
                count = Math.max(count, right - left + 1);
            }
        }
        return count;
    }
}