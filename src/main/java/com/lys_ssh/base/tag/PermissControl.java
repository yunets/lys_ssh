package com.lys_ssh.base.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;



/**
 * 
 * @todo   JSPȨ����֤��ǩ
 * @author ������
 * @datetime 2017��12��21������9:35:58
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
			//EVAL_BODY_INCLUDE����1����body��������������ڵ�������� 
			return EVAL_BODY_INCLUDE ;
		}
		//SKIP_BODY����0 �������˿�ʼ�ͽ�����ǩ֮��Ĵ��롣
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
        //EVAL_PAGE����6������ִ�������ҳ 
		return EVAL_PAGE;
	}

	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

}
