package com.standbyme.sortAlgorithm;

/**
 * 计数排序
 */

public class CardinalSort {

    private int value;
    private CardinalSort next;

    public static void main(String[] args) {
        int[] nums = new int[]{81,72,10,21,65,41,43};
        int[] ints = cardinalSort(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


    public static int[] cardinalSort(int[] nums){
        if (nums == null || nums.length == 1){
            return nums;
        }

        //获取数组中的最大值最小值
        int max = nums[0];
        for (int num : nums) {
            if(max<num){
                max = num;
            }
        }
        int flag = 1 ;
        while (max/10!=0){
            flag++;
            max = max / 10;
        }

        for (int i = 1; i <= flag; i++) {
            CardinalSort[] cardinalSorts = new CardinalSort[10];
            for (int j = 0; j < nums.length; j++) {
                int k = i == 1 ? nums[j] % 10 : nums[j] % ((int)Math.pow(10,i)) / ((int)Math.pow(10,i-1));
                CardinalSort mid = cardinalSorts[k];
                while (true){
                    if (mid == null){
                        CardinalSort cardinalSort = new CardinalSort();
                        cardinalSort.value = nums[j];
                        cardinalSorts[k] = cardinalSort;
                        break;
                    }else if (mid != null && mid.next == null){
                        CardinalSort cardinalSort = new CardinalSort();
                        cardinalSort.value = nums[j];
                        mid.next= cardinalSort;
                        break;
                    }else {
                        mid = mid.next;
                    }
                }
            }
            int count = 0;
            for (CardinalSort cardinalSort : cardinalSorts) {
                CardinalSort mid = cardinalSort;
                while (true){
                    if(mid != null){
                        nums[count] = mid.value;
                        count++;
                        if (mid.next == null){
                            break;
                        }else {
                            mid = mid.next;
                        }
                    }else {
                        break;
                    }
                }
            }

        }

        return nums;

    }



}
