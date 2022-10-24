package com.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Modele.Comment;
import com.Modele.Posts;
import com.Repository.CommentRepository;
import com.Repository.PostsRepository;

@Service
public class CommentsService {
	@Autowired
	CommentRepository commentRepository;

	
	public Iterable<Comment> getAllComment(){
		return commentRepository.findAll();
	}
	
	public Comment saveComment(Comment comment) {
		Comment saveComment = commentRepository.save(comment);
		return saveComment;
	}
	
}
