package com.yedam.control;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.UEncoder;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control{

	//req
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		System.out.println("글목록");
//		req.setAttribute("myName", "Hongkildong");
		//글목록전달
		//list객체주소값참조변수
		//원본 boardList.do?page=2
		//boardList.do?page=2&searchCondition=W&keyword=guest ->0630
		//페이지를 활용해서 전달하려한다 - int타입변환필요
		String page = req.getParameter("page");
		page = page == null ? "1" : page;// boardList.do =>1페이지 출력.
		String sc = req.getParameter("searchCondition");
		sc = sc == null ? "" : sc; //null값인 경우
		//키워드 값도 가져워야함
		String kw = req.getParameter("keyword");
		kw = kw == null ? "" :kw;
		kw = URLDecoder.decode(kw);//16진수 -> 한글
		//검색조건.
		SearchDTO search = new SearchDTO();
		//페이지값
		search.setPage(Integer.parseInt(page));
		search.setSearchCondition(sc);
		//키워드담김값을 search다시담음
		search.setKeyword(kw);
		//데이터처리.
		//페이지정보가들어가야함		
		BoardService svc = new BoardServiceImpl();
		//인터페이스타입,boardlist변경필요
		//파라미터 다수를 넣는것보다변수선언하는게 더 나음
		List<BoardVO> list = svc.boardList(search); //searchDTO타입
//		List<BoardVO> list = svc.boardList(Integer.parseInt(page));//목록가져오는기능,파라미터가많아지면관리힘듦
		
		//페이징 계산 - 임의로
//		int totalCnt = 112;
//		int totalCnt = 320;
		int totalCnt = svc.getTotalCount(search);
		PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);
		
		//jsp페이지에 정보전달
		//요청정보에 값을 담아서 전달,jsp로
		//파라미터로읽어올지 Attrubute에 담을지
		req.setAttribute("blist", list); //요청정보에담아서(req) jsp로 전달
		req.setAttribute("pageInfo", paging);
		req.setAttribute("search", search);
		//요청재지정(페이지이동),jsp에보내주면 화면보여주기만하면됌 실제결과 .jsp파일 실요청control.view
		//한번요청하면연결끊어지는 http 특징을,ex)로그인 1번하고 끊기면 재로그인필요,서버에서갖다씀,세션은 로그아웃되기전 끊어지는데,특정시간 및 세션끊지않을경우 계속공유할방식,정보유지시간김
 		
		//User전용
		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);//없을 경우 out.print("<html>")방식으로 만들어줘야함
	}

}
