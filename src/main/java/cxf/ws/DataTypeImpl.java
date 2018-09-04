package cxf.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import cxf.bean.Student;

@WebService
public class DataTypeImpl implements DataTypeWS {

    @Override
    public boolean addStudent(Student s) {
        System.out.println("WebService addStudent");
        // Student s = new Student(1,"yaang",10000);
        return true;
    }

    @Override
    public Student getStuById(int id) {
        System.out.println("WebService getStuById");
        return new Student(1, "yaang", 1555);
    }

    @Override
    public List<Student> getStudentsByPrice(float p) {
        List<Student> l = new ArrayList<Student>();
        l.add(new Student(1, "yaang", 1555));
        return l;
    }

    /*@Override
    public Map<Integer, Student> getAllStudentsMap() {
        Map<Integer, Student> m = new HashMap<Integer, Student>();
        m.put(1, new Student(1, "yaang", 1555));
        m.put(2, new Student(2, "xu", 12000));
        m.put(3, new Student(3, "hou", 10000));
        return m;
    }*/

}
