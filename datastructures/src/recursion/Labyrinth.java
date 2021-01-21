package recursion;

public class Labyrinth {
    public static void main(String[] args) {
        //1.生成一个地图
        int map[][]=new int[8][7];
        //生成上下两侧的墙，墙为1
        for (int i=0;i<7;i++){
          map[0][i]=1;
          map[7][i]=1;
        }
        //生成左右两侧的墙
        for (int i = 0; i <8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        //4.设置挡板
        map[2][1]=1;
        map[2][2]=1;
        //5.打印生成的地图
        for (int i=0;i<8;i++){
            System.out.printf("[");
            for (int j = 0; j < 7; j++) {
                System.out.printf(map[i][j]+"\t");
            }
            System.out.println("]");
        }
        boolean b = setWay(map, 1, 1);
        System.out.println(b);
        //5.打印生成的地图
        for (int i=0;i<8;i++){
            System.out.printf("[");
            for (int j = 0; j < 7; j++) {
                System.out.printf(map[i][j]+"\t");
            }
            System.out.println("]");
        }
    }
    public static  boolean setWay(int[][] map,int i,int j){
        if (map[6][5]==2){//如果地图上的终点值为二则找到出路
            return true;
        }else {//按照下右上左的顺序寻找路
                if (map[i][j]==0){//当该路未走过时进行探路
                    map[i][j]=2;//表示走过的路
                    if (setWay(map,i+1,j)){//向下走
                        return  true;
                    }else if (setWay(map,i,j+1)){//向右走
                        return true;
                    }else if (setWay(map,i-1,j)){//向上走
                        return true;
                    }else if (setWay(map,i,j-1)){//向左走
                        return true;
                    }else {
                        map[i][j]=3;//表示死路走不通
                        return false;
                         }
                }else {//表示已经走过的路或者为墙体，挡板或者死路则直接返回false
                return false;
            }
        }
    }
}
