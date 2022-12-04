package demo.springmvc.DAO;

import java.sql.SQLException;

import demo.springmvc.model.Orderdetail;
import demo.springmvc.model.Order_main;

public class ex1 {

	public static void main(String[] args) {
	/*	OrderdetailDAO a=null;
		a.readorderdetail();
		System.out.println(a.readorderdetail().toString());*/
//update測試
		 
		  /*update測試
		    Orders s=new Orders();
		  	s.setOrder_ID(1);
	        s.setOrder_date("4");
	        s.setOrder_time("4");
	        s.setOrder_totalprice(100);
	        s.setOrderitem_ID(1);
	        s.setPaidStatus((byte)0);
	        System.out.println(s.toString());
	        int b=0;	        
	        try {
				b=new OrdersDAO().updateordersDAO(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println(b);*/
/*
		Orderdetail s=new Orderdetail();
			s.setORDER_DETAIL_ID(1);
			s.setProduct_ID(2);
			s.setQuantity(2001);
			s.setPrice_Each(666);
	        System.out.println(s.toString());
	        int b=0;	        
	        try {
				b=new OrderdetailDAO().updateorderdetail(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println(b);
		*/
		
/*刪除測試
		Orderdetail s=new Orderdetail();
		s.setOrder_ID(1);
		int b;
		try {
			b=new OrderdetailDAO().deleteorders(s);
			System.out.println(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*int b=0;	        
        try {
			b=new ordersDAO().updateordersDAO(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(b);*/
		//System.out.println(a.getAll().toString());
	}
}
