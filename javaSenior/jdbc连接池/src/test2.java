import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class test2 {
    public static void main(String[] args) throws IOException {
       A a=new B();
        a.foo("test.txt");
    }

}
class A{
    public void foo(String path)throws IOException{
        BufferedReader br=new BufferedReader(new FileReader(path));
        System.out.println("A"+br.readLine());
    }
}
class B extends A{
    public void foo(String path)throws IOException{
        BufferedReader br=new BufferedReader(new FileReader(path));
        System.out.println("B"+br.readLine());
    }
}
