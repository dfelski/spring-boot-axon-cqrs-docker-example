package peanuts.web;

class TakeOutDTO {

    private int amount;

    private TakeOutDTO(){}

    void setAmount(int amount) {
        this.amount = amount;
    }

    int getAmount() {
        return amount;
    }
}
