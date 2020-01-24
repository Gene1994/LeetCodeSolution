package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author quzhe
 * @date 2020/1/22 12:19
 * @description 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
public class GenerateParenthesis {
    //TODO
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        Stack<String> stack = new Stack<>();
        helper(n, stack, 0);
        return res;
    }
    private final String L = "(";
    private final String R = ")";

    private void helper(int n, Stack<String> stack, int i) {
        if (i == n) {
            return;
        }
        for (int j = i; j < n; j++) {
            stack.push(L);
            while (!stack.empty()) {

            }
        }
    }
}
