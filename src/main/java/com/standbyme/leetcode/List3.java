package com.standbyme.leetcode;


//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 5503 👎 0


import java.util.Map;
import java.util.TreeMap;

public class List3 {


    public static void main(String[] args) {

        Integer pwwkew = test("abba");
        System.out.println(pwwkew);

    }


    public static int test(String str) {

        if (str == null ) {
            return 0;
        }
        if (str.length()==1) {
            return 1;
        }


        int lastIndex = 0;
        String mid = "";
        Map<Character,Integer> tmp = new TreeMap<>();
        int i = 0;
        for (i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer put = tmp.put(c, i);
            if (put != null&&put>=lastIndex) {
                String substring = str.substring(lastIndex, i);
                if (substring.length() > mid.length()) {
                    mid = substring;
                }
                lastIndex = put+1;
            }
        }

        if (lastIndex < i) {
            String substring = str.substring(lastIndex, i);
            if (substring.length() > mid.length()) {
                mid = substring;
            }
        }


        return mid.length();
    }




}
