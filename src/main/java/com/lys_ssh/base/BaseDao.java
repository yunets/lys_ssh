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
 * @todo dao层基类，实现增，删，改，查等常用功能
 * @author 刘云生
 * @datetime 2017年11月21日下午2:26:25
 * @email 578888218@qq.com
 * @param <T>
 */
@Repository
public class BaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @todo 保存
	 * @author 刘云生
	 * @datetime 2017年11月21日下午2:34:16
	 * @param t
	 * @return_type void
	 */
	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

    /**
     * 
     * @todo 删除数据
     * @method delete
     * @param id
     * @param clazz
     * @return_type void
     * @author 刘云生
     * @datetime 2017年11月21日下午2:46:34
     */
	public void delete(Serializable id, Class<T> clazz) {
		T t = get(id, clazz);
		if (t != null)
			sessionFactory.getCurrentSession().delete(t);
		else
			new RuntimeException("你要删除的数据不存在").printStackTrace();
		;
	}


	/**
	 * 
	 * @todo 更新数据
	 * @author 刘云生
	 * @datetime 2017年11月21日下午2:36:47
	 * @param t
	 * @return_type void
	 */
	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}


	/**
	 * 
	 * @todo 根据ID查找数据
	 * @author 刘云生
	 * @datetime 2017年11月21日下午2:36:17
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
	 * @todo 查找所有数据
	 * @author 刘云生
	 * @datetime 2017年11月21日下午2:37:30
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
	 * @todo 分页查询
	 * @author 刘云生
	 * @datetime 2017年11月21日下午2:37:58
	 * @param p
	 * @param pram
	 * @return
	 * @return_type Pager
	 */
	public Pager findByHql(Pager p, Map<String, Object> pram) {
		String hql = p.getHql();// 获取查询语句
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setCacheable(true);
		// 设置参数
		query.setProperties(pram);
		// 查询具体数据
		int count = query.list().size();
		p.setRowsTotal(count);
		/*
		 * int nowPage=1; if(p.getPage()>0){ nowPage=p.getPage(); }else{
		 * nowPage=1;}
		 */
		// 指定从那个对象开始查询，参数的索引位置是从0开始的，
		query.setFirstResult((p.getPage() - 1) * p.getRows());
		// 分页时，一次最多产寻的对象数
		query.setMaxResults(p.getRows());
		List<?> list1 = query.list();
		p.setList(list1);
		return p;
	}

}
