package medium;

public class TwoSumII_InputArrayIsSorted167 {
    public int[] twoSum(int[] numbers, int target) {
        int [] arr;
        for (int i = 0, j = numbers.length - 1; i < numbers.length - 1 && j > 0; ) {
            if (numbers[i] + numbers[j] == target) {
                arr = new int[2];
                arr[0] = ++i;
                arr[1] = ++j;
                return arr;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            }
        }
        return new int[0];
    }
}
