package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author quzhe
 * @date 2020/3/13 17:57
 * @description map
 */
public class TranslateNum {
    int res = 0;
    public int translateNum(int num) {
        String s = String.valueOf(num);
        helper(new StringBuilder(), s);
        return res;
    }

    public void helper(StringBuilder sb, String left) {
        if (left.length() == 0) {
            res++;
            return;
        }
        helper(sb.append(left.substring(0,1)), left.substring(1));
        if (left.length() >= 2 && !left.startsWith("0")) {
            int t = Integer.valueOf(left.substring(0,2));
            if (t >=0 && t <= 25){
                helper(sb.append(left.substring(0,2)), left.substring(2));
            }
        }
    }
    final static Map<String, String> map = new HashMap<>();
    static {
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
    }

    public static void main(String[] args) {
        TranslateNum t = new TranslateNum();
        System.out.println(t.translateNum(12258));
    }
}
