package com.standbyme.sortAlgorithm;

/**
 * 归并排序
 * 1. 分块：一直处于二，知道数组的长度不大于2
 * 2. 合并 两个块两个块合并
 */

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{8,7,10,2,6,4};
        int[] ints = mergeSort(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] mergeSort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums;
        }
        return block(nums, 0, nums.length-1);
    }

    public static int[] block(int[] nums, int start, int end) {

        if (end-start <1){
            return nums;
        }

        int flag = (start + end) / 2;
        nums = block(nums, start, flag);
        nums = block(nums, flag +1, end);
        nums = merge(nums,start,flag,end);
        return nums;
    }

    /**
     * 默认mid属于前一块的，start->mid已经排好序了，mid+1->end已经排好序了
     * @param nums
     * @param start
     * @param mid
     * @param end
     * @return
     */
    public static int[] merge(int[] nums, int start, int mid, int end) {
        //表示当前前一块已合并的下角标
        int n = start;
        //表示当前后一块已合并的下角标
        int m = mid+1;
        //放在数组的什么位置
        int flag = start;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        while (true){
            if (n > mid && m > end) {
                break;
            }else if (n > mid){
                result[flag] = nums[m];
                m++;
                flag++;
            } else if (m > end) {
                result[flag] = nums[n];
                n++;
                flag++;
            }else {
                if (nums[n]>nums[m]){
                    result[flag] = nums[m];
                    m++;
                }else {
                    result[flag] = nums[n];
                    n++;
                }
                flag++;
            }

        }
        return result;
    }
 }
