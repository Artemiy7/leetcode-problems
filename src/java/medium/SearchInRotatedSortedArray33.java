package medium;

public class SearchInRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        for (;left <= right;) {
            mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            } else {
                if (nums[mid] < nums[right]) {
                    if (target > nums[mid] && target <= nums[right])
                        left = mid + 1;
                    else
                        right = mid - 1;
                } else {
                    if (target < nums[mid] && target >= nums[left])
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
            }
        }
        return -1;
    }
}
