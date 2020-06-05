/* 
* @Author: Marte
* @Date:   2016-10-09 17:10:32
* @Last Modified by:   Marte
* @Last Modified time: 2016-11-02 13:01:25
*/

/*$(document).ready(function(){
    
});
*/

var menu = document.getElementById("menu");
var menuContent = document.getElementById("menuContent");
//鼠标滑过menu时，显示menuContent
//
/*  menu.onmouseover = function(){
    alert("ok");
    menuContent.style.display = 'block';
  }
  menu.onmouseout = function(){
    menuContent.style.display = 'none';
  }*/
  function fun1(){
    menuContent.style.display = "block";
    menu.setAttribute("class", "navTitle current");
  }

   function fun2(){
    menuContent.style.display = "none";
    menu.setAttribute("class", "navTitle");
  }

  
   //当点击“手机逛商城”的关闭按钮时，二维码消失
  var QRCode = document.getElementById("QRCode");
  function closeQRCode(){
    //方法一：点击按钮，将二维码隐藏
   QRCode.style.display = "none";
   //方法二：点击按钮，将二维码移除
  // QRCode.parentNode.removeChild(QRCode);

}
  
//提交用户名到cookie   
  function setCookie(cname,cvalue,exdays){
  	var d = new Date();
  	d.setTime(d.getTime()+(exdays*24*60*60*1000));
  	var expires = "expires="+d.toGMTString();
  	document.cookie = cname+"="+cvalue+"; "+expires+";"+"path = /MobileShop";
  }
  
  //从cookie获取用户名
  function getCookie(cname){
 		var name = cname + "=";
 		var ca = document.cookie.split(';');
 		for(var i=0; i<ca.length; i++) {
 			var c = ca[i].trim();
 			if (c.indexOf(name)==0) { return c.substring(name.length,c.length); }
 		}
 		return "";
 	}

  //改变标题栏为“您好，xx”
  function Uchange(){
	     var user=getCookie("username");
	     if(user){
	    	 var left= document.getElementsByClassName("left")[0].getElementsByTagName("li");
	         var str="您好，"+user;
	         left[0].innerHTML=str;
	         left[1].innerHTML="";
	         
	         left[2].getElementsByTagName("a")[0].innerHTML="退出";
	         left[2].getElementsByTagName("a")[0].href="/MobileShop/front/login.html";
	     }
	    	
  }
