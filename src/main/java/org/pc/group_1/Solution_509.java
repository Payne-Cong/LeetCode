package org.pc.group_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Solution_509 {

    public static long factorial(int n) {

          return Stream.iterate(new Long[]{Long.valueOf(0), Long.valueOf(1)}, t -> new Long[]{(t[0] + t[1]) % 1000000007,
                  (t[0] + t[1] + t[1]) % 1000000007}) // 1
                .flatMap(Arrays::stream)
//                .map(e -> e % 1000000007)
                .limit(n+1)
                .collect(Collectors.toList())
                .get(n).intValue();

    }

    public static void main(String[] args) {
        for(int i=0 ;i <= 10 ;i++){
            System.out.println(i+ " : " + factorial(i));
        }

    }

}
