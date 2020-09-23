package org.pc.other;

public class SunStringSum {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     *
     * 问题的核心是子数组，子数组可以看作是一段区间，因此可以由起始点和终止点确定一个子数组，两个点中，我们先确定一个点，然后去找另一个点，
     * 比如说，如果我们确定一个子数组的截止元素在 i 这个位置，这个时候我们需要思考的问题是 “以 i 结尾的所有子数组中，和最大的是多少？”，
     * 然后我们去试着拆解，这里其实只有两种情况：
     *
     *    i 这个位置的元素自成一个子数组;
     *
     *    i 位置的元素的值 + 以 i – 1 结尾的所有子数组中的子数组和最大的值
     *
     * 你可以看到，我们把第 i 个问题拆成了第 i – 1 个问题，之间的联系也变得清晰
     *
     *
     * 通过上面的分析，其实状态已经有了，dp[i] 就是 “以 i 结尾的所有子数组的最大值”
     *
     * dp[i] = Math.max(dp[i - 1] + array[i], array[i])
     * 化简:
     * dp[i] = Math.max(dp[i - 1], 0) + array[i]
     *
     */

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int[] dp = new int[n];

        dp[0] = nums[0];

        int result = dp[0];

        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            result = Math.max(result, dp[i]);
        }

        return result;
    }


    public static void main(String[] args) {

    }
}
