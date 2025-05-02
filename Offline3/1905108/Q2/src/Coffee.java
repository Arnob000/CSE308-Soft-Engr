//Decorator
abstract class Coffee {
    protected String description;
    public String getDescription(){
        return description;
    }

    public abstract double cost();
}

class MilkCoffee extends Coffee{
    public MilkCoffee(){
        description="Base\n\tCoffee Mug\t100tk\n\tMilk\t50tk\n\tCoffee Beans\t30tk\n";
    }

    @Override
    public double cost(){
        return 180;
    }
}

class BlackCoffee extends Coffee{
    public BlackCoffee(){
        description="Base\n\tCoffee Mug\t100tk\n\tWater\n\tCoffee Beans\t30tk\n";
    }

    @Override
    public double cost(){
        return 130;
    }
}

abstract class Decorator extends Coffee{
    protected Coffee coffee;
    public abstract String getDescription();
}

class CoffeeBeans extends Decorator{
    public CoffeeBeans(Coffee c){
        this.coffee=c;
    }

    public String getDescription(){
        return coffee.getDescription()+"Coffee Beans\t30tk\n";
    }

    @Override
    public double cost() {
        return 30+coffee.cost();
    }
}

class DairyCream extends Decorator{
    public DairyCream(Coffee c){
        this.coffee=c;
    }

    public String getDescription(){
        return coffee.getDescription()+"Dairy Cream\t40tk\n";
    }

    @Override
    public double cost() {
        return 40+coffee.cost();
    }
}

class Cinnamon extends Decorator{
    public Cinnamon(Coffee c){
        this.coffee=c;
    }

    public String getDescription(){
        return coffee.getDescription()+"Cinnamon Powder\t50tk\n";
    }

    @Override
    public double cost() {
        return 50+coffee.cost();
    }
}

class Chocolate extends Decorator{
    public Chocolate(Coffee c){
        this.coffee=c;
    }

    public String getDescription(){
        return coffee.getDescription()+"Chocolate sauce\t60tk\n";
    }

    @Override
    public double cost() {
        return 60+coffee.cost();
    }
}
