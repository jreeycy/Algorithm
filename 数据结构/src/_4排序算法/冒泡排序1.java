package _4排序算法;

import java.util.Arrays;

public class 冒泡排序1 {/*
几个元素几次排序：【3,5,1,7，9】五个元素，四轮排序，第一次比较4，第二次比较3次，第三次比较2次，第四次比较1次，每一轮将最大值找出
！！：如果在某一轮排序中，没有产生一次交换，则可以直接结束
*/
    public static  void BubbleSort(int [] a){
        for (int k=1;k<a.length;k++){//长度-1轮排序
            boolean flag=true;
            for (int i=0;i<a.length-k;i++){
                if (a[i]>a[i+1]){//如果大于，则交换，将、较大值往后赶
                    int temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                    flag=false;
                }
            }

            if (flag){//说明这一轮一次叫唤都没有，数组已经从小到大，没必要接下来的排序轮次
                return;

            }
        }


    }


    public static void main(String[] args) {
        int[]a1=new int[]{12,45,1,32,512,15};
        BubbleSort(a1);
        System.out.println(Arrays.toString(a1 ));

    }
}
