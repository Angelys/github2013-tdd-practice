package gh.tdd

class FileProcessor implements IFileProcessor {

    IFileReader fileReader
    List<IFileProcessingStrategy> fileProcessingStrategyList

    FileProcessor(IFileReader fileReader, List<IFileProcessingStrategy> fileProcessingStrategyList) {
        this.fileReader = fileReader
        this.fileProcessingStrategyList = fileProcessingStrategyList
    }

    public void run(String folderPath) {
        List<File> files = fileReader.readFolder(folderPath)
        files.each { file ->
            fileProcessingStrategyList.each { processor ->
                if (processor.accept(file)) {
                    processor.process(file)
                }
            }
        }
    }
}
