package sample;

import com.sun.net.httpserver.HttpServer;
import javafx.application.Application;
import javafx.stage.Stage;
import sample.dbcommunicator.DatabaseConnection;
import sample.dbcommunicator.DatabaseObjectInitializer;
import sample.http.HttpServerSingleton;
import sample.json.JsonDeserializerSingleton;
import sample.json.JsonSerializerSingleton;
import sample.objects.*;


import java.util.ArrayList;

public class Main extends Application {

    public static ArrayList<Grade> grades;
    public static ArrayList<Pupil> pupils;
    public static ArrayList<SchoolClass> schoolClasses;
    public static ArrayList<Subject> schoolSubjects;
    public static ArrayList<Teacher> schoolTeachers;

    @Override
    public void start(Stage primaryStage) throws Exception {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance("jdbc:postgresql://localhost:5432/test_db", "postgres", "admin12345");

        pupils = DatabaseObjectInitializer.retrievePupils();
        schoolTeachers = DatabaseObjectInitializer.retrieveTeachers();
        schoolClasses = DatabaseObjectInitializer.retrieveClasses();
        schoolSubjects = DatabaseObjectInitializer.retrieveSubjects();

        HttpServer httpServerSingleton = HttpServerSingleton.getInstance("localhost", 8001, 4, 10);

        //ArrayList<SchoolClass> schoolClass = DatabaseObjectInitializer.retrieveClasses();
//        for (SchoolClass oneClass : schoolClass)
//            System.out.println("  " + oneClass.getNumber() + "  " + oneClass.getLetter() + "  " + oneClass.getNumberOfPupils());

       // ArrayList<Subject> schoolSubjects = DatabaseObjectInitializer.retrieveSubjects();
//      for (Subject oneSubject : schoolSubjects)
//            System.out.println("  " + oneSubject.getSubjectName());

       // ArrayList<Teacher> schoolTeachers = DatabaseObjectInitializer.retrieveTeachers();
//        for (Teacher oneTeacher : schoolTeachers) {
//            System.out.println(oneTeacher.getFullName() + "  " + oneTeacher.getMail() + "  " + oneTeacher.getAge());
//            for (Subject teacherSubject : oneTeacher.getSubjects())
//                System.out.println(teacherSubject.getSubjectName());
//        }

       // ArrayList<Pupil> schoolPupils = DatabaseObjectInitializer.retrievePupils();
//        for (Pupil onePupil : schoolPupils) {
//            System.out.println(onePupil.getFullName() + " " + onePupil.getMail() + "  " + onePupil.getAge());
//            System.out.println(onePupil.getPupilClass().getNumber() + " " + onePupil.getPupilClass().getLetter() + " " + +onePupil.getPupilClass().getNumberOfPupils());
//            for (Grade pupilGrades : onePupil.getPupilGrades()) {
//                System.out.println(pupilGrades.getDateTime() + " " + pupilGrades.getValue());
//            }
//        }

        JsonSerializerSingleton serializerSingleton = JsonSerializerSingleton.getInstance();
        JsonDeserializerSingleton deserializerSingleton = JsonDeserializerSingleton.getInstance();
//        String serializedClasses = serializerSingleton.serializeSchoolClasses(schoolClass);
//        for(SchoolClass oneClass : deserializerSingleton.deserializeSchoolClasses(serializedClasses))
//            oneClass.printClass();
//        ;
//
//        String serializedSubjects = serializerSingleton.serializeSchoolSubjects(schoolSubjects);
//        for(Subject oneSubject : deserializerSingleton.deserializeSchoolSubjects(serializedSubjects))
//            oneSubject.printSubject();

        for(Pupil onePupil : pupils)
            onePupil.printPupil();

//
        String serializedPupils = serializerSingleton.serializePupils(pupils);
        for(Pupil onePupil : deserializerSingleton.deserializePupils(serializedPupils))
            onePupil.printPupil();

        for(Teacher oneTeacher : schoolTeachers)
            oneTeacher.printTeacher();

        for(Subject oneSubject: schoolSubjects)
            oneSubject.printSubject();



        ArrayList<Pupil> pupils = deserializerSingleton.deserializePupils(serializedPupils);
//        String serializedTeachers = serializerSingleton.serializeTeachers(schoolTeachers);
//        for(Teacher oneTeacher : deserializerSingleton.deserializeTeachers(serializedTeachers))
//            oneTeacher.printTeacher();

       // HttpServer serverInstance = HttpServerSingleton.getInstance("localhost", 8081, 1, 10);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
