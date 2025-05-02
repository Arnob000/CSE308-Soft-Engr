interface State {
    public void insert();
    public void retMoney();
    public void retExtraMoney();
    public void dropProduct();
    public void refill(int n);
}

class Initial implements State{
    VendingMachine vm;

    Initial(VendingMachine vm){
        this.vm=vm;
    }
    @Override
    public void insert(){
        System.out.println("Total Amount entered: "+vm.getEnteredAmount()+" TK");
        if(vm.getProductPrice()==vm.getEnteredAmount()){
            vm.moneyUsed();
            vm.setState(vm.getSoldState());
        }
        else if(vm.getProductPrice()<vm.getEnteredAmount()){
            vm.setState(vm.getMuchAmountState());
        }
        else{
            System.out.println("More money needed");
            System.out.println("Give "+(vm.getProductPrice()-vm.getEnteredAmount())+" TK more");
            vm.setState(vm.getLessAmountState());
        }
    }
    @Override
    public void retMoney(){
        System.out.println("You have not give any money");
    }
    @Override
    public void retExtraMoney(){
        System.out.println("Nothing to return");
    }
    @Override
    public void dropProduct(){
        System.out.println("No product bought");
    }
    @Override
    public void refill(int n){
        System.out.println("Already have enough product");
    }

}

class Sold implements State{
    VendingMachine vm;

    Sold(VendingMachine vm){
        this.vm=vm;
    }
    @Override
    public void insert(){
        System.out.println("A product is coming... ");
        System.out.println("Money can't be inserted");
        System.out.println("Amount "+vm.getEnteredAmount()+" returned");
        vm.moneyUsed();
    }
    @Override
    public void retMoney(){
        System.out.println("A product is coming... ");
        System.out.println("You can not take money back");
    }
    @Override
    public void retExtraMoney(){
    }
    
    @Override
    public void dropProduct(){
        vm.releaseProduct();
        if(vm.getProductCount()>0){
            vm.setState(vm.getInitialState());
        }
        else {
            System.out.println("Out of Product, refill");
            vm.setState(vm.getOutOfProductState());
        }
    }

    @Override
    public void refill(int n){
        System.out.println("Already have enough product");
    }
}

class LessMoney implements State{
    VendingMachine vm;

    LessMoney(VendingMachine vm){
        this.vm=vm;
    }
    @Override
    public void insert(){
        System.out.println("Total Amount entered: "+vm.getEnteredAmount()+" TK");
        if(vm.getProductPrice()==vm.getEnteredAmount()){
            vm.moneyUsed();
            vm.setState(vm.getSoldState());
        }
        else if(vm.getProductPrice()<vm.getEnteredAmount()){
            vm.setState(vm.getMuchAmountState());
        }
        else{
            System.out.println("More money needed");
            System.out.println("Give "+(vm.getProductPrice()-vm.getEnteredAmount())+" TK more");
        }
    }

    @Override
    public void retMoney(){
        System.out.println("Amount returned: "+vm.getEnteredAmount());
        vm.moneyUsed();
        vm.setState(vm.getInitialState());
    }
    @Override
    public void retExtraMoney(){
    }
    @Override
    public void dropProduct(){
        System.out.println("Process ongoing...");
    }
    @Override
    public void refill(int n){
        System.out.println("Already have enough product");
    }

}

class ExtraMoney implements State{
    VendingMachine vm;

    ExtraMoney(VendingMachine vm){
        this.vm=vm;
    }
    @Override
    public void insert(){
        System.out.println("You already entered enough money.\n No more needed");
        System.out.println("Amount returned : "+(vm.getEnteredAmount()-vm.getProductPrice()));
        vm.moneyUsed();
        vm.setState(vm.getSoldState());
    }
    @Override
    public void retMoney(){
    }
    @Override
    public void retExtraMoney(){
        System.out.println("You entered extra money");
        System.out.println("Money returned: "+(vm.getEnteredAmount()-vm.getProductPrice()));
        vm.moneyUsed();
        vm.setState(vm.getSoldState());
    }
    @Override
    public void dropProduct(){
        System.out.println("A product is coming...");
    }

    @Override
    public void refill(int n){
        System.out.println("Already have enough product");
    }
}

class OutOfProduct implements State{
    VendingMachine vm;

    OutOfProduct(VendingMachine vm){
        this.vm=vm;
    }
    @Override
    public void insert(){
        System.out.println("Vending machine is out of product");
        System.out.println("Money entered: "+vm.getEnteredAmount());
        System.out.println("Money returned: "+vm.getEnteredAmount());
        vm.moneyUsed();
    }
    @Override
    public void retMoney(){
        System.out.println("No money given");
    }
    @Override
    public void retExtraMoney(){
        System.out.println("No money given");
    }
    @Override
    public void dropProduct(){
        System.out.println("No product bought");
    }

    @Override
    public void refill(int n) {
        vm.setProductCount(n);
        System.out.println("Vending machine is back at work");
        vm.setState(vm.getInitialState());
    }
}
