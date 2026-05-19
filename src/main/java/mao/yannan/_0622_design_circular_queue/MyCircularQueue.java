package mao.yannan._0622_design_circular_queue;

class MyCircularQueue {

    int[] queue;
    int read;
    int write;
    boolean full;

    public MyCircularQueue(int k) {
        queue = new int[k];
        read = 0;
        write = 0;
        full = false;
    }

    public boolean enQueue(int value) {
        if (full) {
            return false;
        }
        queue[write] = value;
        write = increment(write);
        if (write == read) {
            full = true;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        read = increment(read);
        if (full) {
            full = false;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[read];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[decrement(write)];
    }

    public boolean isEmpty() {
        return !full && read == write;
    }

    public boolean isFull() {
        return full;
    }

    int increment(int pointer) {
        if (++pointer == queue.length) {
            return 0;
        }
        return pointer;
    }

    int decrement(int pointer) {
        if (--pointer == -1) {
            return queue.length - 1;
        }
        return pointer;
    }
}
