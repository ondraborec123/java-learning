import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.LocalDate;

class Student {
    String name;
    LocalDate birthday;
    public Student(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }
}

public class StudentList {
    static Student[] studentList() {
        int i = 0;
        File file = new File("students.txt");

        try( Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) { scanner.nextLine(); i++; }
        } catch( FileNotFoundException e) { System.out.print("File not found"); }
        Student[] list = new Student[i];

        int y = -1;
        try( Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String row = scanner.nextLine(); y++;
                String[] splitArray = row.split("\\|");
                String[] splitArrayBd = splitArray[1].split(",");
                LocalDate studentBd = LocalDate.of(Integer.parseInt(splitArrayBd[0]),Integer.parseInt(splitArrayBd[1]),Integer.parseInt(splitArrayBd[2]));
                list[y] = new Student(splitArray[0], studentBd);
            } } catch( FileNotFoundException e) { System.out.print("File not found"); }
        return list;
    }
}
