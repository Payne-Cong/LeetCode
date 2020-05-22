package org.pc.group_1;

import java.util.Arrays;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 *
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 *
 */
public class Solution_1371 {

    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0); // 00001
            } else if (ch == 'e') {
                status ^= (1 << 1); // 00010
            } else if (ch == 'i') {
                status ^= (1 << 2); // 00100
            } else if (ch == 'o') {
                status ^= (1 << 3); // 01000
            } else if (ch == 'u') {
                status ^= (1 << 4); // 10000
            }
            System.out.print("i:"+i+" char:"+ch+" status:"+ status+" ");
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
            System.out.println("pos["+status+"]= "+pos[status]);
        }
        return ans;
    }

    public static void main(String[] args) {

        Solution_1371 Main = new Solution_1371();// aeiou
        int n = Main.findTheLongestSubstring("leetcodeo");
        System.out.println(n);

//        举个例子，s='leetcodeo'
//        dp[] 表示的是 当前状态索引的位置
//        00001 a
//        00010 e
//        00100 i
//        01000 o
//        10000 u
//        例如：10001， a和u出现了奇数次，e,i,o出现了偶数次
//        题目表述为 在 [i,j]范围的子串，元音字母出现偶数次的最大长度
//        
//        首先status状态初始化为0，
//        dp[0]=-1，为了计算长度方便定义，或者理解为，开始计算前，参照点在第一个字符之前，也就是 -1 的位置
//        i=0，l 不是元音，status 不变，status = 0, dp[0] = -1
//        i=1，e 是元音，status 变化，由 0 与 2 做异或运算 变为 2，二进制下为 [00010] dp对应当前 status 对应索引更新为 1, status=00010,dp[2]=1
//        i=2，e 是元音，status 变化，由 2 与 2 做异或运算 变为 0，二进制下为 [00000] 即初始状态，更新 res 为 2-(-1) = 3, status=00000,dp[0]=3
//        i=3，t 不是元音，status 不变，res 更新为 3-(-1) = 4,status=00000,dp[0]=4
//        i=4，c 不是元音，status 不变，res 更新为 4-(-1) = 5,status=00000,dp[0]=5
//        i=5，o 是元音，status，由 0 与 8 做异或运算变为 8，二进制下为 [01000]，dp 对应当前 status 对应索引更新为 5, status=01000,dp[8]=5
//        i=6，d 不是元音，status 不变，对应 cur_len 为 6-5=1，没有 5 大，所以当前 status对应的索引 还是 5, status=01000,dp[8]=max(1,5)
//        i=7，e 是元音，status 变化，由 8 与 2 做异或运算变为 10，二进制下为 [01010]，dp 对应当前 status 对应索引更新为 7,(当前状态没有出现过，将当前位置记录下来)
//        i=8，o 是元音，status 变化，由 10 与 8 做异或运算变为 2，二进制下为 [00010]，由于这个 status 在 i=1 出现过,dp[2]=1，所以用这个对应的 i 来更新 cur_len = i-dp[status] = 8-1 = 7，同时 res 更新到 7
//        遍历结束，结果为 7


    }

}
