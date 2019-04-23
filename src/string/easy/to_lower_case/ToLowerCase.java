package string.easy.to_lower_case;

import org.junit.Test;

/**
 * @author zlb
 * @description:
 * @date 2019/4/8 20:49
 */
public class ToLowerCase {

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i=0; i<chars.length; i++) { // 注：这里使用高级for循环不行
            if(chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] += 32;
            }
        }
        return new String(chars);
    }

    @Test
    public void test() {
        String str = "Hello";
        System.out.println(toLowerCase(str));
    }

}
