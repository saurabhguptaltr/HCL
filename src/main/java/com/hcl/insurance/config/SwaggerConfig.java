package com.hcl.insurance.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {   
	@Autowired
	JdbcTemplate template;
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
    
    @PostConstruct
	private void initDb() {
	    String sqlStatements[] = { 
//	      "insert into TBL_INSURANCE (ticket_id, total_price,status,insurance_amount) values('1', '1234.43', 'INSURANCE-PENDING','34.43')",
	    		"insert into TBL_TRAIN (train_name, train_number,source,destination,days,price) values('RAJDHANI', '12345', 'DELHI','MUMBAI','SUN,WED,FRI','4500')",
	    	    "insert into TBL_TRAIN (train_name, train_number,source,destination,days,price) values('TORONTO', '23456', 'BANGALORE','MUMBAI','MON,TUE,WED,THUR,FRI','3800')",
	    	    "insert into TBL_TRAIN (train_name, train_number,source,destination,days,price) values('ALLEPY', '34567', 'DELHI','CHENNAI','SUN,WED,SAT','4200')",
	    	    "insert into TBL_TRAIN (train_name, train_number,source,destination,days,price) values('LOCAL', '21345', 'DELHI','MUMBAI','SUN,MON,TUE,THUR,FRI,SAT','1200')",
	    	    "insert into TBL_TRAIN (train_name, train_number,source,destination,days,price) values('SHATABDI', '45678', 'HYDERABAD','KOCHI','MON,WED,FRI','2768')"
	    	    
	    };
	    Arrays.asList(sqlStatements).forEach(a->template.execute(a));

	}
}