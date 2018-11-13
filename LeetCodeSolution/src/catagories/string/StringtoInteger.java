/**
 * @author: create by Gene1994
 * @date:2018/11/11
 */

/**
 * No.8 String to Integer (atoi)
 *
 * Difficulty:Medium

 Implement atoi which converts a string to an integer.

 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned.

 Note:

 Only the space character ' ' is considered as whitespace character.
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 Example 1:
 Input: "42"
 Output: 42

 Example 2:
 Input: "   -42"
 Output: -42
 Explanation: The first non-whitespace character is '-', which is the minus sign.
 Then take as many numerical digits as possible, which gets 42.

 Example 3:
 Input: "4193 with words"
 Output: 4193
 Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

 Example 4:
 Input: "words and 987"
 Output: 0
 Explanation: The first non-whitespace character is 'w', which is not a numerical
 digit or a +/- sign. Therefore no valid conversion could be performed.

 Example 5:
 Input: "-91283472332"
 Output: -2147483648
 Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 Thefore INT_MIN (−231) is returned.
 */
public class StringtoInteger {

    //My solution(49ms)
    public int myAtoi(String str) {
        StringBuffer res = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        String s = str.trim();
        if (s.equals("")) return 0;
        char[] c = s.toCharArray();
        if (c.length == 1){
            if (isNum(c[0])){
                return Integer.parseInt(str);
            }else {
                return 0;
            }
        }

        //-32214
        if ((c[0] == '+' || c[0] == '-') && isNum(c[1])){

//            sb.append(c[0]);
            for (int i = 1; i < c.length; i++){
                if (isNum(c[i])){
                    sb.append(c[i]);
                }else {
                    break;
                }
            }
            String res1 = sb.toString().replaceFirst("^0*", "");
            if (res1.equals("")) return 0;
            if (res1.length() > 10 && c[0] == '+'){
                return Integer.MAX_VALUE;
            }else if (res1.length() > 10 && c[0] == '-'){
                return Integer.MIN_VALUE;
            }else if (c[0] == '-'){
                res.append('-');
                res.append(res1);
            }else {
                res.append(res1);
            }
            long l = Long.parseLong(res.toString());
            if(l > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(l < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else {
                return Integer.parseInt(res.toString());
            }
        }

        //21312
        if (isNum(c[0])){
            sb.append(c[0]);
            for (int i = 1; i < c.length; i++){
                if (isNum(c[i])){
                    sb.append(c[i]);
                }else {
                    break;
                }
            }
            String res1 = sb.toString().replaceFirst("^0*", "");
            if (res1.equals("")) return 0;
            if (res1.length() > 10){
                return Integer.MAX_VALUE;
            }else {
                long l = Long.parseLong(res1);
                if(l > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }else {
                    return Integer.parseInt(res1);
                }
            }
        }
        return 0;
    }

    boolean isNum(char c){
        if (c >= '0' && c <= '9'){
            return true;
        }
        return false;
    }

    ////////////////////////////////////////////////////////////////////////////////////

    //Most popular by @lestrois
    public int myAtoi1(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index ++;

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }

    //fastest
    public int myAtoi2(String str) {
        int len = str.length();
        if (len == 0) {
            return 0;
        }
        char[] cs = str.toCharArray();
        int i = 0;
        while (i < len && cs[i++] == ' ') {

        }
        i--;
        char c1 = cs[i];
        int sig = 1;
        if ((c1 > '9' || c1 < '0')) {
            if (c1 == '-') {
                sig = -1;
                i++;
            } else if (c1 == '+') {
                i++;
            } else {
                return 0;
            }
        }
        long v = 0;
        for (; i < len; i++) {
            char c = cs[i];
            if (c < '0' || c > '9') {
                break;
            }
            v = v * 10 + (c - '0');
            if (v * sig > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (v * sig < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) (v * sig);
    }

    //test
    public static void main(String[] args) {
        StringtoInteger stringtoInteger = new StringtoInteger();
        int i = stringtoInteger.myAtoi2("   123");
        System.out.println(i);
    }
}
