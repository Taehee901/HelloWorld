package com.yedam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

/*
 * 클래스가 서블릿이 되는 순서.
 * HttpServlet을 상속
 * 
 * 이클립스만들어주는방식,dogoet,servlets
 * 생성자선언 - init() - service()순으로 작성.
 * url 등록("board.serv")
 * */
@WebServlet("/board.serv")

public class BoardServlet extends HttpServlet{
	// 생성자선언.
	public BoardServlet() {
		System.out.println("BoardServlet 생성자 호출.");
	}
	// init()메소드.//컴파일된 클래스 실행
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출.");
	}
	//service() 메소드.
	@Override
	//클라이언트 요청정보 다담아있음 req,응답정보는HttpServletResponse,매개값을서비스에전달

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");//content 타입지정
		//요청페이지?bno=3,공백들어가면안된다,bno에 파라미터값을
		//중요req.getParameter
		String boardNo = req.getParameter("bno");
		// TODO Auto-generated method stub
		//2번째 부터는 얘만실행
//		System.out.println("service 메소드 호출.");
		//openSession sql세션을 반환해줌,DataSource.getInstance() == sqlfactory
//		SqlSession sqlSession = DataSource.getInstance().openSession(true);//자동커밋,commit;호출안해도		
//		//순서중요,조회-업데이트.카운터늘기전에 업데이트되고 카운트보여주게되니
//		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
//		//상세조회
////		BoardVO board = mapper.selectBoard(Integer.parseInt(boardNo));
////		mapper.updateReadCnt(Integer.parseInt(boardNo));//카운트증가

		//상세조회
		BoardService svc = new BoardServiceImpl();//인터페이스 구현하는 클래스
		BoardVO board = svc.getBoard(Integer.parseInt(boardNo));//단건조회하는건 getBoard에 만들어놨으
		//업데이트만되니 커밋 필요.
		//파리미터전달
//		BoardVO board = mapper.selectBoard(3);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//모양은  글번호 조회수 0
		//Table(표)출력
		//심플데이터맨?
		String str = "";
		str += "<table border = '1'>";
		str += "<tbody>";
		str += "<tr><th>글번호</th><td>"+board.getBoardNo()+"</td><th>조회수</th><td>"+board.getReadCnt()+"</td></tr>";
		str += "<tr><th>제목</th><td colspan='3'>"+board.getTitle()+"</td></tr>";
		str += "<tr><th>내용</th><td colspan='3'>"+board.getContent()+"</td></tr>";
		str += "<tr><th>작성자</th><td colspan='3'>"+board.getWriter()+"</td></tr>";
		str += "<tr><th>작성일시</th><td colsapn='3'>"+sdf.format(board.getWriteDate())+"</td></tr>";
		str += "</tbody>";
		str += "</table>";
		str += "<p><a href='servlet/boardList.serv'>목록이동</a></p>";
		
		//응답,출력스트림을 반환해줌resp.getWriter()
		PrintWriter out = resp.getWriter();
		//한번에 out.print시킴
		out.print(str);

		
	}
}
