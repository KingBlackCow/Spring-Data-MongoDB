package me.js.springbootmongo;

import me.js.springbootmongo.account.Account;
import me.js.springbootmongo.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class SpringbootMongoApplication {
	/*
	*  docker run -p 27015:27017 --name mongo_boot -d mongo
	*  docker exec -i -t mongo_boot bash
	*/
	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongoApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner(){
		return args ->{
			Account account = new Account();
			account.setEmail("sgs1159@naver.com");
			account.setUsername("JS LEE");
			//mongoTemplate.insert(account);//템플릿으로 insert
			accountRepository.insert(account); //repo로 insert
			System.out.println("finished");

		};
	}

}
