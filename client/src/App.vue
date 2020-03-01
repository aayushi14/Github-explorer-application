<template>
  <div id="app">
    <nav class="navbar navbar-light navbar-expand-md bg-faded justify-content-center" id="nav">
      <a class="navbar-brand d-flex w-50 mr-auto"  v-if="authenticated">GitHub Repository Explorer</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsingNavbar3">
          <span class="navbar-toggler-icon"></span>
      </button>
      <div class="navbar-collapse collapse w-100" id="collapsingNavbar3">
          <ul class="navbar-nav w-100 justify-content-center">
              <li class="nav-item active">
                <router-link class="nav-link" v-if="authenticated" to="/home">Home</router-link>
              </li>
              <li class="nav-item">
                <router-link class="nav-link" v-if="authenticated" to="/about">About</router-link>
              </li>
          </ul>
          <ul class="nav navbar-nav ml-auto w-100 justify-content-end">
              <li class="nav-item">
                  <router-link v-if="authenticated" to="/login" v-on:click.native="logout()" replace>Logout</router-link>
              </li>
          </ul>
        </div>
      </nav>
    <router-view @authenticated="setAuthenticated" />
  </div>
</template>

<script>

export default {
        name: 'App',
        data() {
            return {
                authenticated: false,
                mockAccount: {
                    username: 'user',
                    password: 'user123',
                },
            };
        },
        mounted() {
            if (!this.authenticated) {
                this.$router.replace({ name: 'login' });
            }
        },
        methods: {
            setAuthenticated(status) {
                this.authenticated = status;
            },
            logout() {
                this.authenticated = false;
            },
        },
    };
</script>

<style lang="less">
@import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
@import "../node_modules/@fortawesome/fontawesome-free/css/all.min.css";

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
h1 {
  padding: 0;
  margin-top: 0;
}
#nav {
  padding: 15px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
