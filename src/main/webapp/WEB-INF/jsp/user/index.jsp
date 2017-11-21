<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String basePath=request.getContextPath(); 
   request.setAttribute("basePath", basePath); %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
  
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script src="${basePath}/static/js/bootstrap-paginator.js" ></script>
</head>
<body>


<table  class="table table-hover" >
		   <caption>新闻列表</caption>
	<thead>
		<tr>
			<th >导航图片</th>
			<th >新闻标题</th>
			<th>创建时间</th>
			<th>修改时间</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody id="tb1"> </tbody>
    </table>
		<ul id='bp-element' class="col-xs-12 col-sm-12" ></ul>
	<script type="text/javascript">
	$(function(){ 
		paginationNews();
	}); 
	//获取新闻并分页
	function paginationNews(){
		$.ajax({
			url:'${basePath}/user/findByHql',
			data:{
				page:0,
				rows:5
	         },
			dataType:'json',
			type:'post',
			success:function(data){
				var resultData1=data;
				makePage(resultData1);
				var resultData=data.list;
				makeNewsTable(resultData);
				 
	 		},
	 		error:function(data){
	 			alert('提交失败');
			}
		});
	}
	
	
	
	//生成底部分页
	function makePage(resultData){
		var element = $('#bp-element');
        options = {
            bootstrapMajorVersion:3, //对应的bootstrap版本
            currentPage: resultData.pageNo, //当前页数，这里是用的EL表达式，获取从后台传过来的值
            size:"large",//设置控件的显示大小，是个字符串. 允许的值: mini, small, normal,large。值：mini版的、小号的、正常的、大号的。
            numberOfPages: 10, //每页页数
            totalPages:resultData.rowsTotal/5+1, //总页数，这里是用的EL表达式，获取从后台传过来的值
            shouldShowPage:true,//是否显示该按钮
            itemTexts: function (type, page, current) {//设置显示的样式，默认是箭头
                switch (type) {
                    case "first":
                        return "首页";
                    case "prev":
                        return "上一页";
                    case "next":
                        return "下一页";
                    case "last":
                        return "末页";
                    case "page":
                        return page;
                }
            },
            //点击事件
            onPageClicked: function (event, originalEvent, type, page) {
            	$.ajax({
        			url:'${basePath}/user/findByHql',
        			data:{
        				page:page,
        				rows:5
        	         },
        			dataType:'json',
        			type:'post',
        			success:function(data){
        				var resultData=data.list;
        				makeNewsTable(resultData);
        	 		},
        	 		error:function(data){
        	 			alert('提交失败');
        			}
        		});
                
            
            }
        };
        element.bootstrapPaginator(options);
	}

	function makeNewsTable(resultData){
		var str=""
		for(var i=0;i<resultData.length;i++){
			str+="<tr>";
			str+="<td>"+resultData[i].name+"</td>";
			str+="<td>"+resultData[i].id+"</td>";
			str+="<td>"+resultData[i].createTime+"</td>";
			str+="<td>"+resultData[i].alterTime+"</td>"; 
			/* str+="<td><button type=\"button\" class=\"btn btn-info btn-sm\" onclick=\"cms_CmsNews_noshow('"+resultData[i].newsId+"');\">删除</button> ";
			str+=" <button type=\"button\" class=\"btn btn-info btn-sm\" onclick=\"cms_CmsNews_to_top('"+resultData[i].newsId+"');\">置顶</button> "; 
			str+=" <button type=\"button\" class=\"btn btn-info btn-sm\" onclick=\"cms_CmsNews_editById('"+resultData[i].newsId+"');\">编辑</button> "; 
			str+=" <button type=\"button\" class=\"btn btn-info btn-sm\" onclick=\"cms_CmsNews_editImgById('"+resultData[i].newsId+"');\">替换导航图片</button>"; 
			str+=" <button type=\"button\" class=\"btn btn-info btn-sm\" onclick=\"cms_CmsNews_viewById('"+resultData[i].newsId+"');\">详情查看</button></td>";  */
			str+="<tr>";
		}
		$("#tb1").empty();
		$("#tb1").append(str);
	}
	
	
		</script>







</body>
</html>