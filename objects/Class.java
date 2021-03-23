package sample.objects;

public class Class {
    private int number;
    private char letter;
    private int numberOfPupils;

    public Class(int number, char letter, int numberOfPupils) {
        this.number = number;
        this.letter = letter;
        this.numberOfPupils = numberOfPupils;
    }

    public Class() {
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
