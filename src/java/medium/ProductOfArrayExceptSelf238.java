package medium;

public class ProductOfArrayExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length - 1;
        int [] first = new int[nums.length];
        int [] seccond = new int[nums.length];
        first[0] = 1;
        seccond[len] = 1;

        for (int i = 1, j = len - 1; i <= len && j >= 0; i++, j--) {
            first[i] = first[i - 1] * nums[i - 1];
            seccond[j] = seccond[j + 1] * nums[j + 1];
        }

        for (int i = 0; i <= len; i++) {
            nums[i] = first[i] * seccond[i];
        }

        return nums;
    }
}
