package sample.objects;

public class SchoolClass {
    private int number;
    private char letter;
    private int numberOfPupils;

    public SchoolClass(int number, char letter, int numberOfPupils) {
        this.number = number;
        this.letter = letter;
        this.numberOfPupils = numberOfPupils;
    }

    public SchoolClass() {
    }

    public SchoolClass(int class_number, String class_letter, int number_of_pupils) {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getNumberOfPupils() {
        return numberOfPupils;
    }

    public void setNumberOfPupils(int numberOfPupils) {
        this.numberOfPupils = numberOfPupils;
    }
}
