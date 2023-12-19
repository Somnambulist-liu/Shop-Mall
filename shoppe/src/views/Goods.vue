<template>
  <div class="page">
    <div class="breadcrumb">
      <div class="content">
        <el-breadcrumb :separator-icon="ArrowRight">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>全部商品</el-breadcrumb-item>
          <el-breadcrumb-item>分类</el-breadcrumb-item>
        </el-breadcrumb>
        <div class="nav">
          <div class="title">分类</div>
          <el-tabs type="card" class="tabs" v-model="activeName" @tab-change="tabChange">
            <el-tab-pane :label="item.categoryName" :name="item.categoryId" 
              v-for="(item,index) in categorys" :key="item.category_id"></el-tab-pane>
          </el-tabs>
        </div>
      </div>
    </div>
    <div class="products">
      <Item v-for="item in products" :key="item.productId" :item="item"></Item>
    </div>
    <div class="pagination">
      <el-pagination background layout="prev, pager, next"
       v-model:current-page="pageIndex" :page-size="15" :total="total"
       @current-change="loadProducts" />
    </div>
  </div>
</template>
<script setup>

// 导入列表项组件
import Item from '../components/Item.vue'
// 导入图标
import { ArrowRight } from '@element-plus/icons-vue'
// 导入api方法
import {$category_all} from '../api/category'
import {$product_search} from '../api/product'
// 导入组合式api
import {onMounted,ref} from 'vue'
import {useRoute} from 'vue-router'
import { watch } from 'vue'

let route = useRoute()
// console.log(route.query.name,"name");

watch(() => route.query.t,
  (newPath, oldPath) => {
    searchName.value = route.query.name
    loadProducts()
  }
);

// 当前分类
const activeName = ref(0)
// 所有分类的数组
const categorys = ref([])
// 当前页码
const pageIndex = ref(1)
// 商品数组--》接收服务器返回的数据
const products = ref([])
const searchName = ref('')
// 总数量
const total = ref(0)
// 加载所有分类方法
const loadCatetorys = async ()=>{
  categorys.value = await $category_all()
  categorys.value.unshift({
    categoryId: '', categoryName: '全部'
  })
}
// 加载商品方法
const loadProducts = async ()=>{
  let {data,count,currentPage} = await $product_search({
    category_id:activeName.value,
    product_name:searchName.value,
    pageIndex:pageIndex.value,
    pageSize:15
  })
  products.value = data
  total.value = count
  pageIndex.value = currentPage
}
// 分类切换事件
const tabChange = ()=>{
  searchName.value = ''
  loadProducts()
}
//钩子-->已加载
onMounted(()=>{
  // 加载所有分类
  loadCatetorys()
  // 加载商品
  loadProducts()
})
</script>
<style scoped lang='scss'>
.breadcrumb{
  background-color: white;
  .content{
    width: 1226px;
    margin: 0 auto;
    .el-breadcrumb{
      font-size: 16px;
    }
    .nav{
      margin-top: 15px;
      display: flex;
      align-items: center;
      .title{
        font-weight: bold;
        font-size: 16px;
        margin-right: 20px;
      }
      .tabs{
        flex: 1;
      }
      ::v-deep .el-tabs__header{
        margin: 0;
      }
    }
  }
}
.products{
  width: 1240px;
  overflow: hidden;
  margin: 0 auto;
  margin-top: 14px;
  transform: translateX(-14px);
}
.pagination{
  width: 1226px;
  margin: 0 auto;
  margin-top: 10px;
  padding-bottom: 20px;
  display: flex;
  justify-content: center;
}
</style>