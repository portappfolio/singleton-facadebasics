package model;

public interface ProductService {

    public Boolean productExist(String product);

    public int quantityProducts(String product);

    public Boolean discountProductOfQuantity(String product, int quantity);
}
