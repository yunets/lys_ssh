package com.lys_ssh.base.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;



/**
 * 
 * @todo   JSP权限验证标签
 * @author 刘云生
 * @datetime 2017年12月21日上午9:35:58
 * @email 578888218@qq.com
 */
@SuppressWarnings("serial")
public class PermissControl extends TagSupport {
	private String authorization;

	public int doStartTag() throws JspException {

		/*List<FunctionEntity> functionEntities = (List<FunctionEntity>) pageContext
				.getSession().getAttribute(SessionSecurityConstants.KEY_USER_FUNCTION);
		for (FunctionEntity functionEntity : functionEntities) {
			if(authorization.equals(functionEntity.getUrl())){
				return EVAL_BODY_INCLUDE ;
			}
		}*/
		if(authorization.equals("test_pass")){
			//EVAL_BODY_INCLUDE隐含1：将body的内容输出到存在的输出流中 
			return EVAL_BODY_INCLUDE ;
		}
		//SKIP_BODY隐含0 ：跳过了开始和结束标签之间的代码。
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
        //EVAL_PAGE隐含6：继续执行下面的页 
		return EVAL_PAGE;
	}

	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

}
