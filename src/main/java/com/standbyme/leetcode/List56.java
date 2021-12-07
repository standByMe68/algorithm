package com.standbyme.leetcode;

//给出一个区间的集合，请合并所有重叠的区间。
//
//
//
// 示例 1:
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
//
//
//
// 提示：
//
//
// intervals[i][0] <= intervals[i][1]
//
// Related Topics 排序 数组

public class List56 {


    public static void main(String[] args) {

        int[][] i = {{1, 3},  {8, 16}, {2, 6},{15, 18}};
        int[][] test = test(i);

        System.out.println();

    }

    public static int[][] test(int[][] i){

        if (i.length <= 1){
            return i;
        }
        /*Arrays.stream(i).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]>o2[0]?1:-1;
            }
        });*/

        //快速排序
        for (int x = 0 ; x < i.length ; x++){
            for (int y = 0 ; y< i.length-1-x ; y++ ){
                int[] temp;
                if (i[y][0]>i[y+1][0]){
                    temp = i[y+1];
                    i[y+1] = i[y];
                    i[y] = temp;
                }
            }
        }

        int[][] result = new int[i.length][2];
        int[] relust = i[0];
        Integer flag1 = 0;
        for (int x = 1 ; x < i.length ;x++){
            if (i[x][0] >= relust[0] && i[x][0]<=relust[1]){
                if (i[x][1]>relust[1]){
                    relust[1] = i[x][1];
                }
            }else {
                result[flag1] = relust;
                relust = i[x];
                flag1++;
            }
            if (x == i.length-1){
                result[flag1] = relust;
            }
        }
        return result;
    }

}
