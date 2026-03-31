package dao;

import domain.Operation;

import java.sql.*;
import java.util.*;

public class OperationDAO {

    public List<Operation> findAll() {
        List<Operation> list = new ArrayList<>();

        String sql = "SELECT o.*, d.number AS dealNumber, s.name AS subAccountName " +
                     "FROM Operation o " +
                     "JOIN Deal d ON o.dealId = d.id " +
                     "JOIN SubAccount s ON o.subAccountId = s.id";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Operation o = new Operation(
                        rs.getInt("id"),
                        rs.getInt("dealId"),
                        rs.getInt("subAccountId"),
                        rs.getString("number"),
                        rs.getDate("date"),
                        rs.getString("type"),
                        rs.getDouble("sum"),
                        rs.getDouble("saldoInput"),
                        rs.getDouble("saldoOutput")
                );

                o.setDealNumber(rs.getString("dealNumber"));
                o.setSubAccountName(rs.getString("subAccountName"));

                list.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insert(Operation o) {
        String sql = "INSERT INTO Operation(dealId, subAccountId, number, date, type, sum, saldoInput, saldoOutput) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, o.getDealId());
            ps.setInt(2, o.getSubAccountId());
            ps.setString(3, o.getNumber());
            ps.setDate(4, new java.sql.Date(o.getDate().getTime()));
            ps.setString(5, o.getType());
            ps.setDouble(6, o.getSum());
            ps.setDouble(7, o.getSaldoInput());
            ps.setDouble(8, o.getSaldoOutput());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Operation o) {
        String sql = "UPDATE Operation SET dealId=?, subAccountId=?, number=?, date=?, type=?, sum=?, saldoInput=?, saldoOutput=? WHERE id=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, o.getDealId());
            ps.setInt(2, o.getSubAccountId());
            ps.setString(3, o.getNumber());
            ps.setDate(4, new java.sql.Date(o.getDate().getTime()));
            ps.setString(5, o.getType());
            ps.setDouble(6, o.getSum());
            ps.setDouble(7, o.getSaldoInput());
            ps.setDouble(8, o.getSaldoOutput());
            ps.setInt(9, o.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Operation WHERE id=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}