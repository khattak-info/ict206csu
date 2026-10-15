import topic07ObjectsAndClasses.classes.Student;

public class Admission {
    public static void main(String[] args){
        Student csumark007 = new Student("Mark", 20, 85.5);

        csumark007.info();
        csumark007.setGrade(90.0);
        csumark007.info();
    }
}
