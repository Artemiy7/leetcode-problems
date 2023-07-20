package easy;

public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;

        int i = 0;
        if (nums[0] != val)
            i = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i;
    }
}
