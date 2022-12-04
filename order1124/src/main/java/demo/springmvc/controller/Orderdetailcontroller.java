package demo.springmvc.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import demo.springmvc.DAO.OrderdetailDAO;
import demo.springmvc.DAO.OrdersDAO;
import demo.springmvc.model.Orderdetail;
import demo.springmvc.model.Order_main;
@Controller
@RequestMapping("/")
public class Orderdetailcontroller {

	 @RequestMapping("/orderdetail")
	    public ModelAndView show(@ModelAttribute("Orderdetail") Orderdetail orderdetail) {      
	    	return new ModelAndView("Orderdetail", "command", orderdetail);   
	    }
	
	 @RequestMapping("/orderdetail/read")
	    public String read(@ModelAttribute("Orderdetail") Orderdetail orderdetail, ModelMap model) {   
	    	List<Orderdetail> a=null;
	    	a=OrderdetailDAO.readorderdetail();
	    	model.addAttribute ("OrderdetailList",a);       
			return"Orderdetailshow";        
	 }
	 @RequestMapping("/orderdetail/update") 
	    public ModelAndView update(@ModelAttribute("Orderdetail") Orderdetail orderdetail, ModelMap model) {   
	    	int a=0;
	    	try {
				a=OrderdetailDAO.updateorderdetail(orderdetail);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute ("OrderdetailList",a);       
			return new ModelAndView("Orderdetail", "command", orderdetail); 
	 }
	 @RequestMapping("/orderdetail/delete")
	    public ModelAndView delete(@ModelAttribute("Orderdetail") Orderdetail orderdetail, ModelMap model) {   
	    	int a=0;
	    	try {
				a=OrderdetailDAO.deleteorderdetail(orderdetail);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	model.addAttribute ("OrderdetailList",a);       
			return new ModelAndView("Orderdetail", "command", orderdetail);        
	 }
}
