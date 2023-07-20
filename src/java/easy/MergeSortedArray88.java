package easy;

public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = (n + m) - 1;
        --m;
        --n;
        for (;n >= 0 && m >= 0; k--) {
            if (nums1[m] >= nums2[n]) {
                nums1[k] = nums1[m];
                m--;
            } else {
                nums1[k] = nums2[n];
                n--;
            }
        }

        for (;m >= 0; m--) {
            nums1[k--] = nums1[m];
        }

        for (;n >= 0; n--) {
            nums1[k--] = nums2[n];
        }
    }
}
