package com.soecode.lyf.datastruct.array;

public class ArrayQueue<E>  {

    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    public int getSize(){
        return array.getSize();
    }

    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 入队
     * @param e
     */
    public void enqueue(E e){
        array.addLast(e);
    }

    /**
     * 出队
     * @return
     */
    public E dequeue(){
        return array.removeFirst();
    }

    /**
     * 获取对头元素
     * @return
     */
    public E getFront(){
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<>(5  );
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
