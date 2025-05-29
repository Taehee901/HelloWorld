package project;

public class GameEvent {
	int eId;
	String eName;
	String eType;
	int eHp;
	int eAtk;
	int eDef;
	int eExp;
	int eMoney;
	String eAction;
	
	//생성자
	public GameEvent() {}
	public GameEvent(int eId,String eName,String eType,int eHp,int eAtk,int eDef,int eExp,int eMoney,String eAction) {
		this.eId = eId;
		this.eName = eName;
		this.eType = eType;
		this.eHp =eHp;
		this.eAtk = eAtk;
		this.eDef = eDef;
		this.eExp = eExp;
		this.eMoney = eMoney;
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
	public int geteHp() {
		return eHp;
	}
	public void seteHp(int eHp) {
		this.eHp = eHp;
	}
	public int geteAtk() {
		return eAtk;
	}
	public void seteAtk(int eAtk) {
		this.eAtk = eAtk;
	}
	public int geteDef() {
		return eDef;
	}
	public void seteDef(int eDef) {
		this.eDef = eDef;
	}
	public int geteExp() {
		return eExp;
	}
	public void seteExp(int eExp) {
		this.eExp = eExp;
	}
	public int geteMoney() {
		return eMoney;
	}
	public void seteMoney(int eMoney) {
		this.eMoney = eMoney;
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
		return "GameEvent [eId=" + eId + ", eName=" + eName + ", eType=" + eType + ", eHp=" + eHp + ", eAtk=" + eAtk
				+ ", eDef=" + eDef + ", eExp=" + eExp + ", eMoney=" + eMoney + ", eAction=" + eAction + "]";
	}
	
	
}
