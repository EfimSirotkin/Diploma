package sample.objects;

import java.util.ArrayList;

public class Pupil {

    private String fullName;
    private String mail;
    private int age;
    private char sex;
    private ArrayList<Grade> pupilGrades;
    private SchoolClass pupilClass;

    public Pupil(String fullName, String mail, int age, char sex) {
        this.fullName = fullName;
        this.mail = mail;
        this.age = age;
        this.sex = sex;
        pupilGrades = new ArrayList<>(5);
        pupilClass = new SchoolClass();
    }

    public void setPupilGrades(ArrayList<Grade> pupilGrades) {
        this.pupilGrades = pupilGrades;
    }

    public ArrayList<Grade> getPupilGrades() {
        return pupilGrades;
    }

    public SchoolClass getPupilClass() {
        return pupilClass;
    }

    public void setPupilClass(SchoolClass pupilClass) {
        this.pupilClass = pupilClass;
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
