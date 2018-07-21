package com.capgemini.walletapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.util.Util;
import com.capgemini.walletapplication.bean.WalletApplication;

public class WalletApplicationDao implements IWalletApplicationDao {

	static List<WalletApplication> list = new ArrayList<WalletApplication>();

	static ResultSet rs2, rs1, rs3, rs4;
	static Connection conn;
	Connection conn1;

	public int createAcc(WalletApplication obj) {
		int n1 = 0, n2 = 0;
		try {
			conn1 = Util.getConnection();
			String insert = "insert into Details values(?,?,?,?,?,?,?,?)";

			PreparedStatement pstat = conn1.prepareStatement(insert);
			pstat.setString(1, obj.getCust().getCustomerName());
			pstat.setLong(2, obj.getCust().getAadharNum());
			pstat.setString(3, obj.getCust().getUserName());
			pstat.setString(4, obj.getCust().getPassword());
			pstat.setString(5, obj.getCust().getGender());
			pstat.setInt(6, obj.getCust().getAge());
			pstat.setString(7, obj.getCust().getContact());
			pstat.setString(8, obj.getCust().getEmail());
			n1 = pstat.executeUpdate();

			String inser = "insert into walletApplication values(?,curdate(),?,?,?,?)";
			PreparedStatement pstat1 = conn1.prepareStatement(inser);
			pstat1.setLong(1, obj.getAccNum());
			pstat1.setDouble(2, obj.getAmount());
			pstat1.setString(3, obj.getBranch());
			pstat1.setString(4, obj.getAcctype());
			pstat1.setLong(5, obj.getCust().getAadharNum());
			n2 = pstat1.executeUpdate();
			if (n1 == 1 && n2 == 1) {
				return 1;
			} else {
				return 0;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return 0;

	}

	public boolean login(String username, String password) {
		try {
			conn = Util.getConnection();
			String select = "select * from Details where username='" + username + "' and password='" + password + "'";

			PreparedStatement pstat1 = conn.prepareStatement(select);
			rs1 = pstat1.executeQuery();

			if (rs1.first()) {
				int d = rs1.getInt(2);
				String select1 = "select * from walletapplication where aadharNo=" + d;
				PreparedStatement pstat = conn.prepareStatement(select1);
				rs2 = pstat.executeQuery();

			}
			if (rs2.first()) {
				return true;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public double showbal() {
		try {
			// Connection conn = Util.getConnection();
			if (rs2.first()) {
				return rs2.getDouble(3);
			}
		} /*
			 * catch (ClassNotFoundException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */ catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0.0;

	}

	public int deposit(double amount) {

		try {
			// Connection conn = Util.getConnection();
			if (rs2.first()) {

				double d = rs2.getDouble(3) + amount;
				String update = "update walletapplication set balance=" + d + " where aadharNo='" + rs2.getLong(6)
						+ "'";
				PreparedStatement pstat = conn.prepareStatement(update);
				if (pstat.executeUpdate() == 1) {

					long tID = (long) (Math.random() * 1234676567 + 9999);
					LocalDateTime dt = LocalDateTime.now();
					String s = "TransactionID   " + Long.toString(tID) + "  at  " + dt.toString() + " Rs."
							+ Double.toString(amount) + "  credited to your account";
					String insert = "insert into transactions values(" + rs2.getInt(6) + ",'" + s + "')";
					PreparedStatement pstat3 = conn.prepareStatement(insert);
					pstat3.executeUpdate();
					System.out.println("amount deposited successfully");
					int b = rs1.getInt(2);
					String select1 = "select * from walletapplication where aadharNo=" + b;
					PreparedStatement pstat1 = conn.prepareStatement(select1);
					rs2 = pstat1.executeQuery();
					return 1;
				}
			}
		} /*
			 * catch (ClassNotFoundException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */ catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	public int withdraw(double amount) {
		try {
			// Connection conn = Util.getConnection();
			if (rs2.first()) {
				double d = rs2.getDouble(3) - amount;
				String update = "update walletapplication set balance=" + d + " where aadharNo='" + rs2.getLong(6)
						+ "'";
				PreparedStatement pstat = conn.prepareStatement(update);
				if (pstat.executeUpdate() == 1) {

					long tID = (long) (Math.random() * 1234676567 + 9999);
					LocalDateTime dt = LocalDateTime.now();
					String s = "TransactionID   " + Long.toString(tID) + "  at  " + dt.toString() + " Rs."
							+ Double.toString(amount) + "  debited from your account";
					String insert = "insert into transactions values(" + rs2.getInt(6) + ",'" + s + "')";
					PreparedStatement pstat3 = conn.prepareStatement(insert);
					pstat3.executeUpdate();

					System.out.println("withdraw successful");
					int b = rs1.getInt(2);
					String select1 = "select * from walletapplication where aadharNo=" + b;
					PreparedStatement pstat1 = conn.prepareStatement(select1);
					rs2 = pstat1.executeQuery();
					return 1;
				}
			}
		} /*
			 * catch (ClassNotFoundException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */ catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public int fundTransfer(long accNum, double amount) {

		try {
			if (rs2.first()) {

				conn = Util.getConnection();
				String select = "select * from walletapplication where accNum=" + accNum;
				PreparedStatement pstat1 = conn.prepareStatement(select);
				rs3 = pstat1.executeQuery();
				if (rs3.first()) {
					double b = rs3.getDouble(3) + amount;
					String update = "update walletapplication set balance=" + b + " where aadharNo='" + rs3.getLong(6)
							+ "'";
					PreparedStatement pstat = conn.prepareStatement(update);
					pstat.executeUpdate();

					double d = rs2.getDouble(3) - amount;
					String update1 = "update walletapplication set balance=" + d + " where aadharNo='" + rs2.getLong(6)
							+ "'";
					PreparedStatement pstat2 = conn.prepareStatement(update1);

					if (pstat2.executeUpdate() == 1) {

						long tID = (long) (Math.random() * 1234676567 + 9999);
						LocalDateTime dt = LocalDateTime.now();
						String s = "TransactionID   " + Long.toString(tID) + "  at  " + dt.toString() + " Rs."
								+ Double.toString(amount) + " transfered to a/c" + accNum + " ";
						String insert = "insert into transactions values(" + rs2.getInt(6) + ",'" + s + "')";
						PreparedStatement pstat5 = conn.prepareStatement(insert);
						pstat5.executeUpdate();

						System.out.println("Rs." + amount + "is debited from your account");
						int c = rs1.getInt(2);
						String select1 = "select * from walletapplication where aadharNo=" + c;
						PreparedStatement pstat3 = conn.prepareStatement(select1);
						rs2 = pstat3.executeQuery();

						return 1;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public void printTransaction() {

		PreparedStatement pstat5;
		try {
			String select = "select * from transactions where aadharNum=" + rs2.getInt(6);
			pstat5 = conn.prepareStatement(select);
			rs4 = pstat5.executeQuery();
			while (rs4.next()) {
				System.out.println(rs4.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeConn() {
		// TODO Auto-generated method stub
		try {
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
