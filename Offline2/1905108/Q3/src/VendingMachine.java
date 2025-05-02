public class VendingMachine {
    State initialState;
    State soldState;
    State outOfProductState;
    State muchAmountState;
    State lessAmountState;

    State state;
    int productCount;
    int productPrice;
    int money;

    public VendingMachine(int n){
        productCount=n;
        initialState =new Initial(this);
        soldState=new Sold(this);
        outOfProductState= new OutOfProduct(this);
        muchAmountState = new ExtraMoney(this);
        lessAmountState = new LessMoney(this);

        double val = Math.random() * 500 + 250;
        productPrice = (int)Math.round(val);

        if (productCount>0)
            state=initialState;
        else
            state=outOfProductState;

        money=0;
    }

    public void insertMoney(int money){
        this.money+=money;
        state.insert();
    }

    public void returnMoney(){
        state.retMoney();
    }

    public void returnExtraMoney(){
        state.retExtraMoney();
    }

    public void dropProduct(){
        state.dropProduct();
    }

    public void refill(int n){state.refill(n);}

    public void releaseProduct(){
        System.out.println("Product dropped");
        System.out.println("Price: "+productPrice);
        System.out.println();
        money=0;
        if (productCount>0)
            productCount-=1;
    }

    public void setProductCount(int n){
        productCount=n;
    }
    public int getProductCount(){
        return productCount;
    }

    public int getProductPrice(){return productPrice;}

    public int getEnteredAmount(){
        return money;
    }

    public void moneyUsed(){
        money=0;
    }
    public void setState(State s){
        state=s;
    }
    public State getState(){return state;}

    public State getInitialState(){return initialState;}
    public State getSoldState(){return soldState;}
    public State getOutOfProductState(){return outOfProductState;}
    public State getMuchAmountState(){return muchAmountState;}
    public State getLessAmountState(){return lessAmountState;}
}
