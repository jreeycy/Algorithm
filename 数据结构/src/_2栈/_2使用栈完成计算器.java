package _2栈;

public class _2使用栈完成计算器 {
    /*
    数栈：存放数据
    符号栈：存放运算符
    思路：
    1）通过一个index值（索引）便利表达式
    2）如果我们发现是一个数字，就直接入数栈
    3）如果发现扫描的是一个符号
        3.1如果当前的符号栈是空的，直接入栈
        3.2如果符号栈有操作符，就进行比较，如果当前操作符优先级<=栈中操作符，就从数栈pop两个数，再从符号栈pop一个符号，进行运算，并将结果入数栈，然后将当前操作符入
        符号栈
        3.3若果当前操作符优先级大于栈中操作符，直接入符号栈
     4）当表达式扫描完毕，就顺序从数栈和符号栈pop相应数和符号
     5）最后数栈存在唯一的数——结果
    * */




}
