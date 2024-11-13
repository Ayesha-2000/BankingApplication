package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBConnection;

public class LoginDAO {
	public boolean validate(String accno, String holderName) {
        boolean isValid = false;
        try {
            Connection con = DBConnection.getCon();
            String query = "SELECT * FROM BANKACCOUNT WHERE ACCNO=? AND ACCHOLDERNAME=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, accno);
            ps.setString(2, holderName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                isValid = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValid;
}
}