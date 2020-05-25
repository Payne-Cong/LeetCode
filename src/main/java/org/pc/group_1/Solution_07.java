package org.pc.group_1;

/**
 * 7. 整数反转
 * 32位的整数
 */
public class Solution_07 {

    public int reverse(int x) {
        if(x==0) return 0;
        int val = x;
        int res = 0;

        while(val!=0){
            res = res*10 + val%10;
            val = val / 10;
        }

        // error
        if(res>Integer.MAX_VALUE || res<Integer.MIN_VALUE){
            return 0;
        }

        return res;
    }

    public int reverse_sure(int x) {
        if(x==0) return 0;
        int val = x;
        int res = 0;


        while(val!=0){
            int temp = res*10 + val%10;
            if(temp / 10 != res)
                return 0;
            res =temp;
            val = val / 10;
        }

        return res;
    }
}
