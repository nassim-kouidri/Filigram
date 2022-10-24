<template>
  <Header />
 
<div class="left">
  
      <form @submit="addPost" class="form-row">
        <link
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"
        integrity="sha512-1PKOgIY59xJ8Co8+NE6FZ+LOAZKjy+KY8iq0G4B3CyeY6wYHN3yt9PW0XpSriVlkMXe40PTKnXrLnZ9+fkDaog=="
        crossorigin="anonymous"
        />
      <div class="margin">
        <div style="margin-left: 240px">
        <div class="image-upload">
          <label for="file-input">
              <img src="https://icones.pro/wp-content/uploads/2021/06/icone-d-image-bleue.png"/>
          </label>

          <input id="file-input" type="file"  @change="onFileChange"/>
</div>
        </div>
        <div class="containeri" style="margin-top:00px">
        <div class="container2" id="app" :style="{'background-image': `url(${previewImage})`}" @click="selectImage">
          <!-- <input ref="fileInput" id="myFile" type="file" @change="onFileChange"> -->
        </div>
        <div class="container__info">
           <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="30"
                    height="60"
                    class="striped"
                    viewBox="0 0 16 16"
                  >
                    <path
                      d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"
                    />
                  </svg>
                  <br>
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
          
        <br>
        <br>
            <!-- <img
            src="./image/empty.jpg"
            alt="people"
            /> -->
            <div class="container__profile__text">
            <!-- <h2>LOL</h2>
            <p>by <b>Joseph Therrien</b></p> -->

                      <p>Description :</p>
                      <textarea
                        type="email"
                        class="form-control"
                        v-model="description"
                        required
                        placeholder="Add a description"
                      />
                      <br>
            </div>
             
            <button type="submit" style="margin-left: 400px">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="30"
                      height="60"
                      fill="#339dff"
                      class="bi bi-send"
                      style="font-size: 60px; color: #028afa"
                      viewBox="0 0 16 16">
                      <path
                        d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576 6.636 10.07Zm6.787-8.201L1.591 6.602l4.339 2.76 7.494-7.493Z"/>
                    </svg>
                   
                </button>
                <h6>Send</h6>
        
        </div>
        </div>
        </div>
        <br>
        <br>
        <br>
        
      </form>
</div>

        <!--  -->
        
            <!-- End fluid width widget --> 
            

 
    <!-- <center>
    <table>
      <center>  
        <form @submit="addPost" class="form-row">
        <div class="w3-row-padding">
          <div class="mini-headerPost">
            <div class="groove">
              <img
                src="/images/river.jpg"
                class="image-ronde"
              />&nbsp;&nbsp;&nbsp;USER Pseudo

              <hr />
              <div id="container">
          <div>
              <div class="imagePreviewWrapper" id="app" :style="{'background-image': `url(${previewImage})` }" @click="selectImage"></div>
              
              <input ref="fileInput" id="myFile" type="file" @change="onFileChange">
          </div>

              </div>
              <hr />
              <div class="description">
                <div class="w3-container w3-white">
                  <div class="iconesPost">
                    <p>
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="30"
                        height="60"
                        fill="currentColor"
                        class="bi bi-heart"
                        viewBox="0 0 16 16"
                      >
                        <path
                          d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"
                        />
                      </svg>
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
                    </p>
                    <div class="desc">
                      <p>Description :</p>
                      <textarea
                        type="email"
                        class="form-control"
                        v-model="description"
                        required
                        placeholder="Add a description"
                      />
                    </div>
                  </div>
                </div>
                <br />
                <br />
                <br />

                <button type="submit">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="30"
                      height="60"
                      fill="currentColor"
                      class="bi bi-send"
                      style="font-size: 60px; color: #028afa"
                      viewBox="0 0 16 16">
                      <path
                        d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576 6.636 10.07Zm6.787-8.201L1.591 6.602l4.339 2.76 7.494-7.493Z"/>
                    </svg>
                </button>
                <h6>Send</h6>
              </div>
              <br />
              <br />
              <br />
            </div>
          </div>
        </div>
        </form>
      </center>
    </table>
  </center>
  -->
 

</template>


