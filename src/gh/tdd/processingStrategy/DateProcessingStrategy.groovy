package gh.tdd.processingStrategy

import gh.tdd.IFileProcessingStrategy

/**
 * Created with IntelliJ IDEA.
 * User: bogdan
 * Date: 10/31/13
 * Time: 7:52 PM
 * To change this template use File | Settings | File Templates.
 */
class DateProcessingStrategy implements IFileProcessingStrategy {

    private static final String FILE_PREFIX = "d_"

    private date = new IDate() {
        @Override
        String getCurrentDate() {
            return new Date().format("yyyy-MM-dd HH-mm-ss")
        }
    };

    Boolean accept(def file) {
        return file.getFileName().startsWith(FILE_PREFIX)
    }

    void process(file) {
        String result = date.getCurrentDate()
        file.write(result)
        file.rename()
    }

    void setDate(date) {
        this.date = date
    }
}
