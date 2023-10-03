package ex02.Chat.src.main.java.edu.school21.chat.app;


import ex01.Chat.src.main.java.edu.school21.chat.repositories.JdbcDataSource;
import ex02.Chat.src.main.java.edu.school21.chat.models.Chatroom;
import ex02.Chat.src.main.java.edu.school21.chat.models.Message;
import ex02.Chat.src.main.java.edu.school21.chat.models.User;
import ex02.Chat.src.main.java.edu.school21.chat.repositories.MessagesRepository;
import ex02.Chat.src.main.java.edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws SQLException {
        JdbcDataSource dataSource = new JdbcDataSource();
        User creator = new User(2L, "user", "123", new ArrayList<>(), new ArrayList<>());
        User author = creator;
        Chatroom room = new Chatroom(3L, "room", creator, new ArrayList<>());
        Message message = new Message(null, author, room, "Hello from Lexa", LocalDateTime.now());
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource.getDataSource());
        messagesRepository.save(message);
        System.out.println(message.getId());
    }
}
