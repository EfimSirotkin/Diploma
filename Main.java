package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.dbcommunicator.DatabaseConnection;
import sample.dbcommunicator.DatabaseObjectInitializer;
import sample.objects.*;


import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance("jdbc:postgresql://localhost:5432/test_db", "postgres", "admin12345");
        ArrayList<SchoolClass> schoolClass = DatabaseObjectInitializer.retrieveClasses();
        for (SchoolClass oneClass : schoolClass)
            System.out.println("  " + oneClass.getNumber() + "  " + oneClass.getLetter() + "  " + oneClass.getNumberOfPupils());

        ArrayList<Subject> schoolSubjects = DatabaseObjectInitializer.retrieveSubjects();
        for (Subject oneSubject : schoolSubjects)
            System.out.println("  " + oneSubject.getSubjectName());

        ArrayList<Teacher> schoolTeachers = DatabaseObjectInitializer.retrieveTeachers();
        for (Teacher oneTeacher : schoolTeachers) {
            System.out.println(oneTeacher.getFullName() + "  " + oneTeacher.getMail() + "  " + oneTeacher.getAge());
            for (Subject teacherSubject : oneTeacher.getSubjects())
                System.out.println(teacherSubject.getSubjectName());
        }

        ArrayList<Pupil> schoolPupils = DatabaseObjectInitializer.retrievePupils();
        for (Pupil onePupil : schoolPupils) {
            System.out.println(onePupil.getFullName() + " " + onePupil.getMail() + "  " + onePupil.getAge());
            System.out.println(onePupil.getPupilClass().getNumber() + " " + onePupil.getPupilClass().getLetter() + " " + +onePupil.getPupilClass().getNumberOfPupils());
            for (Grade pupilGrades : onePupil.getPupilGrades()) {
                System.out.println(pupilGrades.getDateTime() + " " + pupilGrades.getValue());
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
