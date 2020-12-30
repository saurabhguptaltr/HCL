package com.hcl.ticket.configuration;

import java.sql.SQLException;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class H2Configuration {
	@Autowired
	JdbcTemplate template;
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server inMemoryH2DatabaseaServer() throws SQLException {
	    return Server.createTcpServer(
	      "-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
	}
	@PostConstruct
	private void initDb() {
	    String sqlStatements[] = { 
//	      "insert into TBL_TICKET(user_id, train_id,status,number_of_ticket,ticket_booking_date,travelling_date) values('userid', '12345', 'pending','3','2020-02-02','2020-02-02')"
//	    "insert into TBL_TRAIN (train_name, train_number,source,destination,days,price) values('RAJDHANI', '12345', 'DELHI','MUMBAI','SUN,WED,FRI','4500')",
//  	    "insert into TBL_TRAIN (train_name, train_number,source,destination,days,price) values('TORONTO', '23456', 'BANGALORE','MUMBAI','MON,TUE,WED,THUR,FRI','3800')",
//  	    "insert into TBL_TRAIN (train_name, train_number,source,destination,days,price) values('ALLEPY', '34567', 'DELHI','CHENNAI','SUN,WED,SAT','4200')",
//  	    "insert into TBL_TRAIN (train_name, train_number,source,destination,days,price) values('LOCAL', '21345', 'DELHI','MUMBAI','SUN,MON,TUE,THUR,FRI,SAT','1200')",
//  	    "insert into TBL_TRAIN (train_name, train_number,source,destination,days,price) values('SHATABDI', '45678', 'HYDERABAD','KOCHI','MON,WED,FRI','2768')"
	    };
	    Arrays.asList(sqlStatements).forEach(a->template.execute(a));

	}
}
