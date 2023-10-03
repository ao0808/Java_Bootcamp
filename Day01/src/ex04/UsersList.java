package ex04;

public interface UsersList {
    void addUser(User newUser);
    User getUserById(Integer id);
    User getUserByIndex(Integer index);
    Integer getCountUser();
}
