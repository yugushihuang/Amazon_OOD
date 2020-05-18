public class ExtensionFilter implements IFilter {
    public boolean isValid(SearchParams params, File file){
        if(params.extension==null) return true;
        return file.getExtension().equals(params.extension);
    }
}
