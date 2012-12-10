package demo.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

public class LoggingBean implements BeanNameAware, InitializingBean{
	private String name;


	public void run() {
		System.out.println("Bean name is'" + this.name + "'.printed by method run");
	}

	@Override
	public void setBeanName(String name) {
		this.name = name;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("The afterPropertiesSet method is invoked.");
	}
}