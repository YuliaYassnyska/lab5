package ua.lviv.iot.model;

import ua.lviv.iot.connection.ConnectionManager;

import java.sql.*;

public class Address {
    private static final String FIND_ALL = "SELECT * FROM `address`";
    private static final String FIND_BY_ID = "SELECT * FROM `address` WHERE id=?";
    private static final String CREATE = "INSERT INTO `address` (id, street, number, city, country) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE `address` SET id=?, street=?, number=?, city=?, country=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM `address` WHERE id=?";

    public void findAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                print(resultSet);
            }
        }
    }

    public void findById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                print(resultSet);
            }
        }
    }

    public void create(Integer id, String street, Integer number, String city, String country) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, id);
            ps.setString(2, street);
            ps.setInt(3, number);
            ps.setString(4, city);
            ps.setString(5, country);
            ps.executeUpdate();
        }
    }

    public void update(Integer id, String street, Integer number, String city, String country) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
        	ps.setInt(1, id);
            ps.setString(2, street);
            ps.setInt(3, number);
            ps.setString(4, city);
            ps.setString(5, country);

            ps.executeUpdate();
        }
    }

    public void delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private void print(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.print("{id: " + resultSet.getInt("id"));
            System.out.print("{, street: " + resultSet.getString("street"));
            System.out.print("{, number: " + resultSet.getInt("number"));
            System.out.print("{, city: " + resultSet.getString("city"));
            System.out.print("{, contry: " + resultSet.getString("country"));
            System.out.println("}");
        }
    }
}