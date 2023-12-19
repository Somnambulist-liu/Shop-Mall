<template>
  <div class="page">
    <div class="detail-header">
      <div class="content">
        <div class="name">{{product.productName}}</div>
        <ul>
          <li>概述</li>
          <li>参数</li>
          <li>用户评价</li>
        </ul>
      </div>
    </div>
    <div class="detail-content">
      <div class="swiper">
        <Swiper :list="product_imgs" width="560px" height="560px"></Swiper>
      </div>
      <div class="content">
        <h1 class="name">{{product.productName}}</h1>
        <p class="intro">{{product.productIntro}}</p>
        <p class="store">小米自营</p>
        <div class="price">
          <span>{{product.productSellPrice}}元</span>
          <span class="del">{{product.productPrice}}元</span>
        </div>
        <div class="pro-list">
          <span class="pro-name">{{product.productName}}</span>
          <span class="pro-price">
            <span>{{product.productSellPrice}}元</span>
            <span class="pro-del">{{product.productPrice}}元</span>
          </span>
          <p class="price-sum">总计 : {{product.productSellPrice}}元</p>
        </div>
        <div class="button">
          <el-button class="shop-cart" @click="addCart(product.productId)">加入购物车</el-button>
          <el-button class="like">喜欢</el-button>
        </div>
        <ul class="pro-policy">
          <li><el-icon><CircleCheck /></el-icon> 小米自营</li>
          <li><el-icon><CircleCheck /></el-icon> 小米发货</li>
          <li><el-icon><CircleCheck /></el-icon> 7天无理由退货</li>
          <li><el-icon><CircleCheck /></el-icon> 7天价格保护</li>
        </ul>
      </div>
    </div>
  </div>
