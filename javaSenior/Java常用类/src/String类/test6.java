package String类;

import org.junit.Test;

public class test6 {
    /*
    将一个字符串的指定部分进行反转
    方式1：
        转换为char[]型数组
     */
    @Test

    public String revese(String str,int startIndex,int endIndex){
        //将字符串转换为字符数组
        char[] arry=str.toCharArray();
        for(int x=startIndex, y =endIndex;x<y;x++,y--){
            char temp=arry[x];
            arry[x]=arry[y];
            arry[y]=temp;
        }

        return new String(arry);
    }
    //方式二：使用字符串的拼接
    public  String revese1(String str,int startIndex,int endIndex){
        if(str!=null){
            //第一部分
            String reveseStr1=str.substring(0,startIndex);
            //第二部分
            for (int i=endIndex;i>=startIndex;i--){
                reveseStr1+=str.charAt(endIndex+1);
                return reveseStr1;
            }
        }
        return null;
    }
    //方式三：
        //使用StringBuffer和StringBuilder替换String
    @Test
    public String revese2(String str ,int startIndex,int endIndex){
        if (str!=null){
            StringBuilder builder=new StringBuilder(str);
            //第一部分
            builder.substring(0,startIndex);
            //第二部分
            for (int i=endIndex;i>=startIndex;i--){
                builder.append(str.charAt(i));
            }
            //第三部分
            builder.append(str.substring(endIndex+1));
            return builder.toString();
        }
        return  null;
    }
    @Test
    public void testRevese(){

        revese("abcdefgce",2,5);
    }
}
