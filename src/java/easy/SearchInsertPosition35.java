package easy;

public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {

        for(int i = 0; i<nums.length;i++){
            if(nums[i] == target){
                return i;
            }
            if(nums[0] > target){
                return 0;
            }
            if(i == nums.length - 1){
                return (i+1);
            }
            if(nums[i] < target && nums[i+1] > target){
                return (i+1);
            }
        }

        return target;
    }
}
