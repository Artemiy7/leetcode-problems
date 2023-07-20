package easy;

public class RemoveDuplicatesFromSortedArray26 {
    public int removeDuplicates(int[] nums) {
        int f = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[f]) {
                f++;
                nums[f] = nums[i];
            }
        }
        return ++f;
    }
}
