package math;

/**
 * @author quzhe
 * @date 2020/1/23 16:51
 * @description 找出N以前出现数字中1的个数
 * from《编程之美》
 */
public class FindAll1InInteger {
    //暴力求解
    public int findAll1inInteger(int N) {
        int res = 0;
        for (int i = 0; i <= N; i++) {
            char[] chars = String.valueOf(i).toCharArray();
            for (char c : chars) {
                if (c == '1')
                    res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAll1InInteger f = new FindAll1InInteger();
        System.out.println(f.findAll1inInteger(1100000000));
    }
}
