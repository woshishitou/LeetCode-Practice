package hash_table.easy;

import org.junit.Test;

import java.util.*;

/**
 * @author zlb
 * @description: 771
 * @date 2019/3/30 23:38
 */
public class JewelsAndStones {

    public int numJewelsInStones(String j, String s) {

        int result = 0;

        Set jSet = new HashSet();
        if (j!=null && j!="" && s!=null && s!="") {
            char[] jChar = j.toCharArray();
            for (int i=0; i<jChar.length; i++) {
                jSet.add(jChar[i]);
            }
            char[] sChar = s.toCharArray();
            for (int i=0; i<sChar.length; i++) {
                if (jSet.contains(sChar[i])) {
                    result += 1;
                }
            }
        }

        return result;
    }


    /*

    可参考的Discuss中的代码：
    https://leetcode.com/problems/jewels-and-stones/discuss/264744/Java-faster-than-100

    public int numJewelsInStones(String J, String S) {
        int output = 0;
        for(char c : S.toCharArray()){
            if(J.indexOf(c) > -1) output++;
        }
        return output;
    }

     */


    @Test
    public void test() {

        String j = "abcdefgh";
        String s = "diannaoshujixiaomi6shejimoshi";
        int result = numJewelsInStones(j, s);
        System.out.println("result: " + result);

    }

}
