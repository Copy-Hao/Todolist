import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    account: ""
  },
  mutations: {
    updateAccount(state, account = 0) {
      return state.account = account
    }
  },
  getters:{
    getterAccount(state){
      return state.account
    }
  },
  actions: {
  },
  modules: {
  }
})
