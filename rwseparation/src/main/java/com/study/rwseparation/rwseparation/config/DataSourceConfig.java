package com.study.rwseparation.rwseparation.config;

import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.StandardShardingStrategyConfiguration;
import io.shardingjdbc.core.jdbc.core.datasource.ShardingDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    /**
     * 配置分库分表策略
     * @return
     * @throws SQLException
     */
    @Bean(name = "shardingDataSource")
    DataSource getShardingDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfiguration=new ShardingRuleConfiguration();
        shardingRuleConfiguration.getTableRuleConfigs().add(getUserTableRuleConfiguration());
        shardingRuleConfiguration.getBindingTableGroups().add("user_info");
        shardingRuleConfiguration.setDefaultDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id",DemoDatabaseShardingAlgorithm.class.getName()));
        shardingRuleConfiguration.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id",DemoTableShardingAlgorithm.class.getName()));
        return new ShardingDataSource(shardingRuleConfiguration.build(createDataSourceMap()));
    }

    private Map<String, DataSource> createDataSourceMap() {
        return null;
    }

    /**
     * 设置表的node
     * @return
     */
    @Bean
    TableRuleConfiguration getUserTableRuleConfiguration() {
        TableRuleConfiguration tableRuleConfiguration=new TableRuleConfiguration();
        tableRuleConfiguration.setLogicTable("user_info");
        tableRuleConfiguration.setActualDataNodes("user_${0..1}.user_info${0..1}");
        tableRuleConfiguration.setKeyGeneratorColumnName("user_id");
        return tableRuleConfiguration;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource shardingDataSource){
        return new DataSourceTransactionManager(shardingDataSource);
    }


}
