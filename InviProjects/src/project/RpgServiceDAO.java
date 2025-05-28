package project;

import java.util.List;

public class RpgServiceDAO implements RpgMemberService{
	RpgDAO rpg = new RpgDAO();

	@Override
	public boolean addMember(RpgMember rpgchar) {
		// TODO Auto-generated method stub
		return rpg.insert(rpgchar) == 1;
	}

	@Override
	public boolean modifyMember(RpgMember rpgchar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeMember(String chId) {
		// TODO Auto-generated method stub
		return rpg.delete(chId) == 1;
	}

	@Override
	public List<RpgMember> memberList() {
		// TODO Auto-generated method stub
		return rpg.select();
	}
	
	
}
