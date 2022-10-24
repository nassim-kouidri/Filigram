package com.filigram.account.Controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filigram.account.Modele.Account;
import com.filigram.account.Modele.InternalRole;
import com.filigram.account.Modele.Post;
import com.filigram.account.Modele.Relation;
import com.filigram.account.Repository.AccountRepository;
import com.filigram.account.Repository.PostRepository;
import com.filigram.account.Service.AccountService;
import com.filigram.account.configuration.JwtTokenUtil;

@RestController
@RequestMapping("/api")
//@CrossOrigin("http://localhost:3000/")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping("/Account")
	public Iterable<Account>  getAllAccount(){
		return accountService.getAllAccount();
	}
	
	@GetMapping("/Relation")
	public Iterable<Relation>  getAllRelation(){
		return accountService.getAllRelation();
	}
	
	@GetMapping("/Account/{idAccount}")
	public Account getAccount(@PathVariable("idAccount") final int idAccount) {
		Optional<Account> account = accountService.getAccount(idAccount);
		if(account.isPresent()) {
			return account.get();
		} else {
			return null;
		}
	}
	
	@PostMapping("/addAccount")
	public Account createAccount(@RequestBody Account account) {
	    	return accountService.saveAccount(account);
	}
	
	@PostMapping("/Account/addRelation")
	public Relation createRelation(@RequestBody Relation relation) {
	    	return accountService.saveRelation(relation);
	}
	
	@PostMapping("/Account/addRelation/{idAccountOne}/{idAccountSecond}")
	public Relation createRelationURL(@PathVariable("idAccountOne") final int idAccountOne, @PathVariable("idAccountSecond") final int idAccountSecond ) {
	    Relation relation = new Relation();
	    relation.setIdAccountOne(idAccountOne);
	    relation.setIdAccountSecond(idAccountSecond);
		return accountService.saveRelation(relation);
	}

	
	
	@DeleteMapping("/deleteAccount/{idAccount}")
	public void deleteAccount(@PathVariable("idAccount") final int idAccount) {
		accountService.deleteAccount(idAccount);
	}
	
	
	@PutMapping(path="/PutAccount/{idAccount}")
	public Account updateAccount(@PathVariable("idAccount") final int idAccount, @RequestBody Account account) {
		Optional<Account> e = accountService.getAccount(idAccount);
		if(e.isPresent()) {
			Account currentAccount = e.get();
			
			String Fullname = account.getFullname();
			if(Fullname != null) {
				currentAccount.setFullname(Fullname);
			}
			String Pseudo = account.getPseudo();
			if(Pseudo != null) {
				currentAccount.setPseudo(Pseudo);;
			}
			String Mail = account.getMail();
			if(Mail != null) {
				currentAccount.setMail(Mail);
			}
			String Image = account.getProfilePicture();
			if(Image != null) {
				System.out.println(Image);
				currentAccount.setProfilePicture(Image);
			}
			Boolean accountPost = account.getSignalAccount();
			if(accountPost != null) {
				currentAccount.setSignalAccount(accountPost);
			}
			Boolean signalAccountOnce = account.getSignalAccountOnce();
			if(signalAccountOnce != null) {
				currentAccount.setSignalAccountOnce(signalAccountOnce);
			}
			accountService.saveAccount(currentAccount);
			return currentAccount;
		} else {
			return null;
		}
	}

	@GetMapping("/search/{Account}")
    public Iterable<Account> viewHomePage(Model model, @PathVariable("Account") final String keyword) {
        Iterable<Account> listProducts = accountService.listAll(keyword);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("keyword", keyword);
        return listProducts;
    }
	
	
	@GetMapping("/Account/{idAccount}/posts")
	public List<Post> getComment(@PathVariable("idAccount") final int idAccount) {
		Optional<Account> account = accountService.getAccount(idAccount);
		if(account.isPresent()) {
			System.out.println("Apparement il existe quelque chose");
			return account.get().getPosts();
		} else {
			System.out.println("tu es en null la");
			return null;
		}
	}
	
	@GetMapping("/home/{idUser}")
	public List<Relation> viewFriends(Model model, @PathVariable("idUser") final int idUser){
		List<Relation> listFriends = accountService.listAllFriends(idUser);
		List<Relation> listPostsFromFriends;
//		if(!listFriends.isEmpty()) {
//			for (int i=0; i<listFriends.size(); i++) {
//				System.out.println(listFriends.lastIndexOf(i));
//				listPostsFromFriends = accountService.listAllFriends(i);
//				return listFriends;
////				Optional<Account> account = accountService.getAccount(i);
////				if(account.isPresent()) {
////					System.out.println("Apparement il existe quelque chose");
////					return account.get().getPosts();
////				} else {
////					System.out.println("tu es en null la");
////					return null;
////				}
//			}
//
//		}
		return listFriends;
	}
	
	@GetMapping("/test/{idUser}")
	public List<Post> test(@PathVariable("idUser") final int idUser){
		List<Post> listTest = accountService.listAllPostsFromFriends(idUser);
		return listTest;
	}
	
	@GetMapping("/Relation/{idRelation}")
    public List<Post> getRelation(@PathVariable("idRelation") final int idRelation) {
        List<Relation> relation = accountService.getRelation(idRelation);
        List<Post> listTest = new ArrayList<Post>();
        ArrayList list = new ArrayList() ;
        
        for(int i=0; i<relation.size();i++) {
        	if(relation.get(i).getIdAccountSecond() != idRelation) {
                list.add(relation.get(i).getIdAccountSecond());
        	}else {
                list.add(relation.get(i).getIdAccountOne());
        	}

//            System.out.println(list);

        }
        for(int i=0; i<list.size();i++) {
        	int account = (int) list.get(i);
        	listTest.addAll(accountService.listAllPostsFromFriends(account));
        	System.out.println(list.get(i));
        }
        System.out.println("la list test est : " + listTest);
        return listTest;

    }
	
	@GetMapping("/listRelation/{idAccount}")
    public List<Account> getAllRelationById(@PathVariable("idAccount") final int idAccount) {
        List<Relation> relation = accountService.getRelation(idAccount);
        List<Account> accountRelation = new ArrayList<Account>();
        ArrayList list = new ArrayList() ;
        
        for(int i=0; i<relation.size();i++) {
        	if(relation.get(i).getIdAccountSecond() != idAccount) {
                list.add(relation.get(i).getIdAccountSecond());
        	}else {
                list.add(relation.get(i).getIdAccountOne());
        	}

//            System.out.println(list);

        }
        for(int i=0; i<list.size();i++) {
        	int account = (int) list.get(i);
        	accountRelation.addAll(accountService.listAllAccountFromFriends(account));
//        	System.out.println(list.get(i));
        }
       

        return accountRelation;

    }

	

	
	
