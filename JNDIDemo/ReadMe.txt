 
	JNDI技术是Java EE规范中的一个重要“幕后”角色，它为Java EE容器、
 组件提供者和应用程序之间提供了桥梁作用：Java EE容器同时扮演JNDI
 提供者角色，组件提供者将某个服务的具体实现部署到容器上，应用程序
 通过标准的JNDI接口就可以从容器上发现并使用服务，而不用关心服务的
 具体实现是什么，它的具体位置在哪里。

	下面以一个常见的J2EE应用场景来看四种角色（组件接口、容器、组件
提供者、应用程序）是如何围绕JNDI来发挥作用的：

组件接口
	数据源DataSource是一种很常见的服务。我们通常将组件接口绑定到容器
	的Context上供客户调用。

Java EE容器
    Tomcat是一种常见的Java EE容器，其他的还有JBoss,WebLogic，它们
	同时也实现了JNDI提供者规范。容器通常提供一个JNDI注入场所供加入组件的
	具体实现，比如Tomcat中的Server.xml配置文件。
  
组件提供者
	众多数据库厂商提供了DataSource的实现，比如OracleDataSource，
	MySQLDataSource，XXXDataSource等。我们将该实现的部署到容器中：
	将一系列jar加入classpath中，在Server.xml中配置DataSource实现，如：
	<Resource name="jdbc/MyDB" auth="Container" type="javax.sql.DataSource" ..../> 

应用程序
	一个JSP/Servlet应用程序。通过JNDI接口使用DataSource服务，如：
	Context initContext = new InitialContext();
	Context envContext  = (Context)initContext.lookup("java:/comp/env");
	DataSource ds = (DataSource)envContext.lookup("jdbc/MyDB");

