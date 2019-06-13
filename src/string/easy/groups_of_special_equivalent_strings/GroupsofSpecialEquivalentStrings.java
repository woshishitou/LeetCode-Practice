package string.easy.groups_of_special_equivalent_strings;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zlb
 * @description: 893: https://leetcode.com/problems/groups-of-special-equivalent-strings/
 * @date 2019/6/13 8:13
 */
public class GroupsofSpecialEquivalentStrings {


    /**
     * @Description: 主方法
     * @author zlb
     * @date 2019/6/13 8:52
     */
    public int numSpecialEquivGroups(String[] A) {
        int number = 0;
        String str = "";
        boolean flag;
        for (int i=0; i<A.length; i++) {
            if (str.contains(i+"")) {
                continue;
            } else {
                number += 1;
            }
            for (int j=i+1; j<A.length; j++) {
                if (str.contains(j+"")) {
                    continue;
                }
                flag = judgeEquivalent(A[i], A[j]);
                if (flag) {
                    str = str + j+ ",";
                }
            }
        }
        return number;
    }

    /**
     * @Description: 判断两个字符串是否是等价的
     * @author zlb
     * @date 2019/6/13 8:21
     */
    private boolean judgeEquivalent(String strOne, String strTwo){
        String strOne1 = splitAStringToTwoByNumber(strOne)[0];
        String strOne2 = splitAStringToTwoByNumber(strOne)[1];
        String strTwo1 = splitAStringToTwoByNumber(strTwo)[0];
        String strTwo2 = splitAStringToTwoByNumber(strTwo)[1];
        return judgeCombine(strOne1, strTwo1) && judgeCombine(strOne2, strTwo2);
    }

    /**
     * @Description: 将一个字符串按奇偶数位置拆分成两个字符串
     * @author zlb
     * @date 2019/6/13 8:42
     */
    private String[] splitAStringToTwoByNumber(String string) {
        String string1 = "";
        String string2 = "";
        for (int i=0; i<string.length(); i++) {
            if (i % 2 != 0) {
                string1 += string.substring(i,i+1);
            } else {
                string2 += string.substring(i,i+1);
            }
        }
        String[] stringArray = {string1, string2};
        return stringArray;
    }

    /**
     * @Description: 判断两个字符串的字符组合是否一样
     * @author zlb
     * @date 2019/6/13 8:17
     */
    private boolean judgeCombine(String strOne, String strTwo) {
        if ("".equals(strOne) || "".equals(strTwo)) {
            return true;
        }
        String firstLetter1 = strOne.substring(0,1);
        int i = pattern(strOne, firstLetter1);
        int j = pattern(strTwo, firstLetter1);
        if (i==j) {
            // 某一个字符的个数相同，则分别剔除该字符，并递归调用该方法
            return judgeCombine(strOne.replace(firstLetter1,""), strTwo.replace(firstLetter1, ""));
        }else {
            // 某一个字符的个数不同，说明这两个字符串的字符组合不可能一样，直接返回false
            return false;
        }
    }

    /**
     * 通过正则表达式的方式获取字符串中指定字符的个数
     * @param text 指定的字符串
     * @return 指定字符的个数
     */
    private int pattern(String text, String c) {
        // 根据指定的字符构建正则
        Pattern pattern = Pattern.compile(c);
        // 构建字符串和正则的匹配
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        // 循环依次往下匹配
        while (matcher.find()){ // 如果匹配,则数量+1
            count++;
        }
        return  count;
    }

