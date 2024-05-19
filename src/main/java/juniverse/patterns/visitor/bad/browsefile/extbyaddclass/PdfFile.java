package juniverse.patterns.visitor.bad.browsefile.extbyaddclass;

/**
 *
 * @author tunm2
 */
public class PdfFile implements IFile {

    @Override
    public String preview() {
        return "pdf";
    }

}
