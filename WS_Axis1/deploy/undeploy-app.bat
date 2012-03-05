@echo off
set Cur_Path=D:\workspaces\workspace-ee\WS_Axis1
set Axis_Lib=%Cur_Path%\Web\WEB-INF\lib
set Java_Cmd=java -Djava.ext.dirs=%Axis_Lib%
set Axis_Servlet=http://localhost:8080/axis1/servlet/AxisServlet
%Java_Cmd% org.apache.axis.client.AdminClient -l%Axis_Servlet% %Cur_Path%\Web\WEB-INF\undeploy-app.wsdd
pause