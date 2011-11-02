package ui.g.event;

import java.beans.PropertyChangeEvent; //事件  
import java.beans.PropertyChangeListener; //监听  
import java.beans.PropertyChangeSupport; //支持  

/**
 * 
 * @author maxin
 */
public class PropertyBean { // 源组件（bean）

	private String demoName;

	// 这是一个实用工具类，支持绑定 (bound) 属性的 bean 可以使用该类。
	// 可以使用此类的实例作为 bean 的成员字段，并将各种工作委托给它。
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
		// 发布监听事件
		firePropertyChange("demoName", oldValue, demoName);

	}

	// 本地方法
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.addPropertyChangeListener(listener); // 系统方法
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listeners.removePropertyChangeListener(listener); // 系统方法
	}

	/**
	 * 触发属性改变的事件
	 */
	protected void firePropertyChange(String prop, Object oldValue,
			Object newValue) {
		listeners.firePropertyChange(prop, oldValue, newValue); // 系统方法
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