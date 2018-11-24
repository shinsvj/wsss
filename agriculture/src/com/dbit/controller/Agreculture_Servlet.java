package com.dbit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbit.service.InventoryDisplayService;
import com.dbit.service.LoginService;
import com.dbit.service.PurchaseDetailsService;
import com.dbit.service.PurchaseService;
import com.dbit.service.SaleService;
import com.dbit.service.SalesDetailsService;
import com.dbit.to.InventoryTo;
import com.dbit.to.LoginTo;
import com.dbit.to.PurchaseDetailsTo;
import com.dbit.to.PurchaseTO;
import com.dbit.to.SalesDetailsTo;
import com.dbit.to.SalesTo;

public class Agreculture_Servlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getServletPath();
		System.out.println(path);

		if (path.equals("/login.do")) {
			String StrUserName = request.getParameter("nme");
			String StrUserPassword = request.getParameter("pwd");
			System.out.println(StrUserName + "    " + StrUserPassword);

			LoginTo loginTo = new LoginTo();
			loginTo.setName(StrUserName);
			loginTo.setPassword(StrUserPassword);

			LoginService loginService = new LoginService();
			System.out.println("entered");
			System.out.println(loginService);
			boolean isValid;
			try {
				isValid = loginService.login(loginTo);
				if (isValid) {
					try {

						RequestDispatcher dispatcher = request.getRequestDispatcher("./jsp/contents.jsp");
						dispatcher.forward(request, response);
					} catch (ServletException e) {
						System.out.println(e);
						e.printStackTrace();
					} catch (IOException e) {
						System.out.println(e);
						e.printStackTrace();
					}
					System.out.println("sent");
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("./jsp/loginFailed.jsp");
					dispatcher.forward(request, response);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		else if (path.equals("/purchase.do")) {
			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("./jsp/purchaseInsert.jsp");
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

		else if (path.equals("/submitPurchase.do")) {
			String farName = request.getParameter("farname");
			String mobno = request.getParameter("farmobile");
			String comodity = request.getParameter("farcomodity");
			System.out.println(comodity);
			int quantity = Integer.parseInt(request.getParameter("farqty"));

			// putting all the values got from request to TO
			PurchaseTO purchaseTO = new PurchaseTO();
			purchaseTO.setFarmerName(farName);
			purchaseTO.setMobileNo(mobno);
			purchaseTO.setComodity(comodity);
			purchaseTO.setQuantity(quantity);

			PurchaseService purchaseService = new PurchaseService();
			try {
				purchaseService.purchaseService(purchaseTO);
				RequestDispatcher dispatcher = request.getRequestDispatcher("./jsp/successPurchase.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				System.out.println("sql exception caught  while insert purchase " + e);
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		else if (path.equals("/continue.do")) {
			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("./jsp/contents.jsp");
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (path.equalsIgnoreCase("/sales.do")) {
			try {
				System.out.println("sales");
				RequestDispatcher dispatcher = request.getRequestDispatcher("./jsp/SaleInsert.jsp");
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (path.equalsIgnoreCase("/submitsales.do")) {
			String buyerName = request.getParameter("salebuyname");
			String mobileNumber = request.getParameter("salemobile");
			String comodity = request.getParameter("salecomodity");
			int quantity = Integer.parseInt(request.getParameter("salequantity"));

			SalesTo salesTo = new SalesTo();
			salesTo.setBuyerName(buyerName);
			salesTo.setMobileNumbe(mobileNumber);
			salesTo.setSaleComodity(comodity);
			salesTo.setSaleQuantity(quantity);

			try {
				SaleService saleService = new SaleService();
				saleService.insertSale(salesTo);
				RequestDispatcher dispatcher = request.getRequestDispatcher("./jsp/SuccessSale.jsp");
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (path.equals("/inventoryDisplay.do")) {
			InventoryDisplayService displayService = new InventoryDisplayService();
			try {

				ArrayList<InventoryTo> arrayList = displayService.inventoryDisplayService();
				RequestDispatcher dispatcher = request.getRequestDispatcher("./jsp/inventoryDisplay.jsp");
				HttpSession session = request.getSession();
				session.setAttribute("ARRAY_INV", arrayList);
				dispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (path.equals("/purchaseDisplay.do")) {
			try {
				PurchaseDetailsService detailsService = new PurchaseDetailsService();
				ArrayList<PurchaseDetailsTo> arrayList = detailsService.purchaseDetailsService();

				request.setAttribute("ARL_PUR", arrayList);

				RequestDispatcher dispatcher = request.getRequestDispatcher("./jsp/purchaseDetailDisplay.jsp");
				dispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (path.equals("/salesDisplay.do")) {
			try {
				SalesDetailsService detailsService = new SalesDetailsService();
				ArrayList<SalesDetailsTo> arrayList=detailsService.saleDisplayService();
				
				//put array list to request scope and forward the request to jsp for display
				request.setAttribute("ARR_SALDISP",arrayList);
				
				RequestDispatcher dispatcher=request.getRequestDispatcher("./jsp/saleDetailDisplay.jsp");
				dispatcher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
