<template>
  <div class="page">
    <div class="shopping-header">
      <div class="content">
        <p>
          <el-icon color="#ff6700" size="28"><ShoppingCartFull /></el-icon>
          &nbsp;我的购物车
        </p>
        <span>温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</span>
      </div>
    </div>
    <div class="shopping-content">
      <ul>
        <li class="content-header">
          <div class="pro-check">
            <el-checkbox v-model="ckAll" label="全选" size="large" />
          </div>
          <div class="pro-img"></div>
          <div class="pro-name">商品名称</div>
          <div class="pro-price">单价</div>
          <div class="pro-num">数量</div>
          <div class="pro-total">小计</div>
          <div class="pro-action">操作</div>
        </li>
        <li class="product-list" v-for="(pro,index) in shoppingcartStore.shoppingcartList" :key="pro.id">
          <div class="pro-check">
            <el-checkbox v-model="pro.state" label="" size="large" />
          </div>
          <div class="pro-img">
            <img :src="baseURL+pro.product.productPic" alt="">
          </div>
          <div class="pro-name">{{pro.product.productName}}</div>
          <div class="pro-price">{{pro.product.productSellPrice}}元</div>
          <div class="pro-num">
            <el-input-number @change="(pnum)=>{changeNum(pnum,pro.product.productId)}" v-model="pro.num" :min="1" :max="99" size="small" />
          </div>
          <div class="pro-total pro-total-in">{{pro.product.productSellPrice * pro.num}}元</div>
          <div class="pro-action">
            <el-popconfirm width="150px" title="确定删除吗？"
            confirm-button-text="确定"
            cancel-button-text="取消"
            @confirm="delShoppingCart(pro.userId,pro.product.productId)">
              <template #reference>
                <el-icon size="18"><CircleCloseFilled /></el-icon>
              </template>
            </el-popconfirm>
          </div>
        </li>
      </ul>
      <div style="height: 20px; background-color: rgb(245, 245, 245);"></div>
      <div class="cart-bar">
        <div class="cart-bar-left">
          <span>
            <router-link to="/goods">继续购物</router-link>
          </span>
          <span class="sep">|</span>
          <span class="cart-total">
            共 <span class="cart-total-num">{{totalNum}}</span> 件商品，已选择 <span class="cart-total-num">{{ckNum}}</span> 件
          </span>
        </div>
        <div class="cart-bar-right">
          <span>
            <span class="total-price-title">合计：</span>
            <span class="total-price">{{total_Price}}元</span>
          </span>
          <el-popconfirm width="150px" title="确定购买吗？"
            confirm-button-text="确定"
            cancel-button-text="取消"
            @confirm="buy">
              <template #reference>
                <button class="btn-primary">去结算</button>
              </template>
          </el-popconfirm>
        </div>
      </div>
    </div>
    <div class="mb20"></div>
  </div>
</template>
<script setup>
import {$shoppingcart_delete,$shoppingcart_addOrder,$shoppingcart_update,$shoppingcart_updateNum,$shoppingcart_delete_batch} from '../api/shoppingcart'
import { ShoppingCartFull,CircleCloseFilled } from '@element-plus/icons-vue'
import {computed,ref} from 'vue'
import {useShoppingcart,useUser} from '../store/index'
// 导入通知消息框
import { ElNotification  } from 'element-plus'
// 根路径
import {baseURL} from '../config/index'
// 获取购物车全局状态
let shoppingcartStore = useShoppingcart()
// 获取当前登录用户
let userStore = useUser()
// 总数量
let totalNum = computed(()=>{
  return shoppingcartStore.shoppingcartList.reduce((a,b)=>a+b.num,0)
})
// 选中数量
let ckNum = computed(()=>{
  return shoppingcartStore.shoppingcartList.filter(r=>r.state).reduce((a,b)=>a+b.num,0)
})
// 总价
let total_Price = computed(()=>{
  return shoppingcartStore.shoppingcartList.filter(r=>r.state).reduce((a,b)=>a+b.product.productSellPrice*b.num,0)
})


// 全选
let ckAll = computed({
  get(){
    return shoppingcartStore.shoppingcartList.every(r=>r.state)
  },
  set(val){
    shoppingcartStore.shoppingcartList.forEach(r=>r.state=val)
  }
})
// 删除购物车方法
let delShoppingCart = async (user_id,product_id)=>{
  // 先删除本地数据
  shoppingcartStore.delShoppingCart(user_id,product_id)
  // 再删除远程数据
  let {message,success} = await $shoppingcart_delete({
    user_id,product_id
  })
  if(success){
    ElNotification({
      title: '通知',
      message,
      type: 'success',
    })
  }else{
    ElNotification({
      title: '通知',
      message,
      type: 'error',
    })
  }
}

