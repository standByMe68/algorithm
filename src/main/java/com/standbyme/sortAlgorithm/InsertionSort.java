package com.standbyme.sortAlgorithm;

/**
 * 插入排序：每次将右边的元素插入到左边有序的数组中
 */

public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{8,7,10,2,6,4};
        int[] ints = insertionSort02(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    public  static int[] insertionSort01(int[] nums){

        if (nums == null || nums.length == 1){
            return nums;
        }

        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {
                if ((j == 0 && nums[0] > nums[i]) || (j > 0 && nums[j-1] < nums[i] && nums[j ] >= nums[i])) {
                    int temp = nums[i];
                  //将j,i-1往前移
                  for (int k = i ; k>j;k--){
                      nums[k] = nums[k - 1];
                  }
                    nums[j] = temp;
                    break;
                }
            }

        }
        return nums;
    }

    /**
     * 忠告：
     * 1. 不要随便使用引用类型，要知道引用类型实际值和什么时候进行改变
     * 2. 需要考虑每一个参数的作用以及过程
     * @param nums
     * @return
     */
    public  static int[] insertionSort02(int[] nums){

        if (nums == null || nums.length == 1){
            return nums;
        }

        int j;
        int temp = 0;

        for ( int i = 1; i < nums.length; i++) {
            temp = nums[i];
            for (j = i-1 ; j >= 0&&nums[j] > temp ; j--) {
                nums[j+1] = nums[j];
            }
            nums[j+1] = temp;
        }
        return nums;
    }


}
