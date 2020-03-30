<template>
    <span v-bind:alt=repo>
        <a href="#" v-if="isBookmarked" @click.prevent="unBookmark(repo)">
            <i class="fas fa-bookmark"></i>
        </a>
        <a href="#" v-else @click.prevent="bookmark(repo)">
            <i class="far fa-bookmark"></i>
        </a>
    </span>
</template>


<script>
  import axios from 'axios';
  import Vue from 'vue';
  import AxiosPlugin from 'vue-axios-cors';
  const cors = require('cors');
  const app = new Vue();
  const corsOptions = {
    origin: 'http://localhost:9000',
    optionsSuccessStatus: 200, // some legacy browsers (IE11, various SmartTVs) choke on 204
  };

  Vue.use(AxiosPlugin);

  export default {
        props: ['repo', 'bookmarked'],

        data: function() {
            return {
                isBookmarked: '',
                username: 'user',
            };
        },
        mounted() {
            this.isBookmarked = this.isBookmark ? true : false;
        },
        computed: {
            isBookmark() {
                return this.bookmarked;
            },
        },

        methods: {
            bookmark(repo) {
              const repoData = {
                username : this.username,
                repo_name : this.repo.name,
                repo_url : this.repo.html_url,
                owner_name : this.repo.owner.login,
                owner_url : this.repo.owner.html_url,
                avatar_url : this.repo.owner.avatar_url,
              };
              axios.post('http://localhost:9000/api/bookmark', repoData)
              .then((response) => this.isBookmarked = true)
              .catch((response) => console.log(response.data));
            },
            unBookmark(repo) {
              const header = {

              };
              const repoData = {
                  username : this.username,
                  repo_url : this.repo.html_url,
              };
              axios.delete('http://localhost:9000/api/unBookmark', repoData, header)
              .then((response) => this.isBookmarked = false)
              .catch((response) => console.log(response.data));
            },
        },
    };
</script>
