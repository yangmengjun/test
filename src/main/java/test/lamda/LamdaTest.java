package test.lamda;

import com.sun.jmx.snmp.tasks.Task;
import test.lamda.entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author: yangmengjun
 * @date: 2018\8\21 0021 15:37
 */
public class LamdaTest {
    public static void main(String[] args) {
        consumerTest();
        stastistic();

    }

    private static void stastistic() {
        long start = System.currentTimeMillis();
        Collection<Person> collection = Arrays.asList(
                new Person(1,"yang",15,true),
                new Person(1,"luo",30,true),
                new Person(2,"hou",75,false));
        Integer totalPrettyScore = collection.stream().filter(person -> person.getIsPretty()).mapToInt(Person::getScore).sum();
        Integer totalPoints = collection.stream().parallel().map(person -> person.getScore()).reduce(0,Integer::sum);
        long end = System.currentTimeMillis();
        System.out.printf("Total scores is %d and Pretty men total score:%d,takes %d millseconds",totalPoints,totalPrettyScore,end-start);

    }

    private static void consumerTest() {
        List<Person> personList = new ArrayList<Person>(){
            {
                add(new Person(1,"yang",15,true));
                add(new Person(2,"hou",75,true));
            }

        };
        Consumer<Person> personConsumer = e-> e.setName("test");
        //将personList第二个Person的name设置为test
        personConsumer.accept(personList.get(1));
        personList.forEach(e->System.out.println(e.getName()));
    }
}
