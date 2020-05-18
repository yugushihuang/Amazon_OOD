public abstract class Entry implements IEntry{
    protected String name;

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }
}
