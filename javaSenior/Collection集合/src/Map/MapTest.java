package Map;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MapTest {
    @Test
    public void test1(){
        Map map=new HashMap();
        map.put("AA",13);
        map.put("BB",15);
        map.put(12,13);
        Object aa = map.remove("AA");
        System.out.println(aa);
        Map map1=new HashMap();
        map1.put(15,19);
        map1.put("DD",14);
        map.putAll(map1);
        System.out.println(map.get("DD"));
        System.out.println(map.get(12));
        map.clear();
        System.out.println(map.isEmpty());


    }
    @Test
    public void test2(){
        //查询里面的数据的KEY值
        Map map3=new HashMap();
        map3.put("AA",13);
        map3.put("BB",15);
        map3.put(12,13);
        Set set=map3.keySet();
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //查询map3里面的value值
        Collection set1=map3.values();
        Iterator it=set1.iterator();
        while (it.hasNext()){
            Object key=it.next();
            Object value=map3.get(key);
            System.out.println(key+":"+value);
        }
    }
    @Test
    public void test4(){
        User user1=new User(1,"jack",19);
        User user2=new User(2,"ros",15);
        User user3=new User(3,"los",22);
        User user4=new User(4,"zd",11);
        Map map=new TreeMap();
        map.put(user1,99);
        map.put(user2,100);
        map.put(user3,101);
        map.put(user4,103);
       // System.out.println(map);
         new Comparator() {
             @Override
             public int compare(Object o1, Object o2) {
                 User u1=(User)o1;
                 User u2=(User)o2;
                 if (u1 instanceof User&&u2 instanceof User){
                     int num=Integer.compare(u1.getAge(),u2.getAge());
                     if (num==0){
                         return ((User) o1).getName().compareTo(u2.getName());
                     }
                 }
                 throw new RuntimeException("两次输入的数据不一致");
             }
         };
        System.out.println(map);
    }
    @Test
    public void test5() throws IOException {
    Properties properties=new Properties();
    FileInputStream fis=new FileInputStream("jdbc.properties");
    properties.load(fis);//加载文件
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println(name+":"+password);

    }
    @Test
    public void test6(){
        List list=new ArrayList();
        list.add(15);
        list.add(14);
        list.add(2323);
        list.add(-182);
        list.add(25);
        Collections.reverse(list);//将字符串进行反转
        System.out.println(list);
        Collections.shuffle(list);//将字符串进行随机排序
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        List desp=Arrays.asList(new Object[list.size()]);
        System.out.println(desp.size());
        Collections.copy(desp,list);
        System.out.println(desp);
        Collections.synchronizedList(list);//线程安全处理方法
    }
    //随机抽取数字
    @Test
    public void test7(){
        List list=new ArrayList();
        for (int i=0;i<=100;i++){
            list.add(i);
        }
        Collections.shuffle(list);
        Random random=new Random();
        int num2 = random.nextInt(100);
        System.out.println(num2);
        int num1 = list.indexOf(num2);
        System.out.println(num1);
        System.out.println(num1+num2);


    }
}
