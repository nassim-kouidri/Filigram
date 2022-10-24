<template>
<html>
 
	<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">FILIGRAM</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-12 col-lg-10">
					<div class="wrap d-md-flex">
						<div class="img" style="background-image: url(https://onhike.com/wp-content/uploads/2021/07/build-your-brand-image-with-excellent-commercial-photography.png);">
			      </div>
						<div class="login-wrap p-4 p-md-5">
			      	<div class="d-flex">
			      		<div class="w-100">
			      			<h3 class="mb-4">Sign In</h3>
			      		</div>
	
			      	</div>
							<form @submit="login" class="signin-form">
			      		<div class="form-group mb-3">
			      			<label class="label" for="name">Fullname</label>
			      			<input type="text" class="form-control" placeholder="Fullname"  v-model="account.fullname" required>
			      		</div>
		            <div class="form-group mb-3">
		            	<label class="label" for="password">Password</label>
		              <input type="password" class="form-control" placeholder="Password" v-model="account.password" required>
		            </div>
		            <div class="form-group">
		            	<button type="submit" name="submit" class="form-control btn btn-primary rounded submit px-3">Sign In</button>
		            </div>
		            <div class="form-group d-md-flex">
		            	<div class="w-50 text-left">
			            	<label class="checkbox-wrap checkbox-primary mb-0">Remember Me
									  <input type="checkbox" checked>
									  <span class="checkmark"></span>
										</label>
									</div>
									<div class="w-50 text-md-right">
										<a href="#">Forgot Password</a>
									</div>
		            </div>
		          </form>
		          <p class="text-center">Not a member? <router-link to="/signup"><a data-toggle="tab" href="#signup">Sign Up</a></router-link></p>
		        </div>
		      </div>
				</div>
			</div>
		</div>
	</section>



	</body>
</html>


</template>