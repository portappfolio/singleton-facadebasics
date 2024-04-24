package model;

public class CreditCardServiceImpl implements CreditCardService{

    CreditCard creditCard = CreditCard.getInstancia();
    @Override
    public Boolean creditCardExist(String creditCard) {
        return this.creditCard.getStockOfCards().containsKey(creditCard);
    }

    @Override
    public int balanceCreditCard(String creditCard) {
        return this.creditCard.getStockOfCards().getOrDefault(creditCard, 0);
    }

    @Override
    public Boolean discountValueCreditCard(String creditCard, int quantity) {
        if (!creditCardExist(creditCard) || balanceCreditCard(creditCard) < quantity) {
            return false;
        }
        this.creditCard.getStockOfCards().put(creditCard,balanceCreditCard(creditCard) - quantity);
        return true;
    }
}
