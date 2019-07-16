var colors = ['red','green','blue','pink','yellow','gray','white'];
var len = colors.length;
var counter = 0;
//Kullanıcı maksimum 4 koltuk satın alabilir.
var maxKoltukSayısı=0;
var dizi=[];





$(document).ready(function(){
        var item=  document.getElementById("form3:veri");
        console.log(item.value); 
         
    
    
    
    $('.koltuk').click(function(){
       //alert("koltuk numaranız="+x);
       //biletler id'li input içindeki değere x ekle
       
       
       if(maxKoltukSayısı>3){
           alert('maksimum 4 koltuk satın alabilirsiniz'); 
       }else{
           maxKoltukSayısı++;
           $(this).css('background-color', colors[2]);
   
       var inputTextValue=$(this).val();
      
       if(dizi.includes(inputTextValue)){
           alert("aynı elemanı iki kere seçemezsiniz");
       }else{
            dizi.push(inputTextValue);
       }
       
       var alinanBiletler= document.getElementById("form2:biletler");
       
       
       if(alinanBiletler.value===""){
           alinanBiletler.value=inputTextValue;
       }else{
           alinanBiletler.value=alinanBiletler.value+","+inputTextValue;
       }
        
       
   
       }
       
     
       
       
       
    });
});

