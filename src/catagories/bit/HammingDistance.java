package bit;

/**
 * @author quzhe
 * @date 2020/1/17 16:05
 * @description bit
 */
/*
两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 x 和 y，计算它们之间的汉明距离。
 */
public class HammingDistance {
    //my solution
    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(4,4));
    }
}
