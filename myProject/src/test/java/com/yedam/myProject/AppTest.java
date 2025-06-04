package com.yedam.myProject;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.mapper.BpardMapper;
import com.yedam.vo.BoardVO;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    //실행코드 넣어줌 
    public void testApp()
    {
    	
    	
    	
//        assertTrue( true );
    	//sql세션팩토리 필요,SqlSessionFactory쿼리로부터 세션을 가져와야함
    	SqlSessionFactory factory = DataSource.getInstance();
    	//데이터 한건 가져옴?
    	//대문자- 클래스(),규칙까먹음
    	//첫 글자는 대문자로 시작하고 여러 개의 단어가 섞이는 경우 각 단어의 첫번째 문자는 대문자를 사용
    	SqlSession sqlSession = factory.openSession();
    	BpardMapper mapper = sqlSession.getMapper(BpardMapper.class);
    	//여러건 가져옴
    	//네임스페이스.id => id기능을 가져오겠다,
    	//BoardMapper.id기능에 대한 select를 실행한 후 List로 반환
    	BoardVO board = new BoardVO();
    	board.setTitle("mybatis연습");
    	board.setContent("mybatis입력테스트");
    	board.setWriter("user66");
    	board.setBoardNo(6);
    	//한번에여러건넣는방법있으
    	//com.yedam.mapper.BoardMapper.insertBoard쿼리를 실행하는데 전달할 파라미타 board
//    	int r = sqlSession.insert("com.yedam.mapper.BoardMapper.insertBoard",board);
//    	int r = sqlSession.update("com.yedam.mapper.BoardMapper.updateBoard",board);
//    	int r = sqlSession.delete("com.yedam.mapper.BoardMapper.deleteBoard",board.getBoardNo());
    	int r = mapper.insertBoard(board);
    	if(r>0) {
    		//다른세션에서 반영하기 위해서
    		sqlSession.commit();
    		System.out.println("처리성공.");
//    		System.out.println("삭제성공.");
    		
    	}
    	
    	List<BoardVO> list =  sqlSession.selectList("com.yedam.mapper.BoardMapper.selectBoard");
    	for(BoardVO board2 : list) {
    		System.out.println(board2.toString());
    	}
    }
}
