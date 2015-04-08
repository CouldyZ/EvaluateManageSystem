function checkLogin(form1){
	
	if(form1.username.value==''){
		alert('用户名不能为空!');
		form1.username.focus();
	 return false;
	}
		
	if(form.password.value==''){
		alert('密码不能为空!');
		form1.password.focus();
	 return false;
	}
	return true;
}
