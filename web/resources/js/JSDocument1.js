var colors = ['red','green','blue','pink','yellow','gray','white'];
var len = colors.length;
var counter = 0;
//Kullanıcı maksimum 4 koltuk satın alabilir.
var maxKoltukSayısı=0;
var dizi=[];






$(document).ready(function(){
        var item=  document.getElementById("form3:veri");
        var val=item.value;
        
     
        var arraySeat=val.split(",");
         
            
        for(let index=0;index<46;index++){
            if(arraySeat[index]==="erkek"){
                var coloredSeat=document.querySelector(`[value="${index}"]`);
                coloredSeat.setAttribute("style","background-color:royalblue");
                coloredSeat.setAttribute("disabled","true");
               
                console.log(coloredSeat);
                console.log("index="+index);
            }
            if(arraySeat[index]==="kadın"){
                var coloredSeat=document.querySelector(`[value="${index}"]`);
                coloredSeat.setAttribute("style","background-color:red");
                coloredSeat.setAttribute("disabled","true");
               
                console.log(coloredSeat);
                console.log("index="+index);
            }
        }
            
         
         
    
    
    
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

