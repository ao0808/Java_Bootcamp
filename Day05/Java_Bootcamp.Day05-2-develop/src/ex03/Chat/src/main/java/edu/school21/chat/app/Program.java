package ex03.Chat.src.main.java.edu.school21.chat.app;

import ex03.Chat.src.main.java.edu.school21.chat.repositories.JdbcDataSource;
import ex03.Chat.src.main.java.edu.school21.chat.repositories.MessagesRepository;
import ex03.Chat.src.main.java.edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import ex03.Chat.src.main.java.edu.school21.chat.models.Message;
import ex03.Chat.src.main.java.edu.school21.chat.models.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class Program {
    public static void main(String[] args) throws SQLException {
        JdbcDataSource dataSource = new JdbcDataSource();
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource.getDataSource());
        Optional<Message> messageOptional = messagesRepository.findById(2L);
        if (messageOptional.isPresent()){
            Message message = messageOptional.get();
            message.setText("New Old аоаоа");
            User tmp = new User(4L, "Martirosian", "88888", new ArrayList<>(), new ArrayList<>());
            message.setAuthor(tmp);
            message.setLocalDateTime(null);
            messagesRepository.update(message);
        }
    }
}
