 
	JNDI������Java EE�淶�е�һ����Ҫ��Ļ�󡱽�ɫ����ΪJava EE������
 ����ṩ�ߺ�Ӧ�ó���֮���ṩ���������ã�Java EE����ͬʱ����JNDI
 �ṩ�߽�ɫ������ṩ�߽�ĳ������ľ���ʵ�ֲ��������ϣ�Ӧ�ó���
 ͨ����׼��JNDI�ӿھͿ��Դ������Ϸ��ֲ�ʹ�÷��񣬶����ù��ķ����
 ����ʵ����ʲô�����ľ���λ�������

	������һ��������J2EEӦ�ó����������ֽ�ɫ������ӿڡ����������
�ṩ�ߡ�Ӧ�ó��������Χ��JNDI���������õģ�

����ӿ�
	����ԴDataSource��һ�ֺܳ����ķ�������ͨ��������ӿڰ󶨵�����
	��Context�Ϲ��ͻ����á�

Java EE����
    Tomcat��һ�ֳ�����Java EE�����������Ļ���JBoss,WebLogic������
	ͬʱҲʵ����JNDI�ṩ�߹淶������ͨ���ṩһ��JNDIע�볡�������������
	����ʵ�֣�����Tomcat�е�Server.xml�����ļ���
  
����ṩ��
	�ڶ����ݿ⳧���ṩ��DataSource��ʵ�֣�����OracleDataSource��
	MySQLDataSource��XXXDataSource�ȡ����ǽ���ʵ�ֵĲ��������У�
	��һϵ��jar����classpath�У���Server.xml������DataSourceʵ�֣��磺
	<Resource name="jdbc/MyDB" auth="Container" type="javax.sql.DataSource" ..../> 

Ӧ�ó���
	һ��JSP/ServletӦ�ó���ͨ��JNDI�ӿ�ʹ��DataSource�����磺
	Context initContext = new InitialContext();
	Context envContext  = (Context)initContext.lookup("java:/comp/env");
	DataSource ds = (DataSource)envContext.lookup("jdbc/MyDB");

