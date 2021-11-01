<template>
  <div>
    <div class="container-fluid">
      <div class="row col-7 offset-3 my-5">
        <h1 class="display-3">Welcome To Todo List</h1>
      </div>
      <ul class="nav justify-content-center">
        <li class="nav-item">
          <a class="nav-link">
            <router-link to="/Login">登录</router-link>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link">
            <router-link to="/Signin">注册</router-link>
          </a>
        </li>
      </ul>

      <router-view />
    </div>
  </div>
</template>
<script>
export default {
};
</script>
<style lang="">
</style>