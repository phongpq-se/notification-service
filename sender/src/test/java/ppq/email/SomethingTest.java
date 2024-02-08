package ppq.email;

import ppq.common.Constant;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SomethingTest {
    @Test
    public void getEnv() {
        var rs = System.getenv(Constant.EMAIL_SERVER_PASSWORD);
        assertThat(rs.isEmpty()).isFalse();
    }
}
