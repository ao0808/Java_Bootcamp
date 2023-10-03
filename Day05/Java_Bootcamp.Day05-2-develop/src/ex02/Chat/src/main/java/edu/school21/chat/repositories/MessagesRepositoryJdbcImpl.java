package ex02.Chat.src.main.java.edu.school21.chat.repositories;

import ex02.Chat.src.main.java.edu.school21.chat.models.Chatroom;
import ex02.Chat.src.main.java.edu.school21.chat.models.Message;
import ex02.Chat.src.main.java.edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private final DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) {
        String mQuery = "SELECT * FROM chat.message WHERE id = " + id;

        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(mQuery);

            if (!rs.next()) {
                return null;
            }
            Long userId = rs.getLong(2);
            Long roomId = rs.getLong(3);
            User user = findUser(userId);
            Chatroom room = findChat(roomId);
            return Optional.of(new Message(rs.getLong(1), user, room,
                    rs.getString(4), rs.getTimestamp(5).toLocalDateTime()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    private User findUser(Long id) throws SQLException {
        String uQuery = "SELECT * FROM chat.user WHERE id = " + id;

        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(uQuery);

            if (!rs.next()) {
                return null;
            }
            return new User(id, rs.getString(2), rs.getString(3), new ArrayList<>(), new ArrayList<>());
        }
    }

    private Chatroom findChat(Long id) throws SQLException {
        String cQuery = "SELECT * FROM chat.chatroom WHERE id = " + id;

        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(cQuery);

            if (!rs.next()) {
                return null;
            }
            return new Chatroom(id, rs.getString(2), null, null);
        }
    }

    public void save(Message message) throws SQLException {
        Connection con = dataSource.getConnection();
        Long userId = message.getAuthor().getId();
        String localDateTime = "'" + Timestamp.valueOf(message.getLocalDateTime()) + "'";
        PreparedStatement pSt = con.prepareStatement("INSERT INTO chat.message (author, room, text, localDateTime)" +
                "VALUES(?, ?, ?, ?);");
 //       pSt.setLong(1, message.getId());
        pSt.setLong(1, message.getAuthor().getId());
        pSt.setLong(2, message.getRoom().getId());
        pSt.setString(3, message.getText());
        pSt.setTimestamp(4,Timestamp.valueOf(message.getLocalDateTime()));

        pSt.execute();

        String sqlQuery = "SELECT MAX(id) FROM chat.message WHERE author = ?";
        pSt = con.prepareStatement(sqlQuery);
        pSt.setLong(1, userId);
        ResultSet resultSet = pSt.executeQuery();
        resultSet.next();
        message.setId(resultSet.getLong(1));
    }
}
