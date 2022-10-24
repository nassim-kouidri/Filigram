<template>
  <Header />
  <!-- <div class="container"> -->
<div class="wrapper">
  <div class="profile-card js-profile-card">
    <div class="profile-card__img">
      <img :src="this.account.profilePicture" alt="profile card">
    </div>
    <div class="settings">
      <router-link to="/settings">
        <svg xmlns="http://www.w3.org/2000/svg" width="45" height="80" fill="rgb(108, 68, 252)" class="bi bi-gear-wide" viewBox="0 0 16 16">
          <path d="M8.932.727c-.243-.97-1.62-.97-1.864 0l-.071.286a.96.96 0 0 1-1.622.434l-.205-.211c-.695-.719-1.888-.03-1.613.931l.08.284a.96.96 0 0 1-1.186 1.187l-.284-.081c-.96-.275-1.65.918-.931 1.613l.211.205a.96.96 0 0 1-.434 1.622l-.286.071c-.97.243-.97 1.62 0 1.864l.286.071a.96.96 0 0 1 .434 1.622l-.211.205c-.719.695-.03 1.888.931 1.613l.284-.08a.96.96 0 0 1 1.187 1.187l-.081.283c-.275.96.918 1.65 1.613.931l.205-.211a.96.96 0 0 1 1.622.434l.071.286c.243.97 1.62.97 1.864 0l.071-.286a.96.96 0 0 1 1.622-.434l.205.211c.695.719 1.888.03 1.613-.931l-.08-.284a.96.96 0 0 1 1.187-1.187l.283.081c.96.275 1.65-.918.931-1.613l-.211-.205a.96.96 0 0 1 .434-1.622l.286-.071c.97-.243.97-1.62 0-1.864l-.286-.071a.96.96 0 0 1-.434-1.622l.211-.205c.719-.695.03-1.888-.931-1.613l-.284.08a.96.96 0 0 1-1.187-1.186l.081-.284c.275-.96-.918-1.65-1.613-.931l-.205.211a.96.96 0 0 1-1.622-.434L8.932.727zM8 12.997a4.998 4.998 0 1 1 0-9.995 4.998 4.998 0 0 1 0 9.996z"/>
        </svg>
      </router-link>
    </div>
    <div class="profile-card__cnt js-profile-cnt">
      <div class="profile-card__name">{{account.fullname}}</div>
      <h1>{{ this.account.mail }}</h1>
      <h2>{{ this.account.password }}</h2>


      <div class="profile-card__txt"> Pseudo: <strong>{{this.account.pseudo}}</strong></div>
      <div class="profile-card-loc">
        <span class="profile-card-loc__icon">
          <svg class="icon"><use xlink:href="#icon-location"></use></svg>
        </span>

        <span class="profile-card-loc__txt">
          Intech, Ivry sur Seine
        </span>
      </div>

      <div class="profile-card-inf">
        <div class="profile-card-inf__item">
          <div class="profile-card-inf__title">{{account.nbrFollowers}}</div>
          <div class="profile-card-inf__txt">Followers</div>
        </div>

        <div class="profile-card-inf__item">
          <div class="profile-card-inf__title">{{account.nbrSubscriptions}}</div>
          <div class="profile-card-inf__txt">Following</div>
        </div>

        <div class="profile-card-inf__item">
          <div class="profile-card-inf__title">{{this.nbrPost}}</div>
          <div class="profile-card-inf__txt">Posts</div>
        </div>
      </div>

     

  <div class="CSSwrapper CSSfill">
    <div v-for="post in posts" v-bind:key="post.idPost" >
      <div>     
          <div class="card p-0">
              <div class="card-image">
                  <img :src="post.image" alt="Post" width="150%">
              </div>
              <div class="card-content d-flex flex-column align-items-center"> 
                  <h5>{{post.description}}</h5>
              </div>
          </div>  
        </div>
      </div>
</div>
    </div>
	

  

  </div>

</div>
</template>

<style lang="scss">

@import url('https://fonts.googleapis.com/css?family=Quicksand:400,500,700&subset=latin-ext');

html {
  position: relative;
  overflow-x: hidden!important;
}

