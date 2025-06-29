package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class RemoveBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		BoardService svc = new BoardServiceImpl();
		
		if(req.getMethod().equals("GET")) {
			svc.removeBoard(Integer.parseInt(bno));//수정
			System.out.println("삭제성공");
			resp.sendRedirect("boardList.do");
			}
		}

	}

