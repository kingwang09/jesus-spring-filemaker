package org.jesus.jesusspring.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
@EnableTransactionManagement
@ConditionalOnClass(SqlSessionFactoryBean.class)
@MapperScan(value = "org.jesus.jesusspring.*.mapper", sqlSessionFactoryRef = "mybatisSqlSessionFactory")
public class MybatisConfig {

    @Value("${file-maker.datasource.jdbc-url}")
    private String url;
    @Value("${file-maker.datasource.username}")
    private String username;
    @Value("${file-maker.datasource.password}")
    private String password;
    @Bean
    public SqlSessionFactory mybatisSqlSessionFactory(DataSource myBatisDataSource, ApplicationContext ctx) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(myBatisDataSource);
        factoryBean.setMapperLocations(ctx.getResources("classpath:mapper/*.xml"));

        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate mybatisSqlSession(SqlSessionFactory mybatisSqlSessionFactory) {
        return new SqlSessionTemplate(mybatisSqlSessionFactory);
    }

//    @Bean
//    @ConfigurationProperties(prefix = "file-maker.datasource")
//    public DataSource myBatisDataSource(){
//        return DataSourceBuilder.create().type(SimpleDriverDataSource.class).build();
//    }

    @Bean
    public DataSource myBatisDataSource(){
        //filemaker jdbc에서 Pool을 지원하지 않아 simpleDriverDatasource로 사용해야함.
        return new SimpleDriverDataSource(new com.filemaker.jdbc.Driver(), url, username, password);
    }
}
