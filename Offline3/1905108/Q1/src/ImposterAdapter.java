public class ImposterAdapter implements Crewmate{
    Imposter imposter;

    ImposterAdapter(Imposter im){
        this.imposter=im;
        imposter.setName("Crew ( "+imposter.getName()+" )");
    }

    @Override
    public void setType(int n) {
        imposter.setType(n);
    }

    @Override
    public int getType() {
        return imposter.getType();
    }

    @Override
    public void study() {
        System.out.println(imposter.getName()+" Studying the interstellar object");
        System.out.println("Actually...");
        System.out.print("\t");
        imposter.poison();
    }

    @Override
    public void maintenance() {
        System.out.println(imposter.getName()+" Doing Maintenance of the spaceship");
        System.out.println("Actually...");
        System.out.print("\t");
        imposter.damage();
    }
}
