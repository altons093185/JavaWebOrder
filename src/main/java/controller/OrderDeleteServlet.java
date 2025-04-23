package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.OrderDTO;
import service.OrderService;

import java.io.IOException;

/**
 * Servlet implementation class OrderDeleteServlet
 */
@WebServlet("/order/delete")
public class OrderDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderService = new OrderService();

 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 取得欲刪除的 index
				String index = request.getParameter("index");
				// 進行刪除程序
				OrderDTO orderDTO = orderService.removeOrder(index);
				// 重導到指定 jsp 並帶上歷史反饋資料(OrderDTO)
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/result.jsp");
				request.setAttribute("orderDTO", orderDTO);
				rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
