package String类;

import org.junit.Test;

public class test7 {
    /*
    一个字符串在另一个字符串中出现的次数
     */
    public  int getCount(String mainStr,String subStr){
       int mainLength=mainStr.length();
       int subLength=subStr.length();
       int count=0;
       int index;
       if(mainLength>=subLength){
            while ((index=mainStr.indexOf(subStr))!=-1){
                count++;
               mainStr=mainStr.substring(index+subStr.length());
            }
           return count;
       }else {
           return 0;
       }

    }
    public  int getCount1(String mainStr,String subStr){
        int mainLength=mainStr.length();
        int subLength=subStr.length();
        int count=0;
        int index=0;
        if(mainLength>=subLength){
            while ((index=mainStr.indexOf(subStr,index))!=-1){
                count++;
               index+=subLength;
            }
            return count;
        }else {
            return 0;
        }

    }
    @Test
    public void testCount(){
        String subStr="ab";
        String mainStr="abdskkjdjdjkdabskkskabddd";
       int count= getCount(mainStr,subStr);
       int count2=getCount1(mainStr,subStr);
        System.out.println(count);
        System.out.println(count2);

    }
}
