package medium;

import java.util.List;

public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size() - 1;
        int[][] arr = new int[size + 1][size + 1];

        for(int i = 0; i <= size; i++) {
            arr[size][i] = triangle.get(size).get(i);
        }

        for(int level = size - 1; level >= 0; level--)
            for(int i = 0; i <= level; i++) {
                arr[level][i] = triangle.get(level).get(i) +
                        Math.min(arr[level + 1][i], arr[level + 1][i + 1]);
            }

        return arr[0][0];
    }
}
