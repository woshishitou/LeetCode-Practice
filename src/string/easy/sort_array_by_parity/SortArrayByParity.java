package string.easy.sort_array_by_parity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zlb
 * @description: 905: https://leetcode.com/problems/sort-array-by-parity/
 * @date 2019/7/29 21:49
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {

        // 基本思路：
        //  将集合中的偶数和奇数分别放入专门的偶数集合和奇数集合，
        //  然后将偶数集合中的元素放在大集合的前面，奇数集合的元素放在后面

        // 声明奇偶数集合
        int [] evenArray = new int[A.length];
        int [] oddArray = new int[A.length];
        // 记录奇偶数集合当前的元素数量
        int even = 0;
        int odd = 0;

        // 将集合A中的元素按其本身给的奇偶性分为两个集合
        for (int a: A) {
            if (a%2==0) {
                // 偶数
                oddArray[odd] = a;
                odd++;
            } else {
                // 奇数
                evenArray[even] = a;
                even++;
            }
        }

        // 将两个集合合并，偶数集合在前
        for (int i=0; i<A.length; i++) {
            if (i<odd) {
                A[i] = oddArray[i];
            } else {
                A[i] = evenArray[i-odd];
            }
        }

        return A;

    }

    // 附上一个牛逼的解决方案
    // 来源：https://leetcode.com/problems/sort-array-by-parity/discuss/170734/C%2B%2BJava-In-Place-Swap
    // 思路：一句话，将遇到的第i个偶数元素放在第i位置
    /*public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++)
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;;
            }
        return A;
    }*/

    @Test
    public void test() {

        int[] A = {1,2,3,4};
        System.out.println(Arrays.toString(sortArrayByParity(A)));

        // TODO: 2019/7/29 待研究 
        
        int[] a = new int[5];
        a[0] = 2;
        a[1] = 3;
        a[2] = 4;
        System.out.println(a.length);

        List list = new ArrayList<String>();
        list.add("2");
        list.add("4");
        System.out.println(list.size());


    }





}
