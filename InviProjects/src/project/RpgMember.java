package project;
/*
 * db의 테이블의 데이터(tbl_member)에 대용.
 * */
public class RpgMember {
	private String chId;
	private String chName ; //char_name,관례
	private String chJob ;//member_name
	private int chAge;//
	private int chExp;
	private int chLv;
	private int chGold;
	private int chHp;
	private String chAb;
	private int chAtck;
	private int chDef;
	private String chWeapon;
	//생성자
	public RpgMember() {}
	//생성자호출 한줄호출..
	public RpgMember(String chId,String chName,String chJob,int chAge,int chExp,int chLv,int chGold,int chHp,String chAb,int chAtck,int chDef,String chWeapon) {
		this.chId = chId;
		this.chName = chName;
		this.chJob = chJob;
		this.chAge = chAge;
		this.chExp = chExp;
		this.chLv = chLv;
		this.chGold = chGold;
		this.chHp = chHp;
		this.chAb = chAb;
		this.chAtck = chAtck;
		this.chDef = chDef;
		this.chWeapon = chWeapon;
	}
	//source - getter/setter
	public String getChId() {
		return chId;
	}
	public void setChId(String chId) {
		this.chId = chId;
	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	public String getChJob() {
		return chJob;
	}
	public void setChJob(String chJob) {
		this.chJob = chJob;
	}
	public int getChAge() {
		return chAge;
	}
	public void setChAge(int chAge) {
		this.chAge = chAge;
	}
	public int getChExp() {
		return chExp;
	}
	public void setChExp(int chExp) {
		this.chExp = chExp;
	}
	public int getChLv() {
		return chLv;
	}
	public void setChLv(int chLv) {
		this.chLv = chLv;
	}
	public int getChGold() {
		return chGold;
	}
	public void setChGold(int chGold) {
		this.chGold = chGold;
	}
	public int getChHp() {
		return chHp;
	}
	public void setChHp(int chHp) {
		this.chHp = chHp;
	}
	public String getChAb() {
		return chAb;
	}
	public void setChAb(String chAb) {
		this.chAb = chAb;
	}
	public int getChAtck() {
		return chAtck;
	}
	public void setChAtck(int chAtck) {
		this.chAtck = chAtck;
	}
	public int getChDef() {
		return chDef;
	}
	public void setChDef(int chDef) {
		this.chDef = chDef;
	}
	public String getChWeapon() {
		return chWeapon;
	}
	public void setChWeapon(String chWeapon) {
		this.chWeapon = chWeapon;
	}
	//toString
	@Override
	public String toString() {
		return "RpgMember [chId=" + chId + ", chName=" + chName + ", chJob=" + chJob + ", chAge=" + chAge + ", chExp="
				+ chExp + ", chLv=" + chLv + ", chGold=" + chGold + ", chHp=" + chHp + ", chAb=" + chAb + ", chAtck="
				+ chAtck + ", chDef=" + chDef + ", chWeapon=" + chWeapon + "]";
	}
	
}
