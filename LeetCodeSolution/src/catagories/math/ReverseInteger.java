/**
 * @author: create by Gene1994
 * @date:2018/11/11
 */

/**
 * No.7 Reverse Integer
 * Difficulty:Easy

 Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output: 321


 Example 2:

 Input: -123
 Output: -321


 Example 3:

 Input: 120
 Output: 21
 */
public class ReverseInteger {

    //My solution(34ms)
    public String reverseString(String s) {
        if (s == null){
            return null;
        }
        char[] c = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = c.length - 1; i >= 0; i--){
            sb.append(c[i]);
        }
        return sb.toString();
    }

    public int reverse(int x) {
        String res = null;
        if (x >= 0)
        {
            res = reverseString(x+"");
        }else{
            res = "-" + reverseString((x+"").substring(1));
        }
        long resLong = Long.parseLong(res);
        long max = Integer.MAX_VALUE;
        long min = Integer.MIN_VALUE;
        if (resLong > max || resLong < min) return 0;
        return Integer.parseInt(res);
    }

    //Official solution
    public int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
