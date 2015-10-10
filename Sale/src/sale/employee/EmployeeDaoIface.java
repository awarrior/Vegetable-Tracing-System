package sale.employee;

import java.util.List;

/**
 * �û��ӿ�
 */
public interface EmployeeDaoIface
{
	// ��ȡһ����������Ĺ�Ա
	List getEmployees(String identifier);//
	// ��ȡһ����Ա
	Employee getEmployee(String user);//
	// ƥ���Ա��Ϣ
	Employee checkout(String user, char[] password, char permission);
	// ����һ����Ա
	void addEmployee(Employee employee);//
	// ɾ��һ����Ա
	void delEmployee(Employee employee);//
}
