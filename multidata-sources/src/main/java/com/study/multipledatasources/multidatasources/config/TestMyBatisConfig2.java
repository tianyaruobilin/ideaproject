package com.study.multipledatasources.multidatasources.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.study.multipledatasources.multidatasources.user_info_1_dao",
        sqlSessionFactoryRef = "test2SqlSessionFactory"
)
public class TestMyBatisConfig2 {


    @Bean(name = "test2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }

    
    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
//        //读取mybatis小配置文件
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:mybatis/mapper/test2.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    
    @Bean(name = "test2TransactionManager")
    public DataSourceTransactionManager testTranSactionManager(@Qualifier("test2DataSource")DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "test2SqlSessionTemplate")
    
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
