package _4排序算法;

import java.util.Arrays;

public class 选择排序2 {
    /*每一轮找到最小的，将最小的放在第一位
    排序轮次：数组大小 -1 次
    每轮排序：依次递减
    eg：[1,31,542,12,54]
    排序轮次：4
    第一轮排序比较：4次
    第二轮比较：3次
    * */
public static void selectSort(int [] a){
    for (int k=0;k<a.length-1;k++){
        int min=a[k];
        int minIndex=k;
        for (int i=k;i<a.length;i++){
            if (min>a[i]) {
                min = a[i];//更新最小值
                minIndex=i;//存下最小值下标便于最后和表头交换
            }
        }
        int temp=a[k];
        a[k]=min;//这一轮最小值放在这一轮最前面
        a[minIndex]=temp;//交换最小值和数组头的位置

    }


}
    public static void main(String[] args) {
        int[] a=new int[]{12,341,1,23,5111,21,421};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }

}

