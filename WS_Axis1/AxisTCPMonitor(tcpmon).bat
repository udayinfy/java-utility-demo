set Axis_Lib=D:\Workspaces\workspace-ee\WS_Axis1\Web\WEB-INF\lib
set Java_Cmd=java -Djava.ext.dirs=%Axis_Lib%
set Axis_Servlet=http://localhost:8080/axis1/servlet/AxisServlet
%Java_Cmd% org.apache.axis.client.AdminClient -l%Axis_Servlet% D:\Workspaces\workspace-ee\WS_Axis1\Web\WEB-INF\deploy-monitor.wsdd
pause