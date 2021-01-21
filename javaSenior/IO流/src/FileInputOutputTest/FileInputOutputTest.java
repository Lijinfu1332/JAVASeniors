package FileInputOutputTest;

import org.junit.Test;

import java.io.*;

public class FileInputOutputTest {
    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File inFile=new File("hello.txt");
            File outFile=new File("hello1.txt");
           fis=new FileInputStream(inFile);
            fos=new FileOutputStream(outFile);
            byte[] buffer=new byte[5];
            int len;
            while ((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fis!=null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos!=null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    public void test2(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            //1.指定要打开的文件
            File inFile=new File("C:\\Users\\李锦富\\IdeaProjects\\javaSenior\\IO流\\src\\01oracle简介.flv");
            File outFile=new File("C:\\Users\\李锦富\\IdeaProjects\\javaSenior\\IO流\\src\\02.flv");
           //2.创建数据的读入和写出流
            fis=new FileInputStream(inFile);
            fos=new FileOutputStream(outFile);
            //3.创建数据的读入和写出的缓冲流
           bis=new BufferedInputStream(fis);
            bos=new BufferedOutputStream(fos);
            byte[] buffer=new byte[1024];
            int len;
            while ((len=bis.read(buffer))!=-1){
                bos.write(buffer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //4.关闭流资源
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos!=null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
