class Serving{
    public CoffeerTongCoffee getCoffee(String name){
        if(name.equalsIgnoreCase("1"))
            return new Americano();
        else if (name.equalsIgnoreCase("2"))
            return new Espresso();
        else if(name.equalsIgnoreCase("3"))
            return new Cappuccino();
        else if(name.equalsIgnoreCase("4"))
            return new Mocha();
        else
            return null;
    }
}
abstract class CoffeerTongCoffee {
    protected Coffee c;
    protected String name;
    private void printDescription(){
        System.out.println(c.getDescription()+"Cost:\t"+c.cost());
    }
    public double cost(){
        return c.cost();
    }

    public void print() {
        System.out.println(name);
        System.out.println("------------------------------");
        printDescription();
        System.out.println();
    }
}

class Americano extends CoffeerTongCoffee{
    public Americano(){
        name="Americano";
        c= new BlackCoffee();   //concrete
        c=new CoffeeBeans(c);   //decorator
    }
}

class Espresso extends CoffeerTongCoffee{
    public Espresso(){
        name="Espresso";
        c= new BlackCoffee();
        c=new DairyCream(c);
    }
}

class Cappuccino extends CoffeerTongCoffee{
    public Cappuccino(){
        name="Cappuccino";
        c= new MilkCoffee();
        c=new Cinnamon(c);
    }
}

class Mocha extends CoffeerTongCoffee{
    public Mocha(){
        name="Mocha";
        c= new MilkCoffee();
        c=new Chocolate(c);
    }
}