package easy;

import java.util.Arrays;

public class IntersectionOfTwoArraysII_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int [] arr;
        if (nums1.length < nums2.length)  {
            arr = nums1;
            nums1 = nums2;
            nums2 = arr;
        }

        arr = new int[nums2.length];
        int counter = 0;
        int buff = Integer.MAX_VALUE;
        int buff2 = Integer.MAX_VALUE - 1;

        for (int i = 0; i <= nums1.length - 1; i++) {
            if (nums1[i] != buff2) {
                for (int j = nums2.length - 1; j >= 0; j--) {
                    if (nums1[i] == nums2[j]) {
                        arr[counter++] = nums2[j];
                        nums2[j] = buff;
                        nums1[i] = buff2;
                    }
                }
            }
        }
        return Arrays.copyOf(arr, counter);
    }
}
