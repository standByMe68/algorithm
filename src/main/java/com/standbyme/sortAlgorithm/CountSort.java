package com.standbyme.sortAlgorithm;

/**
 * 计数排序
 * 先找到数组中的最大值和最小值
 * 然后开辟空间二维数组，长度为max-min+1
 * 然后遍历放入
 */

public class CountSort {

    public static void main(String[] args) {
        int[] nums = new int[]{8,7,7,10,10,2,6,2,4};
        int[] ints = countSort(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] countSort(int[] nums){

        if (nums == null || nums.length == 1){
            return nums;
        }

        //获取数组中的最大值最小值
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if(max<num){
                max = num;
            }else if (min>num){
                min = num;
            }
        }
        //构建一维数组
        if (max == min){
            return nums;
        }
        int[] mid = new int[max-min+1];
        for (int i = 0; i < mid.length; i++) {
            mid[i] = 0;
        }

        //排序
        for (int num : nums) {
            mid[num-min]++;
        }

        int count = 0;
        for (int i = 0; i < mid.length; i++) {
            for (int j = 0; j < mid[i]; j++) {
                nums[count] = i+min;
                count++;
            }
        }

        return nums;
    }

}
