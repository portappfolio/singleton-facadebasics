import model.CreditCardService;
import model.CreditCardServiceImpl;
import model.ProductService;
import model.ProductServiceImpl;

public class StoreFacadeImpl implements StoreFacede{

    private final ProductService productService = new ProductServiceImpl();

    private final CreditCardService creditCardService = new CreditCardServiceImpl();
    @Override
    public void buy(String product, int quantity, String creditCard, int value) {

        if(!creditCardService.creditCardExist(creditCard)){
            System.out.println("Credit card doesn´t exist");
            return;
        }

        if(creditCardService.balanceCreditCard(creditCard) == 0 || creditCardService.balanceCreditCard(creditCard) < value){
            System.out.println("Card without balance");
            return;
        }

        if(!productService.productExist(product)){
            System.out.println("Product doesn´t exist");
            return;
        }

        if(productService.quantityProducts(product) == 0 || productService.quantityProducts(product) < quantity){
            System.out.println("There is not stock available");
            return;
        }

        creditCardService.discountValueCreditCard(creditCard,value);

        productService.discountProductOfQuantity(product,quantity);

        int newProductStock = productService.quantityProducts(product);
        int newCreditCardBalance = creditCardService.balanceCreditCard(creditCard);

        System.out.println("Order created successfull");
        System.out.println("New stock of product: ".concat(String.valueOf(newProductStock)));
        System.out.println("New balance of credit card: ".concat(String.valueOf(newCreditCardBalance)));


    }
}
