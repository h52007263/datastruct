package com.wxw.linked;

/**
 * @Description: 链表节点$
 * @create: 2019-09-05 19:49
 * @version: 1.0
 */
//定义链表的基本元素
public class LNode<T> {
      T data;//数据域
      LNode<T> next;//指针域

      /*
       * 使用构造函数构造一个新节点
       * @Author 魏小伟
       * @Date 2019/9/5 19:53
       * @Param [data] 新元素数据
       * @Param next 新元素与链表结合的节点
       * @return 
       **/
      public LNode(T data) {
          this.data = data;
      }
    //方便打印
    @Override
    public String toString() {
        return data.toString();
    }

}
