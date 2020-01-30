package bit;

/**
 * @author quzhe
 * @date 2020/1/25 15:38
 * @description 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int lenA = charA.length;
        int lenB = charB.length;
        StringBuilder res = new StringBuilder();
        boolean flag = false;
        for (int i = lenA-1, j = lenB-1; i >=0 || j >=0; i--, j--) {
            int sum = 0;
            if (i >= 0 && charA[i] == '1') {
                sum += 1;
            }
            if (j >= 0 && charB[j] == '1') {
                sum += 1;
            }
            if (flag) {
                sum += 1;
            }
            if (sum % 2 == 0) {
                res.append("0");
            } else {
                res.append("1");
            }
            if (sum / 2 == 0) {
                flag = false;
            } else {
                flag = true;
            }
        }
        if (flag) {
            res.append("1");
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("100", "111"));
    }
}
