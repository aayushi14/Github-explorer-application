<template>
  <div class="container">
    <div class="d-flex justify-content-between bd-highlight mb-3">
      <div class="p-2 bd-highlight">
        <div class="search-bar d-flex">
          <div class="px-2">
            <i class="fa fa-search"></i>
          </div>
          <div class="px-2">
            <input id="searchInput" class="search-input" @keyup.enter="getRepo($event)" v-model="searchInput" type="text" placeholder="Some string in repository"/>
          </div>
          <div>
            <button class="search-button" v-on:click="getRepo(searchInput)">Find</button> (All JavaScript and PHP repositories)
          </div>
        </div>
      </div>
      <div class="p-2 bd-highlight"></div>
      <div class="p-2 bd-highlight">
        <button class="btn-outline-success float-right" v-on:click="getAllBookmarks()">My Bookmarks (scrolldown)</button>
      </div>
    </div>
    <div class="table-container" v-if="ifShow">
      <table class="table table-bordered my-4">
        <thead class="thead-light">
          <tr class="text-center">
            <th scope="col">#</th>
            <th scope="col">Repo Name</th>
            <th scope="col">Repo Url</th>
            <th scope="col">Owner Name</th>
            <th scope="col">Bookmark</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="repo,index in repositories" v-bind:key="repo.id">
            <th class="index" scope="row">{{index+1}}</th>
            <td class="px-5">{{repo.name}}</td>
            <td class="px-5"><a v-bind:href ="repo.html_url"><i class="px-2 fab fa-github"></i>GitHub Link</a></td>
            <td class="px-5"><a v-bind:href ="repo.owner.html_url"><img width="50" height="50" thumbnail v-bind:src="repo.owner.avatar_url" /> {{repo.owner.login}}</a></td>
            <td class="px-5"><Bookmark :repo="repo"/></td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="table-container" v-if="hasBookmark">
      <p>My Bookmarks</p>
      <table class="table table-bordered my-4">
        <thead class="thead-light">
          <tr class="text-center">
            <th scope="col">#</th>
            <th scope="col">Repo Name</th>
            <th scope="col">Repo Url</th>
            <th scope="col">Owner Name</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="repo,index in bookmarks" v-bind:key="repo.id">
            <th class="index" scope="row">{{index+1}}</th>
            <td class="px-5">{{ repo.repo_name }}</td>
            <td class="px-5"><a v-bind:href ="repo.repo_url"><i class="px-2 fab fa-github"></i>GitHub Link</a></td>
            <td class="px-5"><a v-bind:href ="repo.owner_url"><img width="50" height="50" thumbnail v-bind:src="repo.avatar_url" /> {{repo.owner_name}}</a></td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Bookmark from './Bookmark.vue';

export default {
  name: 'RepoList',
  props: ['repo', 'bookmarked'],
  components: {
    Bookmark,
  },

  data() {
    return {
      repositories: [],
      searchInput: '',
      ifShow: '',
      bookmarks: [],
      hasBookmark: '',
      username: 'a',
    };
  },

  mounted() {
      this.ifShow = this.ifShow ? true : false;
  },

  methods: {
    getRepo(searchInput) {
      this.ifShow = true;
      axios.get(`http://localhost:9000/api/repositories?q=` + this.searchInput)
          .then((response) => {
            this.repositories = response.data;
          })
          .catch((error) => {
            this.ifShow = false;
            console.log(error);
          });
    },
    getAllBookmarks() {
      axios.get(`http://localhost:9000/api/bookmarks?q=` + this.username)
          .then((response) => {
            this.bookmarks = response.data;
            if (this.bookmarks.length !== 0) {
              this.hasBookmark = true;
            } else {
              alert('You have not bookmarked any repo yet!');
            }
          })
          .catch((error) => {
            this.hasBookmark = false;
            console.log(error);
          });
    },
  },
};

</script>

<style scoped lang="less">
.grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 10px;
  grid-auto-rows: minmax(100px, auto);
}

.container {
  width: 100%;
}
.search-input {
  width: 300px;
  border-radius: 5px;
}
.search-button {
  background: #1a6845;
  color: #eeeeee;
  width: 120px;
}

.bookmark-button {
  background: #1a6845;
  color: #eeeeee;
  width: 150px;
}

p {
  font-weight: bold;
  color: #2c3e50;
}
</style>
