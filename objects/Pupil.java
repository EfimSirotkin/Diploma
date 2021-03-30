package sample.objects;

import java.util.ArrayList;

public class Pupil extends Person{

    private ArrayList<Grade> pupilGrades;
    private SchoolClass pupilClass;

    public Pupil(String fullName, String mail, int age, char sex, ArrayList<Grade> pupilGrades, SchoolClass pupilClass) {
        super(fullName,mail,age,sex);
        this.pupilGrades = pupilGrades;
        this.pupilClass = pupilClass;
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

    public void printPupil()
    {
        super.printPerson();
        System.out.println("Учится в: " + + this.getPupilClass().getNumber() + " " + this.getPupilClass().getLetter());
        System.out.print("Оценки: ");
        for(Grade grade : this.getPupilGrades())
            System.out.print(" " + grade.getValue() + "[" + grade.getDateTime() + "]");
        System.out.println();
    }
}
