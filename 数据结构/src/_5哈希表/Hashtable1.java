package _5哈希表;

public class Hashtable1 {
    //数组对应每隔一个元素
    //每个元素对应一条链表
    public static void main(String[] args) {
       //创建7条链表的hashtable
        HashTable t=new HashTable(7);
        //创建100个员工
        for (int i=1;i<=100;i++){
            Employee e=new Employee(i,"部门"+i%7);
            t.add(e);
        }
        t.showHashTab();
        System.out.println(t.searchById(103));
    }
}
class HashTable{
    private EmpLinkedList[]listArrary;//每一个数组元素对应一条链表
    private int size;//表示有多少条链表
    public HashTable(int size) {
        listArrary=new EmpLinkedList[size];
        this.size=size;
        //要注意要给每一个链表还得初始化、
        for (int i=0;i<size;i++){
            listArrary[i]=new EmpLinkedList();
        }

    }
    //添加雇员
    public void add(Employee emp){
        //根据员工的id得到员工应该加入到哪一条链表
        int index=hashFun(emp.id);
        //将emp添加到对应的链表中
        listArrary[index].add(emp);

    }
    //根据员工id决定将员工填入哪一条链表
    public int hashFun(int id){
        return id%size;
    }

    //遍历哈希表
    public void showHashTab(){
        for (int i=0;i<size;i++){
            listArrary[i].show();
        }
    }

    //根据id查找对应雇员
    public Employee searchById(int id){
        int index=id%7;
        //判断链表是否为空
        if (listArrary[index].head==null)return null;
        Employee cur=listArrary[index].head;
        while (true){
            if (cur.id==id){
                return cur;
            }
            //退出条件
            if (cur.next==null){
               return null;
            }
            cur=cur.next;
        }

    }
}



//员工
class Employee{
    public int id;
    public String deparment;
    public Employee next;

    public Employee(int id, String deparment) {
        this.id = id;
        this.deparment=deparment;
    }
}
//创建雇员链表
class EmpLinkedList{
    //头指针就是第一个雇员不能是空
    public Employee head;

    //添加雇员
    /*
    1.添加雇员id自增长，将新雇员添加到链表的最后
     */
    public void add(Employee e) {
        //如果第一个雇员
        if (head == null) {
            head = e;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助指针定位到最后
        Employee cur = head;
        while (true) {
            if (cur.next == null) break;//说明已经到链表的最后
            else cur = cur.next;
        }
        cur.next = e;
    }
    //遍历链表
    public void show(){
        if (head==null){
            System.out.println("链表是空");
            return;
        }
        Employee cur=head;
        while(true){
            System.out.printf("id:%d,dep:%s;",cur.id,cur.deparment);
            if (cur.next==null){
                System.out.printf("\n");
                break;//到链表最后退出
            }
            cur=cur.next;
        }
    }
}