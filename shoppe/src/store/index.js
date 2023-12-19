import {$shoppingcart_list} from '../api/shoppingcart'
import { defineStore } from 'pinia'

// 创建一个store，用于管理菜单高亮索引
export const useMenuActive = defineStore('menuActive', {
  // 定义状态
  state:()=>{
    return {
      activeIndex: sessionStorage.getItem('menuActive') || '/'
    }
  },
  // 操作状态的方法
  actions:{
    // 设置高亮索引
    setActiveIndex(val){
      // 在浏览器缓存中存储菜单高亮索引
      sessionStorage.setItem('menuActive',val)
      // 更新高亮索引
      this.activeIndex = val
    }
  }
})

// 创建一个store，用于管理登录用户信息
export const useUser = defineStore('user',{
  // 定义状态
  state:()=>{
    return {
      // 是否显示登录界面
      showLogin:false,
      // 用户信息
      user:{
        user_id: '', 
        userName: '', 
        userPhoneNumber: ''
      }
    }
  },
  actions:{
    // 修改登录界面的状态
    setShowLogin(val){
      this.showLogin = val
    },
    // 设置用户信息
    setUser(val){
      //this.user = val
      this.user.user_id = val.uid
      this.user.userName = val.nickname
    },
    // 重置方法
    reset(){
      this.user = {
        user_id: '', 
        userName: '', 
        userPhoneNumber: ''
      }
    }
  }
})

// 购物车状态管理
export const useShoppingcart = defineStore('shoppingcart',{
  state:()=>{
    return {
      // 登录用户的购物车数组
      shoppingcartList:[]
    }
  },
  actions:{
    // 加载购物车信息
    async loadShoppingcartList(){
      let userStore = useUser()
      if(!userStore.user.user_id) return
      let {success,data} = await $shoppingcart_list({user_id:userStore.user.user_id})
      if(success){
        this.shoppingcartList = data.map(r=>{
          return {
            ...r,
            // 添加状态
            state:false
          }
        })
      }
    },
    // 获取单个购物车信息
    getShoppingcartOne(user_id,product_id){
      return this.shoppingcartList.find(r=>r.user_id===user_id && r.product_id===product_id)
    },
    // 删除本地购物车数据
    delShoppingCart(user_id,product_id){
      let index = this.shoppingcartList.findIndex(r=>r.user_id===user_id && r.product_id===product_id)
      this.shoppingcartList.splice(index,1)
    },
    // 清空购物车
    clear(){
      this.shoppingcartList = []
    }
  }
})