//abstraction
abstract class Orange {
    protected OS os;
    protected String name;

    public void storeFile(){
        os.storeFile();
    }

    public void interact(){
        os.interact();
    }

    public void communicate(){
        os.communicate();
    }

    public void setOs(OS d) {
        this.os = d;
    }
}

class Notebook extends Orange{
    Notebook(OS d){
        name="Notebook";
        this.os=d;
    }

}

class Smartphone extends Orange{
    Smartphone(OS d){
        name="Smartphone";
        this.os=d;
    }

}