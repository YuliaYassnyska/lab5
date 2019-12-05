package ua.lviv.iot.model;

import ua.lviv.iot.connection.ConnectionManager;

import java.sql.*;

public class Information {
    private static final String FIND_ALL = "SELECT * FROM `information`";
    private static final String FIND_BY_ID = "SELECT * FROM `information` WHERE id=?";
    private static final String CREATE = "INSERT INTO `information` (id, number, details, date, gps_coordinates) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE `information` SET id=?, number=?, details=?, gps_coordinates=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM `information` WHERE id=?";

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

    public void create(Integer id, Integer number, String details, Date date, Double gpsCoordinates) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, id);
            ps.setInt(2, number);
            ps.setString(3, details);
            ps.setDate(4, date);
            ps.setDouble(5, gpsCoordinates);
            ps.executeUpdate();
        }
    }

    public void update(Integer id, Integer number, String details, Date date,  Double gpsCoordinates) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
        	ps.setInt(1, id);
            ps.setInt(2, number);
            ps.setString(3, details);
            ps.setDate(4, date);
            ps.setDouble(5, gpsCoordinates);

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
            System.out.print("{, number: " + resultSet.getInt("number"));
            System.out.print("{, details: " + resultSet.getInt("details"));
            System.out.print("{, date: " + resultSet.getDate("date"));
            System.out.print("{, gps_coordinates: " + resultSet.getDouble("gps_coordinates"));
            System.out.println("}");
        }
    }
}