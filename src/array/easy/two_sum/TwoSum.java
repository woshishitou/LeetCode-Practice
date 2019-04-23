package array.easy.two_sum;

import org.junit.Test;

/**
 * @author zlb
 * @description: 1
 * @date 2019/3/30 22:10
 */
public class TwoSum {

    private int[] twoSum(Integer[] array, int target) {

        long begin = System.nanoTime();

        int[] result = new int[2];
        for (int i=0; i<array.length; i++) {
            for (int j=i+1; j<array.length; j++) {
                if (array[i] + array[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    i = array.length-1;
                    break;
                }
            }
        }

        long end = System.nanoTime();

        System.out.println((end - begin) + " ns");

        return result;
    }

    @Test
    public void test() {

        // Integer[] array = {2, 7, 11, 15};
        // int target = 18;
        // 1,2

        // Integer[] array = {2, 7, 11, 15};
        // int target = 9;
        // 0,1

        Integer[] array = {2, 7, 11, 15};
        int target = 26;
        // 2,3

        // Integer[] array = {2, 7, 11, 15};
        // int target = 25;
        // 0,0

        int[] result;
        result = twoSum(array, target);

        System.out.println("result indices:");
        // System.out.println("0: " + result[0]);
        // System.out.println("1: " + result[1]);
        System.out.println(result[0] + ", " + result[1]);
    }

}
