package 链表.单链表;

import java.util.Stack;

public class 单链表1 {
/*
    1）链表是用节点方式存储
2）每个节点包括data域，next域：指向下一个节点
3）链表分带头节点和不带的
* */

    public static void main(String[] args) {
        Heronode h1 = new Heronode(1, "刘备", "Beibei");
        Heronode h2 = new Heronode(2, "Leborn James", "James");
        Heronode h3 = new Heronode(3, "James Harden", "Harden");
        Heronode h4 = new Heronode(4, "Nick Young", "Young");

        //创建一个链表
        SingleLinkedList s1 = new SingleLinkedList();
        s1.addNode(h1);
        s1.addNode(h2);
        s1.addNode(h3);
        s1.addNode(h4);
        //将链表显示出来
        s1.show();
        System.out.println("----------------");

        SingleLinkedList s2 = new SingleLinkedList();
        s2.addNodeByOrder(h3);
        s2.addNodeByOrder(h1);
        s2.addNodeByOrder(h2);
        s2.addNodeByOrder(h4);
        s2.show();
        System.out.println("------------------");
        Heronode h4New = new Heronode(4, "sTEPHEN Curry", "Curry");
        s2.modify(h4New);
        s2.show();
        System.out.println("------Delete-------");
        s2.delete(4);
        s2.show();
        System.out.println("--腾讯单链表反转----");
        s2.reverse(s2.head);
        s2.show();
        System.out.println("---百度逆序打印-----");
        s2.show();
        System.out.println("--逆序后");
        s2.reversePrint(s2.head);



    }

    //定义单链表，来管理英雄街店


}

class SingleLinkedList {
    //先初始化头结点，不要动,不存数据
    public Heronode head = new Heronode(0, "", "");

    /* 将节点加入到链表*/
    public void addNode(Heronode node) {
        //因为 head不能动，，需要辅助节点temp
        Heronode temp = head;
        //遍历链表找到最后的节点
        while (true) {
            //找到最后节点
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            else temp = temp.next;
        }
        temp.next = node;
    }
    /*将链表根据序号id插入
     * 1）找到要插入的位置
     * 2）新节点的next=temp.next;
     * 3)temp.next=新节点
     * */

    public void addNodeByOrder(Heronode node) {
        Heronode temp = head;
        //temp找的是加入位置的前一个节点
        while (true) {

            if (temp.next == null) {//说明temp已经在链表的最后，直接查到最后即可
                temp.next = node;
                break;
            }
            if (temp.next.no > node.no) {//位置找到，node就应该插入temp和temp.next之间
                node.next = temp.next;
                temp.next = node;
                break;
            } else if (temp.next.no == node.no) {
                System.out.println("该节点已经存在，插入失败");
                break;
            }

            temp = temp.next;//没有找到，temp往后移动
        }
    }

    /* 删除节点
     * 1)找到需要删除节点的前一个节点
     * 2）另temp.next=temp.next.nexxt
     * 3)直接跳过这个节点
     *  */
    public void delete(int no) {
        Heronode temp = head;
        if (head == null) System.out.println("表示空的");
        while (true) {
            if (temp.next == null) {
                break;//遍历完没有找到要被删除的节点
            }
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }

    }

    /* 显示链表*/
    public void show() {
        if (head.next == null) System.out.println("链表是空的");
        Heronode temp = head;
        while (true) {
            //判断链表是否最后
            if (temp == null) {
                break;
            } else {//不是空，打印当前节点
                System.out.println(temp);
                temp = temp.next;

            }
        }
    }

    /* 根据节点no，来修改*/
    public void modify(Heronode node) {
        Heronode temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("没有找到要修改的节点");
                break;//已完成遍历但仍然没有找到
            }
            if (temp.no == node.no) {//找到了
                temp.name = node.name;
                temp.nickname = node.nickname;
                break;
            }
            temp = temp.next;
        }
    }

    /*面试题1：获取单链表节点个数（不计算头结点）*/
    /*
     * @param head链表的头结点
     * @return 有多少节点
     * */

    public static int getLength(Heronode head){
        Heronode cur=head.next;
        if (cur==null)return 0;//空链表
        int length=0;
        while (cur !=null){
            length++;
            cur=cur.next;

        }
        return length;
    }
    /*面试题2：单链表反转*/
    /*
    思路：
    1.先定义一个节点reverseHead=new Heronode()
    2.从头遍历原来的节点，每遍历一个节点就把他取出，放在新链表reverseHead链表的最前端
    3.原来链表的head.next=reverseHead.next;
    * */
    public static void reverse(Heronode head){
        //如果链表俄为空,或本身只有一个节点直接返回
        if (head.next==null || head.next.next==null)return;

        Heronode cur=head.next;
        Heronode next=null;//指向当前节点的下一个节点
        Heronode reverseHead=new Heronode(0,"","");
       //便利原来的链表，没遍历一个节点，就将其取出，并放在新链表reversehead的最前端
        while (cur!=null){
            next=cur.next;//暂时保存当前节点的下一个节点
            cur.next=reverseHead.next;//将当前节点下一个指向新链表最前端
            reverseHead.next=cur;
            cur=next;//cur后移动
        }
        //将head。next指向新链表最前
        head.next=reverseHead.next;
    }
    /*面试题三：逆序打印单链表
    * 方式一：先将单链表翻转再打印
    * 方式二：推荐：利用栈，将各个节点压入到栈中，利用栈先进后出实现逆序打印
    * */
    public void reversePrint(Heronode head){
        Stack<Heronode>stack=new Stack<>();
        Heronode temp=head.next;
        while(temp!=null){
            stack.add(temp);
            temp=temp.next;
        }
        while(stack.size()!=0){
            System.out.println(stack.pop());
        }

    }


}
class Heronode{
    public int no;
    public String name;
    public String nickname;
    public Heronode next;//指向下一个节点

    public Heronode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Heronode{" + "no=" + no + ", name='" + name + '\'' + ", nickname='" + nickname + '\'' + '}';
    }
}
