<template>
  <div class="login-form">
    <div id="form-div">
        <h2 class="text-center">Log in</h2>
        <div class="form-group">
            <input class="form-control" type="text" name="username" v-model="input.username"
            placeholder="Username" @keyup.enter="login($event)" require autofocus/>
        </div>
        <div class="form-group">
            <input class="form-control" type="password" name="password" v-model="input.password"
            placeholder="Password" @keyup.enter="login($event)" reqiured/>
        </div>
        <div class="form-group">
            <button class="btn btn-primary btn-block" type="submit" v-on:click="login()">Login</button>
        </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'Login',
    data() {
      return {
        input: {
          username: '',
          password: '',
        },
      };
    },
    methods: {
      login() {
        if (this.input.username !== '' && this.input.password !== '') {
          if (this.input.username === this.$parent.mockAccount.username
            && this.input.password === this.$parent.mockAccount.password) {
            this.$emit('authenticated', true);
            this.$router.replace({ name: 'home' });
          } else {
            alert('The username and / or password is incorrect');
          }
        } else {
          alert('A username and password must be present');
        }
      },
    },
  };
</script>

<style scoped>

/* Loginform https://www.tutorialrepublic.com/codelab.php?topic=bootstrap&file=simple-login-form */

.login-form {
  width: 340px;
  margin: 50px auto;
}
#form-div {
	margin-bottom: 15px;
  background: #f7f7f7;
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  padding: 30px;
}
.login-form h2 {
  margin: 0 0 15px;
}
.form-control, .btn {
  min-height: 38px;
  border-radius: 2px;
}
.btn {
  font-size: 15px;
  font-weight: bold;
}
</style>
