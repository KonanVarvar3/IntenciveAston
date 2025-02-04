package Models;

import java.util.Objects;

public class User {

    private String name;
    private String surname;
    private int age;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s {name: %s, surname: %s, age: %d}", getClass().getName(), name, surname, age);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        User user = (User) obj;
        return user.age == this.age
                && Objects.equals(this.name, user.name)
                && Objects.equals(this.surname, user.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, surname);
    }

//    @Override
//    public boolean equals(Object obj) {
//        if(this == obj) return true;
//        if(obj == null || obj.getClass() != this.getClass()) return false;
//        User user = (User) obj;
//        return user.age == this.age
//                && (this.name == user.name || (this.name != null && this.name.equals(user.name)))
//                && (this.surname == user.surname || (this.surname != null && this.surname.equals(user.surname)));
//    }

//    @Override
//    public int hashCode() {
//        final int constNumber = 31;
//        int result = 1;
//        result = constNumber * result + age;
//        result = constNumber * result + (name == null ? 0 : name.hashCode());
//        result = constNumber * result + (surname == null ? 0 : surname.hashCode());
//        return result;
//    }
}
