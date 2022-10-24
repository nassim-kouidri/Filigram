<template>
  <Header />
  <div class="left">
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"
      integrity="sha512-1PKOgIY59xJ8Co8+NE6FZ+LOAZKjy+KY8iq0G4B3CyeY6wYHN3yt9PW0XpSriVlkMXe40PTKnXrLnZ9+fkDaog=="
      crossorigin="anonymous"
    />
    <div class="margin">
      <div
        class="containeri"
        :style="{ 'background-image': `url(${post.image})` }"
      >
        <div class="container__info">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="30"
            height="60"
            class="striped"
            viewBox="0 0 16 16"
            @click="incrementCounter"
          >
            <path
              d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"
            />
          </svg>
          <br />
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="30"
            height="60"
            fill="currentColor"
            class="bi bi-chat"
            viewBox="0 0 16 16"
          >
            <path
              d="M2.678 11.894a1 1 0 0 1 .287.801 10.97 10.97 0 0 1-.398 2c1.395-.323 2.247-.697 2.634-.893a1 1 0 0 1 .71-.074A8.06 8.06 0 0 0 8 14c3.996 0 7-2.807 7-6 0-3.192-3.004-6-7-6S1 4.808 1 8c0 1.468.617 2.83 1.678 3.894zm-.493 3.905a21.682 21.682 0 0 1-.713.129c-.2.032-.352-.176-.273-.362a9.68 9.68 0 0 0 .244-.637l.003-.01c.248-.72.45-1.548.524-2.319C.743 11.37 0 9.76 0 8c0-3.866 3.582-7 8-7s8 3.134 8 7-3.582 7-8 7a9.06 9.06 0 0 1-2.347-.306c-.52.263-1.639.742-3.468 1.105z"
            />
          </svg>
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="30"
            height="60"
            fill="currentColor"
            class="bi bi-send"
            style="font-size: 60px; color: #028afa"
            viewBox="0 0 16 16"
          >
            <path
              d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576 6.636 10.07Zm6.787-8.201L1.591 6.602l4.339 2.76 7.494-7.493Z"
            />
          </svg>
        </div>
        <!-- <tr>lol</tr> -->

        <div class="container__profile">
          <br />
          <br />
          <img src="./image/empty.jpg" alt="people" />
          <div class="container__profile__text">
            <h2>{{ post.description }}</h2>
            <p>by <b>Joseph Therrien</b></p>
          </div>
        </div>
      </div>
    </div>
    <br />
    <br />
    <br />
  </div>

  <!--  -->
  <link
    href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
    rel="stylesheet"
    id="bootstrap-css"
  />
  <!-- <div class="container"> -->
  <div class="row">
    <div
      class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2"
    >
      <!-- Fluid width widget -->
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">
            <span class="glyphicon glyphicon-comment"></span>  Recent Comments
          </h3>
        </div>
        <div class="panel-body">
          <ul class="media-list">
            <tr v-for="comment in comments" v-bind:key="comments.idComment">
              <li class="media">
                <div class="media-left">
                  <img src="http://placehold.it/60x60" class="img-circle" />
                </div>
                <div class="media-body">
                  <h4 class="media-heading">
                    {{ post.idAccount }}
                    <br />
                    <small> commented on <a href="#">Post Title</a> </small>
                  </h4>
                  <p>
                    {{ comment.text }}
                  </p>
                </div>
              </li>
            </tr>
          </ul>
          <!-- <a href="#" class="btn btn-default btn-block">More Events »</a> -->
          <form @submit="addComment">
            <center>
              <textarea v-model="commentaire"></textarea>
              <br />

              <button type="submit">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="40"
                  height="80"
                  fill="currentColor"
                  class="bi bi-send"
                  style="font-size: 10px; color: #028afa"
                  viewBox="0 0 16 16"
                >
                  <path
                    d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576 6.636 10.07Zm6.787-8.201L1.591 6.602l4.339 2.76 7.494-7.493Z"
                  />
                </svg>
              </button>
            </center>
          </form>
        </div>
      </div>
      <!-- End fluid width widget -->
    </div>
  </div>
  <!-- </div> -->
</template>

<style scoped>
.striped {
  fill: v-bind("likeColor");
}

.margin {
  margin-left: 40px;
  /* padding-top: 5%; */
}

.row .panel panel-default {
  margin-left: 300px;
  width: 90%;
}

.col-xs-8 {
  /* width: 600px; */
  margin-left: 7%;
  /* width: 90%; */
}
</style>

<script>
import Header from "../components/header.vue";
import postService from "../service/PostService";
import axios from "axios";
export default {
  data() {
    return {
      id: this.$route.params.id,
      post: [],
      comments: [],
      likeColor: "red",
      likeCounter: 0,
      likeVerification: false,
      commentaire: null,
    };
  },
  components: {
    Header,
  },
  methods: {
    async putLike() {
      const res = await axios.put(
        "http://localhost:8080/api/addLike/" + this.id,
        { likeCounter: this.likeCounter }
      );
    },

    LikeNotif() {
      const body = {
        user: this.fullnameConnected,
      };
      axios.post(
        "https://api.ravenhub.io/company/azAjBu4Y0t/subscribers/Mickael/events/QZw8FQx8fy",
        body
      );
    },
    incrementCounter: function () {
      if (this.likeVerification != true) {
        this.likeCounter = 1;
        alert("YOU'VE LIKE THE " + this.post.description);
        this.$emit("increment");
        this.likeVerification = true;
        this.likeColor = "blue";
        this.putLike();
      } else {
        this.likeCounter = -1;
        this.likeVerification = false;
        this.likeColor = "red";
        this.putLike();
      }
      console.log(this.likeCounter + " and " + this.likeVerification);
    },

    getPostbyID() {
      axios
        .get("http://localhost:8080/api/Post/" + this.id)
        .then((response) => {
          this.post = response.data;
          // this.comments = this.post;
          //   console.log(this.comments);
        });
    },
    async addComment(e) {
      e.preventDefault();
      // if the password matches
      // make the post body
      const comment = {
        text: this.commentaire,
      };
      console.log(this.commentaire);
      // call the API
      axios.post(
        `http://localhost:8080/api/posts/` + this.id + `/comments`,
        comment
      );
    },

    getCommentbyPost() {
      axios
        .get("http://localhost:8080/api/post/" + this.id + "/comments")
        .then((response) => {
          // this.post = response.data;
          this.comments = response.data;
          //   console.log(this.comments);
        });
    },
  },
  created() {
    this.getPostbyID();
    this.putLike();
    this.getCommentbyPost();
  },
  computed: {},
};
</script>
