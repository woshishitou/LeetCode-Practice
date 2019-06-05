package string.easy.robot_return_to_origin;

import org.junit.Test;

/**
 * @Description: 657 https://leetcode.com/problems/robot-return-to-origin/
 * @Author zlb
 * @Date 2019/5/21 20:39
 **/
public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        int lr = 0;
        int ud = 0;
        for (char c: moves.toCharArray()) {
            if ('U' == c) {
                ud += 1;
                continue;
            }
            if ('D' == c) {
                ud -= 1;
                continue;
            }
            if ('R' == c) {
                lr += 1;
                continue;
            }
            if ('L' == c) {
                lr -= 1;
                continue;
            }
        }
        return ud == 0 && lr == 0;
    }

    @Test
    public void test() {
        System.out.println(judgeCircle("LL"));
    }

}


