package _1链表.单链表;

public class demo {
    public static void main(String[] args) {
        Animal a1=new Animal("Fox");
        Animal a1n=a1;
        Animal a2=new Animal("Dog");
        System.out.println(a1);
        System.out.println(a1n);
        System.out.println(a2);
        a1n=a2;
        System.out.println("-----");
        System.out.println(a1);

    }

}
class Animal{
    String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
