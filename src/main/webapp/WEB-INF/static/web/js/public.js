jQuery(function($){
    var workFlow={
        init:function(){
            this.renderFooter();
            this.renderHeader();
            this.windowScroll();
            this.slider();
            this.checkUrl();
        },
        renderHeader:function(){
            var str='<nav class="navbar navbar-default zh-navbar navbar-fixed-top"> ' +
                '<div class="container"> ' +
                '<!-- Brand and toggle get grouped for better mobile display --> ' +
                '<div class="navbar-header"> ' +
                '<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> ' +
                '<span class="sr-only">Toggle navigation</span> ' +
                '<span class="icon-bar"></span> ' +
                '<span class="icon-bar"></span> ' +
                '<span class="icon-bar"></span> ' +
                '</button> ' +
                '<a class="navbar-brand" href="#"> ' +
                '<picture> ' +
                '<source media="(max-width:768px)" srcset="static/web/images/logo-xs.png"> ' +
                '<source media="(min-width:768px)" srcset="static/web/images/logo.png"> ' +
                '<img src="备用不支持picture" id="picimg"> ' +
                '</picture></a> ' +
                '</div> ' +
                '<div class="collapse navbar-collapse navStyle" id="bs-example-navbar-collapse-1"> ' +
                '<ul class="nav navbar-nav navbar-right "> ' +
                '<li class="index"><a href="jspWeb?jsp=web/index">首 页</a></li> ' +
                '<li class="aboutUs" data-kind="aboutUs"><a>关于我们</a> ' +
                '<ul class="zh-down-menu"> ' +
                '<div><div class="triangle"></div></div> ' +
                '<li><a href="jspWeb?jsp=web/aboutUs">公司简介</a></li> ' +
                '<li><a href="jspWeb?jsp=web/aboutUs">新闻资讯</a></li> ' +
                '<li><a href="jspWeb?jsp=web/aboutUs">业务动态</a></li> ' +
                '<li><a href="jspWeb?jsp=web/aboutUs">励图活动</a></li> ' +
                '</ul> ' +
                '</li> ' +
                '<li class="solution" data-kind="solution"><a>解决方案</a> ' +
                '<ul class="zh-down-menu"> ' +
                '<div><div class="triangle"></div></div> ' +
                '<li><a href="jspWeb?jsp=web/solution">智能工厂</a></li> ' +
                '<li><a href="jspWeb?jsp=web/solution">仓储物流</a></li> ' +
                '<li><a href="jspWeb?jsp=web/solution">自动化</a></li> ' +
                '<li><a href="jspWeb?jsp=web/solution">质量管理</a></li> ' +
                '</ul> ' +
                '</li> ' +
                '<li class="MES-sys" data-kind="MES-sys"><a>产品中心</a> ' +
                '<ul class="zh-down-menu"> ' +
                '<div><div class="triangle"></div></div> ' +
                '<li><a href="jspWeb?jsp=web/MES-sys">MES系统</a></li> ' +
                '<li><a href="jspWeb?jsp=web/WMS-sys">WMS系统</a></li> ' +
                '<li><a href="jspWeb?jsp=web/QIS-sys">质量管理系统</a></li> ' +
                '<li><a href="../MES-sys/MES-sys.html">资产管理系统</a></li> ' +
                '<li><a href="../MES-sys/MES-sys.html">物流管理系统</a></li> ' +
                '<li><a href="../MES-sys/MES-sys.html">数据采集设备</a></li> ' +
                '<li><a href="../MES-sys/MES-sys.html">打印设备</a></li> ' +
                '<li><a href="../MES-sys/MES-sys.html">自动化产品</a></li> ' +
                '</ul> ' +
                '</li> ' +
                '<li class="service" data-kind="service"><a>服务与支持</a> ' +
                '<ul class="zh-down-menu"> ' +
                '<div><div class="triangle"></div></div> ' +
                '<li><a href="jspWeb?jsp=web/service">服务理念</a></li> ' +
                '<li><a href="jspWeb?jsp=web/service">运营维护</a></li> ' +
                '</ul> ' +
                '</li> ' +
                '<li class="recruit" data-kind="recruit"><a>招募英才</a>'+
                '<ul class="zh-down-menu"> ' +
                '<div><div class="triangle"></div></div> ' +
                '<li><a href="jspWeb?jsp=web/recruit">英才计划</a></li> ' +
                '<li><a href="jspWeb?jsp=web/recruit">晋升机制</a></li> ' +
                '<li><a href="jspWeb?jsp=web/recruit">员工风采</a></li> ' +
                '<li><a href="jspWeb?jsp=web/recruit">员工活动</a></li> ' +
                '</ul> ' +
                '</li> </ul> </div><!-- /.navbar-collapse --> ' +
                '</div><!-- /.container-fluid --> ' +
                '</nav>';
            $('body').prepend(str);
        },
        renderFooter:function(){
            var str='<div class="footer"> <div class="container"> <div class="row"> <div class="col-md-3"><p>联 系 我 们</p><div class=""><img src="static/web/images/QR_code.png" style="margin-top:-10px;"/></div></div> ' +
                '<div class="col-md-4 "> <p>版权所有：青岛励图高科信息技术有限公司</p> <p>电话：0532-80866089 18661671889</p> <p>邮箱：master@qdlimap.com</p> </div> ' +
                '<div class="col-md-5"> <p>微博：http://weibo.com/qdlimap</p> <p>地址：山东省青岛市崂山区株洲路153号高层次人才创业中心12楼</p> <p></p> </div> </div> </div> </div>';
            $('body').append(str);
        },
        windowScroll:function(){
            $(window).scroll(function(){
                var winTop=$(window).scrollTop();
                if(winTop>=50){
                    $('.zh-navbar').addClass('small-nav');
                }else{
                    $('.zh-navbar').removeClass('small-nav');
                }
            });
        },
        slider:function(){
            var str=' <div class="menu-slider hidden-xs"> ' +
                '<ul> ' +
                '<li class="j-top"><span><img src="static/web/images/top.png"/></span><div class="move">返回顶部</div></li> ' +
                '<li><span><img src="static/web/images/tel.png"/></span><div class="move">0532-80866089</div></li> ' +
                '<li class="weibo"><span><img src="static/web/images/weiXin.png"/></span><div class="move weiXin-img"><img src="static/web/images/QR_code.png"/></div></li> ' +
                '</ul> ' +
                '</div>';
            $('body').append(str);
            $('.j-top').click(function(){
                $('html,body').animate({'scrollTop':0},400);
            });
        },
        checkUrl:function(){
            var hrefStr=window.location.pathname;
            var hrefArr=["index","aboutUs","solution","product","solution","service","recruit"];
            for(var i=0;i<hrefArr.length;i++){
                console.log(hrefArr[i]);
                var reg=new RegExp(hrefArr[i]);
                if(hrefStr.search(reg)!=-1) {
                    $("."+hrefArr[i]).addClass('zh-active');
                    return false;
                }
            }
        }
    };
    workFlow.init();
});