<template>
  <!-- <div class="select-username">
    <form @submit.prevent="onSubmit">
      <input v-model="username" placeholder="Your username..." />
      <button :disabled="!isValid">Send</button>
    </form>
  </div> -->
  <div></div>
</template>

<script>
export default {
  name: "SelectUsername",
  data() {
    return {
      username: "",
    };
  },
  computed: {
    isValid() {
      return 1;
    },
  },
  methods: {
    onSubmit() {
      let test = window.location.href;
                test = test.substring(22);
                let params = new URLSearchParams(test);
                this.username = params.get("username");
                console.log(this.username);
      this.$emit("input", this.username);

    },
    verifUsername(){
      let test = window.location.href;
                test = test.substring(22);
                let params = new URLSearchParams(test);
      this.username = params.get("username");
    console.log(this.username);
  },
  },
   created() {
     this.verifUsername();
     this.onSubmit();
   },

  
};
</script>

<style scoped>
.select-username {
  width: 300px;
  margin: 200px auto 0;
}
</style>
