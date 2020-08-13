import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author yymuhua
 * @create 2020-04-15 16:22
 */
public class Main2 {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        Person p1 = new Person("唐僧","pwd1", 25);
        Person p2 = new Person("孙悟空","pwd2",26);
        Person p3 = new Person("猪八戒","pwd3",27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("总共有:"+set.size()+" 个元素!");
        //结果：总共有:3 个元素!
        p3.setAge(2); //修改p3的年龄,此时p3元素对应的hashcode值发生改变 set.remove(p3); //此时remove不掉，造成内存泄漏
        set.add(p3); //重新添加，居然添加成功
        System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:4 个元素!
        for (Person person : set) {
            System.out.println(person);
        }
    }
    static class Person {
        String name;
        String level;
        int age;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name) &&
                    Objects.equals(level, person.level);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, level, age);
        }

        public Person(String name, String level, int age) {
            this.name = name;
            this.level = level;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", level='" + level + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
