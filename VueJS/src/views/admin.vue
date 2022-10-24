<template>
<Header />
<body>
  <div class="CSScolomnForm">
  <div class="CSScolomn">
  <div class="CSSflex" v-for="post in posts" v-bind:key="post.idPost">
    <div class="CSSgauche">
      <div><p><b>Ce post a été signalé</b></p> </div>
          <div>              
          <svg  v-on:click="supprimerPost(post.idPost)" xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
            <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
          </svg>
          <svg v-on:click="updateSignalPost(post.idPost)" xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-hand-thumbs-up" viewBox="0 0 16 16">
            <path d="M8.864.046C7.908-.193 7.02.53 6.956 1.466c-.072 1.051-.23 2.016-.428 2.59-.125.36-.479 1.013-1.04 1.639-.557.623-1.282 1.178-2.131 1.41C2.685 7.288 2 7.87 2 8.72v4.001c0 .845.682 1.464 1.448 1.545 1.07.114 1.564.415 2.068.723l.048.03c.272.165.578.348.97.484.397.136.861.217 1.466.217h3.5c.937 0 1.599-.477 1.934-1.064a1.86 1.86 0 0 0 .254-.912c0-.152-.023-.312-.077-.464.201-.263.38-.578.488-.901.11-.33.172-.762.004-1.149.069-.13.12-.269.159-.403.077-.27.113-.568.113-.857 0-.288-.036-.585-.113-.856a2.144 2.144 0 0 0-.138-.362 1.9 1.9 0 0 0 .234-1.734c-.206-.592-.682-1.1-1.2-1.272-.847-.282-1.803-.276-2.516-.211a9.84 9.84 0 0 0-.443.05 9.365 9.365 0 0 0-.062-4.509A1.38 1.38 0 0 0 9.125.111L8.864.046zM11.5 14.721H8c-.51 0-.863-.069-1.14-.164-.281-.097-.506-.228-.776-.393l-.04-.024c-.555-.339-1.198-.731-2.49-.868-.333-.036-.554-.29-.554-.55V8.72c0-.254.226-.543.62-.65 1.095-.3 1.977-.996 2.614-1.708.635-.71 1.064-1.475 1.238-1.978.243-.7.407-1.768.482-2.85.025-.362.36-.594.667-.518l.262.066c.16.04.258.143.288.255a8.34 8.34 0 0 1-.145 4.725.5.5 0 0 0 .595.644l.003-.001.014-.003.058-.014a8.908 8.908 0 0 1 1.036-.157c.663-.06 1.457-.054 2.11.164.175.058.45.3.57.65.107.308.087.67-.266 1.022l-.353.353.353.354c.043.043.105.141.154.315.048.167.075.37.075.581 0 .212-.027.414-.075.582-.05.174-.111.272-.154.315l-.353.353.353.354c.047.047.109.177.005.488a2.224 2.224 0 0 1-.505.805l-.353.353.353.354c.006.005.041.05.041.17a.866.866 0 0 1-.121.416c-.165.288-.503.56-1.066.56z"/>
          </svg>
          </div> 
    </div>
    <div class="CSSdroite">
      <router-link :to="'/home/' + post.idPost">
        <img  :src="post.image" alt="Post" style="width:20%" class="w3-hover-opacity">
      </router-link>    
    </div>
  </div>  
  </div>

  <div class="CSScolomn">
  <div class="CSSflex" v-for="account in accounts" v-bind:key="account.id">
    <div class="CSSgauche">
      <div><p><b>Cet utilisateur a été signalé</b></p> </div>
          <div>              
          <svg  v-on:click="supprimerAccount(account.id)" xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
            <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
          </svg>
          <svg v-on:click="updateSignalAccount(account.id)" xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-hand-thumbs-up" viewBox="0 0 16 16">
            <path d="M8.864.046C7.908-.193 7.02.53 6.956 1.466c-.072 1.051-.23 2.016-.428 2.59-.125.36-.479 1.013-1.04 1.639-.557.623-1.282 1.178-2.131 1.41C2.685 7.288 2 7.87 2 8.72v4.001c0 .845.682 1.464 1.448 1.545 1.07.114 1.564.415 2.068.723l.048.03c.272.165.578.348.97.484.397.136.861.217 1.466.217h3.5c.937 0 1.599-.477 1.934-1.064a1.86 1.86 0 0 0 .254-.912c0-.152-.023-.312-.077-.464.201-.263.38-.578.488-.901.11-.33.172-.762.004-1.149.069-.13.12-.269.159-.403.077-.27.113-.568.113-.857 0-.288-.036-.585-.113-.856a2.144 2.144 0 0 0-.138-.362 1.9 1.9 0 0 0 .234-1.734c-.206-.592-.682-1.1-1.2-1.272-.847-.282-1.803-.276-2.516-.211a9.84 9.84 0 0 0-.443.05 9.365 9.365 0 0 0-.062-4.509A1.38 1.38 0 0 0 9.125.111L8.864.046zM11.5 14.721H8c-.51 0-.863-.069-1.14-.164-.281-.097-.506-.228-.776-.393l-.04-.024c-.555-.339-1.198-.731-2.49-.868-.333-.036-.554-.29-.554-.55V8.72c0-.254.226-.543.62-.65 1.095-.3 1.977-.996 2.614-1.708.635-.71 1.064-1.475 1.238-1.978.243-.7.407-1.768.482-2.85.025-.362.36-.594.667-.518l.262.066c.16.04.258.143.288.255a8.34 8.34 0 0 1-.145 4.725.5.5 0 0 0 .595.644l.003-.001.014-.003.058-.014a8.908 8.908 0 0 1 1.036-.157c.663-.06 1.457-.054 2.11.164.175.058.45.3.57.65.107.308.087.67-.266 1.022l-.353.353.353.354c.043.043.105.141.154.315.048.167.075.37.075.581 0 .212-.027.414-.075.582-.05.174-.111.272-.154.315l-.353.353.353.354c.047.047.109.177.005.488a2.224 2.224 0 0 1-.505.805l-.353.353.353.354c.006.005.041.05.041.17a.866.866 0 0 1-.121.416c-.165.288-.503.56-1.066.56z"/>
          </svg>
          </div> 
    </div>
    <div class="CSSdroite">
       <router-link :to="'/profileFound/' + account.id">
      
        <img  :src="account.profile" alt="Account" style="width:20%" >
      
      </router-link>    
    </div>
  </div>  
  </div>
  </div>
