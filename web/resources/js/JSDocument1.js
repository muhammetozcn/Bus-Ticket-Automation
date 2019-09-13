var colors = ['red','green','blue','pink','yellow','gray','white'];
var len = colors.length;
var counter = 0;
//Kullanıcı maksimum 4 koltuk satın alabilir.
var maxKoltukSayısı=0;
var dizi=[];
var pagecounter=0;

function sayfayıYenile(){
   
    document.getElementById("form2:biletler").value="";
};

function readOnlyYap(){
    var inputText2=document.querySelector(`[id="form2:biletler`);
    inputText2.setAttribute("readonly","true");
    
};

function veriTabanikoltukKontrolu(){
    var item=  document.getElementById("form3:veri");
    var val=item.value;
    var arraySeat=val.split(",");

        for(let index=0;index<46;index++){
            if(arraySeat[index]==="erkek"){
                var coloredSeat=document.querySelector(`[value="${index}"]`);
                coloredSeat.setAttribute("style","background-color:royalblue");
                coloredSeat.setAttribute("style","display:none");
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
};

function koltukSayisiKontrolü(item){
    if(maxKoltukSayısı>3){
           alert('maksimum 4 koltuk satın alabilirsiniz'); 
           location.reload();
          
       }else{
  
           maxKoltukSayısı++;
           item.css('background-color', colors[1]);
        }
   
};

function eklemeKontrolu(controlAdding,alinanBiletler,inputTextValue){
    if(controlAdding){
        if(alinanBiletler.value===""){
                alinanBiletler.value=inputTextValue;
        }
        else{
                alinanBiletler.value=alinanBiletler.value+","+inputTextValue;
        }
           
    }
    
};

$(document).ready(function(){
        sayfayıYenile();
        readOnlyYap();
        veriTabanikoltukKontrolu();
      
      
    $('.koltuk').click(function(){
       function butonaBasildimi(dizi,inputTextValue){
          return dizi.includes(inputTextValue);
           
       };
       function butonaBasildi(item,maxKoltukSayısı){
           item.css('background-color','');
           maxKoltukSayısı=maxKoltukSayısı-2;
       }
      
       
   
       koltukSayisiKontrolü($(this));
       var inputTextValue=$(this).val();
       var controlAdding=false;
    
       if(butonaBasildimi(dizi,inputTextValue)){
          butonaBasildi($(this),maxKoltukSayısı);
       }else{
            dizi.push(inputTextValue);
            controlAdding=true;
       }      
       var alinanBiletler= document.getElementById("form2:biletler");
       eklemeKontrolu(controlAdding,alinanBiletler,inputTextValue);
       
       
    }
       
    );
});
