class Director{
    Builder newPC;

    public void Build(Builder builder){
        newPC=builder;
        newPC.addBase();
    }
    public void addPatty(){
        newPC.addPatty();
    }
    public void addCheese(){
        newPC.addCheese();
    }
    public void addBBQ(){
        newPC.addBBQ();
    }
    public void addSalad(){
        newPC.addSalad();
    }
    public Builder getNewPC(){
        return newPC;
    }
}
