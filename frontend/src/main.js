import Vue from 'vue'
import App from './App.vue'
import axios from 'axios';
import store from './store'
import router from './router'
import * as Keycloak from 'keycloak-js'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';

Vue.config.productionTip = false

// axios
axios.defaults.baseURL = 'http://localhost:8001/';

axios.interceptors.request.use(config => {
  config.headers.common['Authorization'] = 'Bearer ' + store.getters['auth/token'];
  return config;
});


const initOptions = {
  url: 'http://localhost:8888/auth', realm: 'java-vue-keycloak', clientId: 'frontend', onLoad: 'login-required'
}

const keycloak = Keycloak(initOptions);

keycloak
  .init({ onLoad: initOptions.onLoad })
  .then(auth => {

    if (auth) {
      store.commit('auth/login', { token: keycloak.token, refreshToken: keycloak.refreshToken });

      new Vue({
        render: h => h(App, { props: { keycloak: keycloak } }),
        store,
        router,
      }).$mount('#app')

    } else {
      window.location.reload();
    }

    // Token Refresh
    setInterval(() => {
      keycloak.updateToken(70).then((refreshed) => {
        if (refreshed) {
          store.commit('auth/login', { token: keycloak.token, refreshToken: keycloak.refreshToken });
        }
      }).catch(() => {
        console.log('Failed to refresh token');
      });
    }, 60000)

  })
  .catch(() => {
    console.log('Authenticated Failed');
  });
