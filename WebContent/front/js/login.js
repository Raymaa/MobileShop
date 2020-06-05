/**
 * 
 */

$("#logbtn").click(function(){
	var uname =$(".logname").val().trim();
	var password =$(".logpwd").val().trim();
	var data={uname:uname,password:password};
	if(uname.length == 0 ||password.length == 0){
        alert("用户名密码不能为空");
        }
	var url="http://localhost:8088/MobileShop"+"/member/login";
	
    $.post(url,data,function(data,status,xhr){
    	
    	if(data.status==0){
    		setCookie("username",uname,30);
    		window.location.href='../index.html';
    	}    	
    	else
    	{
    		$(".logname").val('');
    		$(".logpwd").val('');
    		alert("账号或者密码错误");
    	}
    	

	})
	
})
