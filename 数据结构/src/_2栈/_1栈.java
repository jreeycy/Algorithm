package _2栈;

public class _1栈 {
    public static void main(String[] args) {
        arrayStack s=new arrayStack(10);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(4);
       s.show();


    }


}
/*实现栈的思路分析：
  1、使用数组来模拟栈
  2.定义top表示栈顶
  3.入栈的操作，当有数据假如栈：top++，stack【top】=data
  4.出栈操作,int value=stack[top];top-- return value;
  * */
class arrayStack{
    private  int MaxSize;//定义栈的最大大小
    private int[] stack;//数组模拟栈，存放数据
    private int top=-1;

    public arrayStack(int maxSize) {
        MaxSize = maxSize;
        stack=new int[MaxSize];
    }

    //栈满
    public boolean isFull(){
        return top==MaxSize-1;
    }
    //栈空
    public boolean isEmpty(){
        return top==-1;
    }
    //入栈
    public  void push(int value){
        if (isFull()){
            System.out.println("栈满了");
            return;
        }
        top++;
        stack[top]=value;
    }
    //出栈
    public int pop(){
        if (isEmpty()){
            System.out.println("栈已经空了");
            throw new RuntimeException("栈空，没有数据");
        }
       int result=stack[top];
        top--;
        return result;
    }

    //遍历
    public void show(){
        int  size=this.top;
        for (int i=0;i<=size;i++){
            System.out.println(pop());
        }
    }
}
