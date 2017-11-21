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
 * @todo   Service层基类实现类。该类是一个抽象类。
 * @author 刘云生
 * @datetime 2017年11月21日下午2:42:23
 * @email 578888218@qq.com
 * @param <T>
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    @Resource
    protected BaseDao<T> baseDao;

    private Class<T> clazz;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public BaseServiceImpl() {
        // 子类
        Class cla = getClass();
        // 通过子类获取到父类 
        // 泛型参数
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
