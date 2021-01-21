package String类;

import org.junit.Test;

public class test8 {
    //比较两个字符串的相同片段，并获取到相同片段字符串
    //如果有多个，则智能获取到一个
    public String getString(String string1,String string2){
        //获取输入的两个字符串哪个长度长
        String maxString=(string1.length()>=string2.length())?string1:string2;
        //获取输入的两个字符串哪个长度短
        String minString=(string1.length()<string2.length())?string1:string2;
        //判断两个字符串是否为空
        if (maxString!=null&&minString!=null){
            //获取小的字符串长度
        int length=minString.length();
        //遍历小的字符串
        for (int i=0;i<length;i++){
            for (int x=0,y=length-i;y<=length;x++,y++){
                //获取小的字符串片段是否包含在大的那串字符串中
                String subString=minString.substring(x,y);
                if (maxString.contains(subString)){
                    return subString;
                }
            }
        }}
        return null;
    }
    @Test
    public void test(){
        String s1="ssasasaabcdeoosdkdsk";
        String s2="asassasaabcdesasasa";
       String test= getString(s1,s2);
        System.out.println(test);
    }
}
