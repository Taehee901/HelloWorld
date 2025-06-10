package com.yedam.common;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.RemoveBoardControl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontController extends HttpServlet{//HttpServlet를 상속받은 서블릿
	/*m:서비스 = 메퍼,데이터처리화는거
	 * v:화면에보이는거
	 * 역활나누는 이유?간섭최소화
	 * m-v-Control역할,mvc1 mvc2 차이
	 * url패턴 - 실행서블릿 key(Stream)-value(Control인터페이스 구현 클래스?객체 값 아마구나 가져오면됨)형식으로 관리,map
	 *
	 * 서블릿->
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
		//키값읽어오면해당되는값가져옴,map - 키 문자열url패턴 control,exe메소드구현해야함,인터페이스
		map.put("/boardList.do", new BoardListControl());//글목록
		map.put("/board.do",new BoardControl());//상세화면
		map.put("/addBoard.do",new AddBoardControl());//어떤페이지요청파악,페이지값들어오면 해당되는 구현클래스에서(컨트롤)반환-exec실행
		map.put("/modifyForm.do", new ModifyBoardControl());
		//흐름파악 url-실행컨트롤
		map.put("/removeBoard.do", new RemoveBoardControl());
		//member관련,두개의 파일에 get,post분리
		map.put("/loginForm.do", new LoginFormControl());//로그인 화면.
		map.put("/login.do", new LoginControl());//id,pw 로그인처리(DB에 확인)기능
		//로그아웃
		map.put("/logout.do", new LogoutControl());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		///BoardWeb/boardList.do -> url /BoardWeb 기준으로 뒤에거 뭔지 가져와
		//url이(http://localhost:8080/BoardWeb/boardList.do) 호출 -> 페이지 호출(어떤 페이지를 호출하고있는지 파악해서 /boardList.do,new BoardListControl()객체값가져오려고하는거 -> control
		String url = req.getRequestURI();//url값반환해주는메소드.BoardWeb/boardList.do를 반환 /BoardWeb/boardList.do
		
		String context = req.getContextPath();//프로젝트이름,최상위경로,프로젝트이름이 가변적변경가능하니
		String page = url.substring(context.length());// //boardList.do,무슨페이지요청하는지파악하는부분
		Control sub = map.get(page);
		//기능실행부분
		sub.exec(req, resp);//인터페이스기때문에 필요,요청,응답정보필요(매개값)
	}
	
}
