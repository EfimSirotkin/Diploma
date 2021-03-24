package sample.dbcommunicator;

import sample.objects.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DatabaseObjectInitializer {

    /*
CREATE TABLE public.classes
(
    class_id integer NOT NULL,
    class_number integer NOT NULL,
    class_letter character varying(2) COLLATE pg_catalog."default" NOT NULL,
    number_of_pupils integer,
    CONSTRAINT classes_pkey PRIMARY KEY (class_id, class_number, class_letter)
)
* */

    public static ArrayList<SchoolClass> retrieveClasses() throws SQLException {
        ArrayList<SchoolClass> classes = new ArrayList<SchoolClass>(5);
        ResultSet rs = DatabaseManipulator.generateSelectStatement("classes", "*");
        while (rs.next()) {
            classes.add(new SchoolClass(rs.getInt("class_number"), rs.getString("class_letter"), rs.getInt("number_of_pupils")));
        }
        return classes;
    }

    /*
    CREATE TABLE public.subjects
    (
    subject_id integer NOT NULL,
    subject_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT subjects_pkey PRIMARY KEY (subject_id)
    )
     */

    public static ArrayList<Subject> retrieveSubjects() throws SQLException {
        ArrayList<Subject> subjects = new ArrayList<Subject>(5);
        try {
            ResultSet rs = DatabaseManipulator.generateSelectStatement("subjects", "subject_name");

            while (rs.next()) {
                subjects.add(new Subject(rs.getString("subject_name")));
            }
        } catch (SQLException e) {
            System.out.println("Looks like something is wrong with the select in the subject's retrieval");
        }
        return subjects;
    }


    /*
    CREATE TABLE public.teachers
(
    teacher_id integer NOT NULL,
    full_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    mail character varying(100) COLLATE pg_catalog."default" NOT NULL,
    age integer NOT NULL,
    sex integer NOT NULL,
    qualification character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT teachers_pkey PRIMARY KEY (teacher_id)
)
     */

    public static ArrayList<Teacher> retrieveTeachers() throws SQLException {
        ArrayList<Teacher> teachers = new ArrayList<Teacher>(5);
        try {
            ResultSet rs = DatabaseManipulator.generateSelectStatement("teachers", "*");

            while (rs.next()) {
                teachers.add(new Teacher(rs.getString("full_name"),rs.getString("mail"), rs.getInt("age"), rs.getInt("sex"), rs.getString("qualification")));
            }
        } catch (SQLException e) {
            System.out.println("Looks like something is wrong in teacher's retrieval");
        }
        return teachers;
    }

    /*
    CREATE TABLE public.pupils
    (
    pupil_id integer NOT NULL,
    teacher_id integer NOT NULL,
    class_id integer NOT NULL,
    full_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    mail character varying(100) COLLATE pg_catalog."default" NOT NULL,
    age integer NOT NULL,
    sex integer NOT NULL,
    CONSTRAINT pupils_pkey PRIMARY KEY (pupil_id)
    )

    CREATE TABLE public.grades
    (
    pupil_id integer NOT NULL,
    subject_id integer NOT NULL,
    datetime_id timestamp without time zone NOT NULL,
    grade_value integer NOT NULL,
    CONSTRAINT grades_pkey PRIMARY KEY (pupil_id, subject_id, datetime_id)
    )


     */

    public static ArrayList<Pupil> retrievePupils() throws SQLException {
        ArrayList<Pupil> pupils = new ArrayList<Pupil>(5);
        try {

            ResultSet pupilsResultSet = DatabaseManipulator.generateSelectStatement("pupils", "*");

            while(pupilsResultSet.next()) {
                ArrayList<Grade> pupilGrades = new ArrayList<Grade>(5);
                int pupilID = pupilsResultSet.getInt("pupil_id");
                ResultSet pupilGradesRS = DatabaseManipulator.generateSelectStatement("grades", "");


            }
        }
    }
}


