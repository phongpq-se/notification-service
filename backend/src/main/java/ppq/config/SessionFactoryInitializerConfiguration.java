package ppq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.cassandra.SessionFactory;
import org.springframework.data.cassandra.core.cql.session.init.CompositeKeyspacePopulator;
import org.springframework.data.cassandra.core.cql.session.init.ResourceKeyspacePopulator;
import org.springframework.data.cassandra.core.cql.session.init.SessionFactoryInitializer;
import pqq.CassandraConfig;

/**
 * @author phongpq
 */
@Configuration
@Import(value = CassandraConfig.class)
public class SessionFactoryInitializerConfiguration {
    @Bean
    SessionFactoryInitializer sessionFactoryInitializer(
            @Autowired SessionFactory sessionFactory) {

        SessionFactoryInitializer initializer = new SessionFactoryInitializer();
        initializer.setSessionFactory(sessionFactory);

        ResourceKeyspacePopulator populator = new ResourceKeyspacePopulator();
        populator.setSeparator(";");
        populator.setScripts(new ClassPathResource("db/cassandra/schema.cql"));

        initializer.setKeyspacePopulator(new CompositeKeyspacePopulator(populator));

        return initializer;
    }

}
