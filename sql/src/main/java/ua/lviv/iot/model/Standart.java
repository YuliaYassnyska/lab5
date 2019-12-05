package ua.lviv.iot.model;

import ua.lviv.iot.connection.ConnectionManager;

import java.sql.*;

public class Standart {
    private static final String FIND_ALL = "SELECT * FROM `standart`";
    private static final String FIND_BY_ID = "SELECT * FROM `standart` WHERE id=?";
    private static final String CREATE = "INSERT INTO `standart` (id, pay, date) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE `standart` SET id=?, pay=?, date=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM `standart` WHERE id=?";

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

    public void create(Integer id, Double pay, Date date) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, id);
            ps.setDouble(2, pay);
            ps.setDate(3, date);
            ps.executeUpdate();
        }
    }

    public void update(Integer id, Double pay, Date date) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
        	ps.setInt(1, id);
            ps.setDouble(2, pay);
            ps.setDate(3, date);

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
            System.out.print("{, pay: " + resultSet.getDouble("pay"));
            System.out.print("{, date: " + resultSet.getDate("date"));
            System.out.println("}");
        }
    }
}