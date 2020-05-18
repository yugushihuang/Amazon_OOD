public class NameFilter implements IFilter {
    public boolean isValid(SearchParams params, File file){
        if(params.name==null) return true;
        return file.getName().equals(params.name);
    }
}
