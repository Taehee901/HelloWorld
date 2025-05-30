package project;

public class RpgFoe {
	int monId;
	String monName;
	String monType;
	String monRare;
	int monRewGold;
	int monLv;
	int monHp;
	int monAtk;
	int monDef;
	
	public RpgFoe() {}
	public RpgFoe(int monId,String monName,	String monType,String monRare,int monRewGold,int monLv,int monHp,int monAtk,int monDef) {
		this.monId = monId;
		this.monName = monName;
		this.monType = monType;
		this.monRare = monRare;
		this.monRewGold = monRewGold;
		this.monLv = monLv;
		this.monHp = monHp;
		this.monAtk = monAtk;
		this.monDef = monDef;
		
	}
	public int getMonId() {
		return monId;
	}
	public void setMonId(int monId) {
		this.monId = monId;
	}
	public String getMonName() {
		return monName;
	}
	public void setMonName(String monName) {
		this.monName = monName;
	}
	public String getMonType() {
		return monType;
	}
	public void setMonType(String monType) {
		this.monType = monType;
	}
	public String getMonRare() {
		return monRare;
	}
	public void setMonRare(String monRare) {
		this.monRare = monRare;
	}
	public int getMonRewGold() {
		return monRewGold;
	}
	public void setMonRewGold(int monRewGold) {
		this.monRewGold = monRewGold;
	}
	public int getMonLv() {
		return monLv;
	}
	public void setMonLv(int monLv) {
		this.monLv = monLv;
	}
	public int getMonHp() {
		return monHp;
	}
	public void setMonHp(int monHp) {
		this.monHp = monHp;
	}
	public int getMonAtk() {
		return monAtk;
	}
	public void setMonAtk(int monAtk) {
		this.monAtk = monAtk;
	}
	public int getMonDef() {
		return monDef;
	}
	public void setMonDef(int monDef) {
		this.monDef = monDef;
	}
	//toString
	@Override
	public String toString() {
		return "RpgFoe [monId=" + monId + ", monName=" + monName + ", monType=" + monType + ", monRare=" + monRare
				+ ", monRewGold=" + monRewGold + ", monLv=" + monLv + ", monHp=" + monHp + ", monAtk=" + monAtk
				+ ", monDef=" + monDef + "]";
	}
	
}
