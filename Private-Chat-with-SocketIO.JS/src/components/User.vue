<template>
  <div class="user" @click="onClick" :class="{ selected: selected }">
    <div class="description">
      <div class="name">
        {{ user.username }} {{ user.self ? " (yourself)" : "" }}
      </div>
      <div class="status">
        <status-icon :connected="user.connected" />{{ status }}
      </div>
    </div>
    <div v-if="user.hasNewMessages" class="new-messages">!</div>
  </div>
</template>

<script>
import StatusIcon from "./StatusIcon";
import axios from 'axios';
export default {
  name: "User",
   data() {
    return {
        account: [],
       
    };
  },
  components: { StatusIcon },
  props: {
    user: Object,
    selected: Boolean,
  },
  methods: {
    onClick() {
      this.$emit("select");
    },

    getRelation(){
       let test = window.location.href;
                test = test.substring(22);
                let params = new URLSearchParams(test);
                this.id = params.get("id");
                console.log("ceci est l'id de la personne co "+this.id);
             axios
                .get( 'http://localhost:8081/api/listRelation/'+ this.id)
                .then((response) => {
                    this.account = response.data;
                    console.log(this.account);
                });
    },

  },
  computed: {
    status() {
      return this.user.connected ? "online" : "offline";
    },
  },
  created() {
    this.getRelation();
  },
};
</script>

<style scoped>
.selected {
  background-color: #1164a3;
}

.user {
  padding: 10px;
}

.description {
  display: inline-block;
}

.status {
  color: #92959e;
}

.new-messages {
  color: white;
  background-color: red;
  width: 20px;
  border-radius: 5px;
  text-align: center;
  float: right;
  margin-top: 10px;
}
</style>
