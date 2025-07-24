package java.medium;

public class LongestTurbulentSubarray978 {

    public int maxTurbulenceSize(int[] arr) {
        int count = 1;
        String prev = "";
        int left = 0;


        for (int right = 1; right < arr.length;) {
            if (arr[right - 1] > arr[right] && (prev.equals("<") || prev.equals(""))) {
                prev = ">";
                count = Math.max(count, right - left + 1);
                right++;
            } else if (arr[right - 1] < arr[right] && (prev.equals(">") || prev.equals(""))) {
                prev = "<";
                count = Math.max(count, right - left + 1);
                right++;
            } else {
                prev = "";
                if (arr[left] == arr[right]) {
                    right++;
                }
                left = right - 1;
            }
        }
        return count;
    }
}
