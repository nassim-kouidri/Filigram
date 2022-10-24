import { createRouter, createWebHistory } from 'vue-router'
import home from '../views/post.vue'
import addPost from '../views/addPost.vue'
import login from '../views/login.vue'
import signup from '../views/signup.vue'
import profile from '../views/profile.vue'
import profileFound from '../views/profileFound.vue'
import aboutView from '../views/aboutView.vue'
import settings from '../views/settings.vue'
import idPost from '../views/idPost.vue'
import search from '../views/search.vue'
import notif from '../views/notif.vue'
import admin from '../views/admin.vue'
import Messagerie from '../views/Messagerie.vue'

import { authGuard } from '@/utils/auth-guard'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component: login,
      //beforeEnter: authGuard
    },
    {
       path: '/notif',
       name: 'notif',
       component: notif,
       beforeEnter: authGuard
     },
     {
      path: '/Messagerie',
      name: 'Messagerie',
      component: Messagerie,
      //beforeEnter: authGuard
    },
     {
      path: '/admin',
      name: 'admin',
      component: admin,
      beforeEnter: authGuard
    },
    {
      path: '/search',
      name: 'search',
      component: search,
      beforeEnter: authGuard
    },
    {
      path: '/home',
      name: 'home',
      component: home,
      //beforeEnter: authGuard
    },   
    {
      path: '/addPost',
      name: 'addPost',
      component: addPost,
      beforeEnter: authGuard
    },{
      path: '/signup',
      name: 'signup',
      component: signup
    },{
      path: '/profile',
      name: 'profile',
      component: profile,
      beforeEnter: authGuard
    },
    {
      path: '/aboutView',
      name: 'aboutView',
      component: aboutView,
      beforeEnter: authGuard
    },
    {
      path: '/settings',
      name: 'settings',
      component: settings,
      beforeEnter: authGuard
    },
    {
      path: '/home/:id',
      name: 'idPost',
      component: idPost,
      beforeEnter: authGuard
    },
    {
      path: '/profileFound/:id',
      name: 'profileFound',
      component: profileFound,
      beforeEnter: authGuard
    },
    {
      path : '/:pathMatch(.*)*', redirect: '/home'
    }

  ]
})

export default router
