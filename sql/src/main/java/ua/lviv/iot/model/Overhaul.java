package ua.lviv.iot.model;

import ua.lviv.iot.connection.ConnectionManager;

import java.sql.*;

public class Overhaul {
    private static final String FIND_ALL = "SELECT * FROM `overhaul`";
    private static final String FIND_BY_ID = "SELECT * FROM `overhaul` WHERE id=?";
    private static final String CREATE = "INSERT INTO `overhaul` (id, change_discription, change_functions, changing_parts, date) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE `overhaul` SET id=?, change_discription=?, change_functions=?, changing_parts=?, date=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM `overhaul` WHERE id=?";

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

    public void create(Integer id, String changeDiscription, String changeFunctions, String changingParts, Date date) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, id);
            ps.setString(2, changeDiscription);
            ps.setString(3, changeFunctions);
            ps.setString(4, changingParts);
            ps.setDate(5, date);
            ps.executeUpdate();
        }
    }

    public void update(Integer id, String changeDiscription, String changeFunctions, String changingParts, Date date) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
        	ps.setInt(1, id);
            ps.setString(2, changeDiscription);
            ps.setString(3, changeFunctions);
            ps.setString(4, changingParts);
            ps.setDate(5, date);

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
            System.out.print("{, change_discription: " + resultSet.getString("change_discription"));
            System.out.print("{, change_functions: " + resultSet.getInt("change_functions"));
            System.out.print("{, changing_parts: " + resultSet.getString("changing_parts"));
            System.out.print("{, date: " + resultSet.getDate("date"));
            System.out.println("}");
        }
    }
}