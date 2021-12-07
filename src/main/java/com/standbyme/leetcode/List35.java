package com.standbyme.leetcode;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找

public class List35 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,7,9,10};
        System.out.println(test(nums,8));
    }

    public static int test(int[] nums,int target){
        return dichotomy(nums, 0, nums.length-1, target);
    }

    //左闭右开
    public static int dichotomy(int[] nums,int start,int end,int target){
        int flag = (end+start)/2;
        if (end - start == 1||end==start){
            if (target == nums[end]){
                return end;
            }else if (target > nums[end]){
                return end+1;
            }else if (target < nums[end]){
                if (end ==start){
                    return end ;
                }else {
                    if (target <= nums[start]) {
                        return start;
                    } else{
                        return start + 1;
                    }
                }
            }
        }
        if (target > nums[flag]) {
            return dichotomy(nums, flag + 1, end, target);
        } else if (target < nums[flag]) {
            return dichotomy(nums, start, flag - 1, target);
        } else {
            return flag;
        }
    }

}
