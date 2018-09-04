package test.lamda;

import test.lamda.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author: yangmengjun
 * @date: 2018\8\21 0021 15:37
 */
public class LamdaTest {
    public static void main(String[] args) {
        consumerTest();

    }

    private static void consumerTest() {
        List<Person> personList = new ArrayList<Person>(){
            {
                add(new Person(1,"yang"));
                add(new Person(2,"hou"));
            }

        };
        Consumer<Person> personConsumer = e-> e.setName("test");
        //将personList第二个Person的name设置为test
        personConsumer.accept(personList.get(1));
        personList.forEach(e->System.out.println(e.getName()));
    }
}
