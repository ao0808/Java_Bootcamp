package ex02;

public class UsersArrayList {
    private User[] pulUsers;
    private Integer countUser;
    private Integer sizePul;

    public UsersArrayList(){
        pulUsers = new User[10];
        sizePul = 10;
        countUser = 0;
    }

    public void addUser(User newUser){
        checkMember();
        pulUsers[countUser++] = newUser;
    }


    public void checkMember(){
        if(countUser >= sizePul){
            addMember();
        }
    }

    public void addMember(){
        User[] tmp = new User[sizePul * 2];
        for (int i = 0; i < sizePul; i++) {
            tmp[i] = pulUsers[i];
        }
        pulUsers = tmp;
        sizePul = sizePul * 2;
    }

    public User getUserById(Integer id){
        for (int i = 0; i < countUser; i++){
            if(id == pulUsers[i].getId()){
                return pulUsers[i];
            }
        }
        throw new UserNotFoundException("User with id " + id + " not found");
    }

    public User getUserByIndex(Integer index){
        if (index <= countUser && index >= 0) {
            return pulUsers[index];
        }
        throw new UserNotFoundException("User with index " + index + " not found");
    }

    public Integer getCountUser(){
        return countUser;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("UsersList: number of users: " + this.countUser + " size " + this.sizePul + "\n");
        for (int i = 0; i < this.countUser; i++) {
            s.append(pulUsers[i]).append("\n");
        }
        return s.toString();
    }
}


