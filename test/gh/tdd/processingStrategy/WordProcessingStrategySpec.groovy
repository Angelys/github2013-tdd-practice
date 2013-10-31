package gh.tdd.processingStrategy

import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: bogdan
 * Date: 10/31/13
 * Time: 7:46 PM
 * To change this template use File | Settings | File Templates.
 */

class WordProcessingStrategySpec extends Specification {

    def "check accept logic"(String fileName, Boolean result) {
        setup:
            WordProcessingStrategy strategy = new WordProcessingStrategy()

        expect:
            result == strategy.accept(['getFileName': {return fileName}])

        where:
            fileName     || result
            "1.txt"      || false
            "a_1.txt"    || true
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

    def "count characters"(String content, Integer result) {
        setup:
            WordProcessingStrategy strategy = new WordProcessingStrategy()
            def processResult
            def file = ['rename': {}, getContent: {return content}, write: {processResult = it}]

        when:
            strategy.process(file)

        then:
            processResult == result

        where:
            content ||  result
            "aaa"   ||  3
            "agfhsdahdadfh"   ||  3
    }
}
