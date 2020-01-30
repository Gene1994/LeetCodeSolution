package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author quzhe
 * @date 2020/1/27 21:42
 * @description 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class PascalsTriangle {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return res;
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        res.add(new ArrayList<>(tmp));
        if (numRows == 1) {
            return res;
        }
        for (int i  = 2; i <=numRows; i++) {
            List<Integer> list = new ArrayList<>();
            tmp.add(0,0);
            tmp.add(tmp.size(), 0);
            for (int j = 0; j < tmp.size()-1; j++) {
                int k = tmp.get(j) + tmp.get(j+1);
                list.add(k);
            }
            res.add(list);
            tmp = new ArrayList<>(list);
        }
        return res;
    }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>> generate = pascalsTriangle.generate(5);
        System.out.println(generate);
    }
}
