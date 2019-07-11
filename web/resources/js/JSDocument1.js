var colors = ['red','green','blue','pink','yellow','gray','white'];
var len = colors.length;
var counter = 0;


 

 $(document).ready(function () {
    $('#koltuk1').click(function(){
        alert('koltuk2 seçildi');

      
    });
});

       
$(document).ready(function () {
    $('#koltuk2').click(function(){
        alert('koltuk2 seçildi');
      
    });
});
$(document).ready(function(){
    $('.koltuk').click(function(){
        $(this).css('background-color', colors[counter]);
             counter++;
             if(counter===6){
                 
                 counter=0;
             }
    });
});

