package juniverse.design.procedural;

/**
 *
 * @author tunm2
 */
public class Movie {

    // this code is used to calculate price
    public static enum Code { 
        Regular,        // $2.0 for first two days, and $1.5 per day after that
        Children,       // $3.0 per day
        NewRelease      // $1.5 for first three days, and $1.5 per day after that
    }
    
    public String title;
    public Code code;

    public Movie(String title, Code code) {
        this.title = title;
        this.code = code;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }
 
    
}
