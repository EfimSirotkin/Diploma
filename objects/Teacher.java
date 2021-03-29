package sample.objects;

import java.util.ArrayList;

public class Teacher {

    private String fullName;
    private String mail;
    private int age;
    private int sex;
    private String qualification;
    private ArrayList<Subject> subjects;


    public Teacher(String fullName, String mail, int age, char sex, String qualification) {
        this.fullName = fullName;
        this.mail = mail;
        this.age = age;
        this.sex = sex;
        this.qualification = qualification;
    }

    public Teacher(String fullName, String mail, int age, int sex, String qualification, ArrayList<Subject> subjects) {
        this.fullName = fullName;
        this.mail = mail;
        this.age = age;
        this.sex = sex;
        this.qualification = qualification;
        this.subjects = subjects;
    }

    public Teacher(String full_name, String mail, int age, int sex, String qualification) {
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
