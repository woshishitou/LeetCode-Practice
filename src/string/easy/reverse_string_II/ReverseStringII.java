package string.easy.reverse_string_II;

import org.junit.Test;

/**
 * @author zlb
 * @description: 541: https://leetcode.com/problems/reverse-string-ii/
 *
 *  Runtime: 1 ms, faster than 67.13% of Java online submissions for Reverse String II.
 *  Memory Usage: 37.9 MB, less than 41.00% of Java online submissions for Reverse String II.
 *
 * @date 2019/7/25 8:41
 */
public class ReverseStringII {

    public String reverseStr(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        reverseString(stringBuilder, s, k);
        return stringBuilder.toString();
    }

    public void reverseString(StringBuilder stringBuilder, String s, int k) {
        int length = s.length();
        if (length > 2*k) {
            stringBuilder.append(reverse(s.substring(0,k))+s.substring(k,2*k));
            String after2k = s.substring(2*k,length);
            reverseString(stringBuilder, after2k, k);
        } else if (length > k) {
            stringBuilder.append(reverse(s.substring(0,k))+s.substring(k,length));
        } else {
            stringBuilder.append(reverse(s.substring(0,length)));
        }
    }

    public String reverse(String str) {
        int length = str.length();
        char[] charArray = str.toCharArray();
        for (int i=0; i<length; i++) {
            if (i < length/2) {
                char temp = charArray[i];
                charArray[i] = charArray[length-1-i];
                charArray[length-1-i] = temp;
            }
        }
        return new String(charArray);
    }

    @Test
    public void test() {

        String string = "fasdfsda";
        System.out.println(reverseStr(string, 3));

    }

}
