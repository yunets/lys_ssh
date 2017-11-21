jQuery(function($){
    $(window).scroll(function(){
        // console.log($(window).scrollTop());
        if($(window).scrollTop()>=430){
            $('#zh-affix').css({'position':'fixed',"top":0,'marginTop':0});
        }else{
            $('#zh-affix').css({'position':'static','marginTop':0});
        }
    });
});