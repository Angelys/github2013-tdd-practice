package gh.tdd.processingStrategy

import gh.tdd.IFileProcessingStrategy

/**
 * Created with IntelliJ IDEA.
 * User: bogdan
 * Date: 10/31/13
 * Time: 7:52 PM
 * To change this template use File | Settings | File Templates.
 */
class WordProcessingStrategy implements IFileProcessingStrategy {

    private static final String FILE_PREFIX = "a_"

    Boolean accept(def file) {
        return file.getFileName().startsWith(FILE_PREFIX)
    }

    void process(file) {
        String content = file.getContent()
        Integer result = content.count("a")
        file.write(result)
        file.rename()
    }
}
