package org.pc.group_1;

public class Solution_36 {

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i ++){
            // hori, veti, sqre分别表示行、列、小宫
            int hori = 0, veti = 0, sqre = 0;
            for(int j = 0; j < 9; j ++){
                // 由于传入为char，需要转换为int，减48
                int h = board[i][j] - 48;
                int v = board[j][i] - 48;
                int s = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3] - 48;
                // "."的ASCII码为46，故小于0代表着当前符号位"."，不用讨论
                if(h > 0){
                    hori = sodokuer(h, hori);
                }
                if(v > 0){
                    veti = sodokuer(v, veti);
                }
                if(s > 0){
                    sqre = sodokuer(s, sqre);
                }
                if(hori == -1 || veti == -1 || sqre == -1){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 怎么判断初始情况新增？
     * 将 1-9 每个数字 看成 移动的位数,1 << n , 则最高位 为 1 ,代表 该值 存在
     * 对于 遇到 新增的 数字（之前已存在）,则用异或的方式,表示 新增, 因为 相同为0,异为1 嘛
     * 怎么判断该值 是否 存在了？ 利用 与运算
     * 首先 先将之前在左移得到的结果,返还进行右移该数字位,则低位可能为 1 或者 0 , 然后 与 1 进行 运算, 1&1=1 ,其他=0, 运算完的结果表示：1 存在 , 0 不存在
     *
     * @param n
     * @param val
     * @return
     */
    private static int sodokuer(int n, int val){
        return ((val >> n) & 1) == 1 ? -1 : val ^ (1 << n);
    }

    public static void main(String[] args) {
        System.out.println(sodokuer(5, 0));
        System.out.println(Integer.toBinaryString(32));
    }
}
