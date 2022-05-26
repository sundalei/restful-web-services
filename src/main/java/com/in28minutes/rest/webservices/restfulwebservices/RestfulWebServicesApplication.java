package com.in28minutes.rest.webservices.restfulwebservices;

import com.in28minutes.rest.webservices.restfulwebservices.user.Post;
import com.in28minutes.rest.webservices.restfulwebservices.user.PostRepository;
import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import com.in28minutes.rest.webservices.restfulwebservices.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class RestfulWebServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulWebServicesApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, PostRepository postRepository) {
        return (args) -> {
            Post post1 = new Post("post1");
            Post post2 = new Post("post2");
            Post post3 = new Post("post3");
            Post post4 = new Post("post4");

            User user1 = new User("AB", new Date());
            User user2 = new User("Jack", new Date());

            post1.setUser(user1);
            post2.setUser(user2);
            post3.setUser(user2);
            post4.setUser(user2);
            
            userRepository.saveAll(Arrays.asList(user1, user2));
            postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));
        };
    }

}