// 监听到数据变化后，更新购物车数量
let changeNum = async (num,product_id)=>{
  await $shoppingcart_updateNum({
    user_id:userStore.user.user_id,
    product_id,
    num
  })
}
// 结算
let buy = async ()=>{
  // 获取需要结算的商品数组
  let products = shoppingcartStore.shoppingcartList.filter(r=>r.state)
  if(products.length===0) {
    ElNotification({
      title: '通知',
      message:'请选择需要结算的商品',
      type: 'warning',
    })
    return
  }
  
  // let {success,message} = await $shoppingcart_addOrder({
  //   user_id:userStore.user.user_id,
  //   products,
  //   totalPrice:shoppingcartStore.shoppingcartList.filter(r=>r.state).reduce((a,b)=>a+b.product.productSellPrice*b.num,0)
    
  // })
  // if(success){
  //   //删除购物车信息
  let uid = userStore.user.user_id;
  var pids=[];
  for(var i = 0;i<products.length;i++){
      pids[i] =  products[i].productId
  }
  let ids = pids.join(",");  //  id1,id2,id3
  // await $shoppingcart_delete_batch({
  //   uid,
  //   pids:ids
  // })
  // let delUrl = "http://localhost:8080/shopcart/deleteBatch?uid="+uid+"&pids="+ids
  // location.href = delUrl
  // console.log("删除完成");
  //去支付
  let url = "http://localhost:8080/alipay/pay?userId="+uid+"&ids="+ids+"&orderNo="+new Date().getTime()+"&orderName="+userStore.user.userName+"的订单&totalPrice="+shoppingcartStore.shoppingcartList.filter(r=>r.state).reduce((a,b)=>a+b.product.productSellPrice*b.num,0);
  location.href=url
  
  // 重新加载购物车
  shoppingcartStore.loadShoppingcartList()
  // }else{
  //   ElNotification({
  //     title: '通知',
  //     message,
  //     type: 'error',
  //   })
  // }
}
</script>
<style scoped lang='scss'>
.shopping-header{
  height: 64px;
  border-bottom: 2px solid #ff6700;
  background-color: #fff;
  margin-bottom: 20px;
  .content{
    width: 1226px;
    margin: 0 auto;
    display: flex;
    p{
      font-size: 28px;
      line-height: 58px;
      display: flex;
      align-items: center;
      font-weight: 400;
      color: #424242;
    }
    span{
      color: #757575;
      font-size: 12px;
      height: 20px;
      line-height: 20px;
      margin-top: 30px;
      margin-left: 15px;
    }
  }
}
.shopping-content{
  width: 1226px;
  margin: 0 auto;
  background-color: #fff;
  .pro-check{
      width: 110px;
      text-align: center;
    }
    .pro-img{
      height: 85px;
      width: 120px;
      img{
        height: 80px;
        width: 80px;
      }
    }
    .pro-name{
      width: 380px;
    }
    .pro-price{
      width: 140px;
      padding-right: 18px;
      text-align: center;
    }
    .pro-num{
      width: 150px;
      text-align: center;
    }
    .pro-total{
      width: 200px;
      padding-right: 81px;
      text-align: right;
    }
    .pro-total-in{
      color: #ff6700;
    }
    .pro-action{
      width: 80px;
      text-align: center;
      &:hover{
        color: #ff6700;
      }
    }
  .content-header{
    height: 85px;
    padding-right: 26px;
    color: #424242;
    display: flex;
    align-items: center;
    border-bottom: 1px solid #b0b0b0;
  }
  .product-list{
    height: 116px;
    padding: 15px 26px 15px 0;
    border-top: 1px solid #e0e0e0;
    display: flex;
    align-items: center;
  }
  .cart-bar{
    width: 1226px;
    height: 50px;
    line-height: 50px;
    background-color: #fff;
    display: flex;
    justify-content: space-between;
    .cart-bar-left{
      a{
        line-height: 50px;
        margin-left: 32px;
        color: #757575;
        &:hover{
          color: #ff6700;
        }
      }
      .sep{
        color: #eee;
        margin: 0 20px;
      }
      .cart-total{
        color: #757575;
        .cart-total-num{
          color: #ff6700;
        }
      }
    }
    .cart-bar-right{
      .total-price-title{
        color: #ff6700;
        font-size: 14px;
      }
      .total-price{
        color: #ff6700;
        font-size: 30px;
      }
      .btn-primary{
        cursor: pointer;
        border: none;
        float: right;
        width: 200px;
        height: 50px;
        text-align: center;
        font-size: 18px;
        margin-left: 50px;
        background: #ff6700;
        color: #fff;
      }
    }
  }
}
.mb20{
  height: 20px;
}
</style>