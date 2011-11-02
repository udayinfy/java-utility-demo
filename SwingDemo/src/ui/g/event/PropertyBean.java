package ui.g.event;

import java.beans.PropertyChangeEvent; //�¼�  
import java.beans.PropertyChangeListener; //����  
import java.beans.PropertyChangeSupport; //֧��  

/**
 * 
 * @author maxin
 */
public class PropertyBean { // Դ�����bean��

	private String demoName;

	// ����һ��ʵ�ù����֧࣬�ְ� (bound) ���Ե� bean ����ʹ�ø��ࡣ
	// ����ʹ�ô����ʵ����Ϊ bean �ĳ�Ա�ֶΣ��������ֹ���ί�и�����
	PropertyChangeSupport listeners = new PropertyChangeSupport(this);

	public PropertyBean() {
		demoName = "initValue";
	}

	public String getDemoName() {
		return demoName;
	}

	public void setDemoName(String demoName) {
		String oldValue = this.demoName;
		this.demoName = demoName;
		// ���������¼�
		firePropertyChange("demoName", oldValue, demoName);

	}

	// ���ط���
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.addPropertyChangeListener(listener); // ϵͳ����
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listeners.removePropertyChangeListener(listener); // ϵͳ����
	}

	/**
	 * �������Ըı���¼�
	 */
	protected void firePropertyChange(String prop, Object oldValue,
			Object newValue) {
		listeners.firePropertyChange(prop, oldValue, newValue); // ϵͳ����
	}

	public static void main(String[] args) {
		PropertyBean beans = new PropertyBean();
		beans.addPropertyChangeListener(new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("OldValue:" + evt.getOldValue());
				System.out.println("NewValue:" + evt.getNewValue());
				System.out.println("tPropertyName:" + evt.getPropertyName());
			}
		});
		beans.setDemoName("test");
	}

}