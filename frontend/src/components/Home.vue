<template>
  <div class="py-3">
    <p>Welcome to the test application</p>

    <button class="btn btn-primary" @click="getUser">Call Java API</button>

    <div class="mt-3">
      <h3>Backend Response</h3>
      <pre v-if="user" class="bg-dark text-white mt-3 p-3 w-50">{{ user }}</pre>

      <h3>Token</h3>
      <div class="jwt-token mt-3 p-3">
        {{ token }}
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import axios from 'axios';

export default {
  name: 'Home',

  data() {
    return {
      user: null,
    };
  },

  created() {
    this.getUser();
  },

  methods: {
    getUser() {
      axios
          .get('/users')
          .then(response => (this.user = response.data));
    }
  },

  computed: {
    ...mapGetters({
      token: 'auth/token',
    }),
  }
}
</script>

<style scoped>
.jwt-token {
  width: 50%;
  display: block;
  padding: 20px;
  font-size: 13px;
  line-height: 1.42857143;
  word-break: break-all;
  word-wrap: break-word;
  background-color: #f5f5f5;
  border: 1px solid #ccc;
  color: #d63aff;
}
</style>
