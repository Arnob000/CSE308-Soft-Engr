interface PCBuilder {
    void addBase();
    void addProcessor();
    void addExtra();
    void addRam(String ram);
    void addGCard(String gcard);

    PC getPC();
}

class pc1builder implements PCBuilder {
    private PC pc=new PC();

    public void addBase(){
        pc.addItem(new baseItem());
    }

    public void addProcessor(){
        pc.addItem(new Pro1());
    }
    public void addExtra(){
        pc.addItem(new CPUCooler());
    }
    public void addRam(String ram){
        if(ram.equalsIgnoreCase("v1"))
            pc.addItem(new v1RAM());
        else if (ram.equalsIgnoreCase("v2")) {
            pc.addItem(new v2RAM());
        }
    }
    public void addGCard(String gcard){
        if(gcard.equalsIgnoreCase("v1"))
            pc.addItem(new v1GCard());
        else if (gcard.equalsIgnoreCase("v2")) {
            pc.addItem(new v2GCard());
        }
    }
    public PC getPC(){
        return pc;
    }
}

class pc2builder implements PCBuilder {
    private PC pc=new PC();

    public void addBase(){
        pc.addItem(new baseItem());
    }

    public void addProcessor(){
        pc.addItem(new Pro2());
    }
    public void addExtra(){
        pc.addItem(new LiquidCooler());
    }
    public void addRam(String ram){
        if(ram.equalsIgnoreCase("v1"))
            pc.addItem(new v1RAM());
        else if (ram.equalsIgnoreCase("v2")) {
            pc.addItem(new v2RAM());
        }
    }
    public void addGCard(String gcard){
        if(gcard.equalsIgnoreCase("v1"))
            pc.addItem(new v1GCard());
        else if (gcard.equalsIgnoreCase("v2")) {
            pc.addItem(new v2GCard());
        }
    }
    public PC getPC(){
        return pc;
    }
}

class pc3builder implements PCBuilder {
    private PC pc=new PC();

    public void addBase(){
        pc.addItem(new baseItem());
    }

    public void addProcessor(){
        pc.addItem(new Pro3());
    }
    public void addExtra(){
        pc.addItem(new DVDDrive());
    }
    public void addRam(String ram){
        if(ram.equalsIgnoreCase("v1"))
            pc.addItem(new v1RAM());
        else if (ram.equalsIgnoreCase("v2")) {
            pc.addItem(new v2RAM());
        }
    }
    public void addGCard(String gcard){
        if(gcard.equalsIgnoreCase("v1"))
            pc.addItem(new v1GCard());
        else if (gcard.equalsIgnoreCase("v2")) {
            pc.addItem(new v2GCard());
        }
    }
    public PC getPC(){
        return pc;
    }
}

class pc4builder implements PCBuilder {
    private PC pc=new PC();

    public void addBase(){
        pc.addItem(new baseItem());
    }

    public void addProcessor(){
        pc.addItem(new Pro4());
    }
    public void addExtra(){
    }
    public void addRam(String ram){
        if(ram.equalsIgnoreCase("v1"))
            pc.addItem(new v1RAM());
        else if (ram.equalsIgnoreCase("v2")) {
            pc.addItem(new v2RAM());
        }
    }
    public void addGCard(String gcard){
        if(gcard.equalsIgnoreCase("v1"))
            pc.addItem(new v1GCard());
        else if (gcard.equalsIgnoreCase("v2")) {
            pc.addItem(new v2GCard());
        }
    }
    public PC getPC(){
        return pc;
    }
}

