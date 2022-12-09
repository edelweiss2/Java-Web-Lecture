package ch07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class PlayerDao {
	public static Connection getConnection() {
		Connection conn;
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/world");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}	
	
	public void deletePlayer(int backNumber) {
		Connection conn = getConnection();
		String sql = "UPDATE player SET isDeleted = 1 WHERE backNumber = ?;";
		
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, backNumber);
			
			pStmt.executeUpdate();
			pStmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void updatePlayer(Player p) {
		Connection conn = getConnection();		
		String sql = "UPDATE player SET name = ?, position = ?, bday = ?, height = ?, isDeleted = ? WHERE backNumber = ?;";
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, p.getName());
			pStmt.setString(2, p.getPosition());
			pStmt.setString(3, p.getBday().toString());
			pStmt.setInt(4, p.getHeight());			
			pStmt.setInt(5, p.getIsDeleted());			
			pStmt.setInt(6, p.getBackNumber());			
			
			
			pStmt.executeUpdate();
			pStmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Player getPlayer (int backNumber) {
		Connection conn = getConnection();
		String sql = "SELECT * FROM Player WHERE backNumber=?;";
		Player p = new Player();
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, backNumber);
			
			//select 실행
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				p.setBackNumber(rs.getInt(1));
				p.setName(rs.getNString(2));
				p.setPosition(rs.getString(3));
				p.setBday(LocalDate.parse(rs.getString(4)));
				p.setHeight(rs.getInt(5));
				p.setIsDeleted(rs.getInt(6));
			}
			rs.close();
			pStmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public List<Player> getPlayers() {
		Connection conn = getConnection();
		
		List<Player> list = new ArrayList<>();
		String sql = "SELECT * FROM Player WHERE isdeleted=0;";
		try {
			Statement stmt = conn.createStatement();			
			
			//select 실행
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Player p = new Player();
				p.setBackNumber(rs.getInt(1));
				p.setName(rs.getNString(2));
				p.setPosition(rs.getString(3));
				p.setBday(LocalDate.parse(rs.getString(4)));
				p.setHeight(rs.getInt(5));
				p.setIsDeleted(rs.getInt(6));
				list.add(p);
			}
			rs.close();
			stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
	
	
}
