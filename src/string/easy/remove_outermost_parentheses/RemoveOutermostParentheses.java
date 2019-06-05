package string.easy.remove_outermost_parentheses;

import org.junit.Test;

/**
 * @Description: 1021 https://leetcode.com/problems/remove-outermost-parentheses/
 * @Author zlb
 * @Date 2019/5/26 18:29
 **/
public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String S) {
        int outer = 0;
        int inner = 0;
        char[] intput = S.toCharArray();
        char[] output = new char[intput.length];
        int i = 0;
        // (()())(())(()(()))
        for (char c: intput) {
            if (outer != 0) {
                if (inner == 0) {
                    if (')' == c) {
                        outer += 1;
                    } else {
                        inner -= 1;
                        output[i] = c;
                        i += 1;
                    }
                } else {
                    if ('(' == c) {
                        inner -= 1;
                    } else {
                        inner += 1;
                    }
                    output[i] = c;
                    i += 1;
                }
            } else {
                outer -= 1;
            }
        }
        return new String(output).substring(0,i);
    }

    @Test
    public void test() {

        String str = "(()())(())";
        String output = removeOuterParentheses(str);
        System.out.println(output);
        System.out.println("()()()".equals(output) ? "对了" : "错了");

    }

}


