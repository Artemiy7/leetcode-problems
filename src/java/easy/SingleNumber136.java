package easy;

public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        for(int i=0; i < nums.length - 1; i++){
            for (int j = nums.length - 1; j > i ; j --){
                if(nums[i] == nums[j]){
                    nums[i] = 0;
                    nums[j] = 0;
                }
            }
        }
        for(int i=0; i < nums.length - 1; i++){
            for (int j = nums.length - 1; j > i ; j --){
                if(nums[i] != 0 || nums[j] != 0){
                    if(nums[i] != 0) {
                        return nums[i];
                    }
                    if(nums[j] !=0){
                        return nums[j];
                    }
                }
            }
        }
        return 0;
    }
}
