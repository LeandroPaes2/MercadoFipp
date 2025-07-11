<template>
  <div id="menu">
    <img src="@/assets/logo.png" class="logo">
    <!-- Pesquisar (lupa) no canto superior esquerdo -->
    
    <div class="search-container">
      <input type="text" placeholder="Buscar..." id="busca">
      <svg xmlns="http://www.w3.org/2000/svg" class="search-icon" width="20" height="20" viewBox="0 0 24 24"
        stroke-width="2" fill="none" stroke="currentColor">
        <path d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" stroke-linejoin="round" stroke-linecap="round"></path>
      </svg>
    </div>
    <div style="position: absolute; right: 15%; top: 1.5%; color: white;">
      <div v-if="usuarioLogado">
        Usuário logado: {{ this.usuarioLogado.nome }}
        <button @click="logout()" class="logout">Logout</button>
      </div>
    </div>

    <!-- Ícones -->
    <div class="button-container">

      <!-- Usuario (pessoinha) -->
      <button class="button">
        <router-link to="/form-usuario/Usuario" class="button">
          <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24" stroke-width="0"
            fill="currentColor" stroke="currentColor" class="icon">
            <path
              d="M12 2.5a5.5 5.5 0 0 1 3.096 10.047 9.005 9.005 0 0 1 5.9 8.181.75.75 0 1 1-1.499.044 7.5 7.5 0 0 0-14.993 0 .75.75 0 0 1-1.5-.045 9.005 9.005 0 0 1 5.9-8.18A5.5 5.5 0 0 1 12 2.5ZM8 8a4 4 0 1 0 8 0 4 4 0 0 0-8 0Z">
            </path>
          </svg>
        </router-link>
      </button>

      <!-- Menu (casinha) -->
      <button class="button">
        <router-link to="/menu" class="button">
          <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 1024 1024" stroke-width="0"
            fill="currentColor" stroke="currentColor" class="icon">
            <path
              d="M946.5 505L560.1 118.8l-25.9-25.9a31.5 31.5 0 0 0-44.4 0L77.5 505a63.9 63.9 0 0 0-18.8 46c.4 35.2 29.7 63.3 64.9 63.3h42.5V940h691.8V614.3h43.4c17.1 0 33.2-6.7 45.3-18.8a63.6 63.6 0 0 0 18.7-45.3c0-17-6.7-33.1-18.8-45.2zM568 868H456V664h112v204zm217.9-325.7V868H632V640c0-22.1-17.9-40-40-40H432c-22.1 0-40 17.9-40 40v228H238.1V542.3h-96l370-369.7 23.1 23.1L882 542.3h-96.1z">
            </path>
          </svg>
        </router-link>
      </button>

      <!-- Categorias (mais) -->
      <button id="toggleMenu" class="button">
        <router-link to="/form-anuncio/Anuncio" class="button">
          <svg viewBox="0 0 24 24" fill="none" width="1em" height="1em" xmlns="http://www.w3.org/2000/svg" class="icon">
            <path
              d="m17 21-5-4-5 4V3.889a.92.92 0 0 1 .244-.629.808.808 0 0 1 .59-.26h8.333a.81.81 0 0 1 .589.26.92.92 0 0 1 .244.63V21Z"
              stroke-width="2" stroke-linejoin="round" stroke-linecap="round" stroke="currentColor"></path>
          </svg>
        </router-link>
      </button>



      <!-- Carrinho (carrinho) -->
      <button class="button">
        <router-link to="/form-categoria/Categoria" class="button">
          <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" stroke-linejoin="round"
            stroke-linecap="round" viewBox="0 0 24 24" stroke-width="2" fill="none" stroke="currentColor" class="icon">
            <circle r="1" cy="21" cx="9"></circle>
            <circle r="1" cy="21" cx="20"></circle>
            <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path>
          </svg>
        </router-link>
      </button>
    </div>
  </div>




  <!-- Anuncios -->

  <!-- <div id="anuncios">
      <div class="anuncio" v-for="n in 5" :key="n">
        <a :href="'/anuncio/' + n">
          <img :src="'https://via.placeholder.com/150?text=Anuncio+' + n">
        </a>
        <p>Anúncio {{ n }}</p>
      </div>
    </div> -->

  <!-- <div id="anuncios">
    <div class="anuncio" v-for="(imagens, index) in listaAnuncios" :key="index">
      <div class="carrossel">
        <img :src="imagens[imagemAtual[index]]" alt="Imagem do anúncio">
        <div class="botoes">
          <button @click="anterior(index)">&#10094;</button>
          <button @click="proximo(index)">&#10095;</button>
        </div>
      </div>
      <p>Anúncio {{ index + 1 }}</p>
    </div>
  </div> -->

  <!-- <div id="anuncios">
    <div class="anuncio" v-for="(imagens, index) in listaAnuncios" :key="index">
      <Swiper :modules="[Navigation]" :navigation="false" class="carrossel" ref="swiperRefs[index]">
        <SwiperSlide v-for="(img, idx) in imagens" :key="idx">
          <img :src="img" alt="Imagem do anúncio">
        </SwiperSlide>
      </Swiper>
      <div class="botoes-swiper">
        <button @click="slidePrev(index)">&#10094;</button>
        <button @click="slideNext(index)">&#10095;</button>
      </div>
      <p>Anúncio {{ index + 1 }}</p>
    </div>
  </div> -->



