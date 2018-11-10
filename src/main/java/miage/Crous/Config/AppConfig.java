package miage.Crous.Config;

import java.lang.annotation.Annotation;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import miage.Crous.Data.Entity.Bien;
import miage.Crous.Data.Entity.Location;
import miage.Crous.Data.Entity.LocationId;
import miage.Crous.Data.Entity.Personne;
import miage.Crous.Data.Entity.Possede;
import miage.Crous.Data.Entity.PossedeId;
import miage.Crous.Data.Entity.TypeIndividu;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { 
		@ComponentScan("miage.Crous.Data.Dao"),
		@ComponentScan("miage.Crous.Data.Services"),
		@ComponentScan("miage.Crous.Data.Entity")
})
public class AppConfig {
	@Autowired
	private Environment env;

	protected void setAnotatedClasses(LocalSessionFactoryBean sessionFactory) {
		sessionFactory.setAnnotatedClasses(new Class<?>[]{
			Personne.class, 
			TypeIndividu.class,
			Bien.class,
			Location.class,
			Possede.class
		});
	}
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		//dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());

		Properties props=new Properties();
		props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		props.put("hibernate.format_sql",env.getProperty("hibernate.format_sql"));
		props.put("hibernate.dialect",env.getProperty("hibernate.dialect"));
		// props.put("hibernate.archive.autodetection","class");

		factoryBean.setHibernateProperties(props);

		setAnotatedClasses(factoryBean);
		return factoryBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
}