    @Test
    public void test() {

        // String[] A = {"abc","acb","bac","bca","cab","cba"};
        // String[] A = {"abcd","cdab","adcb","cbad"};
        // String[] A = {"a","b","c","a","c","c"};
        // String[] A = {"abcd","cdab","cbad","xyzz","zzxy","zzyx"};
        String[] A = {"vrvamqsyenqkxnbqtsmm","wssvcswtyktttnmxfiev","vjkuqlyncjjdqosxfhqt","rbugbzcyffxsybrlhlum","yypddovzsaxpdsyhoqpi","vlktqujxqofjyhqnsjcd","qnvtsjqlfdcxyjjhkuqo","ynfvwtwkttestvcissmx","xzcmfgryubhfblysulrb","ctynmkwisvttevtxwsfs"};

        System.out.println(numSpecialEquivGroups(A));

        /*System.out.println("---------------------");
        System.out.println(1);

        System.out.println(judgeEquivalent("vrvamqsyenqkxnbqtsmm", "wssvcswtyktttnmxfiev"));
        System.out.println(judgeEquivalent("vrvamqsyenqkxnbqtsmm", "vjkuqlyncjjdqosxfhqt"));
        System.out.println(judgeEquivalent("vrvamqsyenqkxnbqtsmm", "rbugbzcyffxsybrlhlum"));
        System.out.println(judgeEquivalent("vrvamqsyenqkxnbqtsmm", "yypddovzsaxpdsyhoqpi"));
        System.out.println(judgeEquivalent("vrvamqsyenqkxnbqtsmm", "vlktqujxqofjyhqnsjcd"));
        System.out.println(judgeEquivalent("vrvamqsyenqkxnbqtsmm", "qnvtsjqlfdcxyjjhkuqo"));
        System.out.println(judgeEquivalent("vrvamqsyenqkxnbqtsmm", "ynfvwtwkttestvcissmx"));
        System.out.println(judgeEquivalent("vrvamqsyenqkxnbqtsmm", "xzcmfgryubhfblysulrb"));
        System.out.println(judgeEquivalent("vrvamqsyenqkxnbqtsmm", "ctynmkwisvttevtxwsfs"));

        vrvamqsyenqkxnbqtsmm

        System.out.println("---------------------");
        System.out.println(2);

        System.out.println(judgeEquivalent("wssvcswtyktttnmxfiev", "vjkuqlyncjjdqosxfhqt"));
        System.out.println(judgeEquivalent("wssvcswtyktttnmxfiev", "rbugbzcyffxsybrlhlum"));
        System.out.println(judgeEquivalent("wssvcswtyktttnmxfiev", "yypddovzsaxpdsyhoqpi"));
        System.out.println(judgeEquivalent("wssvcswtyktttnmxfiev", "vlktqujxqofjyhqnsjcd"));
        System.out.println(judgeEquivalent("wssvcswtyktttnmxfiev", "qnvtsjqlfdcxyjjhkuqo"));
        System.out.println(judgeEquivalent("wssvcswtyktttnmxfiev", "ynfvwtwkttestvcissmx"));
        System.out.println(judgeEquivalent("wssvcswtyktttnmxfiev", "xzcmfgryubhfblysulrb"));
        System.out.println(judgeEquivalent("wssvcswtyktttnmxfiev", "ctynmkwisvttevtxwsfs"));

        wssvcswtyktttnmxfiev、ynfvwtwkttestvcissmx、ctynmkwisvttevtxwsfs


        System.out.println("---------------------");
        System.out.println(3);

        System.out.println(judgeEquivalent("vjkuqlyncjjdqosxfhqt", "rbugbzcyffxsybrlhlum"));
        System.out.println(judgeEquivalent("vjkuqlyncjjdqosxfhqt", "yypddovzsaxpdsyhoqpi"));
        System.out.println(judgeEquivalent("vjkuqlyncjjdqosxfhqt", "vlktqujxqofjyhqnsjcd"));
        System.out.println(judgeEquivalent("vjkuqlyncjjdqosxfhqt", "qnvtsjqlfdcxyjjhkuqo"));
        System.out.println(judgeEquivalent("vjkuqlyncjjdqosxfhqt", "ynfvwtwkttestvcissmx"));
        System.out.println(judgeEquivalent("vjkuqlyncjjdqosxfhqt", "xzcmfgryubhfblysulrb"));
        System.out.println(judgeEquivalent("vjkuqlyncjjdqosxfhqt", "ctynmkwisvttevtxwsfs"));

        vjkuqlyncjjdqosxfhqt、qnvtsjqlfdcxyjjhkuqo


        System.out.println("---------------------");
        System.out.println(4);

        System.out.println(judgeEquivalent("rbugbzcyffxsybrlhlum", "yypddovzsaxpdsyhoqpi"));
        System.out.println(judgeEquivalent("rbugbzcyffxsybrlhlum", "vlktqujxqofjyhqnsjcd"));
        System.out.println(judgeEquivalent("rbugbzcyffxsybrlhlum", "qnvtsjqlfdcxyjjhkuqo"));
        System.out.println(judgeEquivalent("rbugbzcyffxsybrlhlum", "ynfvwtwkttestvcissmx"));
        System.out.println(judgeEquivalent("rbugbzcyffxsybrlhlum", "xzcmfgryubhfblysulrb"));
        System.out.println(judgeEquivalent("rbugbzcyffxsybrlhlum", "ctynmkwisvttevtxwsfs"));

        rbugbzcyffxsybrlhlum、xzcmfgryubhfblysulrb


        System.out.println("---------------------");
        System.out.println(5);

        System.out.println(judgeEquivalent("yypddovzsaxpdsyhoqpi", "vlktqujxqofjyhqnsjcd"));
        System.out.println(judgeEquivalent("yypddovzsaxpdsyhoqpi", "qnvtsjqlfdcxyjjhkuqo"));
        System.out.println(judgeEquivalent("yypddovzsaxpdsyhoqpi", "ynfvwtwkttestvcissmx"));
        System.out.println(judgeEquivalent("yypddovzsaxpdsyhoqpi", "xzcmfgryubhfblysulrb"));
        System.out.println(judgeEquivalent("yypddovzsaxpdsyhoqpi", "ctynmkwisvttevtxwsfs"));

        yypddovzsaxpdsyhoqpi


        System.out.println("---------------------");
        System.out.println(6);

        System.out.println(judgeEquivalent("vlktqujxqofjyhqnsjcd", "qnvtsjqlfdcxyjjhkuqo"));
        System.out.println(judgeEquivalent("vlktqujxqofjyhqnsjcd", "ynfvwtwkttestvcissmx"));
        System.out.println(judgeEquivalent("vlktqujxqofjyhqnsjcd", "xzcmfgryubhfblysulrb"));
        System.out.println(judgeEquivalent("vlktqujxqofjyhqnsjcd", "ctynmkwisvttevtxwsfs"));

        vlktqujxqofjyhqnsjcd、qnvtsjqlfdcxyjjhkuqo


        System.out.println("---------------------");
        System.out.println(7);

        System.out.println(judgeEquivalent("qnvtsjqlfdcxyjjhkuqo", "ynfvwtwkttestvcissmx"));
        System.out.println(judgeEquivalent("qnvtsjqlfdcxyjjhkuqo", "xzcmfgryubhfblysulrb"));
        System.out.println(judgeEquivalent("qnvtsjqlfdcxyjjhkuqo", "ctynmkwisvttevtxwsfs"));

        qnvtsjqlfdcxyjjhkuqo


        System.out.println("---------------------");
        System.out.println(8);

        System.out.println(judgeEquivalent("ynfvwtwkttestvcissmx", "xzcmfgryubhfblysulrb"));
        System.out.println(judgeEquivalent("ynfvwtwkttestvcissmx", "ctynmkwisvttevtxwsfs"));

        ynfvwtwkttestvcissmx、ctynmkwisvttevtxwsfs


                vrvamqsyenqkxnbqtsmm
        wssvcswtyktttnmxfiev、ynfvwtwkttestvcissmx、ctynmkwisvttevtxwsfs
        vjkuqlyncjjdqosxfhqt、qnvtsjqlfdcxyjjhkuqo
        rbugbzcyffxsybrlhlum、xzcmfgryubhfblysulrb
                yypddovzsaxpdsyhoqpi
        vlktqujxqofjyhqnsjcd、qnvtsjqlfdcxyjjhkuqo
                qnvtsjqlfdcxyjjhkuqo
        ynfvwtwkttestvcissmx、ctynmkwisvttevtxwsfs


                vrvamqsyenqkxnbqtsmm
        wssvcswtyktttnmxfiev、ynfvwtwkttestvcissmx、ctynmkwisvttevtxwsfs
        vjkuqlyncjjdqosxfhqt、qnvtsjqlfdcxyjjhkuqo、vlktqujxqofjyhqnsjcd
        rbugbzcyffxsybrlhlum、xzcmfgryubhfblysulrb
                yypddovzsaxpdsyhoqpi

        String[] wssvcswtyktttnmxfievs = splitAStringToTwoByNumber("rbugbzcyffxsybrlhlum");
        System.out.println(wssvcswtyktttnmxfievs[0]);
        System.out.println(wssvcswtyktttnmxfievs[1]);

        String[] ynfvwtwkttestvcissmxs = splitAStringToTwoByNumber("xzcmfgryubhfblysulrb");
        System.out.println(ynfvwtwkttestvcissmxs[0]);
        System.out.println(ynfvwtwkttestvcissmxs[1]);*/

    }







}
