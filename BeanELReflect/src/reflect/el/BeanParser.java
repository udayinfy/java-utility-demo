package reflect.el;

import java.lang.reflect.Method;

public class BeanParser {

	private static String getMethodName(String property, String prefix) {
		String prop = Character.toUpperCase(property.charAt(0)) + property.substring(1);

		String methodName = prefix + prop;

		return methodName;
	}

	private static Object parse(Object bean, String expr) {
		Class beanClass = bean.getClass();

		Method method = null;
		Object result = null;

		try {
			// 这两步是关键，get方法不需要传入参数，所以只是new出两个空数组传入
			method = beanClass.getMethod(getMethodName(expr, "get"), new Class[] {});
			result = method.invoke(bean, new Object[] {});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	public static Object doParse(Object bean, String expr) {
		String keys[] = expr.split("\\.");

		Object obj = null;

		for (int i = 1; i < keys.length; i++) {
			obj = parse(bean, keys[i]);
			bean = obj;
		}// 递归parse

		return obj;
	}

}