package demo.springmvc.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="order_main")
//@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order_main implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ORDER_ID;

	private String ORDER_DATE;

	private String ORDER_TIME;

	private Integer TOTAL_PRICE;

	private boolean PAID_STATUS;


	public Order_main() {
	}


	public Order_main(String oRDER_ID, String oRDER_DATE, String oRDER_TIME, Integer tOTAL_PRICE, boolean pAID_STATUS) {
		ORDER_ID = oRDER_ID;
		ORDER_DATE = oRDER_DATE;
		ORDER_TIME = oRDER_TIME;
		TOTAL_PRICE = tOTAL_PRICE;
		PAID_STATUS = pAID_STATUS;
	}


	public String getORDER_ID() {
		return ORDER_ID;
	}


	public void setORDER_ID(String oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}


	public String getORDER_DATE() {
		return ORDER_DATE;
	}


	public void setORDER_DATE(String oRDER_DATE) {
		ORDER_DATE = oRDER_DATE;
	}


	public String getORDER_TIME() {
		return ORDER_TIME;
	}


	public void setORDER_TIME(String oRDER_TIME) {
		ORDER_TIME = oRDER_TIME;
	}


	public Integer getTOTAL_PRICE() {
		return TOTAL_PRICE;
	}


	public void setTOTAL_PRICE(Integer tOTAL_PRICE) {
		TOTAL_PRICE = tOTAL_PRICE;
	}


	public boolean isPAID_STATUS() {
		return PAID_STATUS;
	}


	public void setPAID_STATUS(boolean pAID_STATUS) {
		PAID_STATUS = pAID_STATUS;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Order_main [ORDER_ID=" + ORDER_ID + ", ORDER_DATE=" + ORDER_DATE + ", ORDER_TIME=" + ORDER_TIME
				+ ", TOTAL_PRICE=" + TOTAL_PRICE + ", PAID_STATUS=" + PAID_STATUS + "]";
	}
}