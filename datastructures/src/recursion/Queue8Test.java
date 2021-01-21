package recursion;

public class Queue8Test {
    //创建八皇后棋盘
    int[][] map=new int[8][8];
    //创建8个皇后
    int max=8;

    public static void main(String[] args) {

    }
    //判断八皇后所在位置是否满足条件
    private static boolean judge(int map[][]){
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                if (map[i][j]!=0){

                }
            }
        }
        return true;
    }
    private static void  print(int map[][]){//打印八皇后所在位置
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                if (map[i][j]!=0){
                    System.out.printf("map[%d][%d]=%d",i+1,j+1,map[i][j]);
                }
            }

        }
    }

}
