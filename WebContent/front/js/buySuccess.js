/* 
* @Author: Marte
* @Date:   2020-05-02 18:07:06
* @Last Modified by:   Marte
* @Last Modified time: 2020-05-02 18:08:08
*/
Uchange();
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
  Uchange();
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

//封装get
function byId(id)
{
    return typeof(id)==="string"?document.getElementById(id):id;
}
//定义全局变量