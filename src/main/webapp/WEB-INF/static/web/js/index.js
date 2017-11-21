/*jQuery(function($){
    var workFlow= {
        init: function () {
            this.renderFooter();

        }
    }
    function born(){
        $.ajax({
            url:'cms_selectCmsNewsNPBySearch',
            data:{
                page:0,
                rows:5,
                isShow:"yes",
                newsType:newsType,
                newsTitle:$("#newsTitle").val(),
                startTime:$("#startTime").val(),
                endTime:$("#endTime").val()
            },
            dataType:'json',
            type:'post',
            success:function(data){
                var resultData1=data;
                makePage(resultData1);
                var resultData=data.rows;
                makeNewsTable(resultData);

            },
            error:function(data){
                alert('提交失败');
            }
        });
    }
})*/