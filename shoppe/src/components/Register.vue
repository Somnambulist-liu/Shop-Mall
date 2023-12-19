<template>
  <el-dialog
    v-model="showRegister"
    title="注册"
    center
    width="22%"
    :before-close="handleClose"
  >
  <el-form
    ref="ruleFormRef"
    :model="ruleForm"
    status-icon
    :rules="rules"
  >
    <el-form-item prop="username">
      <el-input :prefix-icon="User" placeholder="请输入账号" v-model="ruleForm.username" />
    </el-form-item>
    <el-form-item prop="password">
      <el-input :prefix-icon="View" placeholder="请输入密码" v-model="ruleForm.password" type="password" autocomplete="off" />
    </el-form-item>
    <el-form-item prop="nickname">
      <el-input :prefix-icon="View" placeholder="请输入昵称" v-model="ruleForm.nickname"  autocomplete="off" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm(ruleFormRef)">注册</el-button>
    </el-form-item>
  </el-form>
  </el-dialog>
</template>
<script setup>
// 导入请求api
import {$register,$checkUserName} from '../api/user'
// 导入图标
import {User,View} from '@element-plus/icons-vue'
// 导入消息框
import { ElMessage } from 'element-plus'
import {defineExpose,ref,reactive} from 'vue'
// 是否显示注册界面
let showRegister = ref(false)
// 关闭对话框
let handleClose = (done)=>{
  // 重置表单
  ruleFormRef.value.resetFields()
  // 关闭窗口
  done()
}

// 定义表单Ref对象
const ruleFormRef = ref(null)
// 定义表单数据
const ruleForm = reactive({
  username:'',
  password:'',
  nickname:'',
})
// 验证用户名
const validateUserName = async (rule, value, callback)=>{
  if (value === '') {
    callback(new Error('请输入用户名'))
  } else {
    // 正则验证用户名规则是否正确
    if(/^\w{6,18}$/.test(value)){
      // 验证用户名是否重复
      let {success} = await $checkUserName({userName:value})
      if(success){
        callback(new Error('该用户名已经存在，请重新输入'))
      }else{
        callback()  //验证成功
      }
    }else{
      callback(new Error('用户名必须是由字母、数字、_ 组成的6-18位字符'))
    }
  }
}
// 验证密码
const validatePassword = (rule, value, callback)=>{
  if (value === '') {
    callback(new Error('请输入密码'))
  } else {
    if(/^\w{6,18}$/.test(value)){
      callback()
    }else{
      callback(new Error('密码必须是由字母、数字、_ 组成的6-18位字符'))
    }
  }
}
// 验证昵称
const validateNickName = (rule, value, callback)=>{
  if (value === '') {
    callback(new Error('请输入昵称'))
  } else {
    //昵称的正则校验表达式
    if(/^[\u4e00-\u9fa5|\w]{2,18}$/.test(value)){
      callback()//验证成功
    }else{
      callback(new Error('昵称必须是由中文、字母、数字、_ 组成的2-18位字符'))
    }
  }
}

// 验证表单数据
const rules = reactive({
  username: [{ validator: validateUserName, trigger: 'blur' }],
  password: [{ validator: validatePassword, trigger: 'blur' }],
  nickname: [{ validator: validateNickName, trigger: 'blur' }],
})
// 表单的提交方法
const submitForm = (formEl) => {
  console.log(!formEl);
  if (!formEl) return
  formEl.validate(async (valid) => {
    console.log(valid);
    if (valid) {
      let {success,message} = await $register({...ruleForm})
      if(success){
        ElMessage({
          showClose: true,
          message,
          type: 'success',
        })
        // 清空表单
        formEl.resetFields()
      }else{
        ElMessage({
          showClose: true,
          message,
          type: 'error',
        })
      }
    } else {
      return false
    }
  })
}

// 暴露组件成员
defineExpose({
  showRegister
})
</script>
<style scoped lang='scss'>
.el-button--primary{
  width: 100%;
}
</style>