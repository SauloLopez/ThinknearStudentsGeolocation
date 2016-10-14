/**
 * Author Saulo Lopez
 * */
package geostudents;

import geostudents.model.Student;
import geostudents.model.Classroom;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class GeoStudents {
    
    private static Boolean studentInsideRoom(Student student, Classroom classroom) {
        Boolean result = false;
        Point2D.Double studentPosition = student.getPosition();
        Point2D.Double bottomRight = classroom.getBottomRight();
        Point2D.Double topLeft = classroom.getTopLeft();
        
        if ((studentPosition.x < bottomRight.x)&&(studentPosition.x > topLeft.x)
                &&(studentPosition.y < bottomRight.y)&&(studentPosition.y > topLeft.y)) {
            result = true;
        }
        return result;
    }
    
    public static List<Student> studentsInClasses(List<Student> student_list, List<Classroom> classroom_list) {
        List<Student> result = new ArrayList<Student>();
        for (Student thisStudent : student_list) {
            for (Classroom thisClassroom : classroom_list) {
                if (studentInsideRoom(thisStudent, thisClassroom)) {
                    result.add(thisStudent);
                    break; //A student allways be at one room at most
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Student john_student1 = new Student("John Wilson", 34.069149, -118.442639);
        Student jane_student1 = new Student("Jane Graham", 34.069601, -118.441862);
        Student pam_student1 = new Student("Pam Bam", 34.071513, -118.441181);
        
        List<Student> student_list1 = new ArrayList<Student>();
        student_list1.add(john_student1);
        student_list1.add(jane_student1);
        student_list1.add(pam_student1);

        Classroom engineering_classroom1 = new Classroom("Principles of computational geo-location analysis", 34.069140, -118.442689);
        Classroom geology_classroom1 = new Classroom("Sedimentary Petrology", 34.069585, -118.441878);
        Classroom psychology_classroom1 = new Classroom("Introductory Psychobiology", 34.069742, -118.441312);
        Classroom music_classroom1 = new Classroom("Art of Listening", 34.070223, -118.440193);
        Classroom humanities_classroom1 = new Classroom("Art History", 34.071528, -118.441211);
        
        List<Classroom> classroom_list1 = new ArrayList<Classroom>();
        classroom_list1.add(engineering_classroom1);
        classroom_list1.add(geology_classroom1);
        classroom_list1.add(psychology_classroom1);
        classroom_list1.add(music_classroom1);
        classroom_list1.add(humanities_classroom1);
        
        List<Student> students_in_classroom;
        students_in_classroom = studentsInClasses(student_list1, classroom_list1);
        System.out.println("Output for example 1:");
        System.out.println(students_in_classroom);
        
        
        Student john_student2 = new Student("John Wilson", 34.069849, -118.443539);
        Student jane_student2 = new Student("Jane Graham", 34.069901, -118.441562);
        Student pam_student2 = new Student("Pam Bam", 34.071523, -118.441171);
        
        List<Student> student_list2 = new ArrayList<Student>();
        student_list2.add(john_student2);
        student_list2.add(jane_student2);
        student_list2.add(pam_student2);
                
        Classroom engineering_classroom2 = new Classroom("Principles of computational geo-location analysis", 34.069140, -118.442689);
        Classroom geology_classroom2 = new Classroom("Sedimentary Petrology", 34.069585, -118.441878);
        Classroom psychology_classroom2 = new Classroom("Introductory Psychobiology", 34.069742, -118.441312);
        Classroom music_classroom2 = new Classroom("Art of Listening", 34.070223, -118.440193);
        Classroom humanities_classroom2 = new Classroom("Art Hitory", 34.071528, -118.441211);
        
        List<Classroom> classroom_list2 = new ArrayList<Classroom>();
        classroom_list2.add(engineering_classroom2);
        classroom_list2.add(geology_classroom2);
        classroom_list2.add(psychology_classroom2);
        classroom_list2.add(music_classroom2);
        classroom_list2.add(humanities_classroom2);
        
        students_in_classroom = studentsInClasses(student_list2, classroom_list2);
        System.out.println("");
        System.out.println("Output for example 2:");
        System.out.println(students_in_classroom);
    }
    
}
