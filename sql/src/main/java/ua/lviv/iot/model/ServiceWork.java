package ua.lviv.iot.model;

import ua.lviv.iot.connection.ConnectionManager;

import java.sql.*;

public class ServiceWork {
    private static final String FIND_ALL = "SELECT * FROM `service_work`";
    private static final String FIND_BY_ID = "SELECT * FROM `service_work` WHERE id=?";
    private static final String CREATE = "INSERT INTO `service_work` (id, master, price_of_master, service_price, time) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE `service_work` SET id=?, master=?, price_of_master=?, service_price=?, time=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM `service_work` WHERE id=?";

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

    public void create(Integer id, String master, Double priceOfMaster, Double servicePrice, Time time) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, id);
            ps.setString(2, master);
            ps.setDouble(3, priceOfMaster);
            ps.setDouble(4, servicePrice);
            ps.setDouble(5, servicePrice);
            ps.setTime(6, time);
            ps.executeUpdate();
        }
    }

    public void update(Integer id, String master, Double priceOfMaster, Double servicePrice, Time time) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
        	ps.setInt(1, id);
            ps.setString(2, master);
            ps.setDouble(3, priceOfMaster);
            ps.setDouble(4, servicePrice);
            ps.setDouble(5, servicePrice);
            ps.setTime(6, time);

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
            System.out.print("{, master: " + resultSet.getString("master"));
            System.out.print("{, price_of_master: " + resultSet.getDouble("price_of_master"));
            System.out.print("{, service_price: " + resultSet.getDouble("service_price"));
            System.out.print("{, time: " + resultSet.getTime("time"));
            System.out.println("}");
        }
    }
}