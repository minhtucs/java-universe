import org.junit.Test;

import java.text.DecimalFormat;

/**
 * @author tunm2
 */
public class __Misc {

    @Test
    public void test() {
        DecimalFormat df = new DecimalFormat("###,###,###");
        System.out.println(df.format(1234567899));
    }

}
