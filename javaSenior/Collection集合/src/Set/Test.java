package Set;


import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Test {
    @org.junit.Test
    public void test1(){
        TreeSet treeSet=new TreeSet();
        Employee e1=new Employee("zhangsan",25,new MyDate(1995,11,6));
        Employee e2=new Employee("lisi",23,new MyDate(1996,1,7));
        Employee e3=new Employee("bob",19,new MyDate(1998,9,3));
        Employee e4=new Employee("jack",27,new MyDate(1990,5,2));
        Employee e5=new Employee("lili",25,new MyDate(1995,4,6));
        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        treeSet.add(e5);
        new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                MyDate d1= (MyDate) o1;
                MyDate d2= (MyDate) o2;
                if (d1 instanceof MyDate&&d2 instanceof MyDate){
                    int num=compare(d1.getYear(),d2.getYear());
                    if (num==0){
                        int num2=compare(d1.getMouth(),d2.getMouth());
                        if (num2==0){
                            return compare(d1.getDay(),d2.getDay());
                        }
                    }
                }
                return 0;
            }
        };
        Iterator it=treeSet.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    @org.junit.Test
    public void test2(){
        HashSet set=new HashSet();
        set.add(new User(1001,"zhangsan",15));
        set.add(new User(1001,"lisi",15));
        System.out.println(set);
        set.remove(1001);
        System.out.println(set);

    }

}
