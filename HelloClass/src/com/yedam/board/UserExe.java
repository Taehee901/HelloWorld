package com.yedam.board;
/*
 *User : 아이디,비밀번호,이름.
 * 
 * */
class User{
	private String userId;
	private String passwd;
	private String userName;
	
	//생성자.
	public User(String userId, String passwd, String userName) {
//		super();없어도됨
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
	}

	//getter
	public String getUserId() {
		return userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public String getUserName() {
		return userName;
	}
	
}

//

public class UserExe {
	static User[] users = {
			new User("holy","1111","김영광"),//
			new User("cutie","2222","홍예쁨"),//
			new User("guest","3333","밤손님")//
	};
	//리턴 타입 boolean
	//아이디,비밀번호 =>값이 있으면 t,없으면 f
	static boolean login(String uname,String passwd) {
		//code HERE,같은거 
		for(int i = 0;i<users.length;i++) {
			if(users[i].getUserId().equals(uname) && users[i].getPasswd().equals(passwd)){//문자비교 ==(x)
//				System.out.println("아이디를 입력하세요>>");
				return true;//아이디& 비번이 정확
			}			
		}
		return false;
	}
}
