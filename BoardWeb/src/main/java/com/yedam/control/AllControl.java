package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class AllControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//tiles라는 url호출,관련환경찾음->tiles.xml,wildcard */*
		req.getRequestDispatcher("product/productList.tiles").forward(req, resp);
	}

}
