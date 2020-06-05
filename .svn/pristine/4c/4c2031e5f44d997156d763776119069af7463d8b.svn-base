/* 
* @Author: Marte
* @Date:   2016-12-08 15:16:40
* @Last Modified by:   Marte
* @Last Modified time: 2016-12-12 10:58:22
*/

$(document).ready(function(){
    //左侧导航栏动效
    $(".navTitle").on("click",function(){
      if($(this).parent().hasClass('selected')){
        $(this).parent().removeClass('selected');  
        $(this).next().slideUp();
       }else{ 
        $(this).parent().siblings().removeClass('selected');  
        $(this).parent().addClass('selected');
        $(this).next().slideDown();
        $(this).parent().siblings().children(".item").slideUp();
      }  
    });

   
})