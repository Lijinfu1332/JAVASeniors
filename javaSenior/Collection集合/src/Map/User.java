package Map;

import java.util.Objects;

public class User implements Comparable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.name = name;
        this.age = age;
        this.id=id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        if (user instanceof User) {
            int num = this.name.compareTo(user.name);
            if (num == 0) {
                return Integer.compare(this.age, user.age);
            } else {
                return num;
            }
        } else {

            throw new RuntimeException("两次输入的数据类型不一致");

        }
    }
}
