package IOtest1;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class InputOutpuTest {
    @Test
    public void test1() throws FileNotFoundException {
        //1.实列化文件，指明要操作的文件
        File file=new File("hello.text");
        if (!file.exists()){
            file.mkdir();
            System.out.println(file.getAbsolutePath());
        }else {
            file.delete();
        }
    }
    @Test
    public void test2() throws Exception {
        File file=null;
        FileReader fr=null;
        try {
            //1.实列化文件，指明要操作的文件
            file=new File("hello.txt");
            //2.提供具体的流
           fr=new FileReader(file);
            //3.数据的读入
            int data ;
            while ((data=fr.read())!=-1){//当数据不等于-1的时候遍历读取数据
                System.out.print((char) data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {if(fr!=null) {
                fr.close();
            }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
    @Test
    public  void test3() {
        File file;
        FileReader fr = null;
        try {
            //1.实列化文件，指明要操作的文件
            file = new File("hello.txt");
            //2.提供具体的流
            fr = new FileReader(file);
            //3.数据的读入
            char str[] = new char[5];
            int data;
            while ((data = fr.read(str)) != -1) {//当数据不等于-1的时候遍历读取数据
                /**正确的读法1：
                 *   for (int i = 0; i < data; i++) {
                 *                     System.out.print((char) str[i]);
                 *                 }
                 *  错误的读法1：
                 *     for (int i = 0; i < str.length; i++) {
                 *                     System.out.print((char) str[i]);
                 *                 }
                 *  错误的读法2：
                 *  String strs=new String(str);
                 *                     System.out.print(strs);
                 */
                //正确的读法2：通过字符串来读写
                    String strs=new String(str,0,data);
                    System.out.print(strs);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

