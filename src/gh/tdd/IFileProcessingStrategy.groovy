package gh.tdd

/**
 * Created with IntelliJ IDEA.
 * User: bogdan
 * Date: 10/31/13
 * Time: 7:29 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IFileProcessingStrategy {

    public Boolean accept(def file)
    public void process(def file)

}