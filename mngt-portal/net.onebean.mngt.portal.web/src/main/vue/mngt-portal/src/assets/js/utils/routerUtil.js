
import routerConfig from '../router/routerConfig'
import objectUtil from './objectUtil'
import apiPath from '../constant/ApiPath'
import utils from '../utils//utils'

let routerUtil = {}



routerUtil.initRouterTreeNameArr = function(path) {
  let routeList = []
  let breadcrumbList = []
  path.split('/').forEach(function(r) {
    if (r != '') {
      routeList.push('/' + r)
    }
  })

  routeList.pop()
  routeList.push(path)
  let selfCut = path

  while (selfCut.split('/').length - 1 > 1) {
    selfCut = selfCut.slice(0, selfCut.lastIndexOf('/'))
    routeList.push(selfCut)
  }
  routeList = objectUtil.removeEmptyValueInArray(routeList)
  routerConfig.routerPath.forEach(function(r) {
    routeList.forEach(function(currentPath) {
      let isMatching = false
      if (r.path.indexOf(':') > 0) {
        if (
          r.path.slice(0, r.path.indexOf(':')) ===
          currentPath.slice(0, currentPath.lastIndexOf('/') + 1)
        ) {
          isMatching = true
        }
      }
      if (r.path === currentPath) {
        isMatching = true
      }
      if (isMatching) {
        breadcrumbList.push(r)
      }
    })
  })
  return breadcrumbList
}

routerUtil.getPcUrlByRouterPath = function(path) {
  let pcUrl = ''
  const menuArr = JSON.parse(sessionStorage.menuArr)
  menuArr.map(item => {
    if (item.path === path) {
      pcUrl = item.pcUrl
    }
  })
  return pcUrl
}

routerUtil.initRouterNavBarActiveStatus = function(path){
  let routeList = []
  path.split('/').forEach(function(r) {
    if (r != '') {
      routeList.push('/' + r)
    }
  })
  return routeList[0]
}

routerUtil.getRemoteMenu = async function (router, store) {
  const isLoad = store.state.isLoadMenu
  if (!isLoad) {
    const menuArr = await utils.netUtil.postAsync(apiPath.getMenuList, {})
    let resArr = []
    routerConfig.routerPath.forEach(item => {
      resArr.push(item)
    })
    menuArr.forEach(item => {
      item.component = () => import('@/components/appFrame/AppFrame')
      resArr.push(item)
    })
    sessionStorage.menuArr = JSON.stringify(resArr)
    router.addRoutes(resArr)
    store.commit('doLoadingMenu')
  }
  const menuArr = JSON.parse(sessionStorage.menuArr)
  menuArr.splice(0, 1)
  return menuArr
}

export default routerUtil
