package cxf.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import cxf.bean.Student;

@WebService
public interface DataTypeWS {

    @WebMethod
    public boolean addStudent(Student s);

    @WebMethod
    public Student getStuById(int id);

    @WebMethod
    public List<Student> getStudentsByPrice(float p);

    //    @WebMethod
    //    public Map<Integer, Student> getAllStudentsMap();
}