</template>


<script setup>import { Swiper, SwiperSlide } from 'swiper/vue';
import 'swiper/css';
import { Navigation } from 'swiper/modules';
import { ref, onMounted } from 'vue';

const listaAnuncios = [
  [
    'https://via.placeholder.com/300x300?text=Anuncio+1+Imagem+1',
    'https://via.placeholder.com/300x300?text=Anuncio+1+Imagem+2',
    'https://via.placeholder.com/300x300?text=Anuncio+1+Imagem+3'
  ],
  [
    'https://via.placeholder.com/300x300?text=Anuncio+2+Imagem+1',
    'https://via.placeholder.com/300x300?text=Anuncio+2+Imagem+2'
  ],
  [
    'https://via.placeholder.com/300x300?text=Anuncio+3+Imagem+1',
    'https://via.placeholder.com/300x300?text=Anuncio+3+Imagem+2',
    'https://via.placeholder.com/300x300?text=Anuncio+3+Imagem+3'
  ],
  [
    'https://via.placeholder.com/300x300?text=Anuncio+4+Imagem+1'
  ],
  [
    'https://via.placeholder.com/300x300?text=Anuncio+5+Imagem+1',
    'https://via.placeholder.com/300x300?text=Anuncio+5+Imagem+2'
  ],
];

// Cria uma lista de referências para os carrosseis
const swiperRefs = ref([]);

onMounted(() => {
  swiperRefs.value = listaAnuncios.map(() => null);
});

const slidePrev = (index) => {
  swiperRefs.value[index]?.swiper.slidePrev();
};

const slideNext = (index) => {
  swiperRefs.value[index]?.swiper.slideNext();
};

</script>


<script>
import FormCategoria from '../Formulario/FormCategoria.vue';
import FormUsuario from '../Formulario/FormUsuario.vue';


export default {
  name: 'Menu',
  data() {
    return {
      usuarioLogado: {}
    }
  },
  created() {
    this.usuarioLogado = localStorage.getItem('usuarioLogado')
    if (!this.usuarioLogado) {
      this.$router.push('/') // Redireciona se não estiver logado
    }
    else{
      this.usuarioLogado = JSON.parse(this.usuarioLogado)
    }
  },
  methods: {
    logout() {
      localStorage.removeItem('usuarioLogado')
      this.$router.push('/')
    }
  },
  components: {
    FormCategoria,
    FormUsuario
  }
}
</script>

<style>
.carrossel {
  position: relative;
}

.carrossel img {
  width: 100%;
  height: 300px;
  object-fit: cover;
  border-radius: 8px;
}

.botoes {
  position: absolute;
  top: 50%;
  width: 100%;
  display: flex;
  justify-content: space-between;
  transform: translateY(-50%);
}

.botoes button {
  background-color: rgba(0, 0, 0, 0.5);
  border: none;
  color: white;
  font-size: 18px;
  cursor: pointer;
  padding: 5px 10px;
  border-radius: 50%;
  transition: background-color 0.3s;
}

