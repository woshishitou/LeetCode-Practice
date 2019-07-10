package string.easy.goat_latin;

import org.junit.Test;

/**
 * @author zlb
 * @description: 824 https://leetcode.com/problems/goat-latin/
 * @date 2019/7/10 21:27
 */
public class GoatLatin {

    public String toGoatLatin(String S) {
        String[] stringArray = S.split(" ");
        int length = stringArray.length;
        for (int i=0; i<length; i++) {
            if (!(stringArray[i].startsWith("a") || stringArray[i].startsWith("e") || stringArray[i].startsWith("i") || stringArray[i].startsWith("o") || stringArray[i].startsWith("u")
                || stringArray[i].startsWith("A") || stringArray[i].startsWith("E") || stringArray[i].startsWith("I") || stringArray[i].startsWith("O") || stringArray[i].startsWith("U")
            )) {
                stringArray[i] = stringArray[i].substring(1,stringArray[i].length()) + stringArray[i].substring(0,1);
            }
            // 加一个ma
            stringArray[i] = stringArray[i]+"ma";
            // 加i个a
            for (int j=0; j<i+1; j++) {
                stringArray[i] = stringArray[i]+"a";
            }
        }
        StringBuilder result = new StringBuilder();
        for (String str: stringArray) {
            result.append(str + " ");
        }
        return result.substring(0, result.length()-1);
    }

    @Test
    public void test(){

        String S = "The quick brown fox jumped over the lazy dog";
        String result = toGoatLatin(S);
        System.out.println(result);
        // heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa
    }


}
