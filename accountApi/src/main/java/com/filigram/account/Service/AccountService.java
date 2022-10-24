package com.filigram.account.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.filigram.account.Modele.Account;
import com.filigram.account.Modele.InternalRole;
import com.filigram.account.Modele.Post;
import com.filigram.account.Modele.Relation;
import com.filigram.account.Repository.AccountRepository;
import com.filigram.account.Repository.PostRepository;
import com.filigram.account.Repository.RelationRepository;


@Service
public class AccountService {
	
	Relation relation;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	RelationRepository relationRepository;
	
	@Autowired
	PostRepository postRepository;
	
	
	 Account account;
	 
	public Iterable<Account> getAllAccount(){
		return accountRepository.findAll();
	}
	
	public Iterable<Relation> getAllRelation(){
		return relationRepository.findAll();
	}
	
	public Account saveAccount(Account account) {
		Account saveAccount = accountRepository.save(account);
		return saveAccount;
	}
	
//	public Post savePost(Post post) {
//		Post savePost = accountRepository.save(post);
//		return savePost;
//	}
//	
	public Relation saveRelation(Relation relation) {
		Relation saveRelation = relationRepository.save(relation);
		return saveRelation;
	}

	  public Optional<Account> getAccount(final int id) {
	        return accountRepository.findById(id);
	    }
	  
//	  public Optional<Relation> getRelation(final int id) {
//	        return relationRepository.findById(id);
//	    }
//	  
	  public void deleteAccount(final int idAccount) {
		  accountRepository.deleteById(idAccount);
	    }
	  
	  public Iterable<Account> listAll(String keyword) {
	        if (keyword != null) {
	            return accountRepository.search(keyword);
	        }
	        return accountRepository.findAll();
	    }
	  
	  public List<Relation> listAllFriends(int idUser){
		  if(idUser != 0) {
			  //System.out.println(relationRepository.findByIdAccountOneOrIdAccountSecond(idUser, idUser));
//			 relationRepository.findByIdAccountOneOrIdAccountSecond(idUser, idUser);
//			 relationRepository.testAccountSecond(idUser);
			 System.out.println(relationRepository.testAccountSecond(idUser));
			 return relationRepository.testAccountSecond(idUser);
//			 return relationRepository.findByIdAccountOneOrIdAccountSecond(idUser, idUser);
		  }
		  return null;
	  }
	  
	  public List<Post> listAllPostsFromFriends(int idFriend){
		  if(idFriend != 0) {
			  return postRepository.findPostByIdRelation(idFriend);
		  }
		  return null;
	  }
	  
	  public List<Account> listAllAccountFromFriends(int idFriend){
		  if(idFriend != 0) {
		  return accountRepository.findAccountByIdRelation(idFriend);
		  }
		  return null;
	  }
	  
	  public List<Relation> getRelation(final int id) {
          List<Relation> list =  new ArrayList<>();
          list = relationRepository.findByIdAccountOneOrIdAccountSecond(id, id);
            return list;
        }
	  
	  
	  public Optional<Post> getPost(final int id) {
	        return postRepository.findById(id);
	    }
	  
//	  public Integer getIdFromDb(String username) {
//		    Account account = accountRepository.findByFullname(username);
//		    if (account == null) {
//		        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found ...");
//		    }
//		    return account.getId();
//		}
//	  
//	  public Optional<Account> getId(final String fullname){
//		return Optional.of(accountRepository.findByFullname(fullname).get());
//	  }
	  
//		@Override
//		public UserDetails loadUserByUsername(String fullname) throws UsernameNotFoundException {
//			Account account = accountRepository.findByFullname(fullname).get();
//			return new org.springframework.security.core.userdetails.User(
//					account.getFullname(), 
//					account.getPassword(), 
//					getGrantedAuthorities(account.getRole()));
//		}
	  
	
	  
	  public int getIdFromDb(String fullname) {
		    Account account = accountRepository.findByFullname(fullname);
		    if (account == null) {
		        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found ...");
		    }
		    return account.getId();
		}
	  
//	  public InternalRole getRoleFromDb(String fullname) {
//		    Account account = accountRepository.findByRole(fullname);
//		    if (account == null) {
//		        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found ...");
//		    }
//			   System.out.println("C'est rentré");
//
//		    return account.getRole();
//		}
	  
	  public List<Account> getAccountSignaledOnce(final Boolean param) {
	        return accountRepository.findBySignalAccountOnce(param);
	    }

	  
	}
	  

