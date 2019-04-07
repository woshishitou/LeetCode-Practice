package reverse_string;

import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * @author zlb
 * @description: 344 相关概念了解 in-place algorithm 原地算法
 * @date 2019/4/7 22:02
 */
public class ReverseString {

    public void reverseString(char[] s) {
        char temp;
        for (int i=0;i<s.length-i-1;i++) {
            temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }
    }

    @Test
    public void test() {
        char[] s = {'1','2','3','4','5','6','r','e','Z','#'};
        for (char ss: s) {
            System.out.print(ss);
        }
        System.out.println();
        reverseString(s);
        for (char ss: s) {
            System.out.print(ss);
        }
    }

}
