/**
 * 
 */

Uchange();


//封装get
function byId(id)
{
  return typeof(id)==="string"?document.getElementById(id):id;
}
//定义全局变量
//
var receiving =byId("receiving"),
  receivingInformation=receiving.getElementsByClassName("receiving-information"),
  receivingAddress=receiving.getElementsByClassName("receiving-address"),
  receivingPeople=receiving.getElementsByClassName("receiving-people"),
  radios=document.getElementsByName("radio-address"),

  address=byId("Submission-address"),
  people=byId("Submission-people"),

  payStyle=byId("pay-Style"),
  payItem=payStyle.getElementsByTagName("div"),
  SubmissionBtn=document.getElementsByClassName("Submission-btn");

//传递地址
function changeaddress()
{
    // var getSelectaddress = radios[0].parentNode.parentNode.children[1].innerHTML;
    // var getSelectPhone = radios[0].parentNode.parentNode.children[2].innerHTML;
    // console.log(getSelectaddress,getSelectPhone);
    for (var i = 0; i < radios.length; i++) {
          radios[i].onclick = function () {
           var getSelectaddress = this.parentNode.parentNode.children[1].innerHTML;
           var getSelectPhone = this.parentNode.parentNode.children[2].innerHTML;
            address.innerHTML=getSelectaddress;
            console.log(address.innerHTML);
            people.innerHTML=getSelectPhone;
            console.log(people.innerHTML);
          }
          
      }
    // console.log(payItem);
    for(var i=0;i<payItem.length;i++){
      console.log(payItem[i]);
       payItem[i].id=i;
       
       
      payItem[i].onclick=function(){
         var index=0;
         index=this.id;
         for(var j=0;j<payItem.length;j++){
           payItem[j].style.border="1px solid #a9a9a9";
        }
         payItem[index].style.border="2px solid red";
        // payItem[index].className +=" appear";
        console.log(payItem[index]);
      }
    }

    // SubmissionBtn.onclick=function(){
    //   console.log("6666666");
    //   self.location='buySuccess.html';
    // }


     
   // for(var i=0;i<radios.length;i++)
   // {
   //    console.log(radios[i]);

     
   //    radios[i].onclick=function(){
   //        console.log(i);
   //        // var Address=receivingAddress[i].innerHTML;
   //        // console.log(Address);
   //        if(radio[i]:radio[name="radio-address"]:'checked')
   //        {
   //          address.innerHTML=receivingAddress[i].innerHTML;
   //          people.innerHTML=receivingPeople[i].innerHTML;
   //        }
   //    };
      
   // }
   
}

changeaddress();