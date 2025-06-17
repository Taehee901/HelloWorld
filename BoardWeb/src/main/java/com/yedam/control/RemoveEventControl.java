package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.EventVO;

public class RemoveEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String title = req.getParameter("title");
		//EventVO evo = new EventVO();
		BoardService svc = new BoardServiceImpl();
		if(svc.removeEvent() {
			resp.getWriter().print("{\"retCode\": \"Success\"}");
		}
		else {
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}*/
	}

}
