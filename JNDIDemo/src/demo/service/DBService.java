package demo.service;

public interface DBService {

	String getLocation(); // ��ȡ���ݿ�λ��

	String getState(); // ��ȡ���ݿ�״̬

	void accessDB(); // �������ݿ�

	void setProperty(int index, String property); // �������ݿ���Ϣ
}
