package factory.simplefactory;

/*
 * �û�
 */
public class Magnate {
	
	public static void main(String[] args) {
		
		try {
			Car car = Driver.driverCar("Benz");
			car.drive();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}


//1) �������ɫ�����Ǳ�ģʽ�ĺ��ģ�����һ������ҵ�߼����ж��߼�����java����������һ��������ʵ�֡� 
//
//2) �����Ʒ��ɫ����һ���Ǿ����Ʒ�̳еĸ������ʵ�ֵĽӿڡ���java���ɽӿڻ��߳�������ʵ�֡� 
//
//3) �����Ʒ��ɫ���������������Ķ�����Ǵ˽�ɫ��ʵ������java����һ��������ʵ�֡� 