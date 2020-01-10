package com.tudou.system.platform.base.service;

import com.tudou.system.platform.base.model.DataSourceRequest;
import com.tudou.system.platform.base.model.DataSourceResult;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/26 0026.
 */
@Service
public interface IBaseService<T, ID extends Serializable> {

    /**
     * 通过id查找
     *
     * @param id
     * @return
     */
    T selectById(ID id);

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    void deleteById(ID id) throws Exception;

    /**
     * 保存
     *
     * @param entity
     * @return
     */
    T save(T entity) throws Exception;

    /**
     * 查找所有
     *
     * @return
     */
    List<T> selectAll();

    /**
     * 根据主键更新
     *
     * @param t
     * @return
     */
    void update(T t) throws Exception;

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteBatchByIds(ID[] ids) throws Exception;

    /**
     * 获取列表的数据
     *
     * @param c
     * @param dataSourceRequest
     * @param request
     * @return
     */
    DataSourceResult loadData(Class c, DataSourceRequest dataSourceRequest, Map request);

    /**
     * 获取数据列表
     * @param c
     * @param dataSourceRequest
     * @return
     */
    DataSourceResult loadData(Class c, DataSourceRequest dataSourceRequest);

    /**
     * 条件搜索
     * @param example
     * @return
     */
    List<T> selectByExample(Example example);
}
