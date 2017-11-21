package com.lys_ssh.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lys_ssh.base.page.Pager;


/**
 * 
 * @todo dao����࣬ʵ������ɾ���ģ���ȳ��ù���
 * @author ������
 * @datetime 2017��11��21������2:26:25
 * @email 578888218@qq.com
 * @param <T>
 */
@Repository
public class BaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @todo ����
	 * @author ������
	 * @datetime 2017��11��21������2:34:16
	 * @param t
	 * @return_type void
	 */
	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

    /**
     * 
     * @todo ɾ������
     * @method delete
     * @param id
     * @param clazz
     * @return_type void
     * @author ������
     * @datetime 2017��11��21������2:46:34
     */
	public void delete(Serializable id, Class<T> clazz) {
		T t = get(id, clazz);
		if (t != null)
			sessionFactory.getCurrentSession().delete(t);
		else
			new RuntimeException("��Ҫɾ�������ݲ�����").printStackTrace();
		;
	}


	/**
	 * 
	 * @todo ��������
	 * @author ������
	 * @datetime 2017��11��21������2:36:47
	 * @param t
	 * @return_type void
	 */
	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}


	/**
	 * 
	 * @todo ����ID��������
	 * @author ������
	 * @datetime 2017��11��21������2:36:17
	 * @param id
	 * @param clazz
	 * @return
	 * @return_type T
	 */
	@SuppressWarnings("unchecked")
	public T get(Serializable id, Class<T> clazz) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}


	/**
	 * 
	 * @todo ������������
	 * @author ������
	 * @datetime 2017��11��21������2:37:30
	 * @param clazz
	 * @return
	 * @return_type List<T>
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> clazz) {
		System.out.println(clazz);

		return sessionFactory.getCurrentSession().createQuery(" from " + clazz.toString().replace("class", "")).list();
		// return
		// sessionFactory.getCurrentSession().createQuery(clazz.toString()).list();
	}


	/**
	 * 
	 * @todo ��ҳ��ѯ
	 * @author ������
	 * @datetime 2017��11��21������2:37:58
	 * @param p
	 * @param pram
	 * @return
	 * @return_type Pager
	 */
	public Pager findByHql(Pager p, Map<String, Object> pram) {
		String hql = p.getHql();// ��ȡ��ѯ���
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setCacheable(true);
		// ���ò���
		query.setProperties(pram);
		// ��ѯ��������
		int count = query.list().size();
		p.setRowsTotal(count);
		/*
		 * int nowPage=1; if(p.getPage()>0){ nowPage=p.getPage(); }else{
		 * nowPage=1;}
		 */
		// ָ�����Ǹ�����ʼ��ѯ������������λ���Ǵ�0��ʼ�ģ�
		query.setFirstResult((p.getPage() - 1) * p.getRows());
		// ��ҳʱ��һ������Ѱ�Ķ�����
		query.setMaxResults(p.getRows());
		List<?> list1 = query.list();
		p.setList(list1);
		return p;
	}

}
