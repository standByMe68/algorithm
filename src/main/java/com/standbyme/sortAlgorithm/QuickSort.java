package com.standbyme.sortAlgorithm;

/**
 * 快速排序
 */


public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,6,5};
        int[] ints = quickSort(nums,0,nums.length-1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] quickSort(int[] nums,int start,int end){

        if (nums == null || nums.length == 1) {
            return nums;
        }

        if (end - start < 1) {
            return nums;
        }
        int temp = nums[start];
        int flag = start;
        for (int i = start+1; i <= end;i++) {
            if (nums[i] < temp) {
                int tmp = nums[i];
                for (int j = i; j > flag; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[flag] = tmp;
                flag++;
            }
        }
        nums = quickSort(nums, start, flag - 1);
        nums = quickSort(nums, flag + 1, end);
        return nums;
    }


}
