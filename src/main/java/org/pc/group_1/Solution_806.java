package org.pc.group_1;

public class Solution_806 {

    /**
     * 861. 翻转矩阵后的得分
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int res = m*(1<<(n-1)); // 首列 全是1 的和
        for(int j = 1 ;j < n;j++){
            int nOnes = 0; // 储存 1的个数
            for (int[] ints : A) {
                if (ints[0] == 1) { // 第一列为1 保持不变
                    nOnes += ints[j];
                } else { //反转
                    nOnes += (1 - ints[j]);
                }
            }
            int k = Math.max(nOnes,m-nOnes);

            res += k*(1 << (n-j-1));  // 每列的值 = 1的个数/列 * ( 1<<(n-1-j) )

        }


        return  res;
    }

    public static void main(String[] args) {

    }
}
