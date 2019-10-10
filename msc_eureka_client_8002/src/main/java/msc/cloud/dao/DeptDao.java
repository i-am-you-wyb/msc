package msc.cloud.dao;

import msc.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {
    /**
     * 添加部门信息
     */
    public boolean addDept(Dept dept);

    /**
     * 根据id查询部门信息
     */
    public Dept findById(Long id);

    /**
     * 查询全部部门信息
     */
    public List<Dept> findAll();
}
