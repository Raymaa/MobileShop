
var  login =  document.getElementById("loginBtn");
login.addEventListener("click", loginFun);
function loginFun(){
	//提取账号+密码
	var userName = document.getElementById("userName").value.replace("/(^\s*)|(\s*$)/g","");
	var password =  document.getElementById("password").value.replace("/(^\s*)|(\s*$)/g","");
    var data = {"input":userName,"password":password};

    //改造数据，因为xhr.send(data);中的data有规定格式：
   data = (function(obj){ // 转成post需要的字符串.
        var str = "";
        for(var i in obj){
            str += i + "=" + obj[i] + "&"
        }
        return str;
    })(data);
	
	//创建XMLHttpRequest对象
    var xhr;
    if (window.XMLHttpRequest)
    {
       //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
       xhr=new XMLHttpRequest();
    }
    else
    {
       // IE6, IE5 浏览器执行代码
       xhr=new ActiveXObject("Microsoft.XMLHTTP");
    }
	
    //准备HttpRequest请求
	var url = "http://localhost:8088/MobileShop"+"/admin_manager/login";//服务端提供的登录的url
	xhr.open("POST", url, true);

	//发送请求
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(data);
	//响应请求，回调函数设置
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//表示成功
			alert(xhr.responseText);
			var result = JSON.parse(xhr.responseText);//将responseText值转化为JSON，从而就可以进一步解析
			var adminId = result.data.admin_id;
			var realName = result.data.real_name;
			alert("管理员Id："+adminId+"   真实姓名："+realName);
		}
	}
}

