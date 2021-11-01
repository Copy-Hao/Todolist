<template>
  <div>
    <div id="todo" class="container-fluid p-0">
      <div class="row">
        <div class="jumbotron col-12">
          <h1
            v-bind:title="author"
            class="display-3 d-flex justify-content-center"
          >
            {{ title }}
          </h1>
          <!-- <h2 class="display-5 d-flex justify-content-center">用户{{this.$store.state.account}}欢迎您</h2> -->
        </div>
      </div>
    </div>
    <div class="container-fluid p-0 col-6 offset-3">
      <div class="row">
        <div class="form-group p-0 col-12">
          <input
            v-on:keyup.enter="addItem()"
            v-model="inputValue"
            type="text"
            class="form-control"
            name="input"
            id="input"
            aria-describedby="helpId"
            placeholder="输入你的待办事项"
          />
        </div>
      </div>
      <div class="row mb-3">
        <button
          v-if="isEmpty"
          type="button"
          name=""
          id=""
          class="btn btn-secondary btn-md disabled btn-block col-12"
        >
          添加
        </button>
        <button
          v-else
          v-on:click="addItem()"
          type="button"
          name="add"
          id="add"
          class="col-12 btn btn-info btn-md btn-block"
        >
          添加
        </button>
      </div>
      <div v-for="(item, index) in todoList" class="row my-0">
        <div class="col-12 alert alert-info my-0" role="alert">
          <strong>{{ item.todoname }}</strong>
          <button
            v-on:click="deleteItemInTodoList(index)"
            class="float-right"
            style="outline: none; border: none; background-color: transparent"
          >
            <strong v-bind:title="iconInfo.cross" class="text-danger">X</strong>
          </button>
          <button
            v-on:click="changeToSucessItem(index)"
            class="float-right"
            style="outline: none; border: none; background-color: transparent"
          >
            <strong v-bind:title="iconInfo.tick" class="text-success">√</strong>
          </button>
        </div>
      </div>
      <div v-for="(item, index) in successList" class="row my-0">
        <div class="col-12 alert alert-success my-0" role="alert">
          <strong
            ><s>{{ item.todoname }}</s></strong
          >
          <button
            v-on:click="removeItemInSuccessList(index)"
            class="float-right"
            style="outline: none; border: none; background-color: transparent"
          >
            <strong v-bind:title="iconInfo.cross" class="text-danger">X</strong>
          </button>
          <button
            v-on:click="changeToTodoItem(index)"
            class="float-right"
            style="outline: none; border: none; background-color: transparent"
          >
            <strong v-bind:title="iconInfo.todo" class="text-primary">↑</strong>
          </button>
        </div>
      </div>
      <div class="row my-3 d-flex justify-content-between">
        <button
          v-if="AllItemIsTodo"
          type="button"
          class="col-3 btn btn-outline-secondary disabled"
        >
          设置全部未完成
        </button>
        <button
          v-else
          v-on:click="setAllItemTodo()"
          type="button"
          class="col-3 btn btn-outline-info"
        >
          设置全部未完成
        </button>
        <button
          v-if="AllItemIsSuccess"
          type="button"
          class="col-3 btn btn-outline-secondary disabled"
        >
          设置全部已完成
        </button>
        <button
          v-else
          v-on:click="setAllItemSuccess()"
          type="button"
          class="col-3 btn btn-outline-success"
        >
          设置全部已完成
        </button>
        <button
          v-if="notHasItem"
          type="button"
          class="col-3 btn btn-outline-secondary disabled"
        >
          删除所有项
        </button>
        <button
          v-on:click="removeAllItem()"
          v-else
          type="button"
          class="col-3 btn btn-outline-danger"
        >
          删除所有项
        </button>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  created() {
    let _this = this;
    axios
      .get("http://localhost:8181/Todo/findTodos/" + _this.$store.state.account)
      .then((res) => {
        console.log(res);
        for (const key in res.data) {
          if (res.data[key].status === "completed")
            _this.successList.push(res.data[key]);
          else _this.todoList.push(res.data[key]);
        }
      })
      .catch((err) => {
        console.log("服务器开小差去了");
      });
  },
  data() {
    return {
      iconInfo: {
        tick: "改为已完成",
        cross: "删除",
        todo: "改为未完成",
      },
      author: "create by hehao",
      title: "Welcome To Todo List!",
      todoList: [],
      successList: [],
      inputValue: "",
    };
  },
  methods: {
    deleteItemInTodoList: function (index) {
      axios
        .delete(
          "http://localhost:8181/Todo/deleteById/" + this.todoList[index].id
        )
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.error(err);
        });
      this.todoList.splice(index, 1);
    },
    removeItemInSuccessList: function (index) {
      axios
        .delete(
          "http://localhost:8181/Todo/deleteById/" + this.successList[index].id
        )
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.error(err);
        });
      this.successList.splice(index, 1);
    },
    addItem: function () {
      if (this.inputValue === "") alert("请输入需要添加的内容");
      else {
        var obj = {
          id: "",
          account: this.$store.state.account,
          todoname: this.inputValue,
          status: "incompleted",
        };
        axios
          .post("http://localhost:8181/Todo/addItem", obj)
          .then((res) => {
            console.log(res);
            obj.id = res.data.id;
          })
          .catch((err) => {
            console.error(err);
          });
        this.todoList.push(obj);
        this.inputValue = "";
      }
    },
    changeToSucessItem: function (index) {
      var item = this.todoList[index];
      item.status = "completed";
      axios
        .put("http://localhost:8181/Todo/save", item)
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.error(err);
        });
      this.todoList.splice(index, 1);
      this.successList.push(item);
    },
    changeToTodoItem: function (index) {
      var item = this.successList[index];
      item.status = "incompleted";
      axios
        .put("http://localhost:8181/Todo/save", item)
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.error(err);
        });
      this.successList.splice(index, 1);
      this.todoList.push(item);
    },
    setAllItemTodo: function () {
      this.successList.forEach((element) => {
        element.status = "incompleted";
        axios
          .put("http://localhost:8181/Todo/save", element)
          .then((res) => {
            console.log(res);
          })
          .catch((err) => {
            console.error(err);
          });
        this.todoList.push(element);
      });
      this.successList = [];
    },
    removeAllItem: function () {
      this.todoList.forEach((element) => {
        axios
          .delete("http://localhost:8181/Todo/deleteById/" + element.id)
          .then((res) => {
            console.log(res);
          })
          .catch((err) => {
            console.error(err);
          });
      });
      this.successList.forEach((element) => {
        axios
          .delete("http://localhost:8181/Todo/deleteById/" + element.id)
          .then((res) => {
            console.log(res);
          })
          .catch((err) => {
            console.error(err);
          });
      });
      this.todoList = [];
      this.successList = [];
    },
    setAllItemSuccess: function () {
      this.todoList.forEach((element) => {
        element.status = "completed";
        axios
          .put("http://localhost:8181/Todo/save", element)
          .then((res) => {
            console.log(res);
          })
          .catch((err) => {
            console.error(err);
          });
        this.successList.push(element);
      });
      this.todoList = [];
    },
  },
  computed: {
    isEmpty: function () {
      if (this.inputValue === "") return true;
      return false;
    },
    AllItemIsTodo: function () {
      if (this.successList.length === 0) return true;
      return false;
    },
    AllItemIsSuccess: function () {
      if (this.todoList.length === 0) return true;
      return false;
    },
    notHasItem: function () {
      if (this.todoList.length === 0 && this.successList.length === 0)
        return true;
      return false;
    },
  },
};
</script>
<style lang="">
</style>