<template>
  <div class="home">
    <RepoList />
  </div>
</template>

<script>
import RepoList from '@/components/RepoList.vue';

export default {
  name: 'Home',
  components: {
    RepoList,
  },
};
</script>
