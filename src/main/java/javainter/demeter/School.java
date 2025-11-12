package javainter.demeter;

import java.util.ArrayList;
import java.util.List;

/*
Loi Demeter:
Une classe ne doit interagir qu'avec les classes amies.
Une méthode définie dans une classe:
-peut utiliser ses propres params
-peut utiliser ses variables locales ou les attributs de la classes
 */

public class School {

    private List<Grade> grades = new ArrayList<>();

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    //méthode pour calculer le nombre total d'étudiants

    public int countStudents(){
        int count = 0;

        for(Grade grade : grades){
//            for(StudentClass classe : grade.getClasses()){
//                for(Student s : classe.getStudents()){
//                    count++;
//                }
//            }
            count = grade.countStudents();
        }

        return count;
    }
}
