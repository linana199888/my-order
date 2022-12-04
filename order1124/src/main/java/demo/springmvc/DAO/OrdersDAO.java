package demo.springmvc.DAO;

import java.sql.*;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import demo.springmvc.model.Order_main;  

public class OrdersDAO {  
	//連線
	public static Connection getConnection() {
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/gjun_project?serverTimezone=Asia/Taipei";
		String user="root";
		String password="870527";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				conn=DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		}
	//read查詢
	public static List<Order_main> readOrder() {
		List<Order_main> data=new ArrayList<>();
		//資料庫連線
		Connection conn=getConnection();
		String sql="select * from gjun_project.order_main";

		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
		    while(rs.next()) { 
		    	String ORDER_ID=rs.getString("ORDER_ID");
		    	String ORDER_DATE=rs.getString("ORDER_DATE");
		    	String ORDER_TIME=rs.getString("ORDER_TIME");
		    	int TOTAL_PRICE=rs.getInt("TOTAL_PRICE");
		    	boolean PAID_STATUS=rs.getBoolean("PAID_STATUS");
		    	Order_main ord=new Order_main(ORDER_ID,ORDER_DATE,ORDER_TIME,TOTAL_PRICE,PAID_STATUS);
		    	data.add(ord);
		    }  
		}catch(SQLException ex) {
				System.out.println("getAll() SQL Error "+ex.getMessage());
		}finally {
			if(conn !=null) {
			   try {	
				conn.close();//記得關閉
			   }catch(SQLException ex) {}
			}
		}
		return data;
	}
	//修改update
	public static int updateorders(Order_main ord)
		    throws SQLException {
		    Connection conn=null;
		   PreparedStatement updateORDER_ID = null;

		    String updateString =
		    "update gjun_project.order_main "
		    + "set ORDER_DATE = ?,ORDER_TIME=?,TOTAL_PRICE=?,PAID_STATUS=?"
		    + " where ORDER_ID = ?";
		    try {
		         Class.forName("com.mysql.cj.jdbc.Driver");
		         conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/gjun_project?serverTimezone=Asia/Taipei","root","870527");
		      
		        conn.setAutoCommit(false);
		        updateORDER_ID = conn.prepareStatement(updateString);
		        
		        updateORDER_ID.setString(1,ord.getORDER_DATE());
		        updateORDER_ID.setString(2,ord.getORDER_TIME());
		        updateORDER_ID.setInt(3,ord.getTOTAL_PRICE());
		        updateORDER_ID.setBoolean(4, ord.isPAID_STATUS());
		        updateORDER_ID.setString(5, ord.getORDER_ID());
		        
		        System.out.println(ord.toString());
		            int r1=updateORDER_ID.executeUpdate();
		            if(r1>0) {
		               conn.commit();
		               System.out.println("Congratulations~ Update Find OK!");
		               return 1;//回傳1,老師自己定義的
		            }
		            else {
		               conn.rollback();
		               System.out.println("Update NONONO Find!");
		               return 0;
		            } 
		    } catch (Exception e ) {
		        System.out.println(e.getMessage());
		        if (conn != null) {
		            try {
		            	System.err.print("Connection erroooooor!");
		                conn.rollback();
		            } catch(SQLException excep) {
		                System.out.println(e.getMessage());
		            }
		        }
		    } finally {
		    	
		    	conn.setAutoCommit(true);
		        if (updateORDER_ID != null) {
		        	updateORDER_ID.close();
		        }
		    }
		    return 0;
		}
	//刪除delete
	public static int deleteorders(Order_main ord)throws SQLException {
	    Connection conn=null;
	    PreparedStatement deleteStatement = null;
	    String deleteSql ="delete from gjun_project.order_main where ORDER_ID = ?";
	    try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/gjun_project?serverTimezone=Asia/Taipei","root","870527");
	         conn.setAutoCommit(false);
	         deleteStatement = conn.prepareStatement(deleteSql);
	         deleteStatement.setString(1, ord.getORDER_ID());
	            int r1=deleteStatement.executeUpdate();
	            if(r1>0) {
	               conn.commit();
	               return 1;//回傳1,老師自己定義的
	            }
	            else {
	               conn.rollback();
	               System.out.println("Delete OKok ByeBye!");
	               return 0;
	            } 
	    } catch (Exception e ) {
	        System.out.println(e.getMessage());
	        if (conn != null) {
	            try {
	            	System.err.print("OHOh Sorry~ Delete NO OK!");
	                conn.rollback();
	            } catch(SQLException excep) {
	                System.out.println(e.getMessage());
	            }
	        }
	    } finally {
	    	conn.setAutoCommit(true);
	        if (deleteStatement != null) {
	        	deleteStatement.close();
	        }
	    }
	    return 0;
	}
}

