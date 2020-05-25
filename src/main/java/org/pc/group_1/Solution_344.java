package org.pc.group_1;

/**
 * 344. 反转字符串
 */
public class Solution_344 {
    public void reverseString(char[] s) {

        int len = s.length;
        int j = len-1;
        for(int i=0; i<=j ;i++,j--){
            mx(s,i,j);
        }
    }

    public void mx(char[] ch, int a, int b){
        char temp = ch[a];
        ch[a] = ch[b];
        ch[b] =temp;
    }

    public static void main(String[] args) {
        char[] ch = {'h','e','l','l','o'};
        new Solution_344().reverseString(ch);
        for (char c : ch){
            System.out.print(c);
        }
    }
}
