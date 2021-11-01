<template>
  <div>
    <div class="row col-6 offset-3 border p-5 my-5">
      <form class="col-12">
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
        <button
          @click="addUser()"
          type="button"
          class="col-5 btn btn-outline-primary mt-4"
        >
          注册
        </button>
        <button
          type="reset"
          class="col-5 btn btn-outline-info mt-4 float-right"
        >
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
    };
  },
  methods: {
    addUser: function () {
      let _this = this;
      axios
        .post("http://localhost:8181/Signin/addUser", _this.user)
        .then((res) => {
          if (res.data === "success") {
            _this.$router.push("/Login");
            alert("注册成功！");
          }
          else alert("注册失败！");
        })
        .catch((err) => {
          alert("服务器错误，注册失败！");
        });
    },
  },
};
</script>
<style lang="">
</style>