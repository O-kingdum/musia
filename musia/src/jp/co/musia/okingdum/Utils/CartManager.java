package jp.co.musia.okingdum.Utils;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jp.co.musia.okingdum.Bean.ProductsBean;

public class CartManager {

	/**
	 * getTotalAmount method.
	 * 
	 * @param request
	 * @return int TotalAmount
	 */
	@SuppressWarnings("unchecked")
	public static int getTotalAmount(HttpServletRequest request) {
		
		ArrayList<ProductsBean> products = new ArrayList<ProductsBean>();
		HttpSession session = request.getSession();
		int total = 0;
		
		if(session.getAttribute("cart") != null) {
			products = (ArrayList<ProductsBean>)session.getAttribute("cart");
			
			for(int i = 0; i < products.size(); i++) {
				total = total + products.get(i).getPrice();
			}
		}
		return total;
	}
	
	/**
	 * getCartList method.
	 * 
	 * @param request
	 * @return ArrayList<ProductsBean> CartList
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<ProductsBean> getCartList(HttpServletRequest request) {
		
		ArrayList<ProductsBean> products = new ArrayList<ProductsBean>();
		HttpSession session = request.getSession();
		
		if(session.getAttribute("cart") != null) {
			products = (ArrayList<ProductsBean>)session.getAttribute("cart");
		}
		return products;
	}
	
	/**
	 * setCartList method.
	 * 
	 * @param request
	 * @param product 
	 */
	@SuppressWarnings("unchecked")
	public static void setCartList(HttpServletRequest request, ProductsBean product) {
		
		ArrayList<ProductsBean> products = new ArrayList<ProductsBean>();
		HttpSession session = request.getSession();
		
		if(session.getAttribute("cart") != null) {
			products = (ArrayList<ProductsBean>)session.getAttribute("cart");			
		}
		products.add(product);
		
		session.setAttribute("cart", products);
		return;
	}
	
	/**
	 * delCartList method.
	 * 
	 * @param request
	 * @param String str_id
	 */
	@SuppressWarnings("unchecked")
	public static void delCartList(HttpServletRequest request, String str_id) {
		
		ArrayList<ProductsBean> products = new ArrayList<ProductsBean>();
		HttpSession session = request.getSession();
		int id = 0;
		
		try {
			id = Integer.parseInt(str_id);
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		if(session.getAttribute("cart") != null) {
			
			products = (ArrayList<ProductsBean>)session.getAttribute("cart");
			
			for(int i = 0; i < products.size(); i++) {
				if(i == id) {
					products.remove(i);
					break;
				}
			}
		}
		return;
	}
}
