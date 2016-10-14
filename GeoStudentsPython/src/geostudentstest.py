# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

import unittest

from GeoStudentsManager import GeoStudentsManager;

class  GeostudetsTestCase(unittest.TestCase):
    classroom_list = []
    student_list = []
    studentsManager = GeoStudentsManager()
    
    def setUp(self):
        self.engineering_classroom = { 'name': 'Principles of computational geo-location analysis', 'latitude': 34.069140, 'longitude': -118.442689 }
        self.geology_classroom = { 'name': 'Sedimentary Petrology', 'latitude': 34.069585, 'longitude': -118.441878 }
        self.psychology_classroom = { 'name': 'Introductory Psychobiology', 'latitude': 34.069742, 'longitude': -118.441312 }
        self.music_classroom = { 'name': 'Art of Listening', 'latitude': 34.070223, 'longitude': -118.440193 }
        self.humanities_classroom = { 'name': 'Art Hitory', 'latitude': 34.071528, 'longitude': -118.441211 }

        self.john_student = { 'name': 'John Wilson', 'latitude': 34.069149, 'longitude': -118.442639 } # engineering
        self.jane_student = { 'name': 'Jane Graham', 'latitude': 34.069601, 'longitude': -118.441862 } # geology
        self.pam_student = { 'name': 'Pam Bam', 'latitude': 34.071513, 'longitude': -118.441181 } # humanities

        self.student_list = [self.john_student,self.jane_student,self.pam_student]
        self.classroom_list = [self.geology_classroom,self.psychology_classroom,self.music_classroom,self.humanities_classroom,self.engineering_classroom]

    def test_example1(self):
        result = self.studentsManager.studentsInClasses(self.student_list, self.classroom_list)
       
        assert self.john_student in result
        assert self.jane_student in result
        assert self.pam_student in result
        assert len(result) == 3
        
    def test_example2(self):
        john_student = { 'name': 'John Wilson', 'latitude': 34.069849, 'longitude': -118.443539 }
        jane_student = { 'name': 'Jane Graham', 'latitude': 34.069901, 'longitude': -118.441562 }
        pam_student = { 'name': 'Pam Bam', 'latitude': 34.071523, 'longitude': -118.441171 }

        student_list2 = [john_student,jane_student,pam_student]
        result = self.studentsManager.studentsInClasses(student_list2, self.classroom_list)
       
        assert pam_student in result
        assert len(result) == 1

    def test_crowd_cluster(self):
        jane_student1 = { 'name': 'Jane Graham 1', 'latitude': 34.069601, 'longitude': -118.441862 } # geology
        jane_student2 = { 'name': 'Jane Graham 2', 'latitude': 34.069602, 'longitude': -118.441861 } # geology
        pam_student1 = { 'name': 'Pam Bam 1', 'latitude': 34.071513, 'longitude': -118.441181 } # humanities
        pam_student2 = { 'name': 'Pam Bam 2', 'latitude': 34.071512, 'longitude': -118.441180 } # humanities
        john_student2 = { 'name': 'John Wilson 2', 'latitude': 34.069148, 'longitude': -118.442638 } # engineering
        john_student1 = { 'name': 'John Wilson 1', 'latitude': 34.069149, 'longitude': -118.442639 } # engineering
    
        student_list2 = [jane_student1,jane_student2,pam_student1,pam_student2,john_student1,john_student2]
        result = self.studentsManager.studentClustersInClasses(student_list2, self.classroom_list)
        
        assert jane_student1 in result
        assert jane_student2 in result
        assert pam_student1 in result
        assert pam_student2 in result
        assert john_student1 in result
        assert john_student2 in result
        
        assert len(result) == 6
        
    def test_studentAreInsideRoom(self):
        assert self.studentsManager.studentInsideRoom(self.john_student, self.engineering_classroom, 20)
        assert self.studentsManager.studentInsideRoom(self.jane_student, self.geology_classroom, 20)
        assert self.studentsManager.studentInsideRoom(self.pam_student, self.humanities_classroom, 20)
        
    def test_studentAreNotInsideRoom(self):
        assert self.studentsManager.studentInsideRoom(self.john_student, self.geology_classroom, 20) == 0
        assert self.studentsManager.studentInsideRoom(self.john_student, self.humanities_classroom, 20) == 0
        assert self.studentsManager.studentInsideRoom(self.john_student, self.psychology_classroom, 20) == 0
        assert self.studentsManager.studentInsideRoom(self.john_student, self.music_classroom, 20) == 0
        
        assert self.studentsManager.studentInsideRoom(self.jane_student, self.engineering_classroom, 20) == 0
        assert self.studentsManager.studentInsideRoom(self.jane_student, self.humanities_classroom, 20) == 0
        assert self.studentsManager.studentInsideRoom(self.jane_student, self.psychology_classroom, 20) == 0
        assert self.studentsManager.studentInsideRoom(self.jane_student, self.music_classroom, 20) == 0
        
        assert self.studentsManager.studentInsideRoom(self.pam_student, self.engineering_classroom, 20) == 0
        assert self.studentsManager.studentInsideRoom(self.pam_student, self.geology_classroom, 20) == 0
        assert self.studentsManager.studentInsideRoom(self.pam_student, self.psychology_classroom, 20) == 0
        assert self.studentsManager.studentInsideRoom(self.pam_student, self.music_classroom, 20) == 0
        
if __name__ == '__main__':
    unittest.main()
