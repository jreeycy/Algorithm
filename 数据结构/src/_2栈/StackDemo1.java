package 栈_2;

import java.util.Stack;

public class StackDemo1 {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        stack.add("Tom");
        stack.add("Jreey");
        stack.add("Kimmy");
        while (stack.size()>0){
            System.out.println(stack.pop());//专门的出栈方法
        }
    }
}
