package com.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
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

public class EventListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getParameter("title");
		//String start = req.getParameter("eStart");
		BoardService svc = new BoardServiceImpl();
		//List<EventVO> list = svc.eventList(title);
		List <EventVO> map = svc.eventList();
		//map.put("data", list);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);
		System.out.println(json);
		PrintWriter out = resp.getWriter();
		out.print(json);
	}

}
