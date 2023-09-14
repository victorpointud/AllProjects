
package solidexample;

import java.util.Scanner;

/**
 *
 * @author victorpointud
 */

public class I2 {
    
    public interface IReader {
        String read();
    }

    public class KeyboardReader implements IReader {
        public String read() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingresa el texto que desee:");
            return scanner.nextLine();
        }
    }

    public interface IWriter {
        void write(String message);
    }

    public class ConsoleWriter implements IWriter {
        public void write(String message) {
            System.out.println(message);
        }
    }

    public class TextEditor {
        private IReader reader;
        private IWriter writer;

        public TextEditor(IReader reader, IWriter writer) {
            this.reader = reader;
            this.writer = writer;
        }

        public void edit() {
            String text = reader.read();
            String editedText = text.toUpperCase();
            writer.write(editedText);
        }
    }

}
