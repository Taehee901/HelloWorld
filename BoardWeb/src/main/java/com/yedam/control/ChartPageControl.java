package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class ChartPageControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//경로: WEB-INF/jsp/chart/chart.jsp
		//tiles 필요없으면 이거그대로사용,아니면 tiles레이아웃사용시 설정필요
		//chart/chart.tiles
		req.getRequestDispatcher("chart/chart.tiles").forward(req, resp);

	}

}
