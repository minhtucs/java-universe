package juniverse.patterns.visitor.bad.browsefile.extbyaddclass;

/**
 *
 * @author tunm2
 */
public class HtmlFile implements IFile {

    @Override
    public String preview() {
        return "html";
    }

}
