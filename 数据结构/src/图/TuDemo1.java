package 图;

import java.util.ArrayList;
import java.util.Arrays;

public class TuDemo1 {
    public static void main(String[] args) {
        //节点为5
        int n=5;
        String[] VertexValue={"Shanghai","Beijing","Chengdu","Guangzhou","Shengzhen"};
        //创建图对象
        Graph g=new Graph(n);
        //向图里添加节点
        for (String v:VertexValue){
            g.insertVertex(v);
        }
        //向图里添加边:Shanghai <-> Beijing 距离 1000
        g.insertEdge(0,1,1000);//Shanghai <-> Beijing 距离 1000
        g.insertEdge(0,2,800);//Shanghai <-> Chengdu 距离800
        g.insertEdge(1,2,600);//Beijing<-> Chengdu  距离600
        g.insertEdge(1,3,2000);//Beijign<-> Guangzhou 距离2000
        g.insertEdge(1,4,1500);//beijing <->Shengzhen 距离1500

        g.showGraph();
    }
}
class Graph{
    /*无向图
    1、存储顶点用arrarylist
    2.存储邻接矩阵用二维数组
    * */
    private ArrayList<String>vertexList;//存储顶点集合
    private int[][]edges;//存储图对应的邻接矩阵
    private int numOfEdges;//边的数量

    //构造器
    public Graph(int n){//n节点个数
        //初始化矩阵 和  vertexlist
        edges=new int[n][n];
        vertexList=new ArrayList<String>(n);
        numOfEdges=0;
    }

    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //添加边
    /**
        @param v1   其中一个顶点的下标
        @param weight  权值
    */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;//边的数目+1
    }


    //返回节点的个数
    public int getNumofVertex(){
        return vertexList.size();
    }
    //返回变得个数
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回下标i对应的节点数据，0->"上海"，1->"北京”..
    public String getValueByIndex(int i){
        return  vertexList.get(i);
    }
    //返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    //展示邻接矩阵
    public void showGraph(){
        for (int[]link:edges){
            System.out.println(Arrays.toString(link));
        }
    }




}