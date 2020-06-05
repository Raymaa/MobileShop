 
/* @Author: Marte
* @Date:   2016-10-09 17:10:32
* @Last Modified by:   Marte
* @Last Modified time: 2016-12-06 11:08:23
*/

/*$(document).ready(function(){
    
});
*/


//与index.html不同，分类导航先是隐藏，当鼠标滑过商品分类时才会出现，当鼠标移出二级分类时，消失
$(document).ready(function(){
  $('.control-bar img').on('mouseover',function(){
        var src = $(this).attr("src");
        var newSrc1 = src.replace("thum","orig");
        var newSrc2 = src.replace("thum","big");
        $(".preview .orig-pic").attr("src", newSrc1);
        $(".detail-pic img").attr("src", newSrc2);
  
 });

$('.preview').on('mousemove',function(e){
  $('.zoom-pup').css('display','block');
  $('.detail-pic').css('display','block');
  var ev = e || event;
  var mouseX = ev.pageX;
  var mouseY = ev.pageY;

  var picLeft = $(".orig-pic").offset().left;
  var picTop = $(".orig-pic").offset().top;
  var picWidth = $(".orig-pic").width();
  var picHeight = $(".orig-pic").height();
  var xLength = mouseX - picLeft;
  var yLength = mouseY - picTop;
  var qWidth = picWidth / 4;
  var lastQWidth = picWidth - picWidth / 4;
  var qHeight = picHeight / 4;
  var lastQHeight = picHeight - picHeight / 4;
  if (xLength < qWidth) {
      $(".zoom-pup").css("left","0px");
  } else {
      if (xLength > lastQWidth) {
          $(".zoom-pup").css("left", (lastQWidth - qWidth) + "px");
      } else {
          $(".zoom-pup").css("left", (xLength - qWidth) + "px");
      }
  }
  if (yLength < qHeight) {
      $(".zoom-pup").css("top", "0px");
  } else {
      if (yLength > lastQHeight) {
          $(".zoom-pup").css("top", (lastQHeight - qHeight) + "px");
      } else {
          $(".zoom-pup").css("top", (yLength - qHeight) + "px");
      }
  }
  $(".detail-pic > img").css("left", parseInt($(".zoom-pup").css("left")) * (-800 / picWidth) + "px").css("top", parseInt($(".zoom-pup").css("top")) * (-800 / picWidth) + "px").css("position", "absolute");
  
});


  $('.preview').on('mouseleave',function(e){
      $('.zoom-pup').css('display','none');
      $('.detail-pic').css('display','none');
 });


});

//根据库存值，来设置前面的输入文本框的值
$(document).ready(function(){
  //减
 $(".goods-figure-input .minus").on('click',function(){
    var number = $("#number").val();
    if(number > 1){
    number--;
    $("#number").val(number);}
 });
//加
$(".goods-figure-input .plus").on('click',function(){
    var number = $("#number").val();
    var max = $(".max").html();//提取最大库存
    if(number < parseInt(max)){ //将字符串转化为数字
    number++;
    $("#number").val(number);
    }
 });
});

//相关推荐
$(document).ready(function(){
  //点击向前翻
 $(".prev").on('click',function(){
    var x =  $(".ald-switchable-content").css('top');
    var y =  parseInt(x.substr(0,x.length-2))-160;
    if(Math.abs(y) < ($('.ald-switchable-content li').length-3)*160){
        $(".ald-switchable-content").css('top',y);
    }
  
});

 //点击向后翻
  $(".next").on('click',function(){
    var x =  $(".ald-switchable-content").css('top');
    var y =  parseInt(x.substr(0,x.length-2))+160;
    if(y < 0){
        $(".ald-switchable-content").css('top',y);
    }
});


});

//左边的导航
//
$(document).ready(function(){

  $('.nav .title').on('click',function(){

 
if($(this).siblings('ul').css("display")=='block'){
//假如当前元素它同胞元素ul的display==block，表示当前是展开的
$(this).siblings('ul').css('display','none');
$(this).children('i').removeClass('fa-minus-square');//i的减号移除
$(this).children('i').addClass('fa-plus-square');//i的加号加上
}else{
  //假如display！=block，表示当前是关闭的。那就需要给他展开，把其他的关闭
$(this).siblings('ul').css('display','block');
$(this).parent().siblings().children('ul').css('display','none');
   //全部删除fa-minus-square，添加fa-plus-square
   $('.nav .title i').removeClass('fa-minus-square').addClass('fa-plus-square');
   //自己删除加号，放减号
   $(this).children('i').removeClass('fa-plus-square').addClass('fa-minus-square');
}
});
});


//评价面板
$(document).ready(function(){
  //填写评价，获取评价内容
  //把评价添加到评价那里去
  $(".discuss-btn").on("click",function(){
   var discuss = $("#discuss-content").val();
   //构建星星的html文本
   var starStr= "";
   for(var i=0;i<5;i++){
      if(i <= starNum){
       starStr = starStr +"<img src='img/star_red.png'/>";
      }else{
        starStr = starStr +"<img src='img/star.png'/>";
      }
   }
   var str = " <li class='comment-item'> <div> "+starStr+" </div><div>"+discuss+"</div> <div>***（匿名）<br><button class='delete-btn' type='button'>删除</button></div></li> ";
   $(".comments-list").append(str);

  //假如鼠标单击删除键，则删除该li，需要嵌套，因为删除键是后面新添加的元素
    $(".delete-btn").on("click",function(){
      $(this).parents('.comment-item').remove();
    });

  });



  //评价里的小星星
  //each()方法为每个匹配元素规定要运行的函数
  var starNum = 0;//星星的下标
$('.star img').each(function(index){

    var star='img/star.png';  //普通灰色星星图片的存储路径
    var starRed='img/star_red.png';   //红色星星图片存储路径
    $(this).on("mouseover click",function(){  //设置鼠标滑动和点击都会触发事件
      $('.star img').attr('src',star);//当“回滚”、“改变主意”时，先复位所有图片为木有打星的图片颜色
      $(this).attr('src',starRed);    //设置鼠标当前所在图片为打星颜色图
      $(this).prevAll().attr('src',starRed);  //设置鼠标当前的前面星星图片为打星颜色图
      starNum = index;//星星的下标
    });
  });

})