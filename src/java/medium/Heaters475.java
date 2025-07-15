import java.util.*;

public class Heaters475 {

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int heaterIndex = 0;
        int count = 0;

        for (int i = 0; i < houses.length; i++) {
            while (houses[i] >= heaters[heaterIndex] && heaters.length - 1 > heaterIndex) {
                heaterIndex++;
            }
            heaterIndex = Math.min(heaters.length - 1, heaterIndex);
            if (houses[i] == heaters[heaterIndex]) {
                continue;
            }

            int heaterIndex2 = heaterIndex == 0 ? 0 : heaterIndex - 1;

            int r1 = Math.abs(heaters[heaterIndex] - houses[i]);
            int r2 = Math.abs(heaters[heaterIndex2] - houses[i]);

            if (r1 > r2) {
                if (r2 > count) {
                    count = r2;
                }
            } else {
                if (r1 > count) {
                    count = r1;
                }
            }
        }
        return count;
    }
}