</body>
</template>

 <script>
import Header from "../components/header.vue";
import axios from 'axios';
//import {PostApiService} from '../service/postApiService';

export default {
  name: "search",
  data() {
    return {
        accounts: [],
        posts: [],
    };
  },
  components: {
    Header,
  },
  methods:{
    getPostSignaledOnce() {
      axios.
      get('http://localhost:8080/api/PostSignaledOnce/true')
      .then((response) => {
        this.posts = response.data;
        console.log(this.posts);
      });
    },

    getAccountSignaledOnce() {
      axios.
      get('http://localhost:8081/api/AccountSignaledOnce/true')
      .then((response) => {
        this.accounts = response.data;
        console.log(this.accounts);
      });
    },
    
    supprimerPost(idPost){
      axios.
      delete('http://localhost:8080/api/deletePost/'+idPost)
      //PostApiService.deletePost(idPost)
      .then((response) => {
        console.log("Le post " + idPost +"a été supprimé");
      });
    },

    supprimerAccount(idAccount){
      axios.
      delete('http://localhost:8081/api/deleteAccount/'+idPost)
      .then((response) => {
        console.log("L'utilisateur " + idAccount +" a été supprimé");
      });
    },

    updateSignalPost(idPost){
      const body ={
        signalPost : false,
      };
      axios.
      put('http://localhost:8080/api/signal/'+idPost, body)
      //PostApiService.deletePost(idPost)
      .then((response) => {
        console.log("Le post " + idPost +" a été modifié");
      });
    },

    updateSignalAccount(idAccount){
      const body ={
        signalAccount : false,
      };
      axios.
      put('http://localhost:8081/api/PutAccount/'+idAccount, body)
      //PostApiService.deletePost(idPost)
      .then((response) => {
        console.log("L'utilisateur " + idAccount +" a été modifié");
      });
    },
  },
    created() {
    this.getPostSignaledOnce();
    this.getAccountSignaledOnce();
   
  },
}
</script>

<style> 
body,h1,h2,h3,h4,h5,h6 {
  font-family: "Raleway", sans-serif
}
body{
   
}
.CSSflex{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    border: 2px black solid;
    border-radius: 8px;
    width: 800px;
     margin-top: 50px;
     background-color: rgb(242, 234, 234);
}
.CSSgauche{
  display: flex;
   border: 2px yellow solid; 
margin: auto;

}
.CSSdroite{
display: flex;
justify-content: center;
border: 2px red solid; 

}
.CSScolomn {
  display: flex;
  flex-direction: column;
  margin-top: 50px;
}

.img-border-radius {
  height: 200px;
  border-radius: 50%;
}
</style>