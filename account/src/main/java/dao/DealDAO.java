package dao;

import domain.Deal;

import java.sql.*;
import java.util.*;

public class DealDAO {

    public List<Deal> findAll() {
        List<Deal> list = new ArrayList<>();

        String sql = "SELECT * FROM Deal";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Deal(
                        rs.getInt("id"),
                        rs.getString("agreement"),
                        rs.getString("tiker"),
                        rs.getString("order"),
                        rs.getString("number"),
                        rs.getTimestamp("date"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getDouble("totalCost"),
                        rs.getString("trader"),
                        rs.getDouble("commission")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Deal findById(int id) {
        String sql = "SELECT * FROM Deal WHERE id=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Deal(
                        rs.getInt("id"),
                        rs.getString("agreement"),
                        rs.getString("tiker"),
                        rs.getString("order"),
                        rs.getString("number"),
                        rs.getTimestamp("date"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getDouble("totalCost"),
                        rs.getString("trader"),
                        rs.getDouble("commission")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insert(Deal d) {
        String sql = "INSERT INTO Deal(agreement, tiker, \"order\", number, date, quantity, price, totalCost, trader, commission) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, d.getAgreement());
            ps.setString(2, d.getTiker());
            ps.setString(3, d.getOrder());
            ps.setString(4, d.getNumber());
            ps.setTimestamp(5, d.getDate());
            ps.setInt(6, d.getQuantity());
            ps.setDouble(7, d.getPrice());
            ps.setDouble(8, d.getTotalCost());
            ps.setString(9, d.getTrader());
            ps.setDouble(10, d.getCommission());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Deal d) {
        String sql = "UPDATE Deal SET agreement=?, tiker=?, \"order\"=?, number=?, date=?, quantity=?, price=?, totalCost=?, trader=?, commission=? WHERE id=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, d.getAgreement());
            ps.setString(2, d.getTiker());
            ps.setString(3, d.getOrder());
            ps.setString(4, d.getNumber());
            ps.setTimestamp(5, d.getDate());
            ps.setInt(6, d.getQuantity());
            ps.setDouble(7, d.getPrice());
            ps.setDouble(8, d.getTotalCost());
            ps.setString(9, d.getTrader());
            ps.setDouble(10, d.getCommission());
            ps.setInt(11, d.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Deal WHERE id=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}