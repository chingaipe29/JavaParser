import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.YamlPrinter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ptree {
    public static void main(String[] args) throws IOException {
        File file = new File("Stuff.java");
        JavaParser parser = new JavaParser();
        CompilationUnit cu = parser.parse(new FileInputStream(file)).getResult().get();

        YamlPrinter printer = new YamlPrinter(true); // Pass true to the constructor
        printer.print(cu); // print() returns void, so don't pass its result to println()
    }
}