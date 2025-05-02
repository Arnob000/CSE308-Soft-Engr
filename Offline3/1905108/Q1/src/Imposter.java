interface Imposter {
    public void setName(String n);
    public String getName();
    public void setType(int n);

    public int getType();
    public void poison();
    public void damage();
}

class Monster implements Imposter{
    String name;
    int type;
    Monster(String n){
        name="Monster "+n;
    }

    public void setName(String n){
        name=n;
    }

    public String getName(){
        return name;
    }

    public void setType(int n){
        type=n;
    }

    public int getType(){
        return type;
    }
    @Override
    public void poison() {
        System.out.println(name+" Poisoning the crewmates");
    }

    @Override
    public void damage(){
        System.out.println(name+" Damaging the spaceship");
    }
}