public class Main {
    public static void main(String[] args) {
        for (Student x : StudentList.studentList()) {
            System.out.println(x.name + " " + x.birthday);
        }
    }
}
