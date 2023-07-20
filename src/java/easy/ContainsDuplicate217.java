package easy;

import java.util.HashMap;

public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1 || nums.length == 0)
            return false;

        HashMap<Integer, Integer> container = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            container.put(nums[i], 0);
        }
        return container.size() != nums.length;
    }
}
