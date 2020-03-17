package array;

import java.util.*;

/**
 * @author quzhe
 * @date 2020/3/6 16:07
 * @description array
 */
public class ReconstructMatrix {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        Map<Integer, Integer> up = new HashMap<>();
        Map<Integer, Integer> down = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) {
                up.put(i, 1);
                upper--;
                down.put(i, 1);
                lower--;
            }
            if (colsum[i] == 0) {
                up.put(i,0);
                down.put(i, 0);
            }
        }
        if (upper < 0 || lower < 0) {
            return new ArrayList<>();
        }
        //贪心
        for (int i = 0; i < n; i++) {
            if (colsum[i] != 1){
                continue;
            }
            if (upper >= lower) {
                up.put(i, 1);
                down.put(i, 0);
                upper--;
            } else {
                up.put(i, 0);
                down.put(i, 1);
                lower--;
            }
        }
        if (upper != 0 || lower != 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i : up.values()) {
            l1.add(i);
        }
        for (int i : down.values()) {
            l2.add(i);
        }

        res.add(l1);
        res.add(l2);
        return res;
    }

    public List<List<Integer>> reconstructMatrix1(int upper, int lower, int[] colsum) {
        // up记录第0行可分配的1个数，lo记录第1行可分配的1个数
        int up = upper, lo = lower, sum = 0, len = colsum.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < len; i ++){
            if(colsum[i] == 2){
                up --;
                lo --;
            }
            else if(colsum[i] == 1){
                sum++;
            }
        }
        // 如果行列元素之和不相等，或行元素之和不够分配
        if(up + lo != sum || up < 0 || lo < 0){
            return list;
        }
        List<Integer> upl = new ArrayList<>();
        List<Integer> lol = new ArrayList<>();
        for(int i = 0; i < len; i ++){
            if(colsum[i] == 2){
                upl.add(1);
                lol.add(1);
            }
            else if(colsum[i] == 0){
                upl.add(0);
                lol.add(0);
            }
            else {
                // 先分配上
                if(up-- > 0){
                    upl.add(1);
                    lol.add(0);
                }
                // 再分配下
                else {
                    lol.add(1);
                    upl.add(0);
                }
            }
        }
        list.add(upl);
        list.add(lol);
        return list;
    }

    //public static void main(String[] args) {
    //    ReconstructMatrix re = new ReconstructMatrix();
    //    System.out.println(re.reconstructMatrix(49908
    //        , 49852, i).toString().equals(re.reconstructMatrix1(49908,49852, i).toString()));
    //}

    public static void main(String[] args) {
        String s = "a;b;c;";
        System.out.println(s.split(";").length);
        System.out.println(Arrays.asList(s.split(";")).size());
    }
}
