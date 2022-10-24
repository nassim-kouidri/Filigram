<template>
<div class="try">
  <Header />
</div>
    <form @submit="search" onsubmit="event.preventDefault();" role="search">
        <label for="search">Search for stuff</label>
        <input id="search" name="keyword" v-model="keyword" type="search" placeholder="Search..." autofocus required />
        <button type="submit">Go</button>    
    </form>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

<div class="container profile-page CSSwrapper CSSfill">
    <tr v-for="a in account" v-bind:key="a.id">
    <div class="row">
        <div class="col-xl-6 col-lg-7 col-md-12">
            <div class="card profile-header">
                <div class="body">
                    <div class="row">
                                <button>lol</button>
                        <div class="col-lg-4 col-md-4 col-12">
                            <router-link :to="'/profileFound/' + a.id">
                            <div class="profile-image "> <img :src="a.profilePicture" > </div>
                            </router-link>
                        </div>
                        <div class="col-lg-8 col-md-8 col-12">
                            <center><h4 class="m-t-0 m-b-0"><strong>{{a.fullname}}</strong></h4>
                            <a  v-on:click="Follow(a.id)">Follow</a>
                            <a  v-on:click="FollowNotif(a.fullname, a.id)"> FollowNotif</a>
                            </center>
 
                        </div>                
                    </div>
                </div>                    
            </div>
        </div>
    </div>
    </tr>
</div>
        
       
</template>

<style lang="scss" scoped>
.CSSfill {
    grid-template-columns: repeat(auto-fill, minmax(360px, 1fr));
}

.CSSwrapper {
    display: grid;

  padding: 10px;
}
.CSSwrapper > div { 
  
  padding: 5px 10px; 
  margin-right: 40px;
  margin-bottom: 40px;
}
.try{
    margin-right: 780px;
}
//Vars 
:root {
  --rad: .7rem;
  --dur: .3s;
  --color-dark: #2f2f2f;
  --color-light: #fff;
  --color-brand: #57bd84;
  --font-fam: 'Lato', sans-serif;
  --height: 5rem;
  --btn-width: 6rem;
  --bez: cubic-bezier(0, 0, 0.43, 1.49);
}

// Setup
body {background: var(--color-dark); display: flex; align-items: center; justify-content: center; min-height: 100vh; margin-left: 109px; }
html { box-sizing: border-box; height: 100%; font-size: 10px; } *, *::before, *::after { box-sizing: inherit; }

// Main styles
form {
  position: relative;
  width: 30rem;
  background: var(--color-brand);
  border-radius: var(--rad);
}
input, button {
  height: var(--height);
  font-family: var(--font-fam);
  border: 0;
  color: var(--color-dark);
  font-size: 1.8rem;
}
input[type="search"] {
  outline: 0; // <-- shold probably remove this for better accessibility, adding for demo aesthetics for now.
  width: 100%;
  background: var(--color-light);
  padding: 0 1.6rem;
  border-radius: var(--rad);
  appearance: none; //for iOS input[type="search"] roundedness issue. border-radius alone doesn't work
  transition: all var(--dur) var(--bez);
  transition-property: width, border-radius;
  z-index: 1;
  position: relative;
}
button {
  display: none; // prevent being able to tab to it
  position: absolute;
  top: 0;
  right: 0;
  width: var(--btn-width);
  font-weight: bold;
  background: var(--color-brand);
  border-radius: 0 var(--rad) var(--rad) 0;
}
input:not(:placeholder-shown) {
  border-radius: var(--rad) 0 0 var(--rad);
  width: calc(100% - var(--btn-width));
  + button {
    display: block;
  }
}
label {
  position: absolute;
  clip: rect(1px, 1px, 1px, 1px);
  padding: 0;
  border: 0;
  height: 1px;
  width: 1px;
  overflow: hidden;
}

/////////Css Account/////////////
body{
    margin-top:20px;
    background:#eee;    
}
a {
    color: #f96332;
}
.m-t-5{
    margin-top: 5px;   
}
.card {
    background: #fff;
    margin-bottom: 30px;
    transition: .5s;
    border: 0;
    border-radius: .1875rem;
    display: inline-block;
    position: relative;
    width: 100%;
    box-shadow: none;
}
.card .body {
    font-size: 14px;
    color: #424242;
    padding: 20px;
    font-weight: 400;
}
.profile-page .profile-header {
    position: relative
}

.profile-page .profile-header .profile-image img {
    border-radius: 50%;
    width: 150px;
    height: 150px;
    border: 3px solid #fff;
    box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23)
}

.profile-page .profile-header .social-icon a {
    margin: 0 5px
}

.profile-page .profile-sub-header {
    min-height: 60px;
    width: 100%
}

.profile-page .profile-sub-header ul.box-list {
    display: inline-table;
    table-layout: fixed;
    width: 100%;
    background: #eee
}

.profile-page .profile-sub-header ul.box-list li {
    border-right: 1px solid #e0e0e0;
    display: table-cell;
    list-style: none
}

.profile-page .profile-sub-header ul.box-list li:last-child {
    border-right: none
}

.profile-page .profile-sub-header ul.box-list li a {
    display: block;
    padding: 15px 0;
    color: #424242
}
</style>

 <script>
import Header from "../components/header.vue";
import api from "../config";
import {GetFullnameService} from '@/service';
import axios from 'axios';
//import setAuthHeader from "../utils/setAuthHeader";

export default {
  name: "search",
  data() {
    return {
        account: [],
        keyword: null,
        // idAccountOne: null,
        // idAccountSecond: null,
        fullnameConnected: localStorage.getItem("Fullname"),
        idConnected: localStorage.getItem("Id"),
    };
  },
  components: {
    Header,
  },
  methods: {
        async search(e) {
            // console.log("lol");
                e.preventDefault();
                    const post = {
                        keyword: this.keyword
                                        
                    };
                // call the API account
                api
                .get( `/search/`+ this.keyword).then((response) => {
                    this.account = response.data;
                    console.log(this.account);
                });
        },
      lol(){
            console.log("LOLLLL")
        },
        FollowNotif(fullnameTarget, idTarget){
            const body ={
                "user": this.fullnameConnected,
                "accepturl": axios.
                             post('http://localhost:8081/api/Account/addRelation/'+this.idConnected+'/'+idTarget),
                "rejecturl": "https://fr.wikipedia.org/wiki/Lion"
            };
            axios.
            post('https://api.ravenhub.io/company/azAjBu4Y0t/subscribers/'+fullnameTarget+'/events/08DMMelOGV', body)
        },
  
    
        Follow(idAccountSecond){
             const followData = {
                  idAccountOne : localStorage.Id,
                idAccountSecond : idAccountSecond,
                friendship: true,
            };
            console.log(idAccountSecond)
            GetFullnameService.setFollow(followData)
            .then(response =>
              console.log(response.data),
                  )
            },

          
    

  }

};
</script>
