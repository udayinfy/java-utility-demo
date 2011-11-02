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
			// �������ǹؼ���get��������Ҫ�������������ֻ��new�����������鴫��
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
		}// �ݹ�parse

		return obj;
	}

}