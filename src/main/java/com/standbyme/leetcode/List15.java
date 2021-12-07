package com.standbyme.leetcode;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class List15 {

    public static void main(String[] args) {

        Integer[] test = new Integer[]{-1,0,0,2,-1,0};
        System.out.println(test(test));

    }

    public static List<List<Integer>> test(Integer[] params){

        List<List<Integer>> result = new ArrayList<>();

        Integer zoreNum = 0;

        if (params == null ||params.length<3){
            return result;
        }

        List<Integer> collect1 = Arrays.stream(params).sorted().collect(Collectors.toList());

        for (int i = 0; i < collect1.size()-2; i++) {
            for (int j = i + 1; j < collect1.size() - 1; j++) {
                for (int k = j + 1; k < collect1.size(); k++) {
                    if (collect1.get(i)+collect1.get(j)+collect1.get(k)==0){
                        result.add(Arrays.asList(collect1.get(i),collect1.get(j),collect1.get(k)));
                    }
                }
            }
        }
        List<List<Integer>> collect = result.stream().distinct().collect(Collectors.toList());
        return collect;
    }

}
