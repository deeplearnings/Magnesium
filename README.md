[![GitHub release](https://img.shields.io/badge/release-1.0.0-28a745.svg)](https://github.com/0nebean/com.alibaba.druid-0nebean.custom/releases)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

![](https://img.shields.io/badge/belong_to-chemical--el-yellowgreen.svg)
![](https://img.shields.io/badge/support-onebean--data-red.svg)
![](https://img.shields.io/badge/dependency-spring--15.20-blue.svg)
![](https://img.shields.io/badge/middleware-mysql-lightgrey.svg)



[`Introduction`](https://0nebean.github.io/Magnesium/)
---
- Magnesium 通过两个核心的概念管理API，分别是应用（consumer）和服务（provider），API由服务提供，服务就是常规意义上的一个web server，我们把它其中的API定义到平台上进行可视化的管理，有了这些API加持，应用更像是一个应用市场的账号在海量的API市场里选择自己需要的API进行绑定获得授权，再直接通过该应用设定的授权方式即可直接访问这些API，那么实际意义上的产品，即对应了平台上一个应用的概念，只要接入了平台就等于获得了海量的数据API，并不关心提供方来自哪一个模块，哪一个数据库，用何种方式调用API，在此种模式下开发，API的复用率在得到最大化，开发成本将大幅度下降。


- 框架特性[(查看明细)](https://github.com/0nebean/Magnesium/wiki/%E6%A1%86%E6%9E%B6%E7%89%B9%E6%80%A7)
  - 基于[`Silicon`](https://0nebean.github.io/Silicon/)，[`VUE`](https://cn.vuejs.org/)，[`openresty`](http://openresty.org/cn/) 开发
  - 数据中台能力，企业及平台，平台上一切数据能力皆服务，以服务的单位管理API
  - 开放平台能力，提供oauth授权码模式，私有令牌（登录后访问），IP白名单+Token，等鉴权方式来为接入应用消费平台上API（前后端分离，移动端，后台）
  - API网关能力，当API穿透AUTH层后，即使是分布式的项目也能通过通用的API获取用户，设备信息
  - 独立的user-auth体系，针对平台上接入的每个应用单独分表，提供通用的注册（短信验证码，账号密码），登录，登出操作等API
  - [`SaaS系统 Sodium`](https://0nebean.github.io/Sodium/)租户信息管理，下发SaaS租户超管账号，激活SaaS用户数据
 
Documentation
---
[Magnesium Documentation](https://github.com/0nebean/Magnesium/wiki)
