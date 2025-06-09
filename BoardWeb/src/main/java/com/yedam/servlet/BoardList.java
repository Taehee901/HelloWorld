package com.yedam.servlet;

//톰캣부재오류
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
//1.url 
import com.yedam.vo.BoardVO;

/**
 * Servlet implementation class BoardList
 */
//url""치명 doPost실행
// (/경로)
//http://localhost/boardWeb생략
@WebServlet("/servlet/boardList.serv") //BoardList - doget에있는게실행
//@WebServlet("/html/boardList.serv") // HttpServlet를 상속받은 BoardList클래스라 그냥 서블렛이라 함
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public BoardList() {//doget,dopost - 톰캣지정
		// TODO Auto-generated constructor stub
	}

//동적 가지고있는 데이터몇건이냐에따라 보여지는게 달라짐
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// getWriter()응답정보가리킴,웹은 http연결방식,클라이언트 요청정보 서버전달
		// HttpServletRequest 요청정보 담기위한
		// 응답정보를 담아 처리 클라이언트에 보여짐HttpServletResponse

		// 컨텐츠 담고 있는 정보 지정.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();// String 기반 출력스트림,클라이언트연결시 클라이언트 웹 브라우저에 연결됨
		// append문장연결
		out.print("<h3>hello</h3>");
		out.print("<p>집가고싶다</p>");
//		SqlSession sqlSession //
//		 = DataSource.getInstance().openSession();
		
		//인터페이스 - 매퍼.
		
		//업무 서비스
//		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
//		List<BoardVO> list = mapper.selectList();
//		서블릿이 뭐다를 테스트하기위해쓴거 1들어간거 아무의미도 없다
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(1);
		
		out.print("<table border = '1'>");
		out.print("<thead><tr><th>글번호</th><th>제목</th><th>작성자</th></tr></thead>");
		out.print("<tbody>");
		for(int i = 0;i<list.size();i++) {
			out.print("<tr>");
			out.print("<td align='center'>"+list.get(i).getBoardNo()+"</td>");
			out.print("<td><a href='../board.serv?bno="+list.get(i).getBoardNo()+"'>"+list.get(i).getTitle()+"</a></td>");
			out.print("<td>"+list.get(i).getWriter()+"</td>");
			out.print("</tr>");			
		}
		out.print("</tbody></table>");
		//index페이지 이동
		//index랑 같은경로에 있음
		out.print("<a href='../index.html'>인덱스페이지</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
