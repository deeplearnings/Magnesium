import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)


let routerConfig = {}

routerConfig.routerPath = [
  {
    path: '',
    redirect: '/0'
  }
]


routerConfig.initRouterGenerate = new VueRouter({
  routes: []
})

export default routerConfig
