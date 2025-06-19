<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>회원가입(signUp.jsp)</h3>
<!-- keyup,keydown,changEvent-db확인-,ajax 컨트롤러실행 -->
<!-- 다중 타입(이미지,파일,텍스트)으로넘어가면,처리함->x->key:value(text,xwww-infor),application/x-www-form-urlencoded기본 -->

<form name="signForm" action="signup.do" method="post" enctype="multipart/form-data">
  <table class="table">
    <tr>
      <th>아이디</th>
      <td><input class="form-control" type="text" name="userId" required></td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td><input class="form-control" type="password" name="userPw" required></td>
    </tr>
    <tr>
      <th>이름</th>
      <td><input class="form-control" type="text" name="userName" required></td>
    </tr>
    <tr>
      <th>이미지</th>
      <td><input class="form-control" type="file" name="userImg"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" class="btn btn-primary" value="회원가입">
        <input type="reset" class="btn btn-secondary" value="초기화">
      </td>
  </table>
</form>
<!-- 아이디 확인 -->
<script>
//document속성 ->document.forms()
//console.log(document.forms.signForm.onsubmit);
	let check = false;
	document.forms.signForm.addEventListener('submit',function(e){
		if(!check){
			e.preventDefault();//기본값찾아가는거,페이지이동x
			alert('입력값을 확인....');
			return;
		}
		this.submit();
	})
	document.querySelector('input[name="userId"]').addEventListener('change',function(){
			console.log(this);//실행함수,이벤트면이벤트받는대상가리킴
			let user = this.value;
			//회원입력값 check
			fetch('checkId.do?id='+user)
				.then(data => data.json())
				.then(result =>{
					if(result.retCode == "Exist"){
						alert("존재하는 아이디.");
					}else{
						alert('사용가능한 아이디.');
						check = true;
					}
				})
				.catch(err =>console.log(err))
		})	
	//수정필요 DB저장x	
	document.querySelector('input[name="userPw"]').addEventListener('change',function(){
		console.log(this);
		let upw = this.value.length;
		if(upw >= 5){
			alert('비밀번호 자릿수가 맞습니다.');
			check = true;	
		}
		else{
			alert('비밀번호를 5글자 이상입력해주세요');
			check = false;
		}
	})

</script>