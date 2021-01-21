package arrays;

class SparseArray {
    int sArray[][];//原始数组
    int sparseArrays[][];//稀疏数组
    int count=0;
    //c初始化数组
    public int[][] init(int x,int y){
        sArray= new int[x][y];
        count++;
        return sArray;
    }
    //给元素赋值
    public int setValue(int x,int y,int value){

        return   sArray[x][y]=value;
    }
    //打印数组
    public void showArray(){
        for (int i=0;i<sArray.length;i++){
            for (int val:sArray[i]
                 ) {
                System.out.print(val+"\t");

            }
            System.out.println();
        }

    }
    //数组转稀疏数组
    public int[][] setSparseArray(){

        sparseArrays=new int[count+1][3];//生成稀疏数组
        sparseArrays[0][0]=sArray.length+1;
        sparseArrays[0][1]=sArray[0].length+1;
        int len=0;
        for (int i=0;i<sArray.length;i++){
            for (int j=0;j<sArray[i].length;j++
                 ) {
                if (sArray[i][j]!=0){
                        sparseArrays[len][0]=i;
                        sparseArrays[len][1]=j;
                        sparseArrays[len][2]=sArray[i][j];

                   len++;
                }
            }
        }
        sparseArrays[0][2]=len+1;
        return sparseArrays;
    }
    //展示稀疏数组
    public void showSparse(){
        for (int i=0;i<sparseArrays.length;i++){
            for (int val:sparseArrays[i]
            ) {
                System.out.print(val+"\t");

            }
            System.out.println();
        }

    }

}
 class test{
    public static void main(String[] args) {
        SparseArray sparseArray=new SparseArray();
        sparseArray.init(10,10);
        sparseArray.setValue(1,2,2);
        sparseArray.setValue(2,3,5);
        System.out.println("打印二维数组");
        sparseArray.showArray();
        sparseArray.sparseArrays=sparseArray.setSparseArray();
        System.out.println("打印稀疏数组");
        sparseArray.showSparse();
    }
}