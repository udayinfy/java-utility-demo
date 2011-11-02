package _factory.enumimpl;

/**
 * ²úÆ·Ã¶¾Ù
 */
public enum ProductType {
    
    ProjectType1("_factory.enumimpl.ProductType1"),
    
    ProjectType2("_factory.enumimpl.ProductType2");
    
    private String value = "";
    
    private ProductType() {}
    
    private ProductType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}