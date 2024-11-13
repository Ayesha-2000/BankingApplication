package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.DBConnection;

public class DepositDAO {
	public boolean deposit(long amount, long accno) {
        boolean isSuccess = false;
        try {
        	System.out.println("account Number"+accno);
        	System.out.println("Deposte Ammount"+amount);
            Connection con = DBConnection.getCon();
            String updateQuery = "UPDATE BANKACCOUNT SET ACCBALANCE = ACCBALANCE + ? WHERE ACCNO = ?";
            PreparedStatement ps = con.prepareStatement(updateQuery);
            ps.setLong(1, amount);
            ps.setLong(2, accno);
            int k = ps.executeUpdate();
            if (k > 0) {
                isSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
