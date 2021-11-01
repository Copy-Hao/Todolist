import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
// import Signin from '../views/Signin.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Index',
    redirect:'/Login',
    component: () => import(/* webpackChunkName: "about" */ '../views/Index.vue') ,
    children: [
      {
      path: '/Login',
      name: 'Login',
      component: () => import('../views/Login.vue')
    },
    {
      path: '/Signin',
      name: 'Signin',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ '../views/Signin.vue')
    }
    ]
  }, 
  {
    path: '/Todo',
    name: 'Todo',
    component: () => import('../views/Todo.vue')
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
