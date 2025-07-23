package java.hard;

public class TrappingRainWater42 {

    public int trap(int[] height) {
        int trap = 0;
        int len = height.length;

        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = height[0];

        for (int i = 1; i < len; i++) {
            if (left[i - 1] > height[i])
                left[i] = left[i - 1];
            else
                left[i] = height[i];
        }

        right[len - 1] = height[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            if (right[i + 1] > height[i])
                right[i] = right[i + 1];
            else
                right[i] = height[i];
        }

        for (int i = 0; i < len; i++) {
            if (left[i] < right[i])
                trap += left[i] - height[i];
            else
                trap += right[i] - height[i];
        }

        return trap;
    }
}
