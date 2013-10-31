package gh.tdd

import spock.lang.*

class FileProcessorSpec extends Specification {

    def "read folder"() {
        setup:
            IFileReader fileReader = Mock()
            IFileProcessingStrategy fileProcessingStrategy1 = Mock()
            IFileProcessingStrategy fileProcessingStrategy2 = Mock()
            FileProcessor fileProcessor = new FileProcessor(fileReader, [fileProcessingStrategy1, fileProcessingStrategy2])
            def folder = 'asdasd'
            File file = new File('1')
            List<File> files = [file]

        when:
            fileProcessor.run(folder)

        then:
            1 * fileReader.readFolder(folder) >> files
            1 * fileProcessingStrategy1.accept(file) >> true
            1 * fileProcessingStrategy1.process(file)
            1 * fileProcessingStrategy2.accept(file) >> false
            0 * fileProcessingStrategy2.process(file)
    }

}
