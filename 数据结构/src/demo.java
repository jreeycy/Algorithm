public class demo {
    public static void add(int x){
        x++;

    }
    public static void main(String[] args) {
       Animal a1=new Animal();
       a1.id=1;
       a1.name="a";
        System.out.println(a1);
    }
}
class Animal{
    int id;
    String name;
}