.CSSfill {
    grid-template-columns: repeat(auto-fill, minmax(230px, 1fr));
}

.CSSwrapper {
    display: grid;
  padding: 10px;
}
.CSSwrapper > div { 
  padding: 5px 10px; 
  margin-right: 20px;
  margin-bottom: 20px;
}

.settings{
  position: absolute;
  right: -130px;
  width: 200px;
  height: 120px;
  top: 0%;

}

* {
  box-sizing: border-box;
}

body {
  font-family: 'Quicksand', sans-serif;
  color: #324e63;
}

a, a:hover {
  text-decoration: none;
}

.icon {
  display: inline-block;
  width: 1em;
  height: 1em;
  stroke-width: 0;
  stroke: currentColor;
  fill: currentColor;
}

.wrapper {
//   width: 100%;
  width: 1500px;
  height: auto;
  min-height: 100vh;
  padding: 50px 20px;
  padding-top: 100px;
  display: flex;
//   background-image: linear-gradient(-20deg, #ff2846 0%, #6944ff 100%);

  display: flex;
//   background-image: linear-gradient(-20deg, #ff2846 0%, #6944ff 100%);

  @media screen and (max-width: 768px) {
    height: auto;
    min-height: 100vh;
    padding-top: 100px;
  }

}


.profile-card {
  width: 900px;
  min-height: 800px;
  margin: auto;
  box-shadow: 0px 8px 60px -10px rgba(13,28,39,0.6);
  background: #fff;
  border-radius: 12px;
  max-width: 900px;
  position: relative;

  &.active {
    .profile-card__cnt {
      filter: blur(6px);
    }

    .profile-card-message,
    .profile-card__overlay {
      opacity: 1;
      pointer-events: auto;
      transition-delay: .1s;
    }

    .profile-card-form {
      transform: none;
      transition-delay: .1s;
    }
  }

  &__img {
    width: 150px;
    height: 150px;
    margin-left: auto;
    margin-right: auto;
    transform: translateY(-50%);
    border-radius: 50%;
    overflow: hidden;
    position: relative;
    z-index: 4;
    box-shadow: 0px 5px 50px 0px rgb(108, 68, 252), 0px 0px 0px 7px rgba(107, 74, 255, 0.5);

    @media screen and (max-width: 576px) {
      width: 120px;
      height: 120px;
    }

    img {
      display: block;
      width: 100%;
      height: 100%;
      object-fit: cover;
      border-radius: 50%;
    }

  }

  &__cnt {
    margin-top: -35px;
    text-align: center;
    padding: 0 20px;
    padding-bottom: 40px;
    transition: all .3s;
  }

  &__name {
    font-weight: 700;
    font-size: 24px;
    color: #6944ff;
    margin-bottom: 15px;
  }

  &__txt {
    font-size: 18px;
    font-weight: 500;
    color: #324e63;
    margin-bottom: 15px;

    strong {
      //color: #ff2846;
      font-weight: 700;
    }

  }

  &-loc {
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 18px;
    font-weight: 600;

    &__icon {
      display: inline-flex;
      font-size: 27px;
      margin-right: 10px;
      //color: #6944ff;
    }

  }

  &-inf {
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    align-items: flex-start;
    margin-top: 35px;

    &__item {
      padding: 10px 35px;
      min-width: 150px;

      @media screen and (max-width: 768px) {
        padding: 10px 20px;
        min-width: 120px;
      }

    }

    &__title {
      font-weight: 700;
      font-size: 27px;
      //color: #6944ff;
      color: #324e63;
    }

    &__txt {
      font-weight: 500;
      margin-top: 7px;
    }

  }

  &-social {
    margin-top: 25px;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;

    &__item {
      display: inline-flex;
      width: 55px;
      height: 55px;
      margin: 15px;
      border-radius: 50%;
      align-items: center;
      justify-content: center;
      color: #fff;
      background: #405de6;
      box-shadow: 0px 7px 30px rgba(43,98,169,0.5);
      position: relative;
      font-size: 21px;
      flex-shrink: 0;
      transition: all .3s;

      @media screen and (max-width: 768px) {
        width: 50px;
        height: 50px;
        margin: 10px;
      }

      @media screen and (min-width: 768px){
        &:hover {
          transform: scale(1.2);
        }
      }

      &.facebook {
        background: linear-gradient(45deg, #3b5998, #0078d7);
        box-shadow: 0px 4px 30px rgba(43, 98, 169, 0.5);
      }

      &.twitter {
        background: linear-gradient(45deg, #1da1f2,#0e71c8);
        box-shadow: 0px 4px 30px rgba(19, 127, 212, 0.7);
      }

      &.instagram {
        background: linear-gradient(45deg, #405de6, #5851db, #833ab4, #c13584, #e1306c, #fd1d1d);
        box-shadow: 0px 4px 30px rgba(120, 64, 190, 0.6);
      }

      &.behance {
        background: linear-gradient(45deg, #1769ff, #213fca);
        box-shadow: 0px 4px 30px rgba(27, 86, 231, 0.7);
      }

      &.github {
        background: linear-gradient(45deg, #333333, #626b73);
        box-shadow: 0px 4px 30px rgba(63, 65, 67, 0.6);
      }

      &.codepen {
        background: linear-gradient(45deg, #324e63, #414447);
        box-shadow: 0px 4px 30px rgba(55, 75, 90, 0.6);
      }

      &.link {
        background: linear-gradient(45deg, #d5135a, #f05924);
        box-shadow: 0px 4px 30px rgba(223, 45, 70, 0.6);
      }

    }

    .icon-font {
      display: inline-flex;
    }

  }

  &-ctr {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 40px;

    @media screen and (max-width: 576px) {
      flex-wrap: wrap;
    }

  }

  &__button {
    background: none;
    border: none;
    font-family: 'Quicksand', sans-serif;
    font-weight: 700;
    font-size: 19px;
    margin: 15px 35px;
    padding: 15px 40px;
    min-width: 201px;
    border-radius: 50px;
    min-height: 55px;
    color: #fff;
    cursor: pointer;
    backface-visibility: hidden;
    transition: all .3s;

    @media screen and (max-width: 768px) {
      min-width: 170px;
      margin: 15px 25px;
    }

    @media screen and (max-width: 576px) {
      min-width: inherit;
      margin: 0;
      margin-bottom: 16px;
      width: 100%;
      max-width: 300px;

      &:last-child {
        margin-bottom: 0;
      }
    }

    &:focus {
      outline: none!important;
    }

    @media screen and (min-width: 768px) {
      &:hover {
        transform: translateY(-5px);
      }
    }

    &:first-child {
      margin-left: 0;
    }

    &:last-child {
      margin-right: 0;
    }

    &.button--blue {
      background: linear-gradient(45deg, #1da1f2, #0e71c8);
      box-shadow: 0px 4px 30px rgba(19, 127, 212, 0.4);

      &:hover {
        box-shadow: 0px 7px 30px rgba(19, 127, 212, 0.75);
      }

    }

    &.button--orange {
      background: linear-gradient(45deg, #d5135a, #f05924);
      box-shadow: 0px 4px 30px rgba(223, 45, 70, 0.35);

      &:hover {
        box-shadow: 0px 7px 30px rgba(223, 45, 70, 0.75);
      }

    }

    &.button--gray {
      box-shadow: none;
      background: #dcdcdc;
      color: #142029;
    }

  }

  &-message {
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    padding-top: 130px;
    padding-bottom: 100px;
    opacity: 0;
    pointer-events: none;
    transition: all .3s;
  }

  &-form {
    box-shadow: 0 4px 30px rgba(15, 22, 56, 0.35);
    max-width: 80%;
    margin-left: auto;
    margin-right: auto;
    height: 100%;
    background: #fff;
    border-radius: 10px;
    padding: 35px;
    transform: scale(.8);
    position: relative;
    z-index: 3;
    transition: all .3s;

    @media screen and (max-width: 768px) {
      max-width: 90%;
      height: auto;
    }

    @media screen and (max-width: 576px) {
      padding: 20px;
    }

    &__bottom {
      justify-content: space-between;
      display: flex;

      @media screen and (max-width: 576px) {
        flex-wrap: wrap;
      }

    }

  }

  textarea {
    width: 100%;
    resize: none;
    height: 210px;
    margin-bottom: 20px;
    border: 2px solid #dcdcdc;
    border-radius: 10px;
    padding: 15px 20px;
    color: #324e63;
    font-weight: 500;
    font-family: 'Quicksand', sans-serif;
    outline: none;
    transition: all .3s;

    &:focus {
      outline: none;
      border-color: #8a979e;
    }

  }

  &__overlay {
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    pointer-events: none;
    opacity: 0;
    background: rgba(22, 33, 72, 0.35);
    border-radius: 12px;
    transition: all .3s;
  }

}









/* Reseting */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}

body {
    min-height: 100vh;
    // background: linear-gradient(to bottom, #000428, #49010a);
}

.container {
    margin-top: 100px;
}

.container .row .col-lg-4 {
    display: flex;
    justify-content: center;
}

.card {
    position: relative;
    padding: 0;
    margin: 0 !important;
    border-radius: 20px;
    overflow: hidden;
    max-width: 280px;
    max-height: 340px;
    cursor: pointer;
    border: none;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);

}

.card .card-image {
    width: 100%;
    max-height: 340px;
}

.card .card-image img {
    width: 100%;
    max-height: 340px;
    object-fit: cover;
}

.card .card-content {
    position: absolute;
    bottom: -180px;
    color: #fff;
    background: rgba(255, 255, 255, 0.2);
    backdrop-filter: blur(15px);
    min-height: 140px;
    width: 100%;
    transition: bottom .4s ease-in;
    box-shadow: 0 -10px 10px rgba(255, 255, 255, 0.1);
    border-top: 1px solid rgba(255, 255, 255, 0.2);
}

.card:hover .card-content {
    bottom: 0px;
}

.card:hover .card-content h4,
.card:hover .card-content h5 {
    transform: translateY(10px);
    opacity: 1;
}

.card .card-content h4,
.card .card-content h5 {
    font-size: 1.1rem;
    text-transform: uppercase;
    letter-spacing: 3px;
    text-align: center;
    transition: 0.8s;
    font-weight: 500;
    opacity: 0;
    transform: translateY(-40px);
    transition-delay: 0.2s;
}

.card .card-content h5 {
    transition: 0.5s;
    font-weight: 200;
    font-size: 0.8rem;
    letter-spacing: 2px;
}

.card .card-content .social-icons {
    list-style: none;
    padding: 0;
}


.card .card-content .social-icons li {
    margin: 10px;
    transition: 0.5s;
    transition-delay: calc(0.15s * var(--i));
    transform: translateY(50px);
}


.card:hover .card-content .social-icons li {
    transform: translateY(20px);
}

.card .card-content .social-icons li a {
    color: #fff;
}

.card .card-content .social-icons li a span {
    font-size: 1.3rem;
}

@media(max-width: 991.5px) {
    .container {
        margin-top: 20px;
    }

    .container .row .col-lg-4 {
        margin: 20px 0px;
    }
}
</style>
   
 <script>
import Header from "../components/header.vue";
import accountGetService from "../service/accountGetService";
import axios from 'axios';
export default {
  name: "profile",
  data() {
    return {
      account: [],
      posts: [],
      nbrPost: null,
      id:localStorage.getItem("Id"),
    };
  },
  components: {
    Header,
  },
  methods: {
    getAccount() {
      console.log(this.id);
      accountGetService.getAccount().then((response) => {
        this.account = response.data;
		console.log(this.account.id);

      });
    },
      getPostsbyAccount() {
        axios
        .get('http://localhost:8081/api/Account/'+this.id+'/posts')
        .then((response) => {
          // this.post = response.data;
          this.posts = response.data;
            console.log(this.posts);
          });
        },

        getNbrPost(){
          axios
        .get('http://localhost:8080/api/getNbrPost/'+this.id)
        .then((response) => {
          // this.post = response.data;
          this.nbrPost = response.data;
            console.log(this.nbrPost);
          });
        },
        

  },
  created() {
    this.getAccount();
    this.getPostsbyAccount();
    this.getNbrPost();
  },
};
</script>