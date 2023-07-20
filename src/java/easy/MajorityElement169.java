package easy;

public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int len = nums.length - 1;
        for (int i = 0; i <= len + count; i++) {
            if (i <= len) {
                if (nums[i] != 0) {
                    nums[count++] = nums[i];
                }
            } else  {
                if (nums.length == count)
                    break;
                nums[count++] = 0;
            }
        }
        return count;
    }
}
