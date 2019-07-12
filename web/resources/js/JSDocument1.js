var colors = ['red','green','blue','pink','yellow','gray','white'];
var len = colors.length;
var counter = 0;
//Kullanıcı maksimum 4 koltuk satın alabilir.
var maxKoltukSayısı=0;





$(document).ready(function(){
    $('.koltuk').click(function(){
       //alert("koltuk numaranız="+x);
       //biletler id'li input içindeki değere x ekle
       if(maxKoltukSayısı>3){
           alert('maksimum 4 koltuk satın alabilirsiniz'); 
       }else{
           maxKoltukSayısı++;
           $(this).css('background-color', colors[2]);
       var x=$(this).val();
       var ali= document.getElementById("form2:biletler");
       
       if(ali.value===""){
           ali.value=x;
       }else{
           ali.value=ali.value+","+x;
       }
        
       
   
       }
       
     
       
       
       
    });
});

