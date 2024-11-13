package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.DBConnection;

public class TransferDAO {
	    public boolean transfer(String sourceAccno, String targetAccno, double amount) {
	        boolean isSuccess = false;
	        try {
	            Connection con = DBConnection.getCon();
	            // Begin transaction
	            con.setAutoCommit(false);
	            // Deduct from source account
	            String deductQuery = "UPDATE BANKACCOUNT SET ACCBALANCE = ACCBALANCE - ? WHERE ACCNO = ?";
	            PreparedStatement deductPs = con.prepareStatement(deductQuery);
	            deductPs.setDouble(1, amount);
	            deductPs.setString(2, sourceAccno);
	            int rowsAffected1 = deductPs.executeUpdate();
	            if (rowsAffected1 > 0) {
	                // Add to target account
	               
String addQuery = "UPDATE BANKACCOUNT SET  ACCBALANCE =  ACCBALANCE+? WHERE ACCNO = ?";
	                PreparedStatement addPs = con.prepareStatement(addQuery);
	                addPs.setDouble(1, amount);
	                addPs.setString(2, targetAccno);
	                int rowsAffected2 = addPs.executeUpdate();
	                if (rowsAffected2 > 0) {
	                    con.commit();
	                    isSuccess = true;
	                } else {
	                    con.rollback();
	                }
	            } else {
	                con.rollback();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return isSuccess;
	    }
}
