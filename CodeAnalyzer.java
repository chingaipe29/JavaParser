import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class CodeAnalyzer {
    public static void main(String[] args) throws IOException {
        File file = new File("Stuff.java");
        JavaParser parser = new JavaParser();
        CompilationUnit cu = parser.parse(new FileInputStream(file)).getResult().get();

        List<Node> nodes = cu.getNodesByType(Node.class);

        int numVariables = 0;
        int numMethods = 0;
        int numClasses = 0;

        for (Node node : nodes) {
            if (node instanceof VariableDeclarator || node instanceof VariableDeclarationExpr) {
                numVariables++;
            } else if (node instanceof MethodDeclaration) {
                numMethods++;
            } else if (node instanceof ClassOrInterfaceDeclaration) {
                numClasses++;
            }
        }

        System.out.println("Number of tokens: " + nodes.size());
        System.out.println("Number of variables: " + numVariables);
        System.out.println("Number of methods: " + numMethods);
        System.out.println("Number of classes: " + numClasses);
    }
}
