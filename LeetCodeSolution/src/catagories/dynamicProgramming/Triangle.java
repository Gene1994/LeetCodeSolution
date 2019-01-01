package dynamicProgramming;

/**
 * @author: create by Gene1994
 * @date:2018/12/27
 */

import java.util.List;

/**
 * No.120 Triangle
 *
 *  Difficulty:Medium
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null)
            return 0;
        int h = triangle.size();
        int w = triangle.get(h-1).size();

        int[] min = new int[w];
        for (int i = 0; i < w; i++){
            min[i] = triangle.get(h-1).get(i);
        }
        for (int i = h - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                min[j] = triangle.get(i).get(j) + Math.min(min[j], min[j+1]);
            }
        }
        return min[0];
    }
}
