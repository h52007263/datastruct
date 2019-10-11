package com.wxw.linked;

/**
 * @Description: 链表的Java实现 $
 * @Author: wxw
 */
import java.util.Stack;

/**
 链表结构包含两个要素： 头结点head + 链表大小size，操作包括：
 * 				链表的增删
 * 				链表是否为空
 * 				链表的大小
 * 				链表的打印输出
 * 				删除链表重复节点
*  			链表倒数第K个元素
*  			链表的反转
*  			链表的倒序输出
*  			链表的中间节点
*  			链表是否有环
*  			链表节点的删除(不知道头结点的情况下)
*  			链表是否相交
*  			链表的交点
 *          递归方式实现合并（无序）链表
 *
 */
public class LLinkedList<T> {
        private LNode<T> head;//链表表头
        private int size;//链表长度
    //初始化头节点
    public LLinkedList() {
        head = new LNode<T>(null);
    }
    //==========返回链表的长度=======
    public int getSize() {
        return size;
    }

    //返回链表长度
    public LNode<T> getHead() {
        return head;
    }

    //========向链表指定位置添加新元素 节点================
    public LNode<T> add(T data,int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("添加失败；非法输入");
        }
        LNode<T> cur=head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        LNode<T> node=new LNode<>(data);//将新元素链入链表
        cur.next=node;
        size++;
        return node;
    }

    //=========向链表末尾添加元素=========
    public LNode<T> addTail(T data) throws Exception {
        return add(data, size);
    }

    //==========向链表尾部添加新节点===========
    public void addNodeOnTail(LNode<T> node){
            LNode<T> cur=head;
            while (cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;

            while (node!=null){
                size++;
                node=node.next;
            }
    }
   //=========== 删除链表中指定位置的元素(0 ~~size-1)====
    public T removeByIndex(int index){
        if (index > size - 1 || index < 0) {
           throw new IllegalArgumentException("删除失败，输入非法字符");
        }
        //找到索引所在节点的前一个节点
        LNode<T> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        LNode<T> temp=cur.next;//索引所在节点
        cur.next=temp.next;//前一个节点的指针指向下下个节点
        temp.next=null;
        size--;
        return temp.data;
    }
    //=========从链表末尾删除元素=========、
    public T removeByTail(){
        return removeByIndex(size-1);
    }



   //==========删除链表中的重复元素(外循环 + 内循环)=时间复杂度：O(n^2)=====
   public void removeDuplicateNodes() {
       LNode<T> cur = head.next;
       while (cur != null) { // 外循环
           LNode<T> temp = cur;
           while (temp != null && temp.next != null) { // 内循环
               if (cur.data.equals(temp.next.data)) {
                   LNode<T> duplicateNode = temp.next;
                   temp.next = duplicateNode.next;
                   duplicateNode.next = null;
                   size --;
               }
               temp = temp.next;
           }
           cur = cur.next;
       }
   }
   //===========================================
    /**
     * 找出单链表中倒数第K个元素(双指针法,相差K-1步)
     * 时间复杂度：O(n)
     */
    public LNode<T> getEndK(int k){
        LNode<T> pre = head.next;//前指针
        LNode<T> post = head.next;//后指针
        for (int i = 1; i < k; i++) { // pre先走k-1步
            if (pre != null) {
                pre = pre.next;
            }
        }
        if (pre != null) {//pre是k-1的pre
            // 当pre走到链表末端时，post正好指向倒数第K个节点
            while (pre != null && pre.next != null) {
                pre = pre.next;//n-k个因为已经走了k步
                post = post.next;//和pre同步走
            }
            return post;
        }
        return null;
    }
    //==============反转链表=======[pre]==[2,cur.next=pre]==[1,next=cur.next]==========
    public void reserveLinkedList(){
        LNode<T> cur=head.next;//原链表
        LNode<T> pre=null;//反转后的链表
        while (cur!=null){//对原链表中的每个节点进行反转
            LNode<T> next=cur.next;//保存当前节点的下一个节点
            cur.next=pre;//当前节点指向反转后的链表
            pre=cur;//更新反转后的链表
            cur=next;//更新当前节点
        }
        head.next=pre;//将原链表的头节点指向反转后的链表
    }


   //===========判断单链表是否为空=========
   public boolean isEmpty() {
       return size == 0;
   }

   //=======打印输出单链表==================
  public void print(){
        LNode<T> cur=head.next;
        while (cur!=null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
      System.out.println();
  }

  //==========使用递归法  从尾到头打印链表========
    public void printReverse(LNode<T> head){
           if(head.next!=null){
               printReverse(head.next);// 不断"递去"
               System.out.print(head.next.data + " "); // "归来"开始打印
           }
    }
    //=======寻找单链表中的中间节点(双指针法)=======
    public void printMiddleNode(){
        LNode<T> index1=head.next;//慢指针
        LNode<T> index2=head.next;//快指针
        if (head.next == null) {
            System.out.println(index1.data);
        }
        while (index2 != null && index2.next != null
                && index2.next.next != null) {
            index1 = index1.next;
            index2 = index2.next.next;
        }
        System.out.print(index1.data); // 第一个中间节点
        if (index2.next != null) { // 当链表长度为偶数时，打印第二个中间节点
            System.out.println(index1.next.data);
        }
    }
    //====判断单链表是否有环(双指针法)=====[]===[]====[]===
   public boolean hasloop(){
       LNode<T> index1=head.next;//慢指针
       LNode<T> index2=head.next;//快指针
       while (index2 != null && index2.next != null
               && index2.next.next != null) {
           index1 = index1.next;
           index2 = index2.next.next;
           if (index1 == index2) {
               return true;
           }
       }
       return false;
   }
  //=== 在不知道头结点的前提下，删除指定节点=========
  public boolean deleteNodeWithoutHead(LNode<T> node) {
      if (node == null || node.next == null) { // 当指定节点为空或者为尾节点时，无法删除
          return false;
      }
      LNode<T> next = node.next;//当前节点的后一个节点

      // 将后继节点的内容复制到当前节点
      node.data = next.data;
      node.next = next.next;

      // 将后继节点清空
      next.next = null;
      next.data = null;
      return true;
  }

  //====递归方式实现合并（无序）链表===========
 public LNode<T>  mergeList(LNode<T> list1,LNode<T> list2){
     if(list1 == null)
         return list2;
     if(list2 == null)
         return list1;
     LNode<T> mergeList=null;//合并后的链表
     //有序的话需要比较判断
     mergeList = list1;
     mergeList.next = mergeList(list1.next,list2);
    return null;
 }
 //=============返回环的入口节点============
  public LNode<T> enterOfLoop(LNode<T> head){
      if (head == null) {
          return null;
      }
      LNode<T> slow = head;
      LNode<T> fast = head;
      //1，判断链表能否构成最小环环
      if (fast != null && fast.next != null)
          fast = fast.next.next;
      else
          return null;
      slow = slow.next;
   //fast指针一次跳两步，slow指针一次跳一步
      while (fast != slow) {
          if (fast != null && fast.next != null)
              fast = fast.next.next;
          else
              return null;
          slow = slow.next;
      }
      // 两个指针再次相遇为入口节点
      slow = head;
      while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
      }
      return slow;
  }
 //判断当前链表与目标链表是否相交 并返回交点  栈实现
   public LNode<T> isInstersect_stack(LLinkedList<T> list2){
       LNode<T> cur1 = head.next;   // 当前链表
       LNode<T> cur2 = list2.getHead().next;  // 目标链表
       // 两链表有一个为空，则返回 false
       if(cur1 == null || cur2 == null){
           return  null;
       }
       int count=0;
       Stack<LNode<T>> headStack=new Stack<>();
       Stack<LNode<T>> targetStack=new Stack<>();
       while (cur1!=null){
           headStack.push(cur1);
           cur1=cur1.next;
       }
       while (cur2!=null){
           headStack.push(cur2);
           cur2=cur2.next;
       }
       LNode<T> ret=null;//交点
       while (headStack.peek().data == targetStack.peek().data){
           headStack.pop();
           ret=targetStack.pop();
       }
       return ret;
   }


//=====判断当前链表与目标链表是否相交(相交与否取决于尾节点是否相同)========
public boolean isIntersect(LLinkedList<T> list2) {
    LNode<T> cur1 = head.next;   // 当前链表
    LNode<T> cur2 = list2.getHead().next;  // 目标链表

    // 两链表有一个为空，则返回 false
    if(cur1 == null || cur2 == null){
        return false;
    }
    // 遍历到第一个链表的尾节点
    while(cur1.next != null){
        cur1 = cur1.next;
    }

    // 遍历到第二个链表的尾节点
    while(cur2.next != null){
        cur2 = cur2.next;
    }
    return cur1 == cur2;  // 相交与否取决于尾节点是否相同
}

//=====返回两链表的交点(若不相交，返回null)======
public LNode<T> getIntersectionPoint(LLinkedList<T> list2) {
    LNode<T> cur1 = head.next;   // 当前链表
    LNode<T> cur2 = list2.getHead().next;  // 目标链表

    if(this.isIntersect(list2)){  // 先判断是否相交
        // 让长度较长的链表先移动step步
        int step = Math.abs(list2.size - this.size);
        if(list2.size > this.size){
            while(step > 0){
                cur2 = cur2.next;
                step --;
            }
        }else if(list2.size < this.size){
            while(step > 0){
                cur1 = cur1.next;
                step --;
            }
        }
        //两个指针同时移动，一旦指向同一个节点，即为交点
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    return null;
}


    //1,方法：获取到单链表的有效节点的个数(如果是带头结点的链表，需求不统计头节点)
    /**
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public  int getLength(LNode<T> head) {
        if(head.next==null){//空链表
            return 0;
        }
        int length=0;
        //定义一个辅助变量，这里不统计头节点
        LNode<T> cur=head.next;
        while (cur!=null){
            length++;
            cur=cur.next;//遍历
        }
        return length;
    }
  //2，查找单链表中的倒数第k个结点 【新浪面试题】
  //思路
  //1. 编写一个方法，接收head节点，同时接收一个index
  //2. index 表示是倒数第index个节点
  //3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
  //4. 得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
  //5. 如果找到了，则返回该节点，否则返回nulll
    public LNode<T> findLastIndexNode(LNode<T> head,int index){
        //判断如果链表为空，返回null
        if(head.next==null){
            return null;
        }
        //第一个遍历得到链表的长度(节点个数)
        int size = getLength(head);
        //第二次遍历  size-index 位置，就是我们倒数的第K个节点
        //先做一个index的校验
        if(index <=0 || index > size) {
            return null;
        }
        //定义辅助变量，for循环定位到倒数的index
        LNode<T> cur=head.next; //3 //3-1=2
        for(int i=0;i<size-index;i++){
            cur=cur.next;
        }
        return cur;
    }
//    //将单链表反转   没成功，但思路是对的
//    public  void reserve(LNode<T> head) {
//        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
//        if(head.next == null || head.next.next == null) {
//            return ;
//        }
//        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
//        LNode<T> cur=head.next;
//        LNode<T> next=null;//指向当前节点[cur]的下一个节点
//        LNode<T> reserveHead=head;
//        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
//        while (cur!=null){
//            next=cur.next;//先暂时保存当前节点的下一个节点，因为后面需要用
//            cur.next=reserveHead.next;//将cur的下一个节点指向新的链表的最前端
//            cur=next;//让cur后移
//        }
//        //将head.next 指向 reverseHead.next , 实现单链表的反转
//     	head.next = reserveHead.next;
//    }
//

}


