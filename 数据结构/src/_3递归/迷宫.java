package _3递归;

public class 迷宫 {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        int[][]map=new int[8][7];
        //使用1表示墙
        //表示围墙
        for (int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        map[2][2]=1;
        map[3][1]=1;
        map[3][2]=1;
        //输出地图
        for (int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("------");
        System.out.println(findWay(map,1,1));
        for (int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }


    }
    //使用递归回溯，来给小球找路
    /*map表示地图：
    2.i,j表示出发的起始位置
    3.如果小球能找到map[6][5]则说明通路找到
    4。map[i][j]=0表示没有走过，=1表示墙，2表示同路可以走，3表示该点走过走不通
         策略“下->右 ->上->坐

     */
    public static  boolean findWay(int[][] map,int i,int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;//该点可以走到
                //先下
                if (findWay(map, i + 1, j)) {
                    return true;
                } else if (findWay(map, i, j + 1)) {
                    return true;
                } else if (findWay(map, i - 1, j)) {
                    return true;
                } else if (findWay(map, i, j - 1)) {
                    return true;
                } else {

                    //该点走不到别处
                    map[i][j] = 3;
                    return false;
                }
            } else return false;

        }


    }
}
