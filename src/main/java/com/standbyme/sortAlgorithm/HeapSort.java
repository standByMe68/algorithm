package com.standbyme.sortAlgorithm;

/**
 * 推排序最精明的点是利用了完全二叉树的性质，将一个数组看作一个堆
 * 每次生成一个大顶堆，将大顶堆数据放入最后即可
 */



public class HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{8,7,7,10,10,2,6,2,4};
        int[] ints = heapSort(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


    public static int[] heapSort(int[] nums) {

        int max = nums.length - 1;

        int tmp;
        for (; max >0 ; max--) {

            for (int i = nums.length / 2 - 1; i >= 0; i--) {
                int maxNode = getMaxNode(nums, i,max);
                if (i != maxNode) {
                    tmp = nums[maxNode];
                    nums[maxNode] = nums[i];
                    nums[i] = tmp;
                }
            }
            tmp = nums[0];
            nums[0] = nums[max];
            nums[max] = tmp;
        }
        return nums;

    }


    public static int getMaxNode(int[] nums,int pIndex,int max) {
        int left = pIndex * 2 + 1;
        int right = pIndex * 2 + 2;
        if (left <= max && right <= max) {
            if (right > nums.length - 1) {
                if (nums[left] > nums[pIndex]) {
                    return left;
                }
            } else {
                if (nums[right] >= nums[left] && nums[right] > nums[pIndex]) {
                    return right;
                } else if (nums[left] >= nums[right] && nums[left] > nums[pIndex]){
                    return left;
                }
            }
        }
        return pIndex;
    }


}
