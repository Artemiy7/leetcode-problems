package easy;

public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int right = nums.length - 1;
        for (int left = 0; left < right; left++) {
            if(nums[right] == 0)
                right--;

            if (nums[left] == 0) {
                nums[left] = nums[right];
                nums[right] = 0;
            }
        }
    }
}
