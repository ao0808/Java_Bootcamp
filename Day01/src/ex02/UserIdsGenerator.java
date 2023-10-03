package ex02;

public class UserIdsGenerator {
    private static ex01.UserIdsGenerator Object;
    private static Integer Identifier = 0;

    public static ex01.UserIdsGenerator getInstance() {
        if(Object == null) {
            Object = new ex01.UserIdsGenerator();
        }
        return Object;
    }

    public int generateId() {
        return ++Identifier;
    }

    public static Integer getIdentifier() {
        return Identifier;
    }
}
