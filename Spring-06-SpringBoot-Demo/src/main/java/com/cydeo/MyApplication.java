package com.cydeo;

import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {

		Comment comment = new Comment();
		comment.setAuthor("John");
		comment.setText("Spring Framework");

		ApplicationContext context = SpringApplication.run(MyApplication.class, args);
		CommentService commentService = context.getBean(CommentService.class);
		commentService.publishComment(comment);
	}

}
