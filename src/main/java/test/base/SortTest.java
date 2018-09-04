package test.base;

import junit.framework.TestCase;

/**
 *JAVA八大排序
 * @author Json
 * @since 1.0.0
 */
public class SortTest extends TestCase {
    // public static int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23,
    //        34, 15, 35, 25, 53, 51 };

    /**
     * 1.1插入排序之直接插入排序
     * 基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排好顺序的，
     * 现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。
     * 如此反复循环，直到全部排好顺序。
     *
     */
    public void directInsertSort() {
        int a[] = { 1, 2 };
        int tem = 0;
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            tem = a[i];
            for (; j >= 0 && tem < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = tem;
        }
        printArr(a);
    }

    public static void printArr(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     *  1.2插入排序之<strong>希尔排序</strong>
     */
    public void insertShellSort() {
        int arrays[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15,
                35, 25, 53, 51 };
        for (int d = arrays.length / 2; d > 0; d = d / 2) {
            for (int c = 0; c < arrays.length - d; c++) {
                for (int i = c; i < arrays.length; i = i + d) {
                    for (int j = i; j > 0; j = j - d) {
                        if (j < d) {
                            break;
                        }
                        if (arrays[j] < arrays[j - d]) {
                            int tmp;
                            tmp = arrays[j];
                            arrays[j] = arrays[j - d];
                            arrays[j - d] = tmp;

                        }
                    }
                }

            }
        }
        printArr(arrays);
    }

    /**
     * 2.1简单选择排序
     * （基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
                        然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
     */
    public static void chooseSort() {
        int array[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15,
                35, 25, 53, 51 };
        for (int i = 0; i < array.length; i++) {
            int position = i;
            int min = array[i];
            int temp = array[i];
            // System.out.println("循环到了：" + i);

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    position = j;
                    // System.out.println("循环到了：" + (j + 1));
                }
            }
            if (i != position) { //有过交换
                array[i] = array[position];
                array[position] = temp;
            }
        }
        printArr(array);
    }
    /**
     * 选择排序，每次循环拿出最小（大）的那个和已经排好序的末尾替换。
     * 时间复杂度 O(n^2)
     * 空间复杂度O(1)
     * 一般的递归算法就要有o(n)的空间复杂度了,因为每次递归都要存储返回信息
     * @param arr
     * @return
     */
    public static int[] chooseSort2(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


    public void heapSort() {

    }

    public static void main(String[] args) {
        //        selectSort();
        chooseSort();
    }
}
