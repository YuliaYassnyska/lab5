package ua.lviv.iot.model;

import ua.lviv.iot.connection.ConnectionManager;

import java.sql.*;

public class CollectinCah {
    private static final String FIND_ALL = "SELECT * FROM `collectin_cah`";
    private static final String FIND_BY_ID = "SELECT * FROM `collectin_cah` WHERE id=?";
    private static final String CREATE = "INSERT INTO `collectin_cah` (id, number, date, time) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE `collectin_cah` SET id=?, number=?, date=?, time=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM `collectin_cah` WHERE id=?";

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

    public void create(Integer id, Double number, Date date, Time time) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, id);
            ps.setDouble(2, number);
            ps.setDate(3, date);
            ps.setTime(4, time);
            ps.executeUpdate();
        }
    }

    public void update(Integer id, Double number, Date date, Time time) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
        	ps.setInt(1, id);
            ps.setDouble(2, number);
            ps.setDate(3, date);
            ps.setTime(4, time);

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
            System.out.print("{, number: " + resultSet.getDouble("number"));
            System.out.print("{, date: " + resultSet.getDate("date"));
            System.out.print("{, time: " + resultSet.getTime("time"));
            System.out.println("}");
        }
    }
}