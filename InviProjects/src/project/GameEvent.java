package project;
//게임이벤트
public class GameEvent {
	int eId;
	String eName;
	String eType;
//	int eHp;
//	int eAtk;
//	int eDef;
//	int eExp;
//	int eMoney;
	String eAction;
	//랜덤 호출
	//생성자
	//객체 - 이름 a,a.get(i).f,mathrandom.0~몇가지 *a사이즈만큼.
	public GameEvent() {}
	public GameEvent(int eId,String eName,String eType,String eAction) {
		this.eId = eId;
		this.eName = eName;
		this.eType = eType;
		this.eAction = eAction;
	}
	//getter,setter
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteType() {
		return eType;
	}
	public void seteType(String eType) {
		this.eType = eType;
	}
	public String geteAction() {
		return eAction;
	}
	public void seteAction(String eAction) {
		this.eAction = eAction;
	}
	//toString
	@Override
	public String toString() {
		return "GameEvent [eId=" + eId + ", eName=" + eName + ", eType=" + eType + ", eAction=" + eAction + "]";
	}
	
	
	
}
