package pqq;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.cql.CqlTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author phongpq
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CassandraConfig.class)
public class CassandraConfigTest {

    @Autowired
    CqlTemplate cqlTemplate;

    @Test
    public void connectToCassandraDbSuccess() {
        assertThat(cqlTemplate).isNotNull();
    }
}
