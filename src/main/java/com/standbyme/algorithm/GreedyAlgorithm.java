package com.standbyme.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 贪心算法
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        time();
    }


    public static void time() {

        int[][] time = new int[2][11];
        time[0][0] = 1;
        time[0][1] = 3;
        time[0][2] = 0;
        time[0][3] = 5;
        time[0][4] = 3;
        time[0][5] = 5;
        time[0][6] = 6;
        time[0][7] = 8;
        time[0][8] = 8;
        time[0][9] = 2;
        time[0][10] = 12;
        time[1][0] = 4;
        time[1][1] = 5;
        time[1][2] = 6;
        time[1][3] = 7;
        time[1][4] = 8;
        time[1][5] = 9;
        time[1][6] = 10;
        time[1][7] = 11;
        time[1][8] = 12;
        time[1][9] = 13;
        time[1][10] = 14;

        HashMap<Integer, Integer> result = new HashMap<>();

        //找出最小的时间点
        int min = time[0][0];
        for (int i = 0; i < time[0].length; i++) {
            if (time[0][i] < min) {
                min = time[0][i];
            }
        }


        int start = min;
        int j = 0;
        while (true) {
            int count = 0;
            int end = 1000;
            for (int i = 0; i < time[0].length; i++) {
                int c = time[0][i] - start;
                if (c<=end&&time[0][i]>=start) {
                    end = c;
                    j = i;
                } else {
                    count++;
                }
            }
            start = time[1][j];
            result.put(time[0][j], time[1][j]);
            if (count >= time[0].length) {
                System.out.println(result);
                return;
            }
        }










    }



    public static void board() {
        //创建广播电台，放入到Map中
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        //将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入到map
        broadcasts.put("k1",hashSet1);
        broadcasts.put("k2",hashSet2);
        broadcasts.put("k3",hashSet3);
        broadcasts.put("k4",hashSet4);
        broadcasts.put("k5",hashSet5);

        //allAreas,存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建ArrayList，存放选择的集合
        ArrayList<String> selects = new ArrayList<String>();

        //定义一个临时的集合,在遍历的过程中,存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<>();

        //定义给maxKey，保存在一次遍历过程中，能够覆盖最大未覆盖的地区的电台key，如果key不为空，则会加入到selects


        while (allAreas.size() != 0){ //如果allAreas不为0，则表示还没有覆盖到所有的地区
            //每进行一次while，需要
            String maxKey = broadcasts.keySet().iterator().next();

            //遍历broadcasts，取出对应的key
            for (String key : broadcasts.keySet()) {
                //每进行一次for
                tempSet.clear();;
                //当前这个key能够覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //求出temSet和allAreas集合的交集,交集会赋给temSet
                tempSet.retainAll(allAreas);
                //如果当前这个集合包含的未覆盖地区的数量，比maxKey指向的集合地区还多，就需要重置maxKey
                if (tempSet.size() > 0 && (tempSet.size() > broadcasts.get(maxKey).size())){
                    maxKey = key;
                }
            }
            //maxKey != null,就应该将maxKey加入selects
            if (maxKey != null){
                selects.add(maxKey);
                //将maxKey指向的广播电台的地区从allAreas去掉
                allAreas.removeAll(broadcasts.get(maxKey));
                broadcasts.remove(maxKey);
            }
        }
        System.out.println("得到的选择结果为:" + selects);
    }
}
