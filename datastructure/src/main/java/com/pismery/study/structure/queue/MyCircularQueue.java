package com.pismery.study.structure.queue;

class MyCircularQueue {

    private int[] datas;
    private int head;
    private int tail;
    private int length;

    /** When true:head == tail is empty;false: head == tail is full*/
    private boolean flag;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.datas = new int[k];
        this.length = k;
        this.head = 0;
        this.tail = 0;
        this.flag = true;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull())
            return false;

        if(this.flag)
            this.flag = false;
        this.datas[this.tail] = value;
        this.tail = addIndex(this.tail);
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty())
            return false;
        if(!this.flag)
            this.flag = true;
        this.head = addIndex(this.head);
        return true;
    }

    /** Get the front item from the queue. */
    public int front() {
        if (isEmpty())
            return -1;

        return this.datas[this.head];
    }

    /** Get the last item from the queue. */
    public int rear() {
        if (isEmpty())
            return -1;

        return this.datas[minusIndex(this.tail)];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.head == this.tail && this.flag;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.tail == this.head && !this.flag;
    }

    private int addIndex(int index) {
//        return ++index % this.length;

        if(++index >= this.length)
            return 0;

        return index;
    }

    private int minusIndex(int index) {
//        return (--index + length) % length;

        if(--index < 0)
            return this.length - 1;

        return index;
    }
}
