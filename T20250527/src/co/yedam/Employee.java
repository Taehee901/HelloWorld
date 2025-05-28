package co.yedam;

/*
 * 사원번호, 이름, 전화번호, 입사일자, 급여 항목을 필드로 선언하고
 * 필요한 메소드를 정의하세요.
 */
public class Employee {
	String empId;
	String empName;
	String empPhone;
	String empHiredate;
	Integer empPoint;
	
	//생성자
	public Employee() {}
	
	public Employee(String empId,String empName,String empPhone,String empHiredate,Integer empPoint) {
		this.empId = empId;
		this.empName = empName;
		this.empPhone = empPhone;
		this.empHiredate = empHiredate;
		this.empPoint = empPoint;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpHiredate() {
		return empHiredate;
	}

	public void setEmpHiredate(String empHiredate) {
		this.empHiredate = empHiredate;
	}

	public Integer getEmpPoint() {
		return empPoint;
	}

	public void setEmpPoint(Integer empPoint) {
		this.empPoint = empPoint;
	}
	
}
