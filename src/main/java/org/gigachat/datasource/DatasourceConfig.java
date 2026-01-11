package org.gigachat.datasource;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DatasourceConfig {

    private final DataSource dataSource;
    private final Environment env;

    @Autowired
    public DatasourceConfig(DataSource dataSource, Environment env) {
        this.dataSource = dataSource;
        this.env = env;
    }


}
