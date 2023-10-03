package ex01.Chat.src.main.java.edu.school21.chat.app;

import ex01.Chat.src.main.java.edu.school21.chat.models.Message;
import ex01.Chat.src.main.java.edu.school21.chat.repositories.JdbcDataSource;
import ex01.Chat.src.main.java.edu.school21.chat.repositories.MessagesRepository;
import ex01.Chat.src.main.java.edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main(String[] args)  {
        JdbcDataSource dataSource = new JdbcDataSource();
        MessagesRepository repository = new MessagesRepositoryJdbcImpl(dataSource.getDataSource());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a message ID");
            try {
                String str = scanner.nextLine();

                if ("exit".equals(str)) {
                    System.exit(0);
                }
                long id = Long.parseLong(str);
                Optional<Message> message = repository.findById(id);

                if (message != null && message.isPresent()) {
                    System.out.println(message.get());
                } else {
                    System.out.println("Message not found");
                }
            } catch (NumberFormatException e) {
                System.out.print("Wrong id ");
                System.out.println(e.getMessage());
            }
        }
    }
}
