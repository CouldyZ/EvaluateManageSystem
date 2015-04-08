function checkResetPwd(form){
	
	if(form.password1.value==''){
		alert('密码不能为空!');
		form.password1.focus();
	 return false;
	}

	if(form.password1.value.length<6){
		alert('密码至少为6位，请重新输入!');
		form.password1.focus();
	 return false;
	}
	
	if(form.password1.value.length>20){
		alert('密码不能超过20位，请重新输入!');
		form.password1.focus();
	 return false;
	}
	
	if(form.password1.value!=form.password2.value) {
		alert('你两次输入的密码不一致，请重新输入!');
		form.password2.focus();
	 return false;
	}
	
	return true;
}
