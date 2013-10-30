package gh

import spock.lang.*

class FileProcessorSpec extends Specification {

    @Unroll
    def "maximum of two numbers #a and #b"(int a, int b, int c) {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        1 | 3 | 3
        7 | 4 | 7
        0 | 0 | 0
    }

}
