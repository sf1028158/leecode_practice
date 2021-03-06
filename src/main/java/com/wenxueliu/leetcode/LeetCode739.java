package com.wenxueliu.leetcode;

import java.util.Stack;

/**
 * @author liuwenxue
 * @date 2020-09-07
 */
public class LeetCode739 {
    /**
     * 单调栈的最直接用法
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int len = T.length;
        int[] res = new int[len];
        for (int index = 0; index < len; index++) {
            while (!stack.isEmpty() && T[index] > T[stack.peek()]) {
                res[stack.peek()] = index - stack.peek();
                stack.pop();
            }
            stack.push(index);
        }
        return res;
    }

    public int[] dailyTemperatures1(int[] T) {
        int len = T.length;
        int[] stack = new int[len];
        int stackIndex = -1;
        int[] res = new int[len];
        for (int index = 0; index < len; index++) {
            while (stackIndex > -1 && T[index] > T[stack[stackIndex]]) {
                res[stack[stackIndex]] = index - stack[stackIndex];
                stack[stackIndex] = 0;
                stackIndex--;
            }
            stackIndex++;
            stack[stackIndex] = index;

        }
        return res;
    }
}
