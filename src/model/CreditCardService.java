package model;

public interface CreditCardService {

    public Boolean creditCardExist(String creditCard);

    public int balanceCreditCard(String creditCard);

    public Boolean discountValueCreditCard(String creditCard, int quantity);
}
