package sample.objects;

public class Person {

    private String fullName;
    private String mail;
    private int age;
    private int sex;


    public Person(String fullName, String mail, int age, int sex) {
        this.fullName = fullName;
        this.mail = mail;
        this.age = age;
        this.sex = sex;
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

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void printPerson() {
        System.out.println(this.getFullName() + " " + this.getMail() + " " + this.getAge() + " " + this.getSex());
    }
}
