package cn.itcast.oa.view.action;

import java.util.List;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.util.DepartmentUtils;


@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
	
//	@Resource
//	private DepartmentService departmentService;
	
	
	
	private Long parentId;
//	private Long id;
//	private String name;
//	private String description;
	
//	private Department model=new Department();
//
//	public Department getModel() {
//		return model;
//	}
	
	/** 列表*/
	public String list() throws Exception{
		List<Department> departmentList=null;
		if(parentId==null) { //顶级列表
			departmentList=departmentService.findTopList();
		}else {		//子集列表
			departmentList=departmentService.findChildren(parentId);
			Department parent=departmentService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
			
		}
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}
	
	/** 删除*/
	public String delete() throws Exception{
		departmentService.delete(model.getId());
		return "toList";
	}
	
	/** 添加页面*/
	public String addUI() throws Exception{
		//准备数据 departmentList
		List<Department> topList=departmentService.findTopList();
		List<Department> departmentList=DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList",departmentList );
		
		return "saveUI";
	}
	
	/**添加*/
	public String add() throws Exception{
//		//封装到对象中
//		Role role=new Role();
//		role.setName(model.getName());
//		role.setDescription(model.getDescription());
//		//保存到数据库中
//		roleService.save(role);
		

		Department parent=departmentService.getById(parentId);
		model.setParent(parent);
		

		departmentService.save(model);
		
		return "toList";
	}
	
	/** 修改页面*/
	public String editUI() throws Exception{
		
		List<Department> topList=departmentService.findTopList();
		List<Department> departmentList=DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList",departmentList );
		
		//准备回显数据
		Department department=departmentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(department);
	
		if(department.getParent()!=null)
		{
			parentId=department.getParent().getId();
		}
		return "saveUI";
	}
	
	/** 修改 **/
	public String edit() throws Exception{
		//从数据库获取原对象
		Department department=departmentService.getById(model.getId());
		
		//设置修改的属性
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		department.setParent(departmentService.getById(parentId));
		//保存到数据库
		departmentService.update(department);
		return "toList";
	}

	
	//------
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	
	
	
}
