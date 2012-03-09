@echo off
@echo tcp monitor...
set Axis_Lib=D:\Workspaces\workspace-ee\WS_Axis1\Web\WEB-INF\lib
set Java_Cmd=java -Djava.ext.dirs=%Axis_Lib%
%Java_Cmd% org.apache.axis.utils.tcpmon
