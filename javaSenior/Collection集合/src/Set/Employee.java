package Set;

public class Employee implements Comparable {
    private String name;
    private int age;
    private MyDate date;

    public Employee(String name, int age, MyDate date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public Employee() {
    }

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

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
    @Override
    public int compareTo(Object o) {
        int num;
        Employee e1= (Employee) o;
        if (o instanceof Employee){

            return this.getName().compareTo(e1.getName());

        }
        throw new RuntimeException("两次输入的数据类型不一致");
    }
}
