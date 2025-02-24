import java.util.Arrays;

public class School
{
    Classroom[] classrooms;
    
    public School(int numClassrooms)
    {
        classrooms = new Classroom[numClassrooms];
    }
    
    public void addClassroom(int index, Classroom classroom)
    {
        classrooms[index] = classroom;
    }
    
    public String findStudent(String teacherName, int studentId)
    {
        Classroom classroom = null;
        for (Classroom cls : classrooms)
        {
            if (cls.teacherName.equals(teacherName))
            {
                classroom = cls;
                break;
            }
        }
        
        if (classroom == null)
        {
            return "Student Not Found";
        }
        
        Student[] students = classroom.students;
        int left = 0;
        int right = students.length - 1;
        
        while (left <= right)
        {
            int mid = (left + right) / 2;
            if (students[mid].sID == studentId)
            {
                return students[mid].sName;
            } 
            else if (students[mid].sID < studentId)
            {
                left = mid + 1;
            } 
            else
            {
                right = mid - 1;
            }
        }
        
        return "Student Not Found";
    }
}
