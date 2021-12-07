package com.standbyme.sortAlgorithm;

/**
 * 选择排序
 * 每次轮询将最小的放在轮询部分的最前面或者最大的放在轮询的最后面
 * 与冒泡排序不同的是，选择排序每次轮询都会把比较值放在一个地方,每次轮询选择最大的一个
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */

public class SelectionSort {


    public static void main(String[] args) {
        int[] nums = new int[]{8,7,10,2,6,4};
        int[] ints = selectionSort(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] selectionSort(int[] nums){

        if (nums == null || nums.length == 1) {
            return nums;
        }

        for (int i = 0; i < nums.length-1; i++) {
            for(int j=i;j<nums.length;j++){
                if (nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return nums;

    }

}
