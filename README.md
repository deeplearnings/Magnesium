[![GitHub release](https://img.shields.io/badge/release-1.0.0-28a745.svg)](https://github.com/0nebean/com.alibaba.druid-0nebean.custom/releases)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

![](https://img.shields.io/badge/belong_to-chemical--el-yellowgreen.svg)
![](https://img.shields.io/badge/support-onebean--data-red.svg)
![](https://img.shields.io/badge/dependency-spring--15.20-blue.svg)
![](https://img.shields.io/badge/middleware-mysql-lightgrey.svg)
![](https://img.shields.io/badge/middleware-apollo-lightgrey.svg)
![](https://img.shields.io/badge/middleware-eureka-lightgrey.svg)
![](https://img.shields.io/badge/middleware-rabbitMQ-lightgrey.svg)
![](https://img.shields.io/badge/middleware-redis-lightgrey.svg)
[`Introduction`](https://0nebean.github.io/Magnesium/)  

---
- Magnesium 是一个以管理API 为核心功能的数据中台，并拓展了多种API及用户鉴权模式以满足多种业务场景接入数据中台的需求。


- 框架特性
  - 基于[`Silicon`](https://0nebean.github.io/Silicon/)，[`VUE`](https://cn.vuejs.org/)，[`openresty`](http://openresty.org/cn/) 开发
  - 数据中台能力，企业及平台，平台上一切数据能力皆服务，以管理API 为核心功能的数据中台
  - 开放平台能力，提供oauth授权码模式，私有令牌（登录后访问），等鉴权方式来为接入应用消费平台上API
  - API网关能力，当API穿透AUTH层后，业务层的服务可以无视语言无差别的获取应用信息和当前用户信息
  - 独立的user-auth体系，针对平台上接入的每个应用单独分表，提供独立却不臃肿的用户体系
  - 为[`SaaS系统 Sodium`](https://0nebean.github.io/Sodium/)租户信息管理下发提供一站式的管理
 
Documentation
---
[Magnesium Documentation](https://github.com/0nebean/Magnesium/wiki)
