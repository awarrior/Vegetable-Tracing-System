package sale.employee;

import java.util.List;

/**
 * 用户接口
 */
public interface EmployeeDaoIface
{
	// 获取一个销售网点的雇员
	List getEmployees(String identifier);//
	// 获取一个雇员
	Employee getEmployee(String user);//
	// 匹配雇员信息
	Employee checkout(String user, char[] password, char permission);
	// 增加一个雇员
	void addEmployee(Employee employee);//
	// 删除一个雇员
	void delEmployee(Employee employee);//
}
