package com.standbyme.sortAlgorithm;

/**
 * 桶排序
 */

public class BucketSort {
    private int min;
    private Integer value;
    private BucketSort next;
    private Integer num;

    public static void main(String[] args) {
        int[] nums = new int[]{8,7,10,2,6,4};
        int[] ints = bucketSort(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public  static  int[] bucketSort(int[] nums){
        if (nums == null || nums.length == 1){
            return nums;
        }

        //获取数组中的最大值最小值
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if(max<num){
                max = num;
            }else if (min>num){
                min = num;
            }
        }
        min = (min/10)*10;
        max = (max % 10 == 0 ? max + 10 : (max / 10) * 10 + 10);

        BucketSort[] bucketSorts = new BucketSort[(max-min)/10];

        for (int i = 0; i < bucketSorts.length; i++) {
            BucketSort bucketSort = new BucketSort();
            bucketSort.min = i * 10 + min;
            bucketSort.value = i * 10 + min;
            bucketSort.num = 0;
            bucketSorts[i] = bucketSort;
        }

        //数据入桶
        for (int i = 0; i <  nums.length; i++) {
            for (BucketSort bucketSort : bucketSorts) {
                if (bucketSort.min<=nums[i]&&bucketSort.min+10>nums[i]){
                    BucketSort mid = bucketSort;
                    while (true){
                        if (mid.value < nums[i] && mid.next == null) {
                            BucketSort bucketSort1 = new BucketSort();
                            bucketSort1.value = nums[i];
                            bucketSort1.num = 1;
                            mid.next = bucketSort1;
                            break;
                        }else if (mid.value<nums[i]&&mid.next.value>nums[i]){
                            BucketSort bucketSort1 = new BucketSort();
                            bucketSort1.value = nums[i];
                            bucketSort1.num = 1;
                            bucketSort1.next = mid.next;
                            mid.next = bucketSort1;
                            break;
                        }else if (mid.value<nums[i]&&mid.next.value<=nums[i]){
                            mid = mid.next;
                        } else if (mid.value == nums[i]) {
                            mid.num++;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        //遍历桶
        int count = 0;
        for (BucketSort bucketSort : bucketSorts) {
            BucketSort mid = bucketSort;
            while (true){
                if(mid != null){
                    for (int j = 0; j < mid.num; j++) {
                        nums[count] = mid.value;
                        count++;
                    }
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

        return nums;
    }
}
