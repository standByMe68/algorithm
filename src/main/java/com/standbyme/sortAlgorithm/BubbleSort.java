package com.standbyme.sortAlgorithm;

/**
 * 冒泡排序算法
 * 每一次对比将大的数据往后放
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */

public class BubbleSort {

    public static void main(String[] args) {

        int[] nums = new int[]{1};
        int[] ints = bubbleSort(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    public static int[] bubbleSort(int[] nums){

        if (nums == null || nums.length == 1) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1;j++) {
                if (nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;

    }


}
