
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
function fun1() {
  menuContent.style.display = "block";
  menu.setAttribute("class", "navTitle current");
}

function fun2() {
  menuContent.style.display = "none";
  menu.setAttribute("class", "navTitle");
}


//当点击“手机逛商城”的关闭按钮时，二维码消失
var QRCode = document.getElementById("QRCode");
function closeQRCode() {
  //方法一：点击按钮，将二维码隐藏
  QRCode.style.display = "none";
  //方法二：点击按钮，将二维码移除
  // QRCode.parentNode.removeChild(QRCode);

}

var number = document.getElementById("number").value;
function addnumber() {
  number++;
  document.getElementById("number").value = number;
}
function subnumber() {
  if (number != 1)
    number--;
  document.getElementById("number").value = number;
}
//panel
var listTabs = document.getElementById('cumtabs');
var listTabsLi = listTabs.getElementsByTagName('li');
var divPanel1 = document.getElementById('panel01');
var divPanel2 = document.getElementById('panel02');
function panel01change() {
  listTabsLi[1].className = '';
  listTabsLi[0].className = 'active';
  divPanel1.style.display = 'block';
  divPanel2.style.display = 'none';
}
function panel02change() {
  listTabsLi[0].className = '';
  listTabsLi[1].className = 'active';
  divPanel2.style.display = 'block';
  divPanel1.style.display = 'none';
}

var sliderContent = document.getElementById('slider-content');
var sliderContentLi = sliderContent.getElementsByTagName('li');
var sliderNav = document.getElementById('slider-nav');
var sliderNavLi = sliderNav.getElementsByTagName('li');
var x = 0;
window.onload = function () {
  window.setInterval(function () { change() }, 2000);
  for (var i = 0; i < sliderNavLi.length; i++) {
    sliderNavLi[i].index = i;
    sliderNavLi[i].onmouseover = function () {
      for (var i = 0; i < sliderNavLi.length; i++) {
        /*sliderNavLi[i].className = '';*/
        sliderNavLi[i].removeAttribute("class");
      } /* this.className = 'on';*/
      this.setAttribute("class", "on");
      for (var i = 0; i < sliderContentLi.length; i++) {
        sliderContentLi[i].style.display = 'none';
      }
      sliderContentLi[this.index].style.display = 'block';
    }
  }
}

var bbigimg = document.getElementById('obj');
var curIndex = 0;
var arr = new Array();
arr[0] = "img/items/1_big.jpg";
arr[1] = "img/items/2_big.jpg";
arr[2] = "img/items/3_big.jpg";
arr[3] = "img/items/4_big.jpg";
arr[4] = "img/items/5_big.jpg";
function changebbig() {
  if (curIndex == arr.length - 1) {
    curIndex = 0;
  } else {
    curIndex += 1;
  }
  bbigimg.src = arr[curIndex];
}

function change() {
  if (x == sliderNavLi.length) {
    x = 0;
    curIndex = 0;
  }
  sliderNavLi[x].index = x;
  for (var j = 0; j < sliderNavLi.length; j++) {
    sliderNavLi[j].className = '';
  }
  sliderNavLi[x].className = 'on';
  for (var k = 0; k < sliderContentLi.length; k++) {
    sliderContentLi[k].style.display = 'none';
  }
  sliderContentLi[sliderNavLi[x].index].style.display = 'block';
  bbigimg.src = arr[curIndex];
  x++;
  curIndex++;
}


//放大镜
var $mark = $("#shadow");
var $box1 = $(".big");
var $box2 = $("#bbig");
var $img = $box2.children("img");
$box1.on("mouseenter",
  function (e) {
    //首先让mark遮罩显示
    $mark.stop().show();
    //再让box2显示
    $box2.stop().show();
    move(e)
  }).on("mousemove",
    function (e) {
      $mark.stop().show();
      $box2.stop().show();
      move(e);
    }).on("mouseleave",
      function (e) {
        $mark.stop().hide();
        $box2.stop().hide();
      })
function move(e) {
  var l = e.clientX - $box1.offset().left - $mark.outerWidth() / 2;
  var t = e.clientY - $box1.offset().top - $mark.outerHeight() / 2;
  var minL = 0,
    minT = 0;
  var maxL = $box1.outerWidth() - $mark.outerWidth();
  var maxT = $box1.outerHeight() - $mark.outerHeight();
  l = l <= minL ? 0 : (l >= maxL ? maxL : l);
  t = t <= minT ? 0 : (t >= maxT ? maxT : t);
  $mark.css({
    left: l,
    top: t
  });
  $img.css({
    marginLeft: -1.5 * l,
    marginTop: -1.5 * t
  });
}