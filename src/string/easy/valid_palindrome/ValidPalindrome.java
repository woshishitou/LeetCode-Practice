package string.easy.valid_palindrome;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zlb
 * @description: 125 https://leetcode.com/problems/valid-palindrome/
 *
 * 参考优化：
 * https://leetcode.com/problems/valid-palindrome/discuss/292558/Java-easy-understanding-solution-(no-regular-expression)
 * https://leetcode.com/problems/valid-palindrome/discuss/293468/Java-4ms-simple
 *
 * @date 2019/6/4 20:58
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        for (int i=0; i<10; i++) {
            set.add((char)('0'+i));
        }
        for (int i=0; i<26; i++) {
            set.add((char)('a'+i));
            set.add((char)('A'+i));
        }
        String ss = "";
        for (char c: s.toCharArray()) {
            if (set.contains(c)) {
                ss += c + "";
            }
        }
        boolean flag = true;
        char[] cArrays = ss.toLowerCase().toCharArray();
        for (int i=0; i<cArrays.length; i++) {
            if (cArrays[i] != cArrays[cArrays.length-1-i]) {
                flag = false;
                break;
            }
            if (i == (cArrays.length-1)/2) {
                break;
            }
        }
        return flag;
    }

    @Test
    public void test() {

        String s = "A man, a plan, a canal: Panama";
        // String s = "0P";
        System.out.println(isPalindrome(s));

    }

}
