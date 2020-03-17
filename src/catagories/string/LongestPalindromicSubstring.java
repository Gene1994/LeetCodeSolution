package string;

/**
 * @author quzhe
 * @date 2020/3/3 16:25
 * @description 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome1(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String s1 = s.substring(i, j);
                if (isPalindromic(s1) && s1.length() > res.length()) {
                    res = s1;
                }
            }
        }
        return res;
    }

    private boolean isPalindromic(String s) {
        int len = s.length();
        int halfLen = len / 2;
        String l = s.substring(0, halfLen);
        String r = s.substring(len - halfLen, len);
        StringBuilder sb = new StringBuilder(r);
        if (l.equals(sb.reverse().toString())) {
            return true;
        }
        return false;
        //for (int i = 0; i < halfLen; i++) {
        //    if (!s.substring(i, i+1).equals(s.substring(len - i - 1, len - i))) {
        //        return false;
        //    }
        //}
        //return true;
    }

    public String longestPalindrome(String s) {

        int len = s.length();
        boolean[][] dp = new boolean[len][len+1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len+1; j++) {
                if (i >= j || i + 1 == j) {
                    dp[i][j] = true;
                }
                if (j - i == 2 && s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = len-3; i >=0; i--) {
            for (int j = 0; j < len+1; j++) {
                if (j - i > 2) {
                    if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j-1)) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        String res = "";
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len+1; j++) {
                if (dp[i][j] && j-i > res.length()) {
                    res = s.substring(i,j);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //String s = "ab";
        //System.out.println(s.substring(2, 2));
        //System.out.println(s.charAt(0));
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        //System.out.println(l.longestPalindrome("babad"));
        System.out.println(l.longestPalindrome("abcba"));
        //System.out.println(l.longestPalindrome("babad"));
        //System.out.println(l.longestPalindrome("babad"));
    }
}
