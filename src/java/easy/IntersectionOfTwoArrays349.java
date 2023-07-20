package easy;

import java.util.Arrays;

public class IntersectionOfTwoArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int [] arr;
        if (nums1.length < nums2.length)  {
            arr = nums1;
            nums1 = nums2;
            nums2 = arr;
        }

        arr = new int[nums2.length];
        int counter = 0;
        int buff = 0;

        for (int i = 0; i <= nums1.length - 1; i++) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    arr[counter++] = nums2[j];
                    nums2[j] = Integer.MAX_VALUE;
                }

            }
        }
        return Arrays.copyOf(arr, counter);
    }
}
