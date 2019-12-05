package ua.lviv.iot.model;

import ua.lviv.iot.connection.ConnectionManager;

import java.sql.*;

public class ServicedCompany {
    private static final String FIND_ALL = "SELECT * FROM `serviced_company`";
    private static final String FIND_BY_ID = "SELECT * FROM `serviced_company` WHERE id=?";
    private static final String CREATE = "INSERT INTO `serviced_company` (id, name, email, staff) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE `serviced_company` SET id=?, name=?, email=?, staff=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM `serviced_company` WHERE id=?";

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

    public void create(Integer id, String name, String email, Integer staff) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setInt(4, staff);
            ps.executeUpdate();
        }
    }

    public void update(Integer id, String name, String email, Integer staff) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
        	ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setInt(4, staff);

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
            System.out.print("{, name: " + resultSet.getString("name"));
            System.out.print("{, email: " + resultSet.getString("email"));
            System.out.print("{, staff: " + resultSet.getInt("staff"));
            System.out.println("}");
        }
    }
}