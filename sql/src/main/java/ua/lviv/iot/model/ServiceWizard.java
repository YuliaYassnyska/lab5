package ua.lviv.iot.model;

import ua.lviv.iot.connection.ConnectionManager;

import java.sql.*;

public class ServiceWizard {
    private static final String FIND_ALL = "SELECT * FROM `service_wizard`";
    private static final String FIND_BY_ID = "SELECT * FROM `service_wizard` WHERE id=?";
    private static final String CREATE = "INSERT INTO `service_wizard` (id, first_name, second_name) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE `service_wizard` SET id=?, first_name=?, second_name=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM `service_wizard` WHERE id=?";

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

    public void create(Integer id, String firstName, String secondName) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, id);
            ps.setString(2, firstName);
            ps.setString(3, secondName);
            ps.executeUpdate();
        }
    }

    public void update(Integer id, String firstName, String secondName) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
        	ps.setInt(1, id);
            ps.setString(2, firstName);
            ps.setString(3, secondName);

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
            System.out.print("{, first_name: " + resultSet.getString("first_name"));
            System.out.print("{, second_name: " + resultSet.getString("second_name"));
            System.out.println("}");
        }
    }
}