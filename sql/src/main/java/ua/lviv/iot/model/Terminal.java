package ua.lviv.iot.model;

import ua.lviv.iot.connection.ConnectionManager;

import java.sql.*;

public class Terminal {
    private static final String FIND_ALL = "SELECT * FROM `terminal`";
    private static final String FIND_BY_ID = "SELECT * FROM `terminal` WHERE id=?";
    private static final String CREATE = "INSERT INTO `terminal` (id, logo, function) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE `terminal` SET id=?, logo=?, function=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM `terminal` WHERE id=?";

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

    public void create(Integer id,  String logo, String function) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
        	ps.setInt(1, id);
            ps.setString(2, logo);
            ps.setString(3, function);
            ps.executeUpdate();
        }
    }

    public void update(Integer id,  String logo, String function) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
        	ps.setInt(1, id);
            ps.setString(2, logo);
            ps.setString(3, function);

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
            System.out.print("{, logo: " + resultSet.getString("logo"));
            System.out.print("{, function: " + resultSet.getString("function"));
            System.out.println("}");
        }
    }
}