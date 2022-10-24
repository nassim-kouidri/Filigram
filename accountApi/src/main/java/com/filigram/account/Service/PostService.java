package com.filigram.account.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filigram.account.Modele.Post;
import com.filigram.account.Repository.PostRepository;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post savePost(Post post) {
        Post savePost = postRepository.save(post);
        return savePost;
    }

}