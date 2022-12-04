package demo.springmvc.controller;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demo.springmvc.DAO.OrderdetailDAO;
import demo.springmvc.DAO.OrdersDAO;
import demo.springmvc.model.Orderdetail;
import demo.springmvc.model.Order_main;

@Controller
@RequestMapping("/")
public class Ordercontroller {
	@RequestMapping("/orders")
    public ModelAndView show(@ModelAttribute("Orders") Order_main orders) {      
    	return new ModelAndView("Order", "command", orders);   
    }
	
	 @RequestMapping("/orders/read")
	    public String read(@ModelAttribute("Orders") Order_main orders, ModelMap model) {   
	    	List<Order_main> a=null;
	    	a=OrdersDAO.readOrder();
	    	model.addAttribute ("OrdersList",a);       
			return"Ordersshow";        
	 }
	 @RequestMapping("/orders/update")
	    public ModelAndView update(@ModelAttribute("Orders") Order_main orders, ModelMap model) {   
	    	int a=0;
	    	try {
				a=OrdersDAO.updateorders(orders);
				//System.out.println(a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	model.addAttribute ("OrdersList",a);       
			return new ModelAndView("Order", "command", orders);    
	    }
	 @RequestMapping("/orders/delete")
	    public ModelAndView delete(@ModelAttribute("Orders") Order_main orders, ModelMap model) {   
	    	int a=0;
	    	try {
				a=OrdersDAO.deleteorders(orders);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	model.addAttribute ("OrdersList",a);       
	    	return new ModelAndView("Order", "command", orders);
	    }
	
}
