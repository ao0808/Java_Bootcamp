package ex00.Reflectionfolder.src.main.java.classes;

import java.util.StringJoiner;

public class User {
    private String firstName;
    private String lastName;
    private Integer height;

    public User(){
        firstName = "Default first name";
        lastName = "Default last name";
        height = 0;
    }

    public User(String firstNameIn, String lastNameIn, Integer heightIn){
        firstName = firstNameIn;
        lastName = lastNameIn;
        height = heightIn;
    }

    public int grow(int value) {
        this.height += value;
        return height;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("height=" + height)
                .toString();
    }
}
