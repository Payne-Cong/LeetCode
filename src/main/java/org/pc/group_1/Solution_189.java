package org.pc.group_1;

import java.util.Arrays;

/**
 * 189. 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class Solution_189 {

    /**
     * 暴力
     * 时间复杂度：O(n*k) 。每个元素都被移动 1 步 O(n) k次 O(k) 。
     * 空间复杂度：O(1) 。没有额外空间被使用。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] rotate(int[] nums, int k) {
        int len = nums.length;
        int j = len-1;
        if(k == 0) return nums;
        while(k > 0){
            for(int i = j ;i > 0 ;i --){
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
            k--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 2;
        printfArray(new Solution_189().rotate(arr,k));

    }

    public static void printfArray(int[] arr){
        for(int a:arr){
            System.out.print(a);
        }
    }

    // 12345 ->2 = 45123
    // 1234 ->2 = 3412
    // 1234 ->1 = 4123

    // 1243 1423 4123
    // 1234 1243 143


}
