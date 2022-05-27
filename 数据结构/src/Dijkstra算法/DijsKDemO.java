package Dijkstra算法;

import java.util.Arrays;

public class DijsKDemO {
    //求最短路径，计算一个节点到另外一个节点的最小路径，以起始点为中心向外层层层层扩散
    public static void main(String[] args) {
        char[]vertex={'A','B','C','D','E','F','G'};

        //邻接矩阵
        int[][]matrix=new int[vertex.length][vertex.length];
        final int N=65535;//代表不可连接
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        //创建Graph对象
        Graph graph=new Graph(vertex,matrix);
        graph.showGraph();

    }
}
class VisitVertex{
    //记录各个顶点已经访问过标1
    public int[]already;
    //每个下标对应值为前一个顶点下表，会动态更新
    public int[]pre_visted;
    //记录从出发到其他顶点的距离，比如G为除法定点，就会记录G到别的定调距离，最短距离放到dis【】
    public int[]dis;
    /**
     * @param length
     * @param start 出发顶点对应的下标，比如G，对应的下标就是6
     */
    public VisitVertex(int length,int start) {
        this.already=new int[length];//以顶点个数创建数组，index表示出发顶点对应的下标
        this.pre_visted=new int[length];
        this.dis=new int[length];
        //初始化dis数组，首先全部为不可到达65535
        Arrays.fill(dis,65535);
        //设置出发顶点到自己的访问距离
        this.dis[start]=0;
    }
    /**
     * 功能：判断index顶点是否被访问过
     * @param   index
     * @return  若果访问过返回false
     */
    public boolean in(int index){
        return already[index]==1;
    }


    /**
     * @param index 到index顶点的序号
     * @param len   出发顶点到index定点的距离
     */
    public void update(int index,int len){
        dis[index]=len;
    }

    /**
     * 功能：更新pre顶点的前驱节点为index顶点
     * @param pre
     * @param index
     */
    public void updatePre(int pre,int index){
        pre_visted[pre]=index;
    }

    /**
     * 功能：返回出发顶点到index顶点的距离
     * @param index
     * @return
     */
    public int gerDis(int index){
        return dis[index];
    }
}


class Graph{
    private char[]vertex;//顶点数组
    private int[][]matrix;//邻接矩阵

    //构造器
    public Graph(char[]vertex,int[][]matrix){
        this.vertex=vertex;
        this.matrix=matrix;
    }
    //显示图
    public void showGraph(){
        for (int[]link:matrix){
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * @param start 出发顶点的下标
     */
    //迪杰斯特拉算法的实现
    public void dsj(int start){
        VisitVertex vv=new VisitVertex(vertex.length, start);
        
    }
}
