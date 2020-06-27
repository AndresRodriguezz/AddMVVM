package co.and.addmvvm;

/**
 * Created by Andres Rodriguez 25/06/2020
 */

public class User {
    private String name;
    private String age;

    public User() {
    }

    //Builders
    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
