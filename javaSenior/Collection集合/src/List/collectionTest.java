package List;

import org.junit.Test;

import java.util.*;

/**
 * 一、集合框架的概述
 *
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 *  说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中）
 *
 * 2.1 数组在存储多个数据方面的特点：
 *      > 一旦初始化以后，其长度就确定了。
 *      > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *       比如：String[] arr;int[] arr1;Object[] arr2;
 * 2.2 数组在存储多个数据方面的缺点：
 *      > 一旦初始化以后，其长度就不可修改。
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *      > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *      > 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 * 二、集合框架
 *      |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：存储有序的、可重复的数据。  -->“动态”数组
 *              |----ArrayList、LinkedList、Vector
 *
 *          |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *              |----HashSet、LinkedHashSet、TreeSet
 *
 *      |----Map接口：双列集合，用来存储一对(key - value)一对的数据   -->高中函数：y = f(x)
 *              |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *
 * 三、Collection接口中的方法的使用
 *
 * @author shkstart
 * @create 2019 下午 4:08
 */
public class collectionTest {
    public static void main(String[] args) {
        //Create a collection to implement an ArrayList interface
        Collection collection=new ArrayList();
        Collection collection2=new ArrayList();
        //Add an element to the collection
        collection.add("1222");
        collection.add(new Date());
        collection2.add("12232");
        collection2.add(2112);
        //View the length of the elemente in thecollection
        System.out.println(collection.size());
        //Add an element from another collection to one collection
         collection.addAll(collection2);
        //View the length of the elemente in thecollection
        System.out.println(collection.size());
    }
    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Date());
        coll.add(new Person("lisi",15));
        //See if the element is included in the collection
        System.out.println(coll.contains(123));
        Collection coll1= Arrays.asList(123,456);
        //See if the collection contains all the elements of another collection species
        System.out.println(coll.containsAll(coll1));
    }
    @Test
    public void test2(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Date());
        coll.add(new Person("lisi",15));
        //Delete the element in the collection
        System.out.println(coll.remove(123));
        Collection coll1=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Date());
        //Find the intersection of two sets and return it to the current set
        coll.retainAll(coll1);
        System.out.println(coll);
        //Delete all elements in the collection
        System.out.println(coll.removeAll(coll));
        System.out.println(coll);
    }
    @Test
    public  void test3(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Date());
        coll.add(new Person("lisi",15));
        //The mutual transformation between sets and groups
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int[] arr1={12,56,30,25,47};
        Collection<int[]> list = Arrays.asList(arr1);
        Iterator it=list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    //Iterrator method used
    @Test
    public void test4(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Date());
        coll.add(new Person("lisi",15));
        Iterator it=coll.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            if("123".equals(obj)){
               //
                it.remove();
            }
        }
    }
}
class Person{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //Overriding equals methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}