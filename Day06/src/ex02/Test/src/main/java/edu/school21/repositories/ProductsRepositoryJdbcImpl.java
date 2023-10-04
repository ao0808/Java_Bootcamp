package ex02.Test.src.main.java.edu.school21.repositories;
import ex02.Test.src.main.java.edu.school21.models.Product;
import ex02.Test.src.main.java.edu.school21.repositories.ProductsRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ProductsRepositoryJdbcImpl implements ProductsRepository{
    private DataSource dataSource;

    public ProductsRepositoryJdbcImpl(DataSource dataSourceIn){
        dataSource = dataSourceIn;
    }
    @Override
    public List<Product> findAll(){
        List<Product> listProduct = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             PreparedStatement st = con.prepareStatement("SELECT * FROM shop.product"))
        {
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()){
                Product productTmp = new Product (resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getLong(3));
                System.out.println(resultSet.getLong(1));
                listProduct.add(productTmp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listProduct;
    };
    @Override
    public Optional<Product> findById(Long id){
        try (Connection connection =dataSource.getConnection();
        PreparedStatement st = connection.prepareStatement("SELECT * FROM shop.product WHERE identifier =" + id))
        {
            ResultSet resultSet = st.executeQuery();
            if(!resultSet.next()){
                return Optional.empty();
            };
            Product productTmp = new Product(resultSet.getLong(1), resultSet.getString(2),
                    resultSet.getLong(3));
            return Optional.of(productTmp);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };


    @Override
    public void update(Product product){
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE shop.product SET name = ?, " +
                    "price = ? WHERE identifier = ?");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setLong(2, product.getPrice());
            preparedStatement.setLong(3, product.getIdentifier());
            preparedStatement.execute();
            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    };
    @Override
    public void save(Product product) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement st = con.prepareStatement("INSERT INTO shop.product(name, price) VALUES (?, ?);")) {
            st.setString(1, product.getName());
            st.setLong(2, product.getPrice());
            st.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void delete(Long id) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement st = con.prepareStatement("DELETE FROM shop.product WHERE identifier = " + id)){
            st.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
