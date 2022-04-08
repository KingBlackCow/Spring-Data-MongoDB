package me.js.springbootmongo.account;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
@Getter
@Setter
public class Account {
    @Id
    private String id;
    private String username;
    private String email;


}
