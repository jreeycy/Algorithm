package _1链表;

public class 环形链表_3 {

    public static void main(String[] args) {
        ciucuSingleList c1=new ciucuSingleList();
        c1.Initialize(10);
        c1.show();

        //解决约瑟夫问题

    }





    }
/*
环形链表构建思路：
1）先创建第一个节点，让first指向该节点并形成环形
2）后面每创建一个新的节点，就把该节点，加入到已有的环形链表即可
* */
class ciucuSingleList{
    //创建first节点
    public  Heronode first=new Heronode(-1);
    //初始化节点方法
    public void Initialize(int nums){
        //创建辅助指针
        Heronode cur=null;
        for (int i=1;i<=nums;i++){
            //根据编号创建节点
            Heronode h=new Heronode(i);
            if (i==1){
                first=h;
                first.next=first;//自己指向自己
                cur=first;
            }else{
                cur.next=h;
                h.next=first;
                cur=h;
            }
        }
    }

    /*遍历
    1)设置一个辅助变量cur，指向first节点
    2）当cur.next=first说明遍历完成
    * */
    public  void show(){
        if (first==null) {
            System.out.println("链表为空");
            return;
        }
        Heronode cur=first;
        while (true){
            System.out.println("小孩的编号："+cur.id);
            if (cur.next==first){
                break;
            }
            cur=cur.next;
        }

        /*输出报数对序：

        * */


    }

    class Heronode{
        int id;
        Heronode next;
        public Heronode(int id) {
            this.id = id;

        }
    }
}
