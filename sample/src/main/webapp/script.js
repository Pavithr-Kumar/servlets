let xhr;
function getAppl(id){
	xhr=new XMLHttpRequest();
	
	xhr.open("GET","appl-search?id="+id,true);
	xhr.onreadystatechange= function(){
		if(xhr.readyStateChange==4 || xhr.status==200){
			let resp= xhr.responseText;
			let obj=JSON.parse(resp);
			
			
		    document.getElementById("applId").innerText=obj.id;
		    document.getElementById("applName").innerText=obj.name;
		}
	}
	xhr.send();
}