package project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/*
 * Database에 insert,update,delete,select
 * 
 * */
public class RpgDAO extends DAO{//DAO상속
	
	//등록
	public int insert(RpgMember rpgchar) {//한건추가.업데이트는순서는같고 쿼리는 달라짐
		//''오라클에서 문자열
		String sql = " insert into rpg_chars(char_id,char_name,char_job,char_age,char_exp,char_lv,char_money,"
				+ "char_hp,char_ab,char_atck,char_def,char_weapon)"
				+ "    values(?,?,?,?,?,?,?,?,?,?,?,?)";

		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, rpgchar.getChId());
			psmt.setString(2, rpgchar.getChName());
			psmt.setString(3, rpgchar.getChJob());
			psmt.setInt(4, rpgchar.getChAge());
			psmt.setInt(5, rpgchar.getChExp());
			psmt.setInt(6, rpgchar.getChLv());
			psmt.setInt(7, rpgchar.getChGold());
			psmt.setInt(8, rpgchar.getChHp());
			psmt.setString(9, rpgchar.getChAb());
			psmt.setInt(10, rpgchar.getChAtck());
			psmt.setInt(11, rpgchar.getChDef());
			psmt.setString(12, rpgchar.getChWeapon());//도구
			int r = psmt.executeUpdate();
			return r;//건수반환
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//성공하거나실패해도 하고싶은코드할수있게
			disconnect();
		}
		return 0;//에러거나 제대로 안될경우,한건도 반영안됨 //반영x
	}//end of insert.
	
	//삭제
	public int delete(String chId) {
		String sql = "delete from rpg_chars"
				+ "   where  char_id = ?";
		//접속
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);//쿼리 매개값전달
			psmt.setString(1, chId);
			int r = psmt.executeUpdate();//매개값호출x
			return r;//건수반환
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return 0;
	}//end of delete
	
	//목록
	public List<RpgMember> select(){
		String sql = "select * from rpg_chars";
		getConnect();
		//값 담는 변수 선언
		List<RpgMember> list = new ArrayList<RpgMember>();//컬렉션에 저장.
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				RpgMember rpgchar = new RpgMember();
				
				rpgchar.setChId(rs.getString("char_id"));
				rpgchar.setChName(rs.getString("char_name"));
				rpgchar.setChJob(rs.getString("char_job"));
				rpgchar.setChAge(rs.getInt("char_age"));
				rpgchar.setChExp(rs.getInt("char_exp"));
				rpgchar.setChLv(rs.getInt("char_lv"));
				rpgchar.setChGold(rs.getInt("char_money"));
				rpgchar.setChHp(rs.getInt("char_hp"));
				rpgchar.setChAb(rs.getString("char_ab"));
				rpgchar.setChAtck(rs.getInt("char_atck"));
				rpgchar.setChDef(rs.getInt("char_def"));
				rpgchar.setChWeapon(rs.getString("char_weapon"));
				//컬렉션 추가
				list.add(rpgchar);
				//rs - 여러건수담고 있음
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//게임이벤트
	public List<GameEvent>gameInsert() {
		String esql = "select * from rpg_event";
		getConnect();
		List<GameEvent> list = new ArrayList<GameEvent>();//컬렉션에 저장.
		try {
			psmt = conn.prepareStatement(esql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				GameEvent rpgge = new GameEvent();
				
				rpgge.seteId(rs.getInt("id"));
				rpgge.seteName(rs.getString("name"));  
				rpgge.seteType(rs.getString("e_type"));
				rpgge.seteHp(rs.getInt("hp_chan"));
				rpgge.seteAtk(rs.getInt("atk_chan"));
				rpgge.seteDef(rs.getInt("def_chan"));
				rpgge.seteExp(rs.getInt("exp_chan"));
				rpgge.seteMoney(rs.getInt("money_chan"));
				rpgge.seteAction(rs.getString("action"));
				//컬렉션 추가
				list.add(rpgge);
				//rs - 여러건수담고 있음
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
