package test;

import geostudents.GeoStudents;
import geostudents.model.Classroom;
import geostudents.model.Student;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GeoStudentsTest {
    private List<Classroom> classroom_list;
    Classroom engineering_classroom;
    Classroom geology_classroom;
    Classroom psychology_classroom;
    Classroom music_classroom;
    Classroom humanities_classroom;
    
    public GeoStudentsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        engineering_classroom = new Classroom("Principles of computational geo-location analysis", 34.069140, -118.442689);
        geology_classroom = new Classroom("Sedimentary Petrology", 34.069585, -118.441878);
        psychology_classroom = new Classroom("Introductory Psychobiology", 34.069742, -118.441312);
        music_classroom = new Classroom("Art of Listening", 34.070223, -118.440193);
        humanities_classroom = new Classroom("Art History", 34.071528, -118.441211);
        
        classroom_list = new ArrayList<Classroom>();
        classroom_list.add(engineering_classroom);
        classroom_list.add(geology_classroom);
        classroom_list.add(psychology_classroom);
        classroom_list.add(music_classroom);
        classroom_list.add(humanities_classroom);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testStudentsInClassesExample1() {
        Student john_student = new Student("John Wilson", 34.069149, -118.442639);
        Student jane_student = new Student("Jane Graham", 34.069601, -118.441862);
        Student pam_student = new Student("Pam Bam", 34.071513, -118.441181);
        
        List<Student> student_list = new ArrayList<Student>();
        student_list.add(john_student);
        student_list.add(jane_student);
        student_list.add(pam_student);

        List<Student> result = GeoStudents.studentsInClasses(student_list, classroom_list);
        
        assertEquals(result.contains(john_student), true);
        assertEquals(result.contains(jane_student), true);
        assertEquals(result.contains(pam_student), true);
        assertEquals(result.size(), 3);
    }
    
    @Test
    public void testStudentsInClassesExample2() {
        Student john_student = new Student("John Wilson", 34.069849, -118.443539);
        Student jane_student = new Student("Jane Graham", 34.069901, -118.441562);
        Student pam_student = new Student("Pam Bam", 34.071523, -118.441171);
        
        List<Student> student_list = new ArrayList<Student>();
        student_list.add(john_student);
        student_list.add(jane_student);
        student_list.add(pam_student);
       
        List<Student> expResult = new ArrayList<Student>();
        expResult.add(pam_student);
        
        List<Student> result = GeoStudents.studentsInClasses(student_list, classroom_list);

        assertEquals(result.contains(pam_student), true);
        assertEquals(result.size(), 1);
    }
    
    /*
    * No students inside rooms
    */
    @Test
    public void testStudentsInClassesExample3() {
        Student john_student = new Student("John Wilson", 35.069849, -115.443539);
        Student jane_student = new Student("Jane Graham", 35.069901, -115.441562);
        Student pam_student = new Student("Pam Bam", 35.071523, -115.441171);
        
        List<Student> student_list = new ArrayList<Student>();
        student_list.add(john_student);
        student_list.add(jane_student);
        student_list.add(pam_student);
       
        List<Student> expResult = new ArrayList<Student>();
                
        List<Student> result = GeoStudents.studentsInClasses(student_list, classroom_list);
        assertEquals(expResult, result);
    }
    
    /*
    * Empty students list
    */
    @Test
    public void testStudentsInClassesExample4() {
        Student john_student = new Student("John Wilson", 35.069849, -115.443539);
        Student jane_student = new Student("Jane Graham", 35.069901, -115.441562);
        Student pam_student = new Student("Pam Bam", 35.071523, -115.441171);
        
        List<Student> student_list = new ArrayList<Student>();
        student_list.add(john_student);
        student_list.add(jane_student);
        student_list.add(pam_student);
       
        List<Student> expResult = new ArrayList<Student>();
                
        List<Student> result = GeoStudents.studentsInClasses(student_list, classroom_list);
        assertEquals(expResult, result);
    }
    
    /*
    * Empty classroom list
    */
    @Test
    public void testStudentsInClassesExample5() {
        List<Student> student_list = new ArrayList<Student>();
       
        List<Student> expResult = new ArrayList<Student>();
        
        List<Classroom> classroom_list_empty = new ArrayList<Classroom>();
                
        List<Student> result = GeoStudents.studentsInClasses(student_list, classroom_list_empty);
        assertEquals(expResult, result);
    }
    
    /*
    * Test Example1 data consistency as established the description
    * john_student is in engineering
    * jane_student is in geology
    * pam_student is in humanities
    */
    @Test
    public void testStudentsInClassesExample6() {
        Student john_student = new Student("John Wilson", 34.069149, -118.442639);
        Student jane_student = new Student("Jane Graham", 34.069601, -118.441862);
        Student pam_student = new Student("Pam Bam", 34.071513, -118.441181);
        
        List<Student> student_list = new ArrayList<Student>();
        student_list.add(john_student);
        student_list.add(jane_student);
        student_list.add(pam_student);
        
        List<Classroom> classroom_list_crowd = new ArrayList<Classroom>();
        List<Student> result;
        
        classroom_list_crowd.add(engineering_classroom);
        result = GeoStudents.studentsInClasses(student_list, classroom_list_crowd);
        assertEquals(result.contains(john_student), true);
        assertEquals(result.size(), 1);
        classroom_list_crowd.clear();
        
        classroom_list_crowd.add(geology_classroom);
        result = GeoStudents.studentsInClasses(student_list, classroom_list_crowd);
        assertEquals(result.contains(jane_student), true);
        assertEquals(result.size(), 1);
        classroom_list_crowd.clear();
        
        classroom_list_crowd.add(psychology_classroom);  //Empty room
        result = GeoStudents.studentsInClasses(student_list, classroom_list_crowd);
        assertEquals(result.size(), 0);
        classroom_list_crowd.clear();

        
        classroom_list_crowd.add(music_classroom); //Empty room
        result = GeoStudents.studentsInClasses(student_list, classroom_list_crowd);
        assertEquals(result.size(), 0);
        classroom_list_crowd.clear();
        
        classroom_list_crowd.add(humanities_classroom);
        result = GeoStudents.studentsInClasses(student_list, classroom_list_crowd);
        assertEquals(result.contains(pam_student), true);
        assertEquals(result.size(), 1);
    }
  
}
