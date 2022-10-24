<template>
<body>

<div id="notification">
<p>This user liked your post</p>
</div>
<notification-center 
appId="azAjBu4Y0t" v-bind:subscriberId ="fullname"/>
<br/>
<p>ceci est le fullname connected : {{fullname}}</p>
</body>
</template>
<style>

#notification{
  background-color : grey;
  display: flex;
  border: 1px black solid;
  border-radius: 4px;
  padding: 50px;
  margin: auto;
}
/* body{
        right: -440px !important;
    } */
</style>

<script>
import Header from "../components/header.vue";
export default {
name: "notif",
 data() {
    return {
      id:localStorage.getItem("Id"),
      fullname: localStorage.getItem("Fullname"),
      fl: this.fullname,
    };
  },
  methods : {
    fonctionn(){  
    console.log("ceci est le fullname de la personne connécté : "+this.fullname);
    },},
  
  created() {
    this.fonctionn();
  },

//   components: {
//     Header,
//   },
};
</script>