package java.medium;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        for (;right - left >= k;) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }

        return res;
    }
}