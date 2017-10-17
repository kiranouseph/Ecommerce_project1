 package com.niit.ecommerce_backend.congfig;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.niit.ecommerce_backend.model.Product ;
import com.niit.ecommerce_backend.model.Review;
import com.niit.ecommerce_backend.model.Subcategory;
import com.niit.ecommerce_backend.model.Supplier ;
import com.niit.ecommerce_backend.model.Cart;
import com.niit.ecommerce_backend.model.Category ;
import com.niit.ecommerce_backend.model.Order;
import com.niit.ecommerce_backend.model.User ;

import com.niit.ecommerce_backend.dao.ProductDAO;
import com.niit.ecommerce_backend.dao.ReviewDAO;
import com.niit.ecommerce_backend.dao.SubcategoryDAO;
import com.niit.ecommerce_backend.daoimpl.CategoryDAOImpl;
import com.niit.ecommerce_backend.daoimpl.OrderDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ProductDAOImpl;
import com.niit.ecommerce_backend.daoimpl.ReviewDAOImpl;
import com.niit.ecommerce_backend.daoimpl.SubcategoryDAOImpl;
import com.niit.ecommerce_backend.dao.SupplierDAO;
import com.niit.ecommerce_backend.daoimpl.SupplierDAOImpl;
import com.niit.ecommerce_backend.dao.CategoryDAO;
import com.niit.ecommerce_backend.dao.OrderDAO;
import com.niit.ecommerce_backend.dao.UserDAO;
import com.niit.ecommerce_backend.daoimpl.UserDAOImpl;


@Configuration
@ComponentScan("com.niit.ecommerce_backend")
@EnableTransactionManagement
public class HibernateConfig 
{
	
	    @Autowired
	    @Bean
	    public SessionFactory sessionFactory(DataSource dataSource) {
	        LocalSessionFactoryBuilder sessionBuilder  = new LocalSessionFactoryBuilder(dataSource);
	        /*sessionBuilder.setProperty("hibernate.show_sql", "true");*/
	        
	        sessionBuilder.addProperties(getHibernateProperties());
	       
	        
	        sessionBuilder.addAnnotatedClass(Product.class);
	        sessionBuilder.addAnnotatedClass(Supplier.class);
	        sessionBuilder.addAnnotatedClass(Category.class);
	        sessionBuilder.addAnnotatedClass(User.class);
	        sessionBuilder.addAnnotatedClass(Cart.class);
	        sessionBuilder.addAnnotatedClass(Subcategory.class);
	        sessionBuilder.addAnnotatedClass(Review.class);
	        sessionBuilder.addAnnotatedClass(Order.class);
      	    
	      	    
	        
	        

	      
	       
	        
	       
	        
	        return sessionBuilder.buildSessionFactory();
	    }
	    @Autowired
	    @Bean(name = "datasource")
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.h2.Driver");
	        dataSource.setUrl("jdbc:h2:tcp://localhost/~/ecomdb");

	        dataSource.setUsername("sa");
	        dataSource.setPassword("");
	        System.out.println("Data Source Created.....");
	        return dataSource;
	       
	        }

	    private Properties getHibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.show_sql", "true");
	        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	        properties.put("hibernate.format_sql", "true");
	        properties.put("hibernate.hbm2ddl.auto", "update");
	        properties.put("hibernate.connection.autocommit", true);
	        return properties;
	    }
	    @Bean
	    @Autowired
		public ProductDAO getProductDAO(SessionFactory sessionFactory)
		{
			
		return new ProductDAOImpl(sessionFactory);
		}
	    
	    
	    
	    @Bean
	    @Autowired
		public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
		{
			
		return new SupplierDAOImpl(sessionFactory);
		}
	    
	    
	    @Bean
	    @Autowired
		public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
		{
			
		return new CategoryDAOImpl(sessionFactory);
		}
	    
	    
	    @Bean
	    @Autowired
		public UserDAO getUserDAO(SessionFactory sessionFactory)
		{
		
		return new UserDAOImpl(sessionFactory);
		}
	    
	    
	    @Bean
	    @Autowired
		public SubcategoryDAO getSubcategoryDAO(SessionFactory sessionFactory)
		{
			
		return new SubcategoryDAOImpl(sessionFactory)	;	}
	    
	    
	    
	    
	    @Bean
	    @Autowired
		public ReviewDAO getReviewDAO(SessionFactory sessionFactory)
		{
			
		return new ReviewDAOImpl(sessionFactory);
		}
	    @Bean
	    @Autowired
		public OrderDAO getOrderDAO(SessionFactory sessionFactory)
		{
			
		return new OrderDAOImpl(sessionFactory);
		}
	    
	  
	    
	    
	    
	    
	   
	    
	    
	    
	    @Bean
		@Autowired
	        public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
	                return new HibernateTransactionManager(sessionFactory);
	        }
	    
	    	
	    

}