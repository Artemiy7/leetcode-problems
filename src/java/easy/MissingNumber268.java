package easy;

public class MissingNumber268 {
    public int missingNumber(int[] nums) {
        int i = nums.length + 1;
        int expectedSum  = (i * (i - 1)) / 2;
        int summ = 0;

        for (int num : nums)
            summ = summ + num;

        System.gc();

        return (expectedSum - summ);
    }
}
