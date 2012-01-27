package _factory.enumimpl;

/**
 * 工厂类及测试
 */
public class Factory {
    private Factory() {}
    public static Product getInstance(ProductType type) {
        String className = type.getValue();
        Product product = null;
        try {
            product = (Product)Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return product;
    }
    
    public static void main(String args[]) {
        Product p1 = Factory.getInstance(ProductType.ProjectType1);
        p1.doSomething();
        Product p2 = Factory.getInstance(ProductType.ProjectType2);
        p2.doSomething();
    }
}