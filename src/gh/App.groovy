package gh

import gh.tdd.FileProcessor
import gh.tdd.IFileProcessor

class App {

    static IFileProcessor fileProcessor = new FileProcessor()

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException()
        }

        fileProcessor.run(args[0])
    }

    public static setFileProcessor(IFileProcessor fileProcessor) {
        this.fileProcessor = fileProcessor
    }
}



