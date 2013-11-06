package gh.tdd.processingStrategy

/**
 * Created with IntelliJ IDEA.
 * User: angelys
 * Date: 11/6/13
 * Time: 11:39 PM
 * To change this template use File | Settings | File Templates.
 */
interface IMatrixCounter {

    Integer countDiagonal(ArrayList<ArrayList<Float>> matrix)
    Integer countBackDiagonal(ArrayList<ArrayList<Float>> matrix)

}
