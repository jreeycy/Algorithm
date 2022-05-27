package 链表.单链表;

public class 双向链表_2 {
    /*和单链表区别：
        1.有向前的指针
    * */
    /*
    * 删除：
    * 1）因为是双向链表，因此可以直接自我删除
    * 2）找到要删除的节点
    * 3）temp.pre.next=temp.next
    * 4)temp.next.pre=temp.pre
    *
    *
    *
    * */
    class Heronode{
        int id;
        String name;
        Heronode next;
        Heronode pre;
    }
}



