package sample.objects;

import java.util.ArrayList;

public class Teacher extends Person {


    private String qualification;
    private ArrayList<Subject> subjects;


    public Teacher(String fullName, String mail, int age, char sex, String qualification) {
        super(fullName,mail,age,sex);
        this.qualification = qualification;
    }

    public Teacher(String fullName, String mail, int age, char sex, String qualification, ArrayList<Subject> subjects) {
        super(fullName,mail,age,sex);
        this.qualification = qualification;
        this.subjects = subjects;
    }


    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }


    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
