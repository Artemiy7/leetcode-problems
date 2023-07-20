package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        listList.add(list);

        if (numRows == 1)
            return listList;

        list = new ArrayList<>();
        list.add(1);
        list.add(1);
        listList.add(list);
        if (numRows == 2)
            return listList;
        for (int i = 1; i < numRows - 1; i++) {
            list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j <= i; j++) {
                int current = listList.get(i).get(j) + listList.get(i).get(j - 1);
                list.add(current);
            }
            list.add(1);
            listList.add(list);
        }
        return listList;
    }
}
