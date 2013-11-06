package gh.tdd.processingStrategy

import gh.tdd.IFileProcessingStrategy

/**
 * Created with IntelliJ IDEA.
 * User: bogdan
 * Date: 10/31/13
 * Time: 7:52 PM
 * To change this template use File | Settings | File Templates.
 */
class MatrixProcessingStrategy implements IFileProcessingStrategy {

    private static final String FILE_PREFIX = "1_"

    private IMatrixCounter matrixCounter = new IMatrixCounter() {
        @Override
        Integer countDiagonal(ArrayList<ArrayList<Float>> matrix) {
            //TODO
            return 5
        }

        @Override
        Integer countBackDiagonal(ArrayList<ArrayList<Float>> matrix) {
            //TODO
            return 10
        }
    }

    //Dummy
    private IMatrixGenerator matrixGenerator = new IMatrixGenerator() {
        @Override
        void generateMatrix() {
        }

        @Override
        ArrayList<ArrayList<Float>> getMatrix() {
            return new ArrayList<ArrayList<Float>>();
        }

        @Override
        String dumpMatrix() {
            return ""
        }
    }

    Boolean accept(def file) {
        return file.getFileName().startsWith(FILE_PREFIX)
    }

    void setMatrixCounter(IMatrixCounter matrixCounter) {
        this.matrixCounter = matrixCounter
    }

    void setMatrixGenerator(IMatrixGenerator matrixGenerator) {
        this.matrixGenerator = matrixGenerator
    }

    void process(file) {
        matrixGenerator.generateMatrix()
        Float diagonal = matrixCounter.countDiagonal(matrixGenerator.getMatrix())
        Float backDiagonal = matrixCounter.countBackDiagonal(matrixGenerator.getMatrix())
        file.write(diagonal+backDiagonal)
        file.rename()
    }
}
