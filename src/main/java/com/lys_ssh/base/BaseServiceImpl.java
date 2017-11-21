package com.lys_ssh.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.lys_ssh.base.page.Pager;

/**
 * 
 * @todo   Service�����ʵ���ࡣ������һ�������ࡣ
 * @author ������
 * @datetime 2017��11��21������2:42:23
 * @email 578888218@qq.com
 * @param <T>
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    @Resource
    protected BaseDao<T> baseDao;

    private Class<T> clazz;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public BaseServiceImpl() {
        // ����
        Class cla = getClass();
        // ͨ�������ȡ������ 
        // ���Ͳ���
        Type type = cla.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) type;
            clazz = (Class<T>) pType.getActualTypeArguments()[0];
        }
    }


    public void save(T t) {
        baseDao.save(t);
    }

 
    public void delete(Serializable id) {
        baseDao.delete(id, clazz);
    }

    public void update(T t) {
        baseDao.update(t);
    }

    public T get(Serializable id) {
        return baseDao.get(id, clazz);
    }


    public List<T> getAll() {
        return baseDao.getAll(clazz);
    }

    public Pager findByHql(Pager p, Map<String, Object> pram){
    	return baseDao.findByHql(p, pram);
    }
}
