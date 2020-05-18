public interface IFilter {
    boolean isValid(SearchParams params, File file);
}
