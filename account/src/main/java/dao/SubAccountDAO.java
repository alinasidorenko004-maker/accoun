package dao;

import domain.SubAccount;

import java.sql.*;
import java.util.*;

public class SubAccountDAO {

    public List<SubAccount> findAll() {
        List<SubAccount> list = new ArrayList<>();

        String sql = "SELECT s.*, a.name AS accountPlanName " +
                     "FROM SubAccount s JOIN AccountPlan a ON s.accountPlanId = a.id";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                SubAccount s = new SubAccount(
                        rs.getInt("id"),
                        rs.getInt("accountPlanId"),
                        rs.getString("name"),
                        rs.getString("number")
                );
                s.setAccountPlanName(rs.getString("accountPlanName"));

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insert(SubAccount s) {
        String sql = "INSERT INTO SubAccount(accountPlanId, name, number) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, s.getAccountPlanId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getNumber());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(SubAccount s) {
        String sql = "UPDATE SubAccount SET accountPlanId=?, name=?, number=? WHERE id=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, s.getAccountPlanId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getNumber());
            ps.setInt(4, s.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM SubAccount WHERE id=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}