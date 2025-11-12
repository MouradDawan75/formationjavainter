package javainter.demeter;

import java.util.ArrayList;
import java.util.List;

public class StudentClass {

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int countStudents() {
        return (int)students.stream().count();
    }
}