</template>
<script setup>
// 导入请求api
import {$shoppingcart_add,$shoppingcart_update,$shoppingcart_one} from '../api/shoppingcart'
import {CircleCheck} from '@element-plus/icons-vue'
import Swiper from '../components/Swiper.vue'
import {$product_one,$product_getAllPicture,} from '../api/product'
import {ref,onMounted} from 'vue'
import {useRoute} from 'vue-router'
import {useUser,useShoppingcart} from '../store/index'
// 导入通知消息框
import { ElMessage } from 'element-plus'
// 获取当前登录用户的状态
let userStore = useUser()
// 获取购物车全局状态对象
let shoppingcartStore = useShoppingcart()
// 创建路由
let route = useRoute()
// 商品
const product = ref({})
// 商品图片数组
const product_imgs = ref([])
// 加载商品的方法
const loadProduct = async()=>{
  // 获取当前商品的id
  let product_id = route.query.id
  // 获取商品信息
  let {data} = await $product_one({product_id})
  product.value = data
  // 获取商品图片信息
  let ret = await $product_getAllPicture({product_id})
  product_imgs.value = ret.data.map(r=>r.photoUrl)
}
// 添加购物车
const addCart = async (product_id)=>{
  // 判断用户是否登录
  if(!userStore.user.user_id){
    userStore.setShowLogin(true)
    return
  }
  // 根据用户编号和商品编号，从购物车中获取商品信息
  //let shoppingcart = shoppingcartStore.getShoppingcartOne(userStore.user.user_id,product_id)
//发送异步请求--->查询该商品是否在购物车中
  let {success,message} = await $shoppingcart_one({
      user_id:userStore.user.user_id,
      product_id,

  })
  if(success){
    //true-->该商品在购物车中,数量更新
    // 更新商品数量
    let {success,message} = await $shoppingcart_update({
      user_id:userStore.user.user_id,
      product_id,
      // num:shoppingcart.num+1
    })
    if(success){
      ElMessage({
        showClose: true,
        message,
        type: 'success',
      })
      // 更新购物车信息
      shoppingcartStore.loadShoppingcartList()
    }else{
      ElMessage({
        showClose: true,
        message,
        type: 'error',
      })
    }

  }else{
    //fasle-->该商品不在购物车,-->购物车的商品添加
     // 添加新的商品
     let {message,success} = await $shoppingcart_add({
      userId:userStore.user.user_id,
      productId:product_id,
      num:1,
    })
   
    if(success){
      ElMessage({
        showClose: true,
        message,
        type: 'success',
      })
      // 更新购物车信息
      shoppingcartStore.loadShoppingcartList()
    }else{
      ElMessage({
        showClose: true,
        message,
        type: 'error',
      })
    }

  }

  // if(shoppingcart){
  //   // 更新商品数量
  //   let {success,message} = await $shoppingcart_update({
  //     user_id:userStore.user.user_id,
  //     product_id,
  //     num:shoppingcart.num+1
  //   })
  //   if(success){
  //     ElNotification({
  //       title: '通知',
  //       message:'该商品已在购物车，数量 +1',
  //       type: 'success',
  //     })
  //     // 更新购物车信息
  //     shoppingcartStore.loadShoppingcartList()
  //   }else{
  //     ElNotification({
  //       title: '通知',
  //       message,
  //       type: 'error',
  //     })
  //   }
  // }else{
  //   // 添加新的商品
  //   let {message,success} = await $shoppingcart_add({
  //     user_id:userStore.user.user_id,
  //     product_id
  //   })
  //   console.log(user_id,product_id);
  //   if(success){
  //     ElNotification({
  //       title: '通知',
  //       message,
  //       type: 'success',
  //     })
  //     // 更新购物车信息
  //     shoppingcartStore.loadShoppingcartList()
  //   }else{
  //     ElNotification({
  //       title: '通知',
  //       message,
  //       type: 'error',
  //     })
  //   }
  // }
}
//钩子-->查询的商品的详情(根据id查询商品信息)
onMounted(()=>{
  loadProduct()
})
</script>
<style scoped lang='scss'>
.page{
  background-color: white;
}
.detail-header{
  height: 44px;
  box-shadow: 0 5px 5px rgb(0 0 0 / 7%);
  .content{
    width: 1226px;
    margin: 0 auto;
    display: flex;
    justify-content: space-between;
    .name{
      font-size: 18px;
      font-weight: 400;
      color: #212121;
    }
    ul{
      display: flex;
      li{
        font-size: 14px;
        color: #616161;
        margin-left: 20px;
        cursor: pointer;
        &:hover{
          color: #ff6700;
        }
      }
    }
  }
}
.detail-content{
  width: 1226px;
  margin: 0 auto;
  display: flex;
  padding-top: 30px;
  .swiper{
    width: 560px;
    height: 560px;
  }
  .content{
    margin-left: 25px;
    width: 640px;
    .name{
      height: 30px;
      line-height: 30px;
      font-size: 24px;
      font-weight: 400;
      color: #212121;
    }
    .intro{
      color: #b0b0b0;
      padding-top: 10px;
    }
    .store{
      color: #ff6700;
      padding-top: 10px;
    }
    .price{
      display: block;
      font-size: 18px;
      color: #ff6700;
      border-bottom: 1px solid #e0e0e0;
      padding: 25px 0 25px;
      .del{
        font-size: 14px;
        margin-left: 10px;
        color: #b0b0b0;
        text-decoration: line-through;
      }
    }
    .pro-list{
      background: #f9f9fa;
      padding: 30px 60px;
      margin: 50px 0 50px;
      .pro-name{
        line-height: 30px;
        color: #616161;
      }
      .pro-price{
        float: right;
        span{
          line-height: 30px;
          color: #616161;
        }
        .pro-del{
          margin-left: 10px;
          text-decoration: line-through;
        }
      }
      .price-sum{
        color: #ff6700;
        font-size: 24px;
        padding-top: 20px;
      }
    }
    .button{
      height: 55px;
      margin: 10px 0 20px 0;
      display: flex;
      .el-button{
        height: 55px;
        font-size: 16px;
        color: #fff;
        border: none;
        text-align: center;
      }
      .shop-cart{
        width: 340px;
        background-color: #ff6700;
      }
      .like{
        width: 260px;
        margin-left: 40px;
        background-color: #b0b0b0;
      }
    }
    .pro-policy{
      display: flex;
      li{
        margin-right: 20px;
        color: #b0b0b0;
      }
    }
  }
}
</style>