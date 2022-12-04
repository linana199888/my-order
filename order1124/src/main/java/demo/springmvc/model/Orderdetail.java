package demo.springmvc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Order_detail")
public class Orderdetail implements Serializable {
		private static final long serialVersionUID = 1L;
		@Id
		private Integer ORDER_DETAIL_ID;
		
		private String ORDER_ID;

		private Integer product_ID;

		private Integer Quantity;

		private Integer price_Each ;
		public Orderdetail() {}
		public Orderdetail(Integer oRDER_DETAIL_ID, String oRDER_ID, Integer product_ID, Integer quantity,
				Integer price_Each) {
			ORDER_DETAIL_ID = oRDER_DETAIL_ID;
			ORDER_ID = oRDER_ID;
			this.product_ID = product_ID;
			Quantity = quantity;
			this.price_Each = price_Each;
		}
		public Integer getORDER_DETAIL_ID() {
			return ORDER_DETAIL_ID;
		}
		public void setORDER_DETAIL_ID(Integer oRDER_DETAIL_ID) {
			ORDER_DETAIL_ID = oRDER_DETAIL_ID;
		}
		public String getORDER_ID() {
			return ORDER_ID;
		}
		public void setORDER_ID(String oRDER_ID) {
			ORDER_ID = oRDER_ID;
		}
		public Integer getProduct_ID() {
			return product_ID;
		}
		public void setProduct_ID(Integer product_ID) {
			this.product_ID = product_ID;
		}
		public Integer getQuantity() {
			return Quantity;
		}
		public void setQuantity(Integer quantity) {
			Quantity = quantity;
		}
		public Integer getPrice_Each() {
			return price_Each;
		}
		public void setPrice_Each(Integer price_Each) {
			this.price_Each = price_Each;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		@Override
		public String toString() {
			return "Orderdetail [ORDER_DETAIL_ID=" + ORDER_DETAIL_ID + ", ORDER_ID=" + ORDER_ID + ", product_ID="
					+ product_ID + ", Quantity=" + Quantity + ", price_Each=" + price_Each + "]";
		}
}
