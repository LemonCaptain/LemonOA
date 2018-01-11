package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Role;

public interface DepartmentService {

	//查询所有
	List<Department> findAll();

	void delete(Long id);

	void save(Department model);

	Department getById(Long id);

	void update(Department department);

	/**
	 * 查询顶级列表
	 * @return
	 */
	List<Department> findTopList();

	/**
	 * 查询子部门列表
	 * @param parentId
	 * @return
	 */
	List<Department> findChildren(Long parentId);


	


}
