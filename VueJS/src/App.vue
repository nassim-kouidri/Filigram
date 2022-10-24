<template>
    <div id="app">

        <router-view />

    </div>
</template>


<script>
import Signin from './views/signup.vue'
import Header from './components/header.vue'
import Post from './views/post.vue'
import addPost from './views/addPost.vue'
import image from './views/AboutView.vue'

export default {

    name: 'App',
    components: {
        image,

    }

}
</script>
