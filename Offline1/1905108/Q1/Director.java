class Director{
    PCBuilder newPC;

    public void Build(PCBuilder builder){
        newPC=builder;
        newPC.addBase();
        newPC.addProcessor();
        newPC.addExtra();
    }
    public void addRam(String ram){
        newPC.addRam(ram);
    }
    public void addGCard(String gcard){
        newPC.addGCard(gcard);
    }
    public PCBuilder getNewPC(){
        return newPC;
    }
}
