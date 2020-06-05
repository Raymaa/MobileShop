$(document).ready(function(){
/*	
 * JSON测试代码
 * var userObj = {"name":"zs2016","password":"123456"};
	console.log("js对象userObj转化成JSON字符串：");
	console.log(JSON.stringify(userObj));  //将js对象转化成JSON字符串
	
	var userStr = '{"name":"zs2016","password":"123456"}';
	console.log("JSON字符串userStr转化成js对象：");
	console.log(JSON.parse(userStr));                 //将JSON字符串转化成js对象
*/
$("#loginBtn").on("click",function(e){
   e.preventDefault();//阻止元素发生默认的行为
  //提取账号和密码
  var input = $("#userName").val().trim();
  var password = $("#password").val().trim();
  var data = {"input": input,"password":password};
  var url = "http://localhost:8080/MobileShop"+"/admin_manager/login";
  //简单测试
  /*
  $.post(url, data, function(data,status,xhr) {
	
   console.log("data中提取用户名："+data.data.username);
    console.log("返回的status："+status);
    console.log("xhr对象responseText属性中提取的用户名："+JSON.parse(xhr.responseText).data.username);
    console.log("xhr对象的status属性"+xhr.status);
    
	  
	  if(xhr.readyState == 4 && xhr.status == 200){//表示服务器成功响应
		  if(data.status==0){//表示登录验证成功，这是我们项目自己约定的status
				window.location.href="main.html";
			}else{
				alert(data.msg);
			}
	  }
	  
  });
  */
  
  //加深，用.done() .fail() .always()
/* $.post(url, data)
  .done(function(data){
	  //当登录成功时，跳转到后台首页
	  if(data.status==0){
			window.location.href="main.html";
      //将管理员id和姓名都存入session
			$.session.set('userId', data.data.admin_id);
			$.session.set('userName', data.data.username);
		}else{
			alert(data.msg);
		}
  })
  .fail(function(){
	   alert("服务器忙，请稍后再试");
  })
  .always(function(){
    alert("不管是否登录成功都会执行");
  });
 */
  
  //换一种写法，$.ajax()   语法：$.ajax({name:value, name:value, ... })
 $.ajax({
    type:"post",
    data:data,
    url:url,
    timeout:2000,
    beforeSend:function(){//加载中的图片
      $(".load").css("display","block");
    },
    complete:function(){//加载中的图片消失
     $(".load").css("display","none");
    },
    success:function(result){
         if(result.status==0){
          window.location.href="main.html";
          //将管理员id和姓名都存入session
          $.session.set('userId', result.data.admin_id);
          $.session.set('userName', result.data.username);
        }else{
         alert(result.msg); 
        }
    },
    fail:function(){
       alert("服务器忙，请稍后再试");
    }
  })  
  
});
})

