package model;

public class ProductServiceImpl implements ProductService {

    Product product = Product.getInstancia();

    @Override
    public Boolean productExist(String product) {
        return this.product.getStock().containsKey(product);
    }

    @Override
    public int quantityProducts(String product) {
        return this.product.getStock().getOrDefault(product, 0);
    }

    @Override
    public Boolean discountProductOfQuantity(String product, int quantity) {
        if (!productExist(product) || quantityProducts(product) < quantity) {
            return false;
        }
        this.product.getStock().put(product,quantityProducts(product) - quantity);
        return true;
    }
}
