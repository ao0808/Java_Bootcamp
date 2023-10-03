package ex03.Chat.src.main.java.edu.school21.chat.repositories;

import ex03.Chat.src.main.java.edu.school21.chat.models.Message;

import java.sql.SQLException;
import java.util.Optional;

public interface MessagesRepository {
    Optional<Message> findById(Long id);
    void save(Message message) throws SQLException;
    void update(Message message) throws SQLException;
}
