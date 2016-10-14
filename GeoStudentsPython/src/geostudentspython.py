# Author: Saulo Lopez
from GeoStudentsManager import GeoStudentsManager;
    
if __name__ == "__main__":
    engineering_classroom = { 'name': 'Principles of computational geo-location analysis', 'latitude': 34.069140, 'longitude': -118.442689 }
    geology_classroom = { 'name': 'Sedimentary Petrology', 'latitude': 34.069585, 'longitude': -118.441878 }
    psychology_classroom = { 'name': 'Introductory Psychobiology', 'latitude': 34.069742, 'longitude': -118.441312 }
    music_classroom = { 'name': 'Art of Listening', 'latitude': 34.070223, 'longitude': -118.440193 }
    humanities_classroom = { 'name': 'Art Hitory', 'latitude': 34.071528, 'longitude': -118.441211 }

    john_student = { 'name': 'John Wilson', 'latitude': 34.069149, 'longitude': -118.442639 } # engineering
    jane_student = { 'name': 'Jane Graham', 'latitude': 34.069601, 'longitude': -118.441862 } # geology
    pam_student = { 'name': 'Pam Bam', 'latitude': 34.071513, 'longitude': -118.441181 } # humanities

    student_list = [john_student,jane_student,pam_student]
    classroom_list = [geology_classroom,psychology_classroom,music_classroom,humanities_classroom,engineering_classroom]
    
    studentsManager = GeoStudentsManager()
    result = studentsManager.studentsInClasses(student_list, classroom_list)
    print("Result example 1")
    print(result)
    
    engineering_classroom = { 'name': 'Principles of computational geo-location analysis', 'latitude': 34.069140, 'longitude': -118.442689 }
    geology_classroom = { 'name': 'Sedimentary Petrology', 'latitude': 34.069585, 'longitude': -118.441878 }
    psychology_classroom = { 'name': 'Introductory Psychobiology', 'latitude': 34.069742, 'longitude': -118.441312 }
    music_classroom = { 'name': 'Art of Listening', 'latitude': 34.070223, 'longitude': -118.440193 }
    humanities_classroom = { 'name': 'Art Hitory', 'latitude': 34.071528, 'longitude': -118.441211 }

    john_student = { 'name': 'John Wilson', 'latitude': 34.069849, 'longitude': -118.443539 }
    jane_student = { 'name': 'Jane Graham', 'latitude': 34.069901, 'longitude': -118.441562 }
    pam_student = { 'name': 'Pam Bam', 'latitude': 34.071523, 'longitude': -118.441171 }

    student_list2 = [john_student,jane_student,pam_student]
    result = studentsManager.studentsInClasses(student_list2, classroom_list)
    print("")
    print("Result example 2")
    print(result)
    
    john_student1 = { 'name': 'John Wilson 1', 'latitude': 34.069149, 'longitude': -118.442639 } # engineering
    jane_student1 = { 'name': 'Jane Graham 1', 'latitude': 34.069601, 'longitude': -118.441862 } # geology
    pam_student1 = { 'name': 'Pam Bam 1', 'latitude': 34.071513, 'longitude': -118.441181 } # humanities
    john_student2 = { 'name': 'John Wilson 2', 'latitude': 34.069148, 'longitude': -118.442638 } # engineering
    jane_student2 = { 'name': 'Jane Graham 2', 'latitude': 34.069602, 'longitude': -118.441861 } # geology
    pam_student2 = { 'name': 'Pam Bam 2', 'latitude': 34.071512, 'longitude': -118.441180 } # humanities
    
    student_list2 = [john_student1,jane_student1,pam_student1, john_student2,jane_student2,pam_student2]
    result = studentsManager.studentClustersInClasses(student_list2, classroom_list)
    print("")
    print("Result crowd cluster example")
    print(result)    

