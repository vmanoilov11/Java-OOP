import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();


        persons.add(new Bulgarian("Peter"));
        persons.add(new European("Peter"));
        persons.add(new Chinese("Peter"));

        for (Person person : persons) {
            print(person);
        }
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }


}

public class European implements Person{
    private String name;
    public European(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return "";
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
public class Bulgarian implements Person{
    private String name;
    public Bulgarian(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }

}
public class Chinese implements Person{
    private String name;
    public Chinese(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
public interface Person {
    String getName();
    String sayHello();
}


