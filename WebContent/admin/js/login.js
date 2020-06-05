$(document).ready(function(){
	$("#loginBtn").click(function(e){
		
		var input = $("#userName").val().trim();
		var password = $("#password").val().trim();
		var data ={input:input,password:password};
		var url = "http://localhost:8088/MobileShop"+"/admin_manager/login";
		
		/*$.post(url,data,function(data,status,xhr){
			console.log(data,data.username);
			console.log(status);
			console.log(JSON.parse(xhr.responseText).data.username);
		})*/
		
		
		$.ajax({
			type:"POST",
			url:url,
			data:data,
			dataType: "json",
			success:function(result,status,xhr){
				console.log("你好");
				console.log(JSON.parse(xhr.responseText).data.username);
			}
		})
		
		
		
		
	});
});