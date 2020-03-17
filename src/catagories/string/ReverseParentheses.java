package string;

/**
 * @author quzhe
 * @date 2020/3/6 14:55
 * @description 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 */
public class ReverseParentheses {
    public String reverseParentheses(String s) {
        int left = s.lastIndexOf("(");
        while (left != -1) {
            int right = left +  s.substring(left).indexOf(")");
            String l = s.substring(0, left);
            String toReserve = s.substring(left+1, right);
            String r = s.substring(right+1);
            s = l + new StringBuilder(toReserve).reverse().toString() + r;
            left = s.lastIndexOf("(");
        }
        return s;
    }

    public static void main(String[] args) {
        //String s = "(ed(et(oc))el)";
        //int left = s.lastIndexOf("(");
        //int right = s.indexOf(")");
        //System.out.println(s.substring(0, left));
        //System.out.println(s.substring(left+1, right));
        //System.out.println(s.substring(right+1));
       String ss = "ta()usw(a)";
        int index = ss.lastIndexOf("(");
        System.out.println(index);
        System.out.println(ss.substring(index).indexOf(")"));
        System.out.println(ss.lastIndexOf(")"));
    }
}
