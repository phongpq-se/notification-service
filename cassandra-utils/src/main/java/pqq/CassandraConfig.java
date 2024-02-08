package pqq;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.core.cql.session.init.KeyspacePopulator;
import org.springframework.data.cassandra.core.cql.session.init.ResourceKeyspacePopulator;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author phongpq
 */
@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification
                .createKeyspace("notification").ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true);
        return List.of(specification);
    }

    @Nullable
    @Override
    protected KeyspacePopulator keyspaceCleaner() {
        return new ResourceKeyspacePopulator(scriptOf("DROP KEYSPACE IF EXISTS notification;"));
    }

    @Override
    protected String getContactPoints() {
        return "localhost:9042";
    }

    @Override
    protected String getKeyspaceName() {
        return "notification";
    }
}
