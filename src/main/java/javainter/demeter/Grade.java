package javainter.demeter;

import java.util.ArrayList;
import java.util.List;

public class Grade {

    private List<StudentClass> classes = new ArrayList<>();

    public List<StudentClass> getClasses() {
        return classes;
    }

    public void setClasses(List<StudentClass> classes) {
        this.classes = classes;
    }

    public int countStudents() {
        int count = 0;
        for(StudentClass classe : classes){
           count = classe.countStudents();
        }

        return count;
    }
}
