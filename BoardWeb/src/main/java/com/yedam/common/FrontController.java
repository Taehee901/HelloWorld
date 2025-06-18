package com.yedam.common;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.AddEventControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.AllControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.ChartControl;
import com.yedam.control.ChartPageControl;
import com.yedam.control.CheckControl;
import com.yedam.control.EventListControl;
import com.yedam.control.GetReplyControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.RemoveBoardControl;
import com.yedam.control.RemoveEventControl;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.ReplyCountControl;
import com.yedam.control.ReplyListControl;
import com.yedam.control.SignUpControl;

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
		//json데이터가지고오기위한url
		map.put("/chart.do",new ChartControl());
		//jsp페이지엶
		map.put("/chartpage.do", new ChartPageControl());
		//member관련,두개의 파일에 get,post분리
		map.put("/loginForm.do", new LoginFormControl());//로그인 화면.
		map.put("/login.do", new LoginControl());//id,pw 로그인처리(DB에 확인)기능
		//로그아웃
		map.put("/logout.do", new LogoutControl());
		//회원목록.
		map.put("/signup.do", new SignUpControl());
		map.put("/checkId.do", new CheckControl());
		map.put("/memberList.do", new MemberListControl());
		//상품관련.
		map.put("/allProduct.do", new AllControl());
		//댓글관련 - >기존에는 jsp파일을 열어주는게 마지막작업이었는데 이제는 jsp페이지x,json파일을 만들어주는걸로변경.=>06/12
		//json파일생성(문자열)전달
		map.put("/replyList.do", new ReplyListControl());
		map.put("/addReply.do", new AddReplyControl());
		map.put("/removeReply.do", new RemoveReplyControl());
		map.put("/getReply.do",new GetReplyControl());
		map.put("/replyCount.do", new ReplyCountControl());
		map.put("/eventList.do", new EventListControl());
		map.put("/addEvnet.do", new AddEventControl());
		map.put("/removeEvent.do", new RemoveEventControl());
	
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
