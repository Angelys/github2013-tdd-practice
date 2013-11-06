package gh.tdd.processingStrategy

/**
 * Created with IntelliJ IDEA.
 * User: angelys
 * Date: 11/6/13
 * Time: 11:42 PM
 * To change this template use File | Settings | File Templates.
 */
interface IMatrixGenerator {

    void generateMatrix()

    ArrayList<ArrayList<Float>> getMatrix()

    String dumpMatrix()

}
