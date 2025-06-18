package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class SignUpControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");//인코딩,포스터요청시
		//GET요청 = 화면출력.
		//POST요청=회원등록.
		//tiles적용xjsp직접호출
		if(req.getMethod().equals("GET")) {
			//.tlies호출,경로지정-jsp
			req.getRequestDispatcher("member/signUp.tiles").forward(req, resp);
		}
		else if(req.getMethod().equals("POST")) {
			//파일업로드및insertdb
			//db insert
			//images폴더에 업로드.
			//1.요청정보 2.업로드할 파일 경로 3.업로드할 파일 최대크기 4.인코딩방식 지정 5.리네임정책.
			//서버에똑같은파일이있으면 오버라이트x ->새로운파일이름만들어서 업로드
			//image folder->프로젝트최상위-실제경로,getServletContext프로젝트기준
			String savePath = req.getServletContext().getRealPath("images");
			MultipartRequest mr = new MultipartRequest(
					req,//요청정보.
					savePath,//업로드 경로
					1024 * 1024 * 5,//최대 크기 1024*1024 = 메가바이트,*5 =>5MB.
					"UTF-8",//인코딩
					new DefaultFileRenamePolicy()//리네임 정책 실행하는 클래스이름
		    );//위 파일업로드
			//db입력.
			String id =  mr.getParameter("userId");//
			String pw = mr.getParameter("userPw");
			String nm = mr.getParameter("userName");
			String img = mr.getFilesystemName("userImg");
			
			//Parameter 셋팅.
			MemberVO member = new MemberVO();
			member.setMemberId(id);
			member.setMemberName(nm);
			member.setPassword(pw);
			member.setImg(img);
			
			//사용자입력값받아와서전달
			MemberService svc = new MemberServiceImpl();
			if(svc.addMember(member)) {
				resp.sendRedirect("boardList.do");
			}
		}
	}

}
