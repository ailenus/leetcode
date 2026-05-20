package mao.yannan._0155_min_stack;

import java.util.ArrayList;
import java.util.List;

class MinStack {

    List<int[]> stack;

    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int val) {
        var top = stack.isEmpty() ? new int[] {val, val} : stack.getLast();
        var min = top[1];
        if (min > val) {
            min = val;
        }
        stack.add(new int[] {val, min});
    }

    public void pop() {
        stack.removeLast();
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.getLast()[0];
    }

    public int getMin() {
        return stack.isEmpty() ? -1 : stack.getLast()[1];
    }
}
