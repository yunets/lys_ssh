// 左边附加导航栏根据页面定位
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
$('.zh-affix-content li').click(function(){
    var idx=$(this).index();
    console.log(idx);
    $('.solution-content-factory>.content').eq(idx).show().siblings('.content').hide();
});