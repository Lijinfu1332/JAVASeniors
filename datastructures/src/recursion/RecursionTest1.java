package recursion;

public class RecursionTest1 {
    public static void main(String[] args) {
        test(10);
        //System.out.println(test2(5));
    }
    public static void test(int n){
        if (n>5){
            test(n-1);
            System.out.println(n);
        }

    }
    public static int test2(int n){
        if (n<=1){
            return 1;
        }else {
            return n*test2(n-1);
        }

    }
}
