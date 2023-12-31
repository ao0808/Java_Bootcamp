package ex02.Chat.src.main.java.edu.school21.chat.repositories;

import ex02.Chat.src.main.java.edu.school21.chat.models.Message;

import java.sql.SQLException;
import java.util.Optional;

public interface MessagesRepository {
    Optional<Message> findById(Long id);
    void save(Message message) throws SQLException;
}
