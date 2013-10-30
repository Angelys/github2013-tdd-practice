package gh

import gh.tdd.FileProcessor

class App {

    public static void main(String[] args) {
        assert args.length > 0

        // DI
        // Pattern command
        // Pattern iterator

        FileProcessor fp = new FileProcessor()
        fp.run(args[0])
    }
}
