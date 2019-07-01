package Sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sort {
    /**
     * 冒泡
     * @param a
     * @return
     */
    public static int[] sort(int[] a){

        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1-i; j++) {
                int temp;
                if (a[j+1]<a[j]){
                    temp=a[j];//两个数交换  依靠第三个数
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }

return a;

    }

    /**
     * 选择排序
     * k指向开始遍历的元素  在第二次for循环的遍历中如果出现比k小的数 就与k交换
     *
     * @param a
     * @return
     */
   public  static  int[] selectSort(int[] a){
        int k=0;
        int temp=0;
       for (int i = 0; i <a.length-1; i++) {
          k=i; //定义一个指向遍历数来的数
           for (int j = i; j <a.length ; j++) {
               if (a[k]>a[j]){
                   k=j;
               }
           }
            temp=a[k];
           a[k]=a[i];
           a[i]=temp;
       }
return a;
   }

    /**
     * 插入排序
     * @param arr
     * @return
     */

   public static int[]  insertSort(int[] arr){

           int i, j;
           int n = arr.length;
           int target;

           //假定第一个元素被放到了正确的位置上
           //这样，仅需遍历1 - n-1
           for (i = 1; i < n; i++)
           {
               j = i;
               target = arr[i];//把第二个元素保存到变量中

               while (j > 0 && target < arr[j - 1])
               {
                   arr[j] = arr[j - 1];
                   j--;//减一次就再和前一个做对比
               }

               arr[j] = target;
           }
       return arr;

   }

    /**
     * 希尔排序
     ** 定义一个步长d  然后同a[i]与a[i+d]进行比较   a[i]>a[i+d]则进行交换
     *
     * 每遍历一个d--
     *
     * @param arr
     * @return
     */
   public  static  int[]  heerSort(int [] arr){

       int d=arr.length/2;//定义默认步长
while (true){
       for (int i = 0; i < arr.length; i++) {

           for (int j = 0; j+d < arr.length; j+=d) {
                int temp;
               if (arr[j]>arr[j+d]){
                   temp=arr[j];
                   arr[j]=arr[j+d];
                   arr[j+d]=temp;
               }
           }
       }
       if (d==1){
           break;
       }
       d--;}
return arr;

   }
     public static void main(String[] args) {
        int[]  arr={23,4,55,6,7,77,53,78,1,3,5,0,-1};

   /*冒泡

    int[] sort = sort(arr);
        for (int i : sort) {
        System.out.println(i);
    }*/
       /* 选择排序
       int[] ints = selectSort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }*/
       //插入排序
       /* int[] ints = insertSort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }*/
      /* 希尔排序
       int[] ints = heerSort(arr);
         for (int anInt : ints) {
             System.out.println(anInt);
         }
*/

     }


}