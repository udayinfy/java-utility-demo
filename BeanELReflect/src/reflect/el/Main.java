package reflect.el;

public class Main {

	public static void main(String[] args) {
		UserBean bean = new UserBean();
		bean.setName("John Abruzzi");
		bean.setNick("Abruzzi");
		bean.setAge(24);

		AddressBean addr = new AddressBean();
		addr.setZip("0086");
		addr.setStreet("Bell Street #12");
		bean.setAddress(addr);

		System.out.println(BeanParser.doParse(bean, "bean.address.street"));
		System.out.println(BeanParser.doParse(bean, "bean.address.zip"));
		System.out.println(BeanParser.doParse(bean, "bean.name"));
		System.out.println(BeanParser.doParse(bean, "bean.nick"));
		System.out.println(BeanParser.doParse(bean, "bean.age"));
	}
}
