package com.standbyme.leetcode;

//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//
//
// 示例 1：
//
//
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
//
//
// 示例 2：
//
//
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
//
//
// 示例 3：
//
//
//输入：digits = [0]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
// Related Topics 数组
// 👍 652 👎 0
public class List66 {

    public static void main(String[] args) {
        int[] num = {9, 9, 9, 9, 9};
        num = test(num);
        System.out.println(num);
    }

    public static int[] test(int[] num) {
        if (num == null) {
            return num;
        }
        return test(num, num.length-1);
    }

    //如果当前下角标的数据加1大于等于10，调用该方法，并将当前变成0
    //如果当前下角标变成-1，直接返回数组
    //如果当前下角标为0时，相加大于9，需要进行数组更换
    public static int[] test(int[] nums, int index) {

        if (index == 0 && nums[index] + 1 >= 10) {
            int[] mid = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                mid[nums.length + 1 - i-1] = nums[nums.length - i-1];
            }
            mid[0] = 1;
            mid[1] = 0;
            return mid;
        } else if (nums[index] + 1 >= 10) {
            nums[index] = 0;
            nums = test(nums, --index);
        } else {
            nums[index] += 1;
            return nums;
        }
        return nums;
    }

}
