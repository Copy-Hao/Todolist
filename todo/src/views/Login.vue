<template>
  <div>
    <div class="row col-6 offset-3 border p-5 my-5">
      <form @keyup.enter="findUser()" class="col-12">
        <div class="form-group">
          <label for="exampleInputEmail1">账号：</label>
          <input
            v-model="user.account"
            type="text"
            class="form-control"
            placeholder="请输入您的账号"
          />
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">用户名：</label>
          <input
            v-model="user.username"
            type="text"
            class="form-control"
            placeholder="请输入您的用户名"
          />
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">密码：</label>
          <input
            v-model="user.password"
            type="password"
            class="form-control"
            placeholder="请输入您的密码"
          />
        </div>
        <div class="row d-flex justify-content-center">
          <small class="text-danger">{{ tip }}</small>
        </div>
        <a
          v-on:click="findUser()"
          class="col-5 btn btn-primary mt-4 text-light"
        >
          登录
        </a>
        <button type="reset" class="col-5 btn btn-info mt-4 float-right">
          重置
        </button>
      </form>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      user: {
        account: "",
        username: "",
        password: "",
      },
      tip: "",
    };
  },
  methods: {
    findUser: function () {
      var _this = this;
      axios
        .get("http://localhost:8181/Login/findUser/" + _this.user.account)
        .then((res) => {
          if (
            res.data.username === _this.user.username &&
            res.data.password === _this.user.password
          )
            _this.$router.push("/Todo");
            _this.$store.commit("updateAccount", _this.user.account);
        })
        .catch((err) => {
          _this.tip = "账号或用户名或密码错误";
        });
    },
  },
};
</script>
<style lang="">
</style>