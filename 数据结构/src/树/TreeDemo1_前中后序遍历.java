package 树;

public class TreeDemo1_前中后序遍历 {
    public static void main(String[] args) {
        //先创建一个二叉树
        BinaryTree bT=new BinaryTree();
        //创建需要的节点
        HeroNode root1=new HeroNode(1,"刘备");
        HeroNode h2=new HeroNode(2,"关羽");
        HeroNode h3=new HeroNode(3,"张飞");
        HeroNode h4=new HeroNode(4,"赵云");

        //确定二叉树的 root节电
        bT.setRoot(root1);
        //手动创建二叉树，后面可用递归
        root1.setLeft(h2);
        root1.setRight(h3);
        h3.setRight(h4);

        System.out.print("前序遍历：");bT.preOrder();
        System.out.println("---------");
        System.out.println("中序遍历：");bT.midOrder();

    }

}




    /*
    1、创建二叉树
    2.1如果当前节点左子节点不为空，递归中序遍历
    2.2输出当前节点
    2.3如果当前节点右子节点不为空。递归中序遍历
    * */
    //创建二叉树
    class BinaryTree{
        private HeroNode root;
        public void  setRoot(HeroNode root){
            this.root=root;
        }
        //前序遍历
        public void  preOrder(){
            if (this.root!=null){
                this.root.preOrder();
            }else {
                System.out.println("当前二叉树为空,无法遍历");
            }
        }

        //中序遍历
        public void midOrder(){
            if (this.root!=null){
                this.root.midOrder();
            }
            else {
                System.out.println("当前二叉树为空");
            }
        }

        //后序遍历
        public void postOrder(){
            if (this.root!=null){
                this.root.postOrder();
            }
            else System.out.println("当前二叉树为空");
        }


    }

    class HeroNode{
        private  int no;
        private String name;
        private  HeroNode left;
        private  HeroNode right;

        public HeroNode(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HeroNode getLeft() {
            return left;
        }

        public void setLeft(HeroNode left) {
            this.left = left;
        }

        public HeroNode getRight() {
            return right;
        }

        public void setRight(HeroNode right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }
        //前序遍历
        public void preOrder(){
            System.out.println(this);//先输出父节点
            //递归左子节点前序遍历
            if (this.left!=null){
                this.left.preOrder();//递归前序遍历
            }
            //递归右子节点前序遍历
            if (this.right!=null){
                this.right.preOrder();
            }
        }

        //中序遍历
        public void midOrder(){
            //1.先递归遍历左子节点
            if (this.left!=null){
                this.left.midOrder();
            }
            //2、输出当前节点
            System.out.println(this);
            //3.递归遍历右子节点
            if (this.right!=null){
                this.right.midOrder();
            }
        }

        //后序遍历
        public  void postOrder(){
            if (this.left!=null){
                this.left.postOrder();
            }
            if (this.right!=null){
                this.right.postOrder();
            }
            System.out.println(this);
        }


    }



