package java.easy;

public class ReverseStringII541 {

    public String reverseStr(String s, int k) {
        int len = s.length();

        char[] array = s.toCharArray();
        int left = 0;

        for (;left < len;left+=2*k) {
            if (len - left < k) {
                reverse(array, left, len - 1);
                left = len;
            } else {
                reverse(array, left, left+k-1);
            }
        }

        return String.valueOf(array);
    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
