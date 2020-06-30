package org.pc.group_2;

import java.util.LinkedList;

/**
 *  两个栈模拟一个队列
 *  栈: 先进后出
 *  队列: 先进先出
 */
public class Offer_09 {

    private LinkedList<Integer> stack1 = new LinkedList<>();
    private LinkedList<Integer> stack2 = new LinkedList<>();

    public void appendTail(int value) {
        stack1.addLast(value);
    }

    public int deleteHead() {

        if(!stack2.isEmpty()) return stack2.removeLast();
        if(stack1.isEmpty()) return -1;

        while(!stack1.isEmpty())
            stack2.addLast(stack1.removeLast());

        return stack2.removeLast();
    }
}
