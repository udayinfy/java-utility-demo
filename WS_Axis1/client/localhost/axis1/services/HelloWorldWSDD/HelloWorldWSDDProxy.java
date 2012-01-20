package localhost.axis1.services.HelloWorldWSDD;

public class HelloWorldWSDDProxy implements localhost.axis1.services.HelloWorldWSDD.HelloWorldWSDD {
  private String _endpoint = null;
  private localhost.axis1.services.HelloWorldWSDD.HelloWorldWSDD helloWorldWSDD = null;
  
  public HelloWorldWSDDProxy() {
    _initHelloWorldWSDDProxy();
  }
  
  public HelloWorldWSDDProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloWorldWSDDProxy();
  }
  
  private void _initHelloWorldWSDDProxy() {
    try {
      helloWorldWSDD = (new localhost.axis1.services.HelloWorldWSDD.HelloWorldWSDDServiceLocator()).getHelloWorldWSDD();
      if (helloWorldWSDD != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)helloWorldWSDD)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)helloWorldWSDD)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (helloWorldWSDD != null)
      ((javax.xml.rpc.Stub)helloWorldWSDD)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public localhost.axis1.services.HelloWorldWSDD.HelloWorldWSDD getHelloWorldWSDD() {
    if (helloWorldWSDD == null)
      _initHelloWorldWSDDProxy();
    return helloWorldWSDD;
  }
  
  public java.lang.Float add(float a, float b) throws java.rmi.RemoteException{
    if (helloWorldWSDD == null)
      _initHelloWorldWSDDProxy();
    return helloWorldWSDD.add(a, b);
  }
  
  public java.lang.String hello(java.lang.String name) throws java.rmi.RemoteException{
    if (helloWorldWSDD == null)
      _initHelloWorldWSDDProxy();
    return helloWorldWSDD.hello(name);
  }
  
  
}