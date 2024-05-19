package juniverse.patterns.visitor.bad.browsefile.extbyaddclass;

/**
 *
 * @author tunm2
 */
public class TextFile implements IFile {

    @Override
    public String preview() {
        return "text";
    }

}
