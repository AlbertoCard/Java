<template>
  <h1>Lista de alumnos</h1>
  <Alumnos/>
</template>

<script>
import Alumnos from './components/Alumnos.vue'

export default {
  name: 'App',
  components: {
    Alumnos
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
