package string.easy.reverse_words_in_a_string_III;

import org.junit.Test;

/**
 * @author zlb
 * @description: 557: https://leetcode.com/problems/reverse-words-in-a-string-iii/
 * @date 2019/6/30 11:11
 */
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }

    @Test
    public void test() {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

}
