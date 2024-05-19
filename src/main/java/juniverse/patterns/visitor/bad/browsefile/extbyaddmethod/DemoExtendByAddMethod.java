package juniverse.patterns.visitor.bad.browsefile.extbyaddmethod;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tunm2
 */
public class DemoExtendByAddMethod {
    
    static List<IFile> files = Arrays.asList(
        new TextFile(),
        new PdfFile(),
        new HtmlFile()
    );
    
    public static void main(String[] args) {
        FilePreviewer filePreviewer = new FilePreviewer();
        files.forEach((file) -> {
            System.err.println(filePreviewer.preview(file));
        });
    }
    
}
