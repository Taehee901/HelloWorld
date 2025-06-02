package project;

public class RpgFoe {
	int monId;
	String monName;
	String monType;
	String monRare;
	int monLv;
	int monRewGold;
	int monExp;
	int monHp;
	int monMhp;
	int monAtk;
	int monDef;
	
	public RpgFoe() {}
	// 복사 생성자
	public RpgFoe(RpgFoe mon) {
	this.monName = mon.monName;
	this.monHp = mon.monHp;
	this.monAtk = mon.monAtk;
	this.monRewGold = mon.monRewGold;
	this.monExp = mon.monExp;
	}
	//생성자 추가
	public RpgFoe(int monId,String monName,	String monType,String monRare,int monLv,int monRewGold,int monExp,int monMhp,int monHp,int monAtk,int monDef) {
		this.monId = monId;
		this.monName = monName;
		this.monType = monType;
		this.monRare = monRare;
		this.monLv = monLv;
		this.monRewGold = monRewGold;
		this.monExp = monExp;
		this.monMhp = monMhp;
		this.monHp = monHp;
		this.monAtk = monAtk;
		this.monDef = monDef;
		
	}
	//getter.setter
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
	public int getMonLv() {
		return monLv;
	}
	public void setMonLv(int monLv) {
		this.monLv = monLv;
	}
	public int getMonRewGold() {
		return monRewGold;
	}
	public void setMonRewGold(int monRewGold) {
		this.monRewGold = monRewGold;
	}
	public int getMonExp() {
		return monExp;
	}
	public void setMonExp(int monExp) {
		this.monExp = monExp;
	}
	public int getMonHp() {
		return monHp;
	}
	public void setMonHp(int monHp) {
		this.monHp = monHp;
	}
	public int getMonMhp() {
		return monMhp;
	}
	public void setMonMhp(int monMhp) {
		this.monMhp = monMhp;
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
	@Override
	public String toString() {
		return "RpgFoe [monId=" + monId + ", monName=" + monName + ", monType=" + monType + ", monRare=" + monRare
				+ ", monLv=" + monLv + ", monRewGold=" + monRewGold + ", monExp=" + monExp + ", monHp=" + monHp
				+ ", monMhp=" + monMhp + ", monAtk=" + monAtk + ", monDef=" + monDef + "]";
	}

	//toString
	


	
	
	}
