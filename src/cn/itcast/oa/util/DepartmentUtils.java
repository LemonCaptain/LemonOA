package cn.itcast.oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.itcast.oa.domain.Department;

public class DepartmentUtils {

	/**
	 * 遍历部门树，把所有的部门遍历出来放到同一个集合中返回，并且其中所有的部门名称都修改，以表示层次
	 * @param topList
	 * @return
	 */
	public static List<Department> getAllDepartments(List<Department> topList) {
		List<Department> list=new ArrayList<Department>();
		walkDepartmentTreeList(topList,"┣",list);
		return list;
	}

	/**
	 * 遍历部门树,将遍历信息放在有序集合中
	 * @param topList
	 */
	
	private static void walkDepartmentTreeList(Collection<Department> topList,String prefix,List<Department> list) {
		for(Department top:topList) {
			//顶点
			Department copy=new Department();  //使用副本，避免对源数据的修改
			copy.setId(top.getId());
			copy.setName(prefix+top.getName());
			list.add(copy);			//把副本添加到同一个集合中
			//子树
			walkDepartmentTreeList(top.getChildren(),"　"+prefix,list);
		}
	}
}
