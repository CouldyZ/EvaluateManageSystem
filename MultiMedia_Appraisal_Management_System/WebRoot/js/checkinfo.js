function checkInfo(form){
	
        for(var i=0;i<document.form.elements.length-1;i++)
        {
         if(document.form.elements[i].value=="")
         {
          alert("当前表单不能有空项");
          document.form.elements[i].focus();
          return false;
         }
        }
        
        if(form.name.value.length>5){
    		alert('名字长度不超过5');
    		form.name.focus();
    	 return false;
    	}

        return true;
       
}
