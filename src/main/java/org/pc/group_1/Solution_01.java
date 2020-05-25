package org.pc.group_1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 */
public class Solution_01 {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

}
