var colors = ['red','green','blue','pink','yellow','gray','white'];
var len = colors.length;
var counter = 0;
//Kullanıcı maksimum 4 koltuk satın alabilir.
var maxKoltukSayısı=0;
var dizi=[];
var pagecounter=0;





$(document).ready(function(){
    
    
    
    
        
    
        var item=  document.getElementById("form3:veri");
        var val=item.value;
        document.getElementById("form2:biletler").value="";
     
        var arraySeat=val.split(",");
        
        
        var inputText2=document.querySelector(`[id="form2:biletler`);
        inputText2.setAttribute("readonly","true");
         
            
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
           location.reload();
          
       }else{
           
           maxKoltukSayısı++;
           $(this).css('background-color', colors[1]);
   
       var inputTextValue=$(this).val();
       var controlAdding=false;
      
       if(dizi.includes(inputTextValue)){
           $(this).css('background-color','');
           maxKoltukSayısı=maxKoltukSayısı-2;
           /*
           dizi.splice(dizi.indexOf(inputTextValue));   
           console.log(x123);
           let textBoxArray=x123.split(",");
           let = document.getElementById("form2:biletler");
           var indexOfthis=textBoxArray.indexof(inputTextValue);
           delete textBoxArray[indexOfthis];
           console.log(textBoxArray);
           var newString="";
           for(var i1=0;i1<textBoxArray.length;i1++){
              if(newString.value===""){
           newString=textBoxArray[i1];
             }else{
           newString=newString.value+","+textBoxArray[i1];
              }
           }
           document.getElementById("form2:biletler").value=newString;
           
           */
       }else{
            dizi.push(inputTextValue);
            controlAdding=true;
       }
       
       var alinanBiletler= document.getElementById("form2:biletler");
       
       
       if(controlAdding){
            if(alinanBiletler.value===""){
           alinanBiletler.value=inputTextValue;
       }else{
           alinanBiletler.value=alinanBiletler.value+","+inputTextValue;
       }
           
       }
      
        
       
   
       }
       
     
       
       
       
    });
});