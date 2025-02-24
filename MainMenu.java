import java.util.Scanner;

public class MainMenu
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("How many classrooms you want to add?");
        int n = CheckNum(input);
        input.nextLine();

        School school = new School(n);

        for (int i = 0; i < n; i++)
        {
            System.out.println("Enter teacher's name for classroom " + (i + 1));
            String teacherName = input.nextLine();

            System.out.println("How many students in classroom " + (i + 1) + "?");
            int x = CheckNum(input);
            input.nextLine();

            Student[] students = new Student[x];
            for (int j = 0; j < x; j++)
            {
                System.out.println("Enter student name for student #" + (j + 1));
                String studentName = input.nextLine();
                System.out.println("Enter student ID for student #" + (j + 1));
                int studentId = CheckidNum(input);
                input.nextLine();
                students[j] = new Student(studentName, studentId);
            }

            school.addClassroom(i, new Classroom(teacherName, students));
        }

        System.out.println("What is the name of the teacher of the student you are looking for?");
        String teacherName = input.nextLine();

        System.out.println("What is the student ID?");
        int studentId = CheckidNum(input);

        String result = school.findStudent(teacherName, studentId);
        System.out.println("The student is " + result + ".");
    }

    private static int CheckNum(Scanner input)
    {
        while (true)
        {
            if (input.hasNextInt())
            {
                int value = input.nextInt();
                if (value > 0)
                {
                    return value;
                }
                else
                {
                    System.out.println("Please enter the number that is equal or greater than 1.");
                }
            }
            else
            {
                System.out.println("Please enter a valid number.");
                input.next();
            }
        }
    }

    private static int CheckidNum(Scanner input)
    {
        while (true)
        {
            if (input.hasNextInt())
            {
                int value = input.nextInt();
                String idString = Integer.toString(value);
                if (idString.length() == 9)
                {
                    return value;
                }
                else
                {
                    System.out.println("Please enter a 9-digit ID Number.");
                }
            } 
            else
            {
                System.out.println("Please enter a valid ID Number.");
                input.next();
            }
        }
    }
}
