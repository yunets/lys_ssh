package com.lys_ssh.base.page;

import java.util.List;
/**
 * 
 * @todo   ��ҳ��
 * @author ������
 * @datetime 2017��11��21������2:56:28
 * @email 578888218@qq.com
 */
public class Pager {
    private int page;//��ǰҳ��
    private int pageTotal;//��ҳ��
    private int rowsTotal;//������
    private int rows;//ÿҳ��ʾ����
    private String hql;//��ҳ���    
    private List<?> list;//���ص����ݼ���
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getRowsTotal() {
		return rowsTotal;
	}
	public void setRowsTotal(int rowsTotal) {
		this.rowsTotal = rowsTotal;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getHql() {
		return hql;
	}
	public void setHql(String hql) {
		this.hql = hql;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
    
    
}
