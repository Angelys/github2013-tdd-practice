package gh

import gh.tdd.FileProcessor
import gh.tdd.IFileProcessor
import spock.lang.Specification

class AppSpec extends Specification {

    def "Calling app without parameters"() {
        when:
            App.main([] as String[])

        then:
            thrown(IllegalArgumentException)
    }

    def "Calling App with one parameter"() {
        setup:
            IFileProcessor fileProcessor = Mock()
            App.setFileProcessor(fileProcessor)
            def parameter = 'fooBar'

        when:
            App.main([parameter] as String[])

        then:
            notThrown(IllegalArgumentException)
            1 * fileProcessor.run(parameter)
    }

}
