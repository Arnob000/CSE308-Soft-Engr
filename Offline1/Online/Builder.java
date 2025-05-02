interface Builder {
    void addBase();
    void addPatty();
    void addCheese();
void addBBQ();
void addSalad();
    Burger getBurger();
}

class burgerbuilder implements Builder {
    private Burger pc=new Burger();

    public void addBase(){
        pc.addItem(new Bun());
        pc.addItem(new Bun());
        pc.addItem(new Patty());
    }

    public void addPatty(){
        pc.addItem(new Patty());
    }
    public void addCheese(){
        pc.addItem(new Cheese());
    }
    public void addBBQ(){

            pc.addItem(new BBQ());

    }
    public void addSalad(){
        pc.addItem(new Salad());
    }
    public Burger getBurger(){
        return pc;
    }
}
