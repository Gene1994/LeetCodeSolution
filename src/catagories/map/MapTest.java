package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: create by Gene1994
 * @date:2018/12/15
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Character, Integer> a = new HashMap<>();
        Map<Character, Integer> b = new HashMap<>();
        a.put('a',1);
        b.put('a',1);
        System.out.println(a==b);//false
        System.out.println(a.equals(b));//true
        Set s = new HashSet();
        s.add("a");
        s.add("b");

    }
}
