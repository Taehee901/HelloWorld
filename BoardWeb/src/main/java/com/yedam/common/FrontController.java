package com.yedam.common;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontController extends HttpServlet{
	/*
	 * m-v-Control역할
	 * url패턴 - 실행서블릿 key(Stream)-value(Control인터페이스 구현 클래스?객체 값 아마구나 가져오면됨)형식으로 관리,map
	 * 
	 * 동일패키지따로임포트x
	 * init setvlet,최초한번만,서비스는호출될때마다실행
	 * 
	 * */
	Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<String, Control>();
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		// url은 boardList.do-글목록 출력 기능.null컨틀롤구현클래스들어오면됨
		//키값읽어오면해당되는값가져옴
		map.put("/boardList.do", new BoardListControl());
		map.put("/board.do",new BoardControl());
		map.put("/addBoard.do",new AddBoardControl());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		///BoardWeb/boardList.do -> url /BoardWeb 기준으로 뒤에거 뭔지 가져와
		//url이(http://localhost:8080/BoardWeb/boardList.do) 호출 -> 페이지 호출(어떤 페이지를 호출하고있는지 파악해서 /boardList.do,new BoardListControl()객체값가져오려고하는거 -> control
		String url = req.getRequestURI();//url값반환해주는메소드.BoardWeb/boardList.do를 반환 /BoardWeb/boardList.do
		String page = url.substring(9);// //boardList.do,무슨페이지요청하는지파악하는부분
		Control sub = map.get(page);
		sub.exec(req, resp);//인터페이스기때문에 필요,요청,응답정보필요(매개값)
	}
	
}
