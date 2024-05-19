package juniverse.patterns.visitor.bad.browsefile.extbyaddmethod;

/**
 *
 * @author tunm2
 */
public class FilePreviewer {

    public String preview(IFile file) {
        if (file instanceof TextFile) {
            return "text";
        } else if (file instanceof PdfFile) {
            return "pdf";
        } else if (file instanceof HtmlFile) {
            return "html";
        }
        return "";
    }
    
}
