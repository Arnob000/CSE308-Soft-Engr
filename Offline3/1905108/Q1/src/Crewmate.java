interface Crewmate{
    void setType(int n);
    int getType();
    void study();
    void maintenance();
}

class Crew implements Crewmate{
    String name;
    int type;
    Crew(String n){
        name="Crew "+n;
    }

    public void setType(int n){
        type=n;
    }

    public int getType(){
        return type;
    }
    @Override
    public void study() {
        System.out.println(name+" Studying the interstellar object");
    }

    @Override
    public void maintenance() {
        System.out.println(name+" Doing Maintenance of the spaceship");
    }
}
