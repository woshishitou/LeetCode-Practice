package string.easy.roman_to_integer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zlb
 * @description: 13: https://leetcode.com/problems/roman-to-integer/
 * @date 2019/6/30 11:20
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        String pre = "";
        int result = 0;
        for (char c: s.toCharArray()) {
            String next = String.valueOf(c);
            if ("".equals(pre)) {
                result += map.get(next);
            } else {
                if (map.get(pre+next) != null) {
                    result = result - map.get(pre) + map.get(pre+next);
                } else {
                    result += map.get(next);
                }
            }
            pre = next;
        }
        return result;
    }

    @Test
    public void test() {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
        assert romanToInt(s) == 1994;
    }

}
