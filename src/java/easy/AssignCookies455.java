package easy;

import java.util.Arrays;

class AssignCookies455 {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int l1 = 0;
        int l2 = 0;

        int res = 0;

        for (; l1 < g.length && l2 < s.length;) {
            if (s[l2] >= g[l1]) {
                res++;
                l1++;
            }
            l2++;
        }
        return res;
    }
}