.botoes button:hover {
  background-color: rgba(0, 0, 0, 0.8);
}



/* ---------------------------------------------------------------------- MENU ---------------------------------------------------------------------- */

.logo {
  width: 60px;
  position: absolute;
  left: 20px;
  top: 10px;
}

#menu {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #0c343c;
  padding: 15px;

}

.menu-lateral {
  display: flex;
  justify-content: flex-end;
  width: 100%;
  max-width: 1000px;
  /* ajuste conforme o tamanho desejado */
  margin-top: 10px;
  /* espaçamento da barra rosa */
}

#menu-esquerda {
  display: flex;
}

#menu-esquerda>div {
  background-color: #2F4F4F;
  width: 100px;
  margin: 5px;
  text-align: center;
  line-height: 40px;
  font-size: 18px;
}

#menu-esquerda>div a {
  color: white;
  text-decoration: none;
}

#menu-direita {
  display: flex;
  align-items: center;
}

.search-container {
  position: relative;
  display: flex;
  align-items: center;
  margin-left: auto;
  top: -5.5px;
}

#busca {
  padding: 10px 30px 5px 10px;
  border-radius: 5px;
  border: none;
  position: absolute;
  top: 7px;
  right: 20px;

}

.logout{
    padding: 8px;
    border: none;
    border-radius: 8px;
    background: #0b5154;
    color: white;
    font-weight: bold;
    cursor: pointer;

}

.logout:hover {
  background: #0f3f49;
}

.button-container {
  display: flex;
  background-color: rgb(155 141 42);
  padding: 0 20px;
  height: 40px;
  align-items: center;
  justify-content: center;
  border-radius: 10px;
  box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px,
    rgba(105, 104, 94, 0.5) 5px 10px 15px;
  gap: 20px;
}

.button {
  outline: 0 !important;
  border: 0 !important;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: transparent;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #fff;
  transition: all ease-in-out 0.3s;
  cursor: pointer;
}

.button:hover {
  transform: translateY(-3px);
}

.icon {
  font-size: 20px;
}


.search-icon {
  position: absolute;
  top: 17px;
  right: 25px;
  cursor: pointer;
  color: #555;
}

/* ------------------------------------------------------------------- CATEGORIAS ------------------------------------------------------------------- */




/* --------------------------------------------------------------- CARDS DOS ANUNCIOS --------------------------------------------------------------- */

#anuncios {
  display: flex;
  justify-content: center;
  flex-wrap: nowrap;
  /* Impede quebrar de linha */
  gap: 50px;
  /* Espaçamento entre os cards */
  margin: 40px auto;
  max-width: 100%;
  /* Pode ocupar toda largura */
}

.anuncio {
  background-color: #f1f1f1;
  padding: 15px;
  border-radius: 10px;
  width: 300px;
  /* Largura fixa */
  height: 450px;
  /* Altura aumentada conforme solicitado */
  text-align: center;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.anuncio img {
  width: 100%;
  height: 300px;
  object-fit: cover;
  border-radius: 8px;
}

.anuncio p {
  margin-top: 15px;
  font-weight: bold;
  font-size: 18px;
  color: #2F4F4F;
}

.swiper-button-next,
.swiper-button-prev {
  position: static;
  margin: 0 10px;
  color: white;
  background-color: rgba(0, 0, 0, 0.5);
  width: 35px;
  height: 35px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  top: 50%;
  transform: translateY(-50%);
}

.swiper-button-next:hover,
.swiper-button-prev:hover {
  background-color: rgba(0, 0, 0, 0.8);
  color: #ffd700;
  /* Dourado ou outra cor que combine */
}

.botoes-swiper {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 10px;
  gap: 20px;
}

.swiper-button-next::after,
.swiper-button-prev::after {
  font-size: 16px;
  font-weight: bold;
}

.anuncio:hover {
  transform: translateY(-10px);
}

.swiper-button-next::after {
  content: '›';
}

.swiper-button-prev::after {
  content: '‹';
}


#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2F4F4F;
}
</style>
