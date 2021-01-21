package List;

import org.junit.Test;

public class test {
  //  @Test
  public static void main(String[] args) {
      ArrayTest test=new ArrayTest();
      int[] arr={29,28,7,36,21,88,59,26,05,15};

      int[] arraysort=test.arrayTest(arr);
      /*
      System.out.printf("[");
      for (int i=0;i<arraysort.length;i++){

          if (arraysort[i]==arraysort[arraysort.length-1]){
          }else {
              System.out.printf(arraysort[i]+",");
          }
      }
      System.out.printf("]");
      */

  }

}
class ArrayTest{
    public int[] arrayTest(int[] array){
        for (int i=0;i<array.length-1;i++){
            for (int j=0;j<array.length-1-i;j++){
                if (array[j]>array[j+1]){
                    int team=array[j];
                    array[j+1]=array[j];
                    array[j]=team;
                }
            }
        }
        return array;
    }
}
