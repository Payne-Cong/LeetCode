package org.pc.group_1;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Solution_283 {


    public int[] moveZeroes(int[] nums)  {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return nums;
        }
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                if (i > j) {// #1
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
        return nums;
    }

    public static void printArray(int[] nums){
        for(int i:nums){
            System.out.print(i);
        }
    }


    public static void main(String[] args) {
        int nums[] = {1,0,0,3};
        printArray(new Solution_283().moveZeroes(nums));

    }

    // 10203
    // 12
}
