<template>

    <!-- <div class="general-container"> -->
        <link
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"
        integrity="sha512-1PKOgIY59xJ8Co8+NE6FZ+LOAZKjy+KY8iq0G4B3CyeY6wYHN3yt9PW0XpSriVlkMXe40PTKnXrLnZ9+fkDaog=="
        crossorigin="anonymous"
        />
        <div class="containeri">
        <div class="container__info">
            <span><i class="fas fa-eye"></i>2350</span>
            <span><i class="fas fa-comment-alt"></i>624</span>
            <span><i class="fas fa-download"></i>1470</span>
        </div>
        <di class="container__profile">
            <img
            src="./image/empty.jpg"
            alt="people"
            />
            <div class="container__profile__text">
            <h2>White Mountains</h2>
            <p>by <b>Joseph Therrien</b></p>
            </div>
        </di>
        </div>
        <br>
        <br>
        <br>
    <!-- </div> -->
</template>

<style lang="scss">



$bright-color: #fff;
@mixin bottom {
 position: absolute;
 right: 0;
 left: 0;
}
* {
 margin: 0;
 padding: 0;
 box-sizing: border-box;
}

body {
 background-color: whitesmoke;
 font-family: Arial, Helvetica, sans-serif;
 display: flex;
 justify-content: center;
 align-items: center;
 min-height: 100vh;
 line-height: 1.4;
}

.general-container{
    border-radius: 30px;
}

.containeri {
 border-radius: 30px;
 background: url("https://images.unsplash.com/photo-1574007557239-acf6863bc375?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=80");
 background-repeat: no-repeat;
 background-position: center;
 background-size: cover;
 width: 750px;
 height: 650px;
 margin-left: -100px;
 position: relative;
 box-shadow: 0 0 50px rgba(0, 0, 0, 0.315);
 .container__info {
  @include bottom;
  bottom: 20%;
  display: flex;
  align-items: flex-end;
  padding: 15px 30px;
  color: $bright-color;
  span {
   margin-right: 20px;
  }
  i {
   margin-right: 10px;
  }
 }
 .container__profile {
 border-radius: 30px;

  background-color: #e4f2fd;
  display: flex;
  align-items: center;
  padding: 30px;
  @include bottom();
  bottom: 0;
  img {
   width: 60px;
   height: 60px;
   border-radius: 50%;
   object-position: center;
   object-fit: cover;
   margin-right: 10px;
  }
  h2 {
   color: #334454;
   font-size: 1.2rem;
  }
  p {
   color: #a1b2bc;
   font-size: 0.8rem;
  }
  p b {
   font-style: italic;
  }
 }
}
</style>
