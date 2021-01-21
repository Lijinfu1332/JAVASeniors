package Set;

import org.junit.Test;

import java.util.*;

public class SetTest {
    @Test
    public void test1(){
        Set set=new HashSet();
        set.add(15);
        set.add("aa");
        set.add("BB");
        set.add(new User(1001,"lisi",18));
        set.add(new User(1002,"lisi",19));
        set.add(new Date());
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        Set set=new LinkedHashSet();
        set.add(15);
        set.add("aa");
        set.add("BB");
        set.add(new User(1001,"lisi",18));
        set.add(new User(1002,"lisi",18));
        set.add(new Date());
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }}
        @Test
        public void test3(){
        Set set=new TreeSet();
        set.add(new User(1001,"lisi",119));
        set.add(new User(1002,"lisi",18));
        set.add(new User(1003,"zhangsan",119));
        set.add(new User(1004,"wangwu",18));
        set.add(new User(1005,"laoer",18));
            Iterator iterator=set.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    @Test
    public void test4(){
        Comparator com=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User&& o2 instanceof User ){
                    User u1=(User)o1;
                    User u2=(User)o2;
                    return -Integer.compare(u1.getAge(),u2.getAge());
                }else {
                throw new RuntimeException("数据类型不一致");
            }}
        };
        Set set=new TreeSet(com);
        set.add(new User(1001,"lisi",119));
        set.add(new User(1002,"lisi",18));
        set.add(new User(1003,"zhangsan",119));
        set.add(new User(1004,"wangwu",18));
        set.add(new User(1005,"laoer",18));
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
