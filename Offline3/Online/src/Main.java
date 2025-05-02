public class Main {
    public static void main(String[] args) {
        OS os=new Windoors();
        OS o=new Linus();
        Notebook note=new Notebook(os);
        note.storeFile();
        note.communicate();
        note.interact();
        note.setOs(o);
        note.storeFile();
        note.communicate();
        note.interact();

    }
}
