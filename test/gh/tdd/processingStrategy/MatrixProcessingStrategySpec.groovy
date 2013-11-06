package gh.tdd.processingStrategy

import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: bogdan
 * Date: 10/31/13
 * Time: 7:46 PM
 * To change this template use File | Settings | File Templates.
 */

class MatrixProcessingStrategySpec extends Specification {

    def "check accept logic"(String fileName, Boolean result) {
        setup:
            WordProcessingStrategy strategy = new WordProcessingStrategy()

        expect:
            result == strategy.accept(['getFileName': {return fileName}])

        where:
            fileName     || result
            "1.txt"      || true
            "a_1.txt"    || false
            "aa_1.txt"   || false
            "ba_1.txt"   || false
    }

    def "should rename file"() {
        setup:
            WordProcessingStrategy strategy = new WordProcessingStrategy()
            def file = ['rename': {throw new Exception()}]
        when:
            strategy.process(file)

        then:
            thrown(Exception)
    }

    def "generate matrix"() {
        setup:
            MatrixProcessingStrategy strategy = new MatrixProcessingStrategy()
            IMatrixGenerator matrixGenerator = Mock()
            strategy.setMatrixGenerator(matrixGenerator)

            def file = ['rename': {}, getContent: {return content}, write: {processResult = it}]

        when:
            strategy.process(file)

        then:
            1*matrixGenerator.generateMatrix()

    }

    def "count and write matrix"() {
        setup:
            MatrixProcessingStrategy strategy = new MatrixProcessingStrategy()
            def diagonal = 3,backDiagonal = 8 , processResult
            IMatrixCounter matrixCounter = new IMatrixCounter() {
                @Override
                Integer countDiagonal(ArrayList<ArrayList<Float>> matrix) {
                    diagonal
                }

                @Override
                Integer countBackDiagonal(ArrayList<ArrayList<Float>> matrix) {
                   backDiagonal
                }
            }
            strategy.setMatrixCounter(matrixCounter)

        def file = ['rename': {}, getContent: {}, write: {processResult = it}]

        when:
            strategy.process(file)

        then:
            processResult == diagonal+backDiagonal

    }
}
