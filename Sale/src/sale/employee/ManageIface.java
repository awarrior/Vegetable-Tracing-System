package sale.employee;

/**
 * 管理接口
 */
public interface ManageIface
{
	// 增加子地点
	void addSubset(String name, String identifier);
	// 删除子地点
	void deleteSubset(String identifier);
	// 增加职员
	void addEmployee(String id, char[] password, String type);
	// 删除职员
	void deleteEmployee(String id);
	// 更新职员
	void updateEmployee(String id, char[] password, String type);
}
