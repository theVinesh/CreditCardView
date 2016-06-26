package xyz.vinesh.creditcardview;

/**
 * Created by vineshraju on 26/6/16.
 */

public class Card {
    public static final String NAME_KEY = "xyz.vinesh.NAME", NUMBER_KEY = "xyz.vinesh.NUMBER", CVV_KEY = "xyz.vinesh.CVV", EXPIRY_KEY = "xyz.vinesh.EXPIRY";
    private String cardHolderName, cardNumber, expiry, cvv;

    public Card(String cardHolderName, String cardNumber, String cvv, String expiry) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiry = expiry;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
}
