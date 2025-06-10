package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	//예외처리 넘김
	public void exec(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
//		System.out.println("글상세");
		//http://localhost:8080/board.do?(?뒤에는 파라미터)bno=34 단건조회
		String bno = req.getParameter("bno");//=뒷부분받아와서 글에대한정보봄bno지정
		//boardList와 코드흐름비슷
		//글상세조회
		//    <mapper resource="com/yedam/mapper/BoardMapper.xml"/>->BoardService에서 먼저읽어옴

		//추가 파라미터.(page,searchCondition,keyword)=>board.jsp담아놔야해
		//controller이 갖는값
		String page =  req.getParameter("page");
		String sc =  req.getParameter("searchCondition");
		String kw =  req.getParameter("keyword");
		

		BoardService svc = new BoardServiceImpl();//인터페이스 구현하는 구현클래스,관계 - 정의해놓은 메소드를 new ~ 반드시구현해야함
		BoardVO board = svc.getBoard(Integer.parseInt(bno));//문자열 -> int파싱,조회 주소값가짐
		//요청정보저장
		//주소값을읽어오려면 getAttribute
		//boardjs전달할거 attribute 값을 담아전달
		//attribute의 "board" 속성으로 저장."board" getAt~이름
		req.setAttribute("board", board);
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword",kw);
		
		//요청재지정(페이지이동)
 		req.getRequestDispatcher("WEB-INF/jsp/board.jsp").forward(req, resp);
		
	}
	
}
