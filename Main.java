import java.util.Scanner;

public class MainMenu
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("How many students?");
        int x = input.nextInt();
        
        System.out.println("How many classrooms?");
        int n = input.nextInt();
        
        School school = new School(n);
        
        for (int i = 0; i < n; i++)
        {
        	input.nextLine();
            System.out.println("Enter teacher's name for classroom " + (i + 1));
            String teacherName = input.nextLine();
            
            Student[] students = new Student[x];
            for (int j = 0; j < x; j++)
            {
                System.out.println("Enter student name for student #" + (j + 1));
                String studentName = input.nextLine();
                System.out.println("Enter student ID for student #" + (j + 1));
                int studentId = input.nextInt();
                input.nextLine(); // consume newline
                students[j] = new Student(studentName, studentId);
            }
            
            school.addClassroom(i, new Classroom(teacherName, students));
        }
        
        System.out.println("What is the name of the teacher?");
        String teacherName = input.nextLine();
        
        System.out.println("What is the student ID?");
        int studentId = input.nextInt();
        
        String result = school.findStudent(teacherName, studentId);
        System.out.println(result);
        
    }
}
