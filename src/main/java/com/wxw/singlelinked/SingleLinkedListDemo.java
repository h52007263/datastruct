package com.wxw.singlelinked;

/**
 * 链表
 * 包含头指针、虚拟节点
 */
public class SingleLinkedListDemo<E> {

    /** 虚拟头节点*/
    private Node dummyHead;
    /** 链表大小*/
    private int size;

    public SingleLinkedListDemo() {
        dummyHead = new Node(null,null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向链表指定位置添加元素
     *
     * @param index
     * @param e
     * @return void
     */
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add faild. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e,prev.next);

        size ++;
    }

    /**
     * 向链表头添加元素
     *
     * @param e
     * @return void
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 向链表尾部添加元素
     *
     * @param e
     * @return voi
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获取指定位置元素
     *
     * @param index
     * @return E
     */
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get faild. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表头部的元素
     *
     * @param
     * @return E
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取链表尾部的元素
     *
     * @param
     * @return E
     */
    public E getLast(){
        return get(size);
    }

    /**
     * 修改指定位置的元素
     *
     * @param index
     * @param e
     * @return void
     */
    public void set(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 判断链表是否包含某个元素
     *
     * @param e
     * @return boolean
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index
     * @return void
     */
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Delete failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size --;
        return delNode.e;
    }

    /**
     * 删除指定元素
     *
     * @return void
     */
    public void remove(E e){
        if(!contains(e)){
            throw new IllegalArgumentException("Delete failed. e is not exists.");
        }
        Node prev = dummyHead;
        while (prev.next != null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    /**
     * 删除所有的指定元素
     *
     * @return void
     */
    public void removeAll(E e){
        if(!contains(e)){
            throw new IllegalArgumentException("Delete failed. e is not exists.");
        }
        Node prev = dummyHead;
        while (prev.next != null){
            if(prev.next.e.equals(e)){
                Node delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                size --;
                continue;
            }
            prev = prev.next;
        }
    }

    /**
     * 删除链表头部的元素
     *
     * @param
     * @return E
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除链表尾部的元素
     *
     * @param
     * @return E
     */
    public E removeLast(){
        return remove(size - 1);
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("LinkedList: size: %d\n",size));
        result.append("head ");
        Node cur = dummyHead.next;
        while (cur != null){
            result.append(cur+ "->");
            cur = cur.next;
        }
        result.append("NULL");
        return result.toString();
    }

    private class Node{

        private E e;//数据域
        private Node next;//指针域

        //初始化后继节点
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        //初始化数据
        public Node(E e) {
            this.e = e;
        }

        //初始化头节点
        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
