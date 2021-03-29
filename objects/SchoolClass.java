package sample.objects;

public class SchoolClass {
    private int number;
    private String letter;
    private int numberOfPupils;


    public SchoolClass() {
    }

    public SchoolClass(int class_number, String class_letter, int number_of_pupils) {
        this.number = class_number;
        this.letter = class_letter;
        this.numberOfPupils = number_of_pupils;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getNumberOfPupils() {
        return numberOfPupils;
    }

    public void setNumberOfPupils(int numberOfPupils) {
        this.numberOfPupils = numberOfPupils;
    }
}
