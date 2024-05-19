package juniverse.patterns.visitor.bad.browsefile.extbyaddclass;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tunm2
 */
public class DemoExtendByAddClass {
    
    static List<IFile> files = Arrays.asList(
        new TextFile(),
        new PdfFile(),
        new HtmlFile()
    );
    
    public static void main(String[] args) {
        files.forEach((file) -> {
            System.err.println(file.preview());
        });
    }
}
