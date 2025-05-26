<template>
  <div id="menu">
    <div id="menu-esquerda">
      <div><router-link to="/form-categoria/Categoria">Categoria</router-link></div>
      <div><router-link to="/form-usuario/Usuario">Usuário</router-link></div>
    </div>
    <div id="menu-direita">
      <input type="text" placeholder="Buscar..." id="busca">
    </div>
  </div>

  <div id="anuncios">
    <div class="anuncio" v-for="n in 5" :key="n">
      <a :href="'/anuncio/' + n">
        <img :src="'https://via.placeholder.com/150?text=Anuncio+' + n">
      </a>
      <p>Anúncio {{ n }}</p>
    </div>
  </div>

  <router-view></router-view>
</template>

<script>
import FormCategoria from '../Formulario/FormCategoria.vue';
import FormUsuario from '../Formulario/FormUsuario.vue';

export default {
  name: 'App',
  components: {
    FormCategoria,
    FormUsuario
  }
}
</script>

<style>
#menu {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #FFFAF0;
  padding: 10px;
}

#menu-esquerda {
  display: flex;
}

#menu-esquerda > div {
  background-color: #2F4F4F;
  width: 100px;
  margin: 5px;
  text-align: center;
  line-height: 40px;
  font-size: 18px;
}

#menu-esquerda > div a {
  color: white;
  text-decoration: none;
}

#menu-direita {
  display: flex;
  align-items: center;
}

#busca {
  padding: 5px;
  border-radius: 5px;
  border: none;
}

#anuncios {
  display: flex;
  justify-content: space-around;
  gap: 30px; /* Espaçamento maior entre os retângulos */
  margin: 40px auto;
  flex-wrap: wrap;
  max-width: 1200px; /* Limita a largura máxima do container */
}

.anuncio {
  background-color: #f1f1f1;
  padding: 15px;
  border-radius: 10px;
  width: 300px; /* Largura maior */
  text-align: center;
  box-shadow: 0 4px 10px rgba(0,0,0,0.1);
  transition: transform 0.3s ease;
}

.anuncio:hover {
  transform: translateY(-10px);
}

.anuncio img {
  width: 100%;
  height: 200px; /* Altura fixa maior */
  object-fit: cover; /* Faz a imagem preencher sem distorcer */
  border-radius: 8px;
}

.anuncio p {
  margin-top: 15px;
  font-weight: bold;
  font-size: 18px;
  color: #2F4F4F;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2F4F4F;
}
</style>
