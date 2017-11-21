package com.lys_ssh.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.lys_ssh.base.page.Pager;


/**
 * 
 * @todo   Service����࣬����ͨ�õ�����ɾ���ģ��鹦�ܽӿڡ�
 * @author ������
 * @datetime 2017��11��21������2:40:47
 * @email 578888218@qq.com
 * @param <T>
 */
public interface BaseService<T> {
  
    @Transactional
    public void save(T t); 
    @Transactional
    public void delete(Serializable id);
    @Transactional
    public void update(T t);
    public T get(Serializable id);
    public List<T> getAll();
    public Pager findByHql(Pager p, Map<String, Object> pram);
}
