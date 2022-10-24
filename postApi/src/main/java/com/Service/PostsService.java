package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Modele.Comment;
import com.Modele.Posts;
import com.Repository.CommentRepository;
import com.Repository.PostsRepository;


@Service
public class PostsService {
	
	@Autowired
	PostsRepository postsRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	public Iterable<Posts> getAllPost(){
		return postsRepository.findAll();
	}
	
	public Posts savePost(Posts post) {
		Posts savePost = postsRepository.save(post);
		return savePost;
	}
	
	public Optional<Posts> getPost(final int id) {
        return postsRepository.findById(id);
    }
	
	public List<Posts> getPostSignaledOnce(final Boolean id) {
        return postsRepository.findPostBySignalPostOnce(id);
    }
	
	public Optional<Comment> getComments(final int id){
		return commentRepository.findById(id);
		
	}

	public void deletePost(final int idPost) {
		  postsRepository.deleteById(idPost);
	    }	
	
	public int getNbrPost(int id) {
        return postsRepository.getNbrPost(id);
    }
	
}
