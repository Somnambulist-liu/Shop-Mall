<template>
  <div class="page">
    <div class="shopping-header">
      <div class="content">
        <p>
          <el-icon color="#ff6700" size="28"><List /></el-icon>
          &nbsp;我的订单
        </p>
      </div>
    </div>
    <div class="shopping-content" v-for="order in orderList" :key="order.order+new Date().getTime()">
      <ul>
        <li class="order">
          <span class="order_id">订单编号: {{order.orderId}}</span>
          <span class="order_time">订单时间: {{order.createTime}}</span>
        </li>
        <li class="content-header">
          <div class="pro-check">
          </div>
          <div class="pro-img"></div>
          <div class="pro-name">商品名称</div>
          <div class="pro-price">单价</div>
          <div class="pro-num">数量</div>
          <div class="pro-total">小计</div>
          <div class="pro-action"></div>
        </li>
        <li class="product-list" v-for="pro in order.shopcartList" :key="pro.scid+new Date().getTime()">
          <div class="pro-check">
          </div>
          <div class="pro-img">
            <img :src="baseURL+pro.product.productPic" alt="">
          </div>
          <div class="pro-name">{{pro.product.productName}}</div>
          <div class="pro-price">{{pro.product.productPrice}}元</div>
          <div class="pro-num">{{pro.num}}</div>
          <div class="pro-total pro-total-in">{{pro.product.productSellPrice*pro.num}}元</div>
          <div class="pro-action">
            
          </div>
          <input type="hidden">
        </li>
      </ul>
      <div class="cart-bar">
        <div class="cart-bar-left">
          <span class="cart-total">
            共 <span class="cart-total-num">{{order.shopcartList.length}}</span> 件商品
          </span>
        </div>
        <div class="cart-bar-right">
          <span>
            <span class="total-price-title">合计：</span>
            <span class="total-price">{{order.totalPrice}}元</span>
          </span>
        </div>
      </div>
    </div>
    <div class="mb20"></div>
  </div>
</template>
<script setup>
import {$order_getUserOrder} from '../api/shoppingcart'
import { List } from '@element-plus/icons-vue'
import {useUser} from '../store/index'
import {onMounted,reactive} from 'vue'
import {baseURL} from '../config/index'
// 订单数组
let orderList = reactive([])
const userStore= useUser()
const loadUserOrder = async ()=>{
  let {data} = await $order_getUserOrder({user_id:userStore.user.user_id})
  orderList = data
  // console.log(data);
  // console.log(orderList)
  // data.forEach(r=>{
  //   let index = orderList.findIndex((o)=>o.oid===r.oid)
  //   if(index!=-1){
  //     orderList[index].products.push(r)
  //     orderList[index].totalPrice += r.product.product_price*r.pnum
  //   }else{
  //     orderList.push({
  //       // 订单编号
  //       oid:r.oid,
  //       // 订单时间
  //       createTime:r.createTime,
  //       // 订单数据
  //       products:[r],
  //       // 总价
  //       totalPrice: r.product.product_price*r.pnum
  //     })
  //   }
  // })
}
// 格式化时间
// let formatTime = (time)=>{
//   let date = new Date(time)
//   let y = date.getFullYear()
//   let m = date.getMonth()+1
//   let d = date.getDate()
//   let h = date.getHours()
//   let mi = date.getMinutes()
//   let s = date.getSeconds()
//   return [y,m,d].map(r=>r>=10?r:'0'+r).join('-')+' '+[h,mi,s].map(r=>r>=10?r:'0'+r).join(':')
// }
onMounted(()=>{
  loadUserOrder()
})
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
  .order{
    height: 80px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-size: 18px;
    padding: 0 20px;
    border-bottom: 1px solid #ff6700;
    .order_id{
      color: #ff6700;
    }
  }
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
    padding: 0 20px;
    border-top: 1px solid #ff6700;
    height: 60px;
    line-height: 60px;
    background-color: #fff;
    display: flex;
    justify-content: space-between;
    margin-bottom: 20px;
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