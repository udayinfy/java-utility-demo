
1。
MyThread.java 
线程的四个状态

2。
MyThread2.java
现在假设一种情况：线程1与线程2都要访问某个数据区,
并且要求线程1的访问先于线程2, 则这时仅用synchronized
是不能解决问题的。这在Unix或Windows NT中可用Simaphore来实现。
而Java并不提供。在Java中提供的是wait()和notify()机制。