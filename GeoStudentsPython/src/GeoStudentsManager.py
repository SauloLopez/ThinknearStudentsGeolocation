import math
__author__ = "SauloLopez"
__date__ = "$13-10-2016 11:16:38 AM$"

class  GeoStudentsManager :
    EARTH_EQUATORIAL_CIRCUMFERENCE = 40075017.0
    EARTH_MERIDIONAL_CIRCUMFERENCE = 40007860.0
        
    def getMercatorProjectionX(self, longitude):
        
        return (longitude + 180)*(self.EARTH_EQUATORIAL_CIRCUMFERENCE/360.0)
    
    def getMercatorProjectionY(self, latitude):
        latitudeInRad = latitude * math.pi/180
        mercN = math.log(math.tan((math.pi/4) + (latitudeInRad/2)))
        result = (self.EARTH_MERIDIONAL_CIRCUMFERENCE/2) - (self.EARTH_EQUATORIAL_CIRCUMFERENCE*mercN/(2*math.pi));
        return result;
    
    def studentInsideRoom(self, student, classroom, roomSize):
        student_longitude = student["longitude"]
        student_latitude = student["latitude"]
    
        classroom_longitude = classroom["longitude"]
        classroom_latitude = classroom["latitude"]
    
        posx = self.getMercatorProjectionX(student_longitude)
        posy = self.getMercatorProjectionY(student_latitude)
    
        centerx = self.getMercatorProjectionX(classroom_longitude)
        centery = self.getMercatorProjectionY(classroom_latitude)
    
        topx = centerx - roomSize/2
        lefty = centery - roomSize/2
    
        bottomx = centerx + roomSize/2
        righty = centery + roomSize/2
    
        return ((posx < bottomx) and (posx > topx) and (posy < righty) and (posy > lefty))

    def studentsInClasses(self, student_list, classroom_list):
        result = []
        for thisStudent in student_list:
            for thisClassroom in classroom_list:
                if self.studentInsideRoom(thisStudent, thisClassroom, 20):
                    result.append(thisStudent)
                    break; #A student allways be at one room at most

        return result
    
    def studentClustersInClasses(self, student_list, classroom_list):
        result = []
        for thisClassroom in classroom_list:
            tempClassList = []
            tempClassList.append(thisClassroom)

            studentsSingleClass = self.studentsInClasses(student_list, tempClassList)
            if len(studentsSingleClass) > 1:
                result = result + studentsSingleClass

        return result