//	@GetMapping("/account/getAccount")
//	public int getAccount(HttpServletRequest request){
//	   String fullnameFromToken = jwtTokenUtil.getUsername(null)
//	   return accountService.getIdFromDb(fullnameFromToken);
//	}
	
	//@PostMapping(value="/jwt/decode")

	

	
	@PostMapping(value="/Account/getFullname")
//	consumes = MediaType.TEXT_PLAIN_VALUE,
	//produces = MediaType.APPLICATION_JSON_VALUE)
public String decodeJwt(@RequestBody String token) throws UnsupportedEncodingException{
String payload = token.split("\\.")[1];

 String result = new String(Base64.decodeBase64(payload), "UTF-8");
 String resultFilter = result.replace("," , "").replace(":", "").replace("sub", "").replace("iss", "").replace("iat", "").replace("exp", "")
		 .replace("\"", "").replace("com.intech.s4.Filigram", "").replace(".", "").replace("{", "").replace("}", "").replace("1", "").replace("2", "")
		 .replace("3", "").replace("4", "").replace("5", "").replace("6", "").replace("7", "").replace("8", "").replace("9", "").replace("0", "");
// String dateExpiration = result.
 return resultFilter;
 
 
// return result.replace("," , "").replace(":", "").replace("sub", "").replace("iss", "").replace("iat", "").replace("exp", "")
//		 .replace("\"", "");
		 
}
	
	@PostMapping("/Account/getId")
	public int getUser(@RequestBody String token) throws UnsupportedEncodingException{
		String payload = token.split("\\.")[1];
		String result = new String(Base64.decodeBase64(payload), "UTF-8");
		String resultFilter = result.replace("," , "").replace(":", "").replace("sub", "").replace("iss", "").replace("iat", "").replace("exp", "")
				 .replace("\"", "").replace("com.intech.s4.Filigram", "").replace(".", "").replace("{", "").replace("}", "").replace("1", "").replace("2", "")
				 .replace("3", "").replace("4", "").replace("5", "").replace("6", "").replace("7", "").replace("8", "").replace("9", "").replace("0", "");
	   return accountService.getIdFromDb(resultFilter);
	}
	
//	@PostMapping("/Account/getRole")
//	public InternalRole getRole(@RequestBody String token) throws UnsupportedEncodingException{
//		String payload = token.split("\\.")[1];
//		String result = new String(Base64.decodeBase64(payload), "UTF-8");
//		String resultFilter = result.replace("," , "").replace(":", "").replace("sub", "").replace("iss", "").replace("iat", "").replace("exp", "")
//				 .replace("\"", "").replace("com.intech.s4.Filigram", "").replace(".", "").replace("{", "").replace("}", "").replace("1", "").replace("2", "")
//				 .replace("3", "").replace("4", "").replace("5", "").replace("6", "").replace("7", "").replace("8", "").replace("9", "").replace("0", "");
//		return accountService.getRoleFromDb(resultFilter);
//	}
	
	@PostMapping("/Account/{AccountId}/posts")
    public Post createPost(@PathVariable (value = "AccountId") int AccountId,
                   @RequestBody Post post) {
      return accountRepository.findById(AccountId).map(account -> {
    	  post.setAccount(account);
    	  return postRepository.save(post);
      }).orElseThrow();
    }

//	@GetMapping("/Account/getId")
//	public Account getIdFromFullname(@RequestBody String fullname)  {
//		Optional<Account> account = accountService.getId(fullname);
//		if(account.isPresent()) {
//			return account.get();
//		} else {
//			return null;
//		}
//	}
	
	
//	@PostMapping("/addPost")
//	public Post createPost(@RequestBody Post post) {
//		return accountService.savePost(post);
//	}
//	
//	
	
	
	
	
	@GetMapping("/AccountSignaledOnce/{trueParam}")
	public Iterable<Account> getAllPostSignaledOnce(@PathVariable("trueParam") final Boolean trueParam){
		return accountService.getAccountSignaledOnce(trueParam);
	}
	
//	@PutMapping(path="/account/{idAccount}")
//	public Account updateSignalAccount(@PathVariable("idAccount") final int idAccount, @RequestBody Account account) {
//		Optional<Account> e = accountService.getAccount(idAccount);
//		if(e.isPresent()) {
//			Account currentAccount = e.get();
//			
//			Boolean accountPost = account.getSignalAccount();
//			if(accountPost != null) {
//				currentAccount.setSignalAccount(accountPost);
//			}
//			Boolean signalAccountOnce = account.getSignalAccountOnce();
//			if(signalAccountOnce != null) {
//				currentAccount.setSignalAccountOnce(signalAccountOnce);
//			}
//			accountService.saveAccount(currentAccount);
//			return currentAccount;
//		} else {
//			return null;
//		}
//	}	
	
	
	
	
	
}
