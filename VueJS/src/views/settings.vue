<template>
    <!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Account Settings UI Design</title>
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
    <div class="background">
	<section class="py-5 my-5">
			<h1 class="mb-5">Account Settings</h1>
 <div class="img-circle text-center mb-3">
							<img src="img/user2.jpg" alt="Image" class="shadow">
                            <div class="profile-card__img" id="app" alt="profile card">
                                <!-- <div class="container2" id="app" @click="selectImage"> -->
                                    <img :src="previewImage" alt="" >
                                <!-- </div> -->
                            </div>
						</div>
			
			<div class="image-upload" >
          <label for="file-input">
              <img src="https://icones.pro/wp-content/uploads/2021/06/icone-d-image-bleue.png"/>
          </label>

          <input id="file-input" type="file"  @change="onFileChange" />
        <!-- <div class="containeri" style="margin-top:00px">
             <div class="container2" id="app" >

        </div> -->
          <!-- </div> -->
<!-- </div> -->
             </div>
			<div class="bg-white shadow rounded-lg d-block d-sm-flex">
				<div class="profile-tab-nav border-right">
					<div class="p-4">
						<div class="img-circle text-center mb-3">
							<img src="img/user2.jpg" alt="Image" class="shadow">
						</div>
						<h4 class="text-center">FILIGRAM SPA</h4>
					</div>
					<div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
						<a class="nav-link active" id="account-tab" data-toggle="pill" href="#account" role="tab" aria-controls="account" aria-selected="true">
							<i class="fa fa-home text-center mr-1"></i> 
							Account
						</a>
						<a class="nav-link" id="password-tab" data-toggle="pill" href="#password" role="tab" aria-controls="password" aria-selected="false">
							<i class="fa fa-key text-center mr-1"></i> 
							Password
						</a>
						<a class="nav-link" id="security-tab" data-toggle="pill" href="#security" role="tab" aria-controls="security" aria-selected="false">
							<i class="fa fa-user text-center mr-1"></i> 
							Security
						</a>
						<a class="nav-link" id="application-tab" data-toggle="pill" href="#application" role="tab" aria-controls="application" aria-selected="false">
							<i class="fa fa-tv text-center mr-1"></i> 
							Application
						</a>
						<a class="nav-link" id="notification-tab" data-toggle="pill" href="#notification" role="tab" aria-controls="notification" aria-selected="false">
							<i class="fa fa-bell text-center mr-1"></i> 
							Notification
						</a>
					</div>
				</div>
				<div class="tab-content p-4 p-md-5" id="v-pills-tabContent">
					<div class="tab-pane fade show active" id="account" role="tabpanel" aria-labelledby="account-tab">
						<h3 class="mb-4">Account Settings</h3>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Fullname</label>
								  	<input type="text" class="form-control" name="fullname" v-model="fullname">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Pseudo</label>
								  	<input type="text" class="form-control" name="pseudo" v-model="pseudo">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Mail</label>
								  	<input type="text" class="form-control" name="email" v-model="mail">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Phone number</label>
								  	<input type="text" class="form-control" value="+91 9876543215">
								</div>
							</div>
						</div>
						<div>
							<button class="btn btn-primary" type="submit" name="submit" v-on:click="putAccount()">Update</button>
							<router-link to="/profile">
							<button class="btn btn-light">Cancel</button>
							</router-link>
							<button v-on:click="removeToken()" class="btn btn-light">Log out</button>
						</div>
					</div>
					<div class="tab-pane fade" id="password" role="tabpanel" aria-labelledby="password-tab">
						<h3 class="mb-4">Password Settings</h3>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Old password</label>
								  	<input type="password" class="form-control">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
								  	<label>New password</label>
								  	<input type="password" class="form-control">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Confirm new password</label>
								  	<input type="password" class="form-control">
								</div>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="security" role="tabpanel" aria-labelledby="security-tab">
						<h3 class="mb-4">Security Settings</h3>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Login</label>
								  	<input type="text" class="form-control">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Two-factor auth</label>
								  	<input type="text" class="form-control">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value="" id="recovery">
										<label class="form-check-label" for="recovery">
										Recovery
										</label>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="application" role="tabpanel" aria-labelledby="application-tab">
						<h3 class="mb-4">Application Settings</h3>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value="" id="app-check">
										<label class="form-check-label" for="app-check">
										App check
										</label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value="" id="defaultCheck2" >
										<label class="form-check-label" for="defaultCheck2">
										Lorem ipsum dolor sit.
										</label>
									</div>
								</div>
							</div>
						</div>
						
					</div>
					<div class="tab-pane fade" id="notification" role="tabpanel" aria-labelledby="notification-tab">
						<h3 class="mb-4">Notification Settings</h3>
						<div class="form-group">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value="" id="notification1">
								<label class="form-check-label" for="notification1">
									Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorum accusantium accusamus, neque cupiditate quis
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value="" id="notification2" >
								<label class="form-check-label" for="notification2">
									hic nesciunt repellat perferendis voluptatum totam porro eligendi.
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value="" id="notification3" >
								<label class="form-check-label" for="notification3">
									commodi fugiat molestiae tempora corporis. Sed dignissimos suscipit
								</label>
							</div>
						</div>

					</div>
				</div>
			</div>
	</section>
    </div>
</body>

</html>

</template>

<style>
.background{
    background-color: aliceblue;
}
</style>

<script>
import Header from "../components/header.vue";
import api from "../config";
import axios from 'axios';
import upload from "../components/filePreview.vue";
import accountGetService from "../service/accountGetService";
export default {
  name: "settings",
  data() {
    return {
			fullname: null,
			pseudo: null,
			mail: null,
			previewImage: null,
    };
  },
  components: {
    // Signin,
    // Post,
	upload,
    Header,
    // addPost
  },
  methods: {

	async putAccount() {
		console.log("C'est l'image "+this.image);
        const res = await axios.put('http://localhost:8081/api/PutAccount/'+localStorage.Id, {
			mail:this.mail,
			 pseudo:this.pseudo,
			  fullname:this.fullname, 
			  profilePicture:this.image
			  });
        this.result = res.status;
      },
	  removeToken(){
      localStorage.removeItem('jwtToken')
	  localStorage.removeItem('Id')
		localStorage.removeItem('Fullname')

	  window.location = "http://localhost:3000";
	  },
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
  },
  created() {
    this.putAccount();
  },
};
</script>



