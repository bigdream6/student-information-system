import Vue from 'vue'
import VueRouter from 'vue-router'

const Home = () => import('../components/index/index')
const StuIndex = () => import('../components/index/stuIndex')
const Login = () => import('../components/login/login')
const Zhang = () => import('../components/login/zhang')
const PhoneLogin = () => import('../components/login/phoneLogin')
const Zhu = () => import('../components/login/zhu')
const ZhuBox = () => import('../components/login/zhuBox')
const Jin = () => import('../components/login/jin')
const Kao = () => import('../components/index/kao')
const IndexStu = () => import('../components/index/indexStu')
const notFound = () => import('../components/404')
const GaiLan = () => import('../components/index/gaiLan')
const StuSession = () => import('../components/index/stuSession')
const StuSessionSelf = () => import('../components/index/stuSessionSelf')
const PhoneHome = () => import('../components/phone/phoneIndex')
const Tu = () => import('../components/index/tu')
const SerachPage = () => import('../components/index/searchPage')
const PhoneStuSession = () => import('../components/phone/phoneStuSession')
const phoneStuIndex = () => import('../components/phone/phoneStuIndex')
Vue.use(VueRouter)

const routes = [{
      path: '/404',
      component: notFound

    },
    {
      path: "/",
      beforeEnter: (to, from, next) => {
        if (
          $cookies.get("shen") == "teacher" 
          
        ) {
          if (navigator.userAgent.match(/(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i)) {

            next({
              path: "/phoneHome"
            })
          } else {
            next({
              path: "/home"
            })
          }


        } else if (
          $cookies.get("shen") == "student" 
         
        ) {
          console.log("aaaaa")
          if (navigator.userAgent.match(/(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i)) {

            next({
              path: "/phoneStuIndex/"+$cookies.get("id")
            })
          } else {
            next({
              path: "/stuIndex/" + $cookies.get("id")
            })
          }
        } else {
          next({
            path: "/login"
          })
        }
      }
      },
      {
        path: "/phoneHome",
        component: PhoneHome,
        redirect: '/phoneHome/tu',

        children: [{
          path: 'tu',
          component: Tu
        }, {
          path: "phoneKao",
          component: Kao
        }, {
          path: "phoneStuSession/:name",
          component: PhoneStuSession
        }, {
          path: "selfsession/:name",
          component: StuSessionSelf
        }]

      },
      {
        path: "/phoneStuIndex/:name",
        component: phoneStuIndex
      },
      {
        path: '/home',
        name: 'Home',
        redirect: '/home/indexStu',
        component: Home,
        beforeEnter: (to, from, next) => {
          if (
            $cookies.get("shen") == "teacher" 
           
          ) {
            next()
          } else if (
            $cookies.get("shen") == "student" 
            
          ) {
            next({
              path: "/stuIndex/" + $cookies.get("id")
            })
          } else {
            next({
              path: "/login"
            })
          }

        },
        children: [{
          path: "search/:stuName",
          component: SerachPage
        }, {
          path: 'kao',
          component: Kao,

        }, {
          path: 'indexStu',
          component: IndexStu,
          redirect: '/home/indexStu/gaiLan',
          children: [{
            path: 'gaiLan',
            component: GaiLan
          }, {
            path: 'stuSession/:id',
            component: StuSession
          }, {
            path: 'stuSessionSelf/:name',
            component: StuSessionSelf
          }]
        }],
      },
      {
        path: '/stuIndex/:name',
        component: StuIndex,
        beforeEnter: (to, from, next) => {
          if (
            $cookies.get("shen") == "teacher" 
           
          ) {
            next({
              path: "/home"
            })
          } else if (
            $cookies.get("shen") == "student" 
          ) {
            next()
          } else {
            next({
              path: "/login"
            })
          }
        }
      },
      {
        path: '/login',
        component: Login,
        redirect: '/login/zhang',
        children: [{
          path: 'zhang',
          component: Zhang,

        }, {
          path: 'phoneLogin',
          component: PhoneLogin
        }]
      },
      {
        path: '/zhu',
        component: Zhu,
        redirect: '/zhu/zhuBox',
        children: [{
          path: 'zhuBox',
          component: ZhuBox,
          beforeEnter: (to, from, next) => {
            if ($cookies.get("isSend")) {
              next({
                path: '/zhu/jin'
              })
            } else {
              next()
            }
          }
        }, {
          path: 'jin',
          component: Jin
        }]
      }

    ]

    const router = new VueRouter({
      routes
    })
    router.beforeEach((to, from, next) => {
      if (to.matched.length !== 0) {
        next()
      } else {
        next({
          path: '/404'
        })
      }
    });

    export default router