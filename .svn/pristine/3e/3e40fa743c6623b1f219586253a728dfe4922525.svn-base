 
/* @Author: Marte
* @Date:   2016-10-09 17:10:32
* @Last Modified by:   Marte
* @Last Modified time: 2016-11-23 16:20:04
*/

/*$(document).ready(function(){
    
});
*/



  //banner动效

       var  sliderContent = document.getElementById('slider-content');
       var  sliderContentLi = sliderContent.getElementsByTagName('li');

       var  sliderNav = document.getElementById('slider-nav');
       var  sliderNavLi = sliderNav.getElementsByTagName('li');
       var x = 0;
 
window.onload =function(){
     window.setInterval(function(){change()}, 2000); 


    for(var i = 0; i < sliderNavLi.length; i++){
      sliderNavLi[i].index = i;
      sliderNavLi[i].onmouseover = function(){
      
        for(var i = 0; i <sliderNavLi.length; i++){
          /*sliderNavLi[i].className = '';*/
        sliderNavLi[i].removeAttribute("class") ;
        }
      /* this.className = 'on';*/
       this.setAttribute("class","on");
  
        for(var i = 0; i < sliderContentLi.length; i++){
          sliderContentLi[i].style.display = 'none';
        }
        sliderContentLi[this.index].style.display = 'block';
      }
    }

   //添加一个广告图
  var banner=document.createElement("li");
  var bannerContent=document.createElement("img");
  bannerContent.setAttribute("src","img/banner/banner5.jpg");
  banner.appendChild(bannerContent);
  sliderContent.appendChild(banner);

  //添加一个翻页按钮
  var page=document.createElement("li");
  var pageContent=document.createElement("a");
  var pageNumber=document.createTextNode("5");
  pageContent.appendChild(pageNumber);
  page.appendChild(pageContent);
  sliderNav.appendChild(page);

  sliderContent.removeChild(banner);  //删除第5张广告图
  sliderNav.removeChild(page);//删除第5个翻页
  }
function change(){    
     if(x == sliderNavLi.length){
        x=0;
      }

      sliderNavLi[x].index = x;
      
  
        for(var j = 0; j <sliderNavLi.length; j++){
          sliderNavLi[j].className = '';
        }
        sliderNavLi[x].className = 'on';

        
        for(var k = 0; k < sliderContentLi.length; k++){
          sliderContentLi[k].style.display = 'none';
        }
        sliderContentLi[sliderNavLi[x].index].style.display = 'block';
       x++;
}

  //频道展示动效
  
  //鼠标滑过标签时，会在标签的li上添加selected类
  //鼠标滑过标签时，会将下面对应的div显示出来，也就是style.display="block"
  //鼠标滑过下面的某一个商品时，这个商品的opacity: 1;其他商品的opacity: 0.25;

       //商品列表
       var  floor1 = document.getElementById('floor1');
       var  floor1ContentLi = floor1.getElementsByClassName('floor-goodslist');

       //标签
       var  floor1Nav = document.getElementById('floor1Nav');
       var   floor1NavLi = floor1Nav.getElementsByTagName('li');



//写好 changeTab()函数实现当鼠标悬停时的功能
    function  changeTab(myNav){
    for(var i = 0; i <floor1NavLi.length; i++){
       floor1NavLi[i].removeAttribute("class") ;
     }
     myNav.setAttribute("class","selected");
    //获取到myNav的data-index属性值，为了方便对应起来而专门设置的属性
    var index =  myNav.getAttribute("data-index");

    for(var i = 0; i < floor1ContentLi.length; i++){
         floor1ContentLi[i].style.display = 'none';
        }
        floor1ContentLi[index-1].style.display = 'block';
    }
//方法1，采用onmouseover事件属性调用函数changeTab()，调用函数是写在事件发生的HTML元素上

//方法2，采用DOM来分配onmouseover事件，从而调用函数,遍历一次floor1NavLi，为每个li都分配一个
/*
for(var i = 0; i < floor1NavLi.length; i++){
 floor1NavLi[i].onmouseover =function(){changeTab(this)};
}*/

//方法3，为元素绑定事件监听onmouseover事件，从而调用函数
for(var i = 0; i < floor1NavLi.length; i++){
floor1NavLi[i].addEventListener("mouseover", function(){changeTab(this);});
}


//品牌标签动态效果
$(document).ready(function(){

   //鼠标悬停在品牌单元上
$('.brand-item').mouseover(function(){
   /* //显示黑色遮罩层和内容遮罩层
     $(this).find('.black-cover').css('display','block');
    $(this).find('.content-cover').css('display','block');
      //排他处理
    $(this).siblings().find('.black-cover').css('display','none');
    $(this).siblings().find('.content-cover').css('display','none');*/
 

     //链式编程
   $(this).find('.black-cover').css('display','block').siblings().find('.black-cover').css('display','none');
     
    $(this).find('.content-cover').css('display','block').siblings().find('.content-cover').css('display','none');
    });
 //鼠标移出
$('.brand-item').mouseout(function(){
     $('.brand-item').find('.black-cover').css('display','none');
     $('.brand-item').find('.content-cover').css('display','none');
    });
 
});

//分类导航交互效果
$(document).ready(function(){

//鼠标悬停在左边一级分类标签上，右边出现相应的二级标签
$('.category-tab-Con .nav-item').mouseover(function(){
  //通过添加、移除class的方式
$(this).siblings().removeClass('current');
$(this).addClass('current');


 //通过添加、移除class的方式，显示与之对应的二级分类
$('.content-con .pannel-con').eq($(this).index()).siblings().removeClass('on');
$('.content-con .pannel-con').eq($(this).index()).addClass('on');

//通过jQuery动画的方式
//$('.content-con .pannel-con').eq($(this).index()).siblings().hide();
//$('.content-con .pannel-con').eq($(this).index()).show();
//
 //通过jQuery动画的方式,有参数，表示实现动画的时间
//$('.content-con .pannel-con').eq($(this).index()).siblings().hide(100);
//$('.content-con .pannel-con').eq($(this).index()).show(100);
});



/*老方法
 $(".content-con").mouseout(function () { 
          var s = event.relatedTarget;
      //relatedTarget 事件属性返回与事件的目标节点相关的节点。  
      //对于 mouseover 事件来说，该属性是鼠标指针移到目标节点上时所离开的那个节点。  
      //对于 mouseout 事件来说，该属性是离开目标时，鼠标指针进入的节点。  
      //relatedTarget 对于其它事件无效
           if (!this.contains(s)) { 
   //contains()函数用于判断指定元素内是否包含另一个元素。即判断另一个DOM元素是否是指定DOM元素的后代
            $(this).find('.pannel-con').hide(); 
           }
        });
*/

//书中所讲的方式，当鼠标移出.content-con时
$(".content-con").mouseleave(function () { 
     $(this).find('.pannel-con').removeClass('on');
     //通过jQuery动画的方式
    //$(this).find('.pannel-con').hide(); 
     $('.category-tab-Con .nav-item').removeClass('current');
        });


});


