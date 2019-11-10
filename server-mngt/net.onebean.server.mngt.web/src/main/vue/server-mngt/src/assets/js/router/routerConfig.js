import ServerInfoList from '../../../components/serverInfo/ServerInfoList.vue'
import ServerInfoAdd from '../../../components/serverInfo/ServerInfoAdd.vue'
import ServerInfoEditor from '../../../components/serverInfo/ServerInfoEditor.vue'
import ApiInfoList from '../../../components/apiInfo/ApiInfoList.vue'
import ApiInfoAdd from '../../../components/apiInfo/ApiInfoAdd.vue'
import ApiInfoEditor from '../../../components/apiInfo/ApiInfoEditor.vue'
import ServerMachineNodeInfoList from '../../../components/serverMachineNodeInfo/ServerMachineNodeInfoList'
import ServerMachineNodeInfoAdd from '../../../components/serverMachineNodeInfo/ServerMachineNodeInfoAdd'
import ServerMachineNodeInfoEditor from '../../../components/serverMachineNodeInfo/ServerMachineNodeInfoEditor'
import UpSteamNodeInfoList from '../../../components/upSteamNodeInfo/UpSteamNodeInfoList'
import UpSteamNodeInfoAdd from '../../../components/upSteamNodeInfo/UpSteamNodeInfoAdd'
import UpSteamNodeInfoEditor from '../../../components/upSteamNodeInfo/UpSteamNodeInfoEditor'
import AppInfoList from '../../../components/appInfo/AppInfoList.vue'
import AppInfoAdd from '../../../components/appInfo/AppInfoAdd.vue'
import AppInfoEditor from '../../../components/appInfo/AppInfoEditor.vue'
import ErrorCard from '../../../components/error/ErrorCard'

import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)


let routerConfig = {}


routerConfig.routerPath = [
  {
    path: '',
    redirect: '/app-info-list'
  },
  {
    path: '/app-info-list',
    component: AppInfoList,
    icon: 'ios-appstore',
    name: '应用列表'
  },
  {
    path: '/app-info-list/app-info-add',
    component: AppInfoAdd,
    icon: 'md-add-circle',
    name: '添加应用'
  },
  {
    path: '/app-info-list/app-info-editor/:id',
    component: AppInfoEditor,
    icon: 'ios-brush',
    name: '编辑应用'
  },
  {
    path: '/upsteam-node-info-list',
    component: UpSteamNodeInfoList,
    icon: 'ios-leaf',
    name: '服务节点列表'
  },
  {
    path: '/upsteam-node-info-list/upsteam-node-info-add',
    component: UpSteamNodeInfoAdd,
    icon: 'md-add-circle',
    name: '添加服务节点'
  },
  {
    path: '/upsteam-node-info-list/upsteam-node-info-editor/:id',
    component: UpSteamNodeInfoEditor,
    icon: 'ios-brush',
    name: '编辑服务节点'
  },
  {
    path: '/server-machine-node-info-list',
    component: ServerMachineNodeInfoList,
    icon: 'md-git-compare',
    name: '服务器节点列表'
  },
  {
    path: '/server-machine-node-info-list/server-machine-node-info-add',
    component: ServerMachineNodeInfoAdd,
    icon: 'md-add-circle',
    name: '新增服务器节点'
  },
  {
    path: '/server-machine-node-info-list/server-machine-node-info-editor/:id',
    component: ServerMachineNodeInfoEditor,
    icon: 'ios-brush',
    name: '编辑服务器节点'
  },
  {
    path: '/server-info-list',
    component: ServerInfoList,
    icon: 'ios-globe',
    name: '服务列表'
  },
  {
    path: '/server-info-list/api-info-list/:sid',
    component: ApiInfoList,
    icon: 'ios-grid',
    name: '接口管理'
  },
  {
    path: '/server-info-list/api-info-list/api-info-add/:sid',
    component: ApiInfoAdd,
    icon: 'md-add-circle',
    name: '添加接口'
  },
  {
    path: '/server-info-list/api-info-list/api-info-editor/:sid/:id',
    component: ApiInfoEditor,
    icon: 'ios-brush',
    name: '编辑接口'
  },
  {
    path: '/server-info-list/server-info-add',
    component: ServerInfoAdd,
    icon: 'md-add-circle',
    name: '添加服务'
  },
  {
    path: '/server-info-list/server-info-editor/:id',
    component: ServerInfoEditor,
    icon: 'ios-brush',
    name: '编辑服务'
  },
  {
    path: '/err',
    component: ErrorCard
  },
  {
    path: '',
    redirect: '/server-info-list'
  }
]


routerConfig.initRouterGenerate = new VueRouter({
  routes: routerConfig.routerPath
})



export default routerConfig
