function checkEva(form){
	
	if(form.score.value==''){
		alert('分数不能为空!');
		form.score.focus();
	 return false;
	}
	
	if(form.content.value==''){
		alert('评价不能为空!');
		form.content.focus();
	 return false;
	}
	
	if(form.content.value.length<15){
		alert('评价不能少于15字');
		form.content.focus();
	 return false;
	}
	
	return true;
}