<script>
    import Header from "../components/header.vue";
    import postService from "../service/PostService";
    import upload from "../components/filePreview.vue";
    import api from "../config";

    export default {
      name: "Posts",
      // components: {
      //   upload,
      // },
      data() {
        return {
          posts: [],
          description: null,
          image: '',
          previewImage: null,
          id:localStorage.getItem("Id"),
         // base64String = "",
        };
      },

      components: {
        Header,
        upload
      },
      methods: {
    get(key){
        this.image=localStorage.getItem(key);
      },
      set(key){
        var vm = this
        try{
                localStorage.setItem(key,this.image);
        }
        catch(e){
          console.log(`Storage failed: ${e}`);
        }
      },
         onFileChange(e) {
           var files = e.target.files ||                
           e.dataTransfer.files;
          if(!files.length)
            return;
          this.createImage(files[0]);
         },
        createImage(file) {
          var image = new Image();
          var reader = new FileReader();
          var vm = this;
          
          reader.onload=(e) => {
            vm.image = e.target.result; 
            this.previewImage = vm.image;
            vm.set('img');
            console.log(this.image);
          };
          reader.readAsDataURL(file);
        },
        removeImage: function (e){
          this.image = '';
          localStorage.removeItem('img')
        }
    ,    
  
        selectImage (){
                this.$refs.fileInput.click()
                // const image = event.target.files[0]
                
                console.log(this.dataUrl);
            },
            pickFile(){
                var filee = document.getElementById('myFile').files[0];
                this.image = filee.name;


                let input = this.$refs.fileInput

                let file = input.files

                if(file && file[0]){
                    let reader = new FileReader
                    reader.onload = e =>{
                        this.previewImage = e.target.result
                    }
                    reader.readAsDataURL(file[0])
                    
                    this.$emit('input', file[0])
                    
                }
                return filename

            },
                 async addPost(e) {
                        e.preventDefault();
                            const post = {
                            description: this.description,
                            image: this.image,
                            likeCounter: 0,
                            account_id: this.id,
                            signalPost : false,

                            };
                            // call the API
                            api
                            .post( `/Account/`+this.id+`/posts`, post)
                    },
                    computed : {       
                 }
      } 
    };



</script>

    <style>

    .image-upload > input
{
    display: none;
}

.image-upload img
{
    width: 80px;
    cursor: pointer;
}

.container2{
  border-radius: 30px;
    /* background: url(https://images.unsplash.com/photo-1574007557239-acf6863bc375?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=80); */
    background-repeat: no-repeat;
    background-position: center;
    background-size: cover;
    width: 750px;
    height: 650px;
    margin-left: -00px;
    position: relative;
    /* box-shadow: 0 0 50px rgb(0 0 0 / 32%); */
}
    
hr {
  border: none;
  border-top: 1px double rgb(0, 0, 0);
  color: #333;
  overflow: visible;
  text-align: center;
  height: 5px;
}


button{
  border: none;
  background-color: white;
}

.groove {
  border-style: groove;
  padding: 0px;
  /* margin: 720px auto 0; */
}

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  /* width: 100%; */
}

td,
th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

body {
  padding: 10px 50px 700px;
  font-family: sans-serif;
  /* background-color: white; */
}

.download2 {
  display: inline-block;
  margin-right: 10px;
  background: black;
  color: #fff;
  text-decoration: none;
  font-size: 13px;
  line-height: 38px;
  border-radius: 50px;
  -webkit-transition: all 0.3s;
  transition: all 0.3s;
  width: 150px;
  /* text-align: center; */
}

.download2:hover {
  background: #fff;
  color: #339dff;
  box-shadow: 0 4px 4px rgba(83, 100, 255, 0.32);
}


h1,
h2,
h3,
h4,
h5,
h6 {
  font-family: "Raleway", sans-serif;
}

.alignement {
  margin-left: 60px;
  display: flex;
  flex-direction: column;
}

.description {
  width: 60%;
}

.iconesPost {
  padding-left: 10px;
  margin-left: -510px;
}

.mini-headerPost {
  width: 610px;
  height: 80px;
  background: white;
}

.desc {
  width: 100px;
  height: 80px;
  background: white;
}

.image-ronde {
  margin-top: 5px;
  margin-left: -400px;
  width: 70px;
  height: 70px;
  border: none;
  -moz-border-radius: 75px;
  -webkit-border-radius: 75px;
  border-radius: 75px;
}

.imagePreviewWrapper{
    width: 60px;
    height: 250px;
    display: block;
    cursor: pointer;
    /* margin: 0 auto 30px; */
    background-size: cover;
    background-position: center center;
}
</style>
