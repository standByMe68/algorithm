package com.standbyme.leetcode;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学
// 👍 6217 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class List2 {

    public static void main(String[] args) {

        ListNode v1 = new ListNode(9);
        v1.next = new ListNode(9);
        v1.next.next = new ListNode(9);
        v1.next.next.next = new ListNode(9);
        v1.next.next.next.next = new ListNode(9);
        v1.next.next.next.next.next = new ListNode(9);
        v1.next.next.next.next.next.next = new ListNode(9);

        ListNode v2 = new ListNode(9);
        v2.next = new ListNode(9);
        v2.next.next = new ListNode(9);
        v2.next.next.next = new ListNode(9);

        ListNode listNode = list2(v1, v2);
        System.out.println();


    }


    public static ListNode list2(ListNode v1, ListNode v2) {

        ListNode result = null;
        int carry = 0;
        int midRes = 0;
        while (v1 != null || v2 != null) {
            int v1Val  ;
            int v2Val = 0;
            if (v1 == null) {
                v1Val = 0;
            }else {
                v1Val = v1.val;
            }
            if (v2 == null) {
                v2Val = 0;
            }else{
                v2Val = v2.val;

            }
            midRes = v2Val + v1Val;
            midRes += carry;
            if (midRes >= 10) {
                carry = 1;
                midRes = midRes - 10;
            } else {
                carry = 0;
            }
            result = setNode(result, midRes);
            if (v1 != null) {
                v1 = v1.next;
            }
            if (v2 != null) {
                v2 = v2.next;
            }
        }

        if (carry == 1) {
            setNode(result, carry);
        }

        return result;
    }

    public static ListNode setNode(ListNode result,int midRes) {
        if (result == null) {
            result = new ListNode(midRes);
        } else {
            boolean midFlag = true;
            ListNode midNode = result;
            do {
                if (midNode.next == null) {
                    midNode.next = new ListNode(midRes);
                    midFlag = false;
                } else {
                    midNode = midNode.next;
                }
            } while (midFlag);

        }
        return result;
    }






    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
