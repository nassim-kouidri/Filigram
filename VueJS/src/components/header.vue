<template>
    
   <nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:180px;margin-left: -190px" id="mySidebar"><br>
        <div class="w3-container">
        </div>
        <div class="alignement">
          <br>
          <router-link to="/home">
            <img src="/images/logo.png" style=" margin-left: -10px; width:65%;">
            <br>
            <br>
          </router-link>
            <br>
          <!-- <a href="http://localhost:8082/"> -->
            <a v-bind:href="'http://localhost:3001/username='+ this.fullname+'&id='+this.id">
            <svg xmlns="http://www.w3.org/2000/svg" width="45%" height="75" fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
              <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z"/>
            </svg>
          </a>
            <br>
            <br>
            <router-link to="/addPost">
            <svg xmlns="http://www.w3.org/2000/svg" width="45%" height="75" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
              <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
              <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
            </svg>
             </router-link>
            <br>
            <br>
            <notification-center 
            appId="azAjBu4Y0t" v-bind:subscriberId ="fullname"/>
            <!-- <router-link to ="notif">
            <svg xmlns="http://www.w3.org/2000/svg" width="45%" height="75" fill="currentColor" class="bi bi-chat-square-heart-fill" viewBox="0 0 16 16">
              <path d="M2 0a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h2.5a1 1 0 0 1 .8.4l1.9 2.533a1 1 0 0 0 1.6 0l1.9-2.533a1 1 0 0 1 .8-.4H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2Zm6 3.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132Z"/>
            </svg></router-link> -->
            <br>
            <br>
            <router-link to="/search">
            <svg xmlns="http://www.w3.org/2000/svg" width="45%" height="75" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
              <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
            </svg>
            </router-link>
            <br>
            <br>
            <router-link to="/profile">
            <svg xmlns="http://www.w3.org/2000/svg" width="45%" height="75" color="#028AFA" fill="currentColor" class="bi bi-person-square" viewBox="0 0 16 16">
              <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
              <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12z"/>
            </svg>
            </router-link>
        </div>
    </nav>

</template>
<script>


export default {
name: "notif",
 data() {
    return {
      id:localStorage.getItem("Id"),
      fullname:localStorage.getItem("Fullname"),
    };
  },
  methods : {
    fonctionn(){  
    console.log("ceci est le fullname de la personne connécté : "+this.fullname);
    },

    },
  
  created() {
    this.fonctionn();

  },

//   components: {
//     Header,
//   },
};
</script>
<style >
.feed-container{
        right: -440px !important;
    }
    </style>