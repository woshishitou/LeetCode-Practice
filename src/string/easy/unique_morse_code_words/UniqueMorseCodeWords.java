package string.easy.unique_morse_code_words;

import org.junit.Test;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 804 https://leetcode.com/problems/unique-morse-code-words/
 * @Author zlb
 * @Date 2019/5/29 8:30
 **/
@SuppressWarnings("Duplicates")
public class UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        Map<Character, String> map = new HashMap<Character, String>();
        String[] dotAndDash = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (int i=0; i<26; i++) {
            map.put((char)('a'+i), dotAndDash[i]);
        }
        Set<String> set = new HashSet<String>();
        String concatenation = "";
        for (String word: words) {
            concatenation = "";
            for (char c: word.toCharArray()) {
                concatenation += map.get(c);
            }
            set.add(concatenation);
        }
        int result = set.size();
        System.out.println(result);
        return result;
    }


    // Runtime: 3 ms, faster than 54.63% of Java online submissions for Unique Morse Code Words.
    // Memory Usage: 34.8 MB, less than 98.52% of Java online submissions for Unique Morse Code Words.
    public int uniqueMorseRepresentations54(String[] words) {
        long start = System.nanoTime();
        String[] dotAndDash = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<String>();
        long start1 = System.nanoTime();
        for (String word: words) {
            StringBuilder concatenation = new StringBuilder();
            for (char c: word.toCharArray()) {
                concatenation.append(dotAndDash[c-97]);
            }
            set.add(concatenation.toString());
        }
        long end1 = System.nanoTime();
        System.out.println("uniqueMorseRepresentations54 循环 : "+ (end1-start1) + " 纳秒");
        int result = set.size();
        long end = System.nanoTime();
        System.out.println("uniqueMorseRepresentations54 : "+ (end-start) + " 纳秒");
        return result;
    }

    public int uniqueMorseRepresentations54copy(String[] words) {
        long start = System.nanoTime();
        String[] dotAndDash = {".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.","---",".--.",
                "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<String>();
        long start1 = System.nanoTime();
        for (String word: words) {
            set.add(helpercopy(word, dotAndDash));
        }
        long end1 = System.nanoTime();
        System.out.println("uniqueMorseRepresentations54copy 循环 : "+ (end1-start1) + " 纳秒");
        int result = set.size();
        long end = System.nanoTime();
        System.out.println("uniqueMorseRepresentations54copy : "+ (end-start) + " 纳秒");
        return result;
    }

    private String helpercopy(String str, String[] dotAndDash){
        StringBuilder concatenation = new StringBuilder();
        for(char c : str.toCharArray())
            concatenation.append(dotAndDash[c - 97]);
        return concatenation.toString();
    }

    // TODO: 2019/5/29 基本都一样，为什么时间差距这么大？ 直接原因是封装方法并调用，深层原因是什么

    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Unique Morse Code Words.
    // Memory Usage: 34.8 MB, less than 98.52% of Java online submissions for Unique Morse Code Words.
    // String[] MORSE = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations100(String[] words) {
        long start = System.nanoTime();
        Set<String> set = new HashSet();
        long start1 = System.nanoTime();
        for(int i = 0; i < words.length; i++){
            set.add(helper(words[i]));
        }
        long end1 = System.nanoTime();
        System.out.println("uniqueMorseRepresentations100 循环 : "+ (end1-start1) + " 纳秒");
        long end = System.nanoTime();
        System.out.println("uniqueMorseRepresentations100 : "+ (end-start) + " 纳秒");
        return set.size();
    }

    private String helper(String str){
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray())
            sb.append(MORSE[c - 97]);
        return sb.toString();
    }


    @Test
    public void test() {
        String[] words = {"gin", "zen", "gig", "msg"};
        // System.out.println();
        // otherMethod(words);
        // myMethod(words);
        // TODO: 2019/5/29 调用的先后顺序影响执行时间，越先被调用耗时越长；每次运行只调用一个的话，100的比54的耗时还要长
        uniqueMorseRepresentations100(words);
        uniqueMorseRepresentations54(words);



        // uniqueMorseRepresentations54(words);
        // uniqueMorseRepresentations100(words);
        // uniqueMorseRepresentations54copy(words);
        // System.out.println();
        // System.out.println();
        // System.out.println();
        // myMethod(words);
        // otherMethod(words);
        // System.out.println();
        // System.out.println();
        // System.out.println();


        // // uniqueMorseRepresentations(words);
        // myMethod(words);
        // uniqueMorseRepresentations100(words);
        // uniqueMorseRepresentations54copy(words);
        // System.out.println();
        // System.out.println();
        // System.out.println();
        // uniqueMorseRepresentations54(words);
        // otherMethod(words);
        // System.out.println();
        // System.out.println();
        // System.out.println();
    }





    // 以下是提问代码



    public int myMethod(String[] words) {
        String[] dotAndDash = {".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.","---",".--.",
                "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<String>();
        long start = System.nanoTime();
        for (String word: words) {
            StringBuilder concatenation = new StringBuilder();
            for (char c: word.toCharArray()) {
                concatenation.append(dotAndDash[c-97]);
            }
            set.add(concatenation.toString());
        }
        long end = System.nanoTime();
        System.out.println("myMethod 循环 : "+ (end-start) + " 纳秒");
        int result = set.size();
        return result;
    }



    String[] MORSE = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int otherMethod(String[] words) {
        Set<String> set = new HashSet();
        long start = System.nanoTime();
        for(int i = 0; i < words.length; i++){
            set.add(help(words[i]));
        }
        long end = System.nanoTime();
        System.out.println("otherMethod 循环: "+ (end-start) + " 纳秒");
        return set.size();
    }

    private String help(String str){
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray())
            sb.append(MORSE[c - 97]);
        return sb.toString();
    }





}
