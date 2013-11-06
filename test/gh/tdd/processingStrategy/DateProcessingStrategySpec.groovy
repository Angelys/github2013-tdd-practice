package gh.tdd.processingStrategy

import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: bogdan
 * Date: 10/31/13
 * Time: 7:46 PM
 * To change this template use File | Settings | File Templates.
 */

class DateProcessingStrategySpec extends Specification {

    def "check accept logic"(String fileName, Boolean result) {
        setup:
            DateProcessingStrategy strategy = new DateProcessingStrategy()

        expect:
            result == strategy.accept(['getFileName': {return fileName}])

        where:
            fileName     || result
            "1.txt"      || false
            "a_1.txt"    || false
            "1_1.txt"   || false
            "d_1.txt"   || true
    }

    def "should rename file"() {
        setup:
            DateProcessingStrategy strategy = new DateProcessingStrategy()
            def file = ['rename': {throw new Exception()}]
        when:
            strategy.process(file)

        then:
            thrown(Exception)
    }

    def "process file"() {
        setup:
            DateProcessingStrategy strategy = new DateProcessingStrategy()
            IDate date = Mock()
            strategy.setDate(date)
            def file = ['rename': {}, getContent: {return ""}, write: {}]

        when:
            strategy.process(file)

        then:
        //How can i properly mock this ? 0.o
            1 * date.getCurrentDate()

    }
}
