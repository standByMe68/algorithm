package com.standbyme.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * n皇后问题
 */
public class QueensProblem {

    public static List<Map<Integer, Integer>> result = new ArrayList<>();
    public static Integer count = 0;


    public static void main(String[] args) {
        queensProblem(6,1,new HashMap<>());
        System.out.println(count+"="+count);
    }


    /**
     *
     * @param queenNum  当前皇后的数量,从1开始
     * @param currQueen 当前是第几个皇后
     * @param queensPosition 皇后的位置
     * @return
     */
    public static Map<Integer, Integer> queensProblem(int queenNum,int currQueen,Map<Integer, Integer> queensPosition) {

        List<Integer> mid = new ArrayList<>();
        for (int i = 0; i < queenNum; i++) {
            mid.add(i);
        }

        //判断当前皇后可以放的位置
        List<Integer> noQueensPosition = new ArrayList<>();
        queensPosition.forEach((x, y) ->{
            noQueensPosition.add( y);
            //计算主对角线
            Integer m = currQueen - 1 - x + y;
            if (m >= 0 && m < queenNum) {
                noQueensPosition.add(m);
            }
            //计算副对角线
            Integer n = x + y - currQueen + 1;
            if (0 <= n && n < queenNum) {
                noQueensPosition.add(n);
            }
        });

        mid.removeAll(noQueensPosition);

        if (currQueen == queenNum) {
            if (mid.size() == 0) {
                return null;
            } else {
                queensPosition.put(currQueen - 1, mid.get(0));
                System.out.println(queensPosition);
                count++;
                queensPosition.remove(currQueen-1);
                return queensPosition;
            }
        }

        //遍历递归皇后的位置
        mid.forEach(x ->{
            queensPosition.put(currQueen - 1, x);
            Map<Integer, Integer> integerIntegerMap = queensProblem(queenNum, currQueen + 1, queensPosition);
        });
        //如果当前节点的所有选择都不能满足要求，删除该节点
        queensPosition.remove(currQueen - 1);
        return null;

    }



}
