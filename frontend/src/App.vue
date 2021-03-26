<template>
  <div id="app" class="container">
    <h1>Java + VueJS + Keycloak</h1>
    <button class="btn btn-outline-secondary" @click="keycloak.logout()">Logout</button>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
  props: [ 'keycloak' ],
}
</script>
