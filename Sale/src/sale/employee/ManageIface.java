package sale.employee;

/**
 * ����ӿ�
 */
public interface ManageIface
{
	// �����ӵص�
	void addSubset(String name, String identifier);
	// ɾ���ӵص�
	void deleteSubset(String identifier);
	// ����ְԱ
	void addEmployee(String id, char[] password, String type);
	// ɾ��ְԱ
	void deleteEmployee(String id);
	// ����ְԱ
	void updateEmployee(String id, char[] password, String type);
}
