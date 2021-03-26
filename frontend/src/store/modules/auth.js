export default {
  namespaced: true,

  state: {
    token: null,
    refreshToken: null,
  },

  mutations: {
    login(state, payload) {
      state.token = payload.token;
      state.refreshToken = payload.refreshToken;
    }
  },

  actions: {

  },

  getters: {
    token: state => state.token,
    refreshToken: state => state.refreshToken,
  }
}