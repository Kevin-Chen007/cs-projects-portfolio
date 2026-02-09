

public class specialLocation extends location
{
    private int price;
    private store shop;
    private trail mainRunner = new trail();
    public specialLocation(int multiplier){
        super();
        price = multiplier;
    }

    //use when at the mall
    public void simOfSpecial()
    {
        int money = mainRunner.getMoney();
        shop = new store();
        mainRunner.setMoney(shop.storeRun(money, price));
    }
}

