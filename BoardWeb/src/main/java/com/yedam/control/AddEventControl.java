package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.EventVO;

public class AddEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		String title = req.getParameter("title");
		String eStart = req.getParameter("eventStart");
		String eEnd = req.getParameter("eventEnd");

		EventVO evo = new EventVO();
		evo.setTitle(title);
		evo.setEStart(eStart);
		evo.setEEnd(eEnd);
		
		
		Map<String,Object> map = new HashMap<>();
		
		Gson gson = new GsonBuilder().create();
		BoardService svc = new BoardServiceImpl();
		if(svc.addEvent(evo)) {
			map.put("retVal",evo);
			map.put("retCode","Success");
		}else {
			map.put("retCode","Fail");
		}
		String json = gson.toJson(map);
		System.out.println(json);
		resp.getWriter().print(json);
	}
}
