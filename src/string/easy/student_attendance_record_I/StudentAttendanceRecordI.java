package string.easy.student_attendance_record_I;

import org.junit.Test;

/**
 * @author zlb
 * @description: 551: https://leetcode.com/problems/student-attendance-record-i/
 * @date 2019/7/17 8:52
 */
public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        char[] charArray = s.toCharArray();
        int numA = 0;
        int maxNumL = 0;
        int tempNumL = 0;
        for (char c : charArray) {
            if (c == 'L') {
                tempNumL++;
                if (tempNumL > maxNumL) {
                    maxNumL = tempNumL;
                }
            } else {
                if (c == 'A') {
                    numA++;
                }
                tempNumL = 0;
            }
        }
        if (numA <= 1 && maxNumL <= 2) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {

        // String str = "PPALLL";
        String str = "PPALLLPLLLLPLL";
        System.out.println(checkRecord(str));

    }


}
