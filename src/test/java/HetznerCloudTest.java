import de.langomatisch.hetzner.api.HetznerCloudAPI;
import de.langomatisch.hetzner.internal.exception.HetznerNotAuthorizedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HetznerCloudTest {

    @Test
    public void testWrong() {
        HetznerCloudAPI test = new HetznerCloudAPI("wrong-key");
        assertThrowsExactly(HetznerNotAuthorizedException.class, test::getDatacenters);
    }
}
