package demo.springmvc.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demo.springmvc.model.Orderdetail;
import demo.springmvc.model.Order_main; 

public class OrderdetailDAO {
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
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
			}
		//read查詢
		public static List<Orderdetail> readorderdetail() {
			List<Orderdetail> data=new ArrayList<>();
			//資料庫連線
			Connection conn=getConnection();
			String sql="select * from gjun_project.order_detail";

			try {
				Statement st=conn.createStatement();
				ResultSet rs=st.executeQuery(sql);
			    while(rs.next()) { 
			    	int ORDER_DETAIL_ID=rs.getInt("ORDER_DETAIL_ID");
			    	String ORDER_ID=rs.getString("ORDER_ID");
			    	int productID=rs.getInt("product_ID");
			    	int quantity=rs.getInt("Quantity");
			    	int PriceEach=rs.getInt("price_Each");
			    	Orderdetail ord=new Orderdetail(ORDER_DETAIL_ID,ORDER_ID,productID,quantity,PriceEach);
			    	data.add(ord);
			    }  
			}catch(SQLException ex) {
					System.out.println("getAll() SQL Error "+ex.getMessage());
			}finally {
				if(conn !=null) {
				   try {	
					conn.close();
				   }catch(SQLException ex) {}
				}
			}
			return data;
		}
		//修改update
		public static int updateorderdetail(Orderdetail ord) throws SQLException {
			    Connection conn=null;
			   PreparedStatement ORDER_DETAIL_ID = null;

			    String updateString =
			    		"update gjun_project.order_detail "
			    		+ "set ORDER_ID=?,product_ID=?, Quantity=?,price_Each=? "
			    		+ "where ORDER_DETAIL_ID=?";
			    try {
			         Class.forName("com.mysql.cj.jdbc.Driver");
			         conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/gjun_project?serverTimezone=Asia/Taipei","root","870527");
			      
			        conn.setAutoCommit(false);
			        ORDER_DETAIL_ID = conn.prepareStatement(updateString);
			        ORDER_DETAIL_ID.setString(1,ord.getORDER_ID());
			        ORDER_DETAIL_ID.setInt(2,ord.getProduct_ID());
			        ORDER_DETAIL_ID.setInt(3,ord.getQuantity());
			        ORDER_DETAIL_ID.setInt(4,ord.getPrice_Each());
			        ORDER_DETAIL_ID.setInt(5,ord.getORDER_DETAIL_ID());
			       
			        System.out.println(ord.toString());
			            int r1=ORDER_DETAIL_ID.executeUpdate();
			            if(r1>0) {
			               conn.commit();
			               System.out.println("Congratulations~ Update Find OK!");
			               return 1;
			            }
			            else {
			               conn.rollback();
			               System.out.println("Update NONONO Find!");
			               return 0;
			            } 
			    } 
			    catch (Exception e ) {
			        System.out.println(e.getMessage());
			        
			        if (conn != null) {
			            try {
			            	System.err.print("Connection erroooooor!");
			                conn.rollback();
			            } catch(SQLException excep) {
			                System.out.println(e.getMessage());
			            }
			        }
			    } 
			    finally 
			    {
			    	conn.setAutoCommit(true);
			        if (ORDER_DETAIL_ID != null) {
			        	ORDER_DETAIL_ID.close();
			        }
			    }
			    return 0;
			}
		//刪除delete
		public static int deleteorderdetail(Orderdetail ord)throws SQLException {
		    Connection conn=null;
		    PreparedStatement deleteStatement = null;
		    String deleteSql ="delete from gjun_project.order_detail where ORDER_DETAIL_ID = ?";
		    try {
		         Class.forName("com.mysql.cj.jdbc.Driver");
		         conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/gjun_project?serverTimezone=Asia/Taipei","root","870527");
		         conn.setAutoCommit(false);
		         deleteStatement = conn.prepareStatement(deleteSql);
		         deleteStatement.setInt(1, ord.getORDER_DETAIL_ID());
		            int r1=deleteStatement.executeUpdate();
		            if(r1>0) {
		               conn.commit();
		               return 1;
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
