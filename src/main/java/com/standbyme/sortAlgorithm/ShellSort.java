package com.standbyme.sortAlgorithm;

/**
 * shell排序
 */

public class ShellSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4};
        int[] ints = shellSort(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] shellSort(int[] nums){
        if (nums == null || nums.length==1){
            return nums;
        }
        return grouping(nums, (0 + nums.length) / 2);
    }

    public static int[] grouping(int[] nums,int increment){

        if (increment == 0){
            return nums;
        }

        nums = sort(nums, increment);
        increment = increment / 2;
        return grouping(nums, increment);

    }

    public static int[] sort(int[] nums, int increment) {

        for (int i = 1; i <= increment; i++) {
            int j;
            int temp;
            for (int k = i + increment-1; k < nums.length; k += increment) {
                temp = nums[k];
                for (j = k-increment; j >=0 && nums[j]>temp; j -= increment) {
                    nums[j+increment] = nums[j];
                }
                nums[j+increment] = temp;
            }

        }

        return nums;
    }

}
