<template>
  <div id="menu">
    <div><router-link to ="form-categoria">Categoria</router-link></div>
    <div><router-link to = "form-usuario">Usuário</router-link></div>
  </div>
  <router-view></router-view>
</template>

<script>
import FormCategoria from './components/FormCategoria.vue'
import FormUsuario from './components/FormUsuario.vue'

export default {
  name: 'App',
  components: {
    FormCategoria, FormUsuario
  }
}
</script>

<style>
#menu {
  display: flex;
  justify-content: flex-end;
  background-color: DodgerBlue;
}

#menu > div {
  background-color: #f1f1f1;
  width: 100px;
  margin: 5px;
  text-align: center;
  line-height: 40px;
  font-size: 18px;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
