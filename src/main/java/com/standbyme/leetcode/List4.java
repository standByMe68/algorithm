package com.standbyme.leetcode;
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//
//
// 示例 2：
//
//
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//
// 示例 3：
//
//
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
//
//
// 示例 4：
//
//
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
//
//
// 示例 5：
//
//
//输入：nums1 = [2], nums2 = []
//输出：2.00000
//
//
//
//
// 提示：
//
//
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106
//
//
//
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
// Related Topics 数组 二分查找 分治算法
// 👍 4118 👎 0

public class List4 {

    public static void main(String[] args) {
        double medianSortedArrays = findMedianSortedArrays(new int[]{2,3,4}, new int[]{1});
        System.out.println("medianSortedArrays = " + medianSortedArrays);
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        } else if (nums1.length == 0 && nums2.length > 0) {
            return (nums2.length % 2 == 1) ? nums2[nums2.length / 2] : ((double) (nums2[nums2.length / 2-1] + nums2[nums2.length / 2 ])) / 2;
        } else if (nums1.length > 0 && nums2.length == 0){
            return (nums1.length % 2 == 1) ? nums1[nums1.length / 2] : ((double) (nums1[nums1.length / 2-1] + nums1[nums1.length / 2 ])) / 2;
        }

        int i = 0;
        int j = 0;
        int k = 0;
        int[] mid = new int[nums1.length + nums2.length];

        //数组合并
        while (i < nums1.length || j < nums2.length) {

            if (i >= nums1.length && j < nums2.length) {
                mid[k] = nums2[j++];
            } else if (i < nums1.length && j >= nums2.length) {
                mid[k] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                mid[k] = nums2[j];
                j++;
            } else {
                mid[k] = nums1[i];
                i++;
            }
            k++;
        }

        return (mid.length % 2 == 1) ? mid[mid.length / 2] : ((double) (mid[mid.length / 2-1] + mid[mid.length / 2 ]) )/ 2;
    }





}
