public class Classroom
{
	private String teacherName;
	private Student[] students;

    public Classroom(String teacherName, Student[] students)
    {
        this.teacherName = teacherName;
        this.students = students;
    }

    public String getTeacherName()
    {
        return teacherName;
    }

    public Student[] getStudents()
    {
        return students;
    }
}
