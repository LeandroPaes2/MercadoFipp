<template>

    <div id="menu" style="padding: 15px">
    <img src="@/assets/logo.png" class="logo">

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
    <svg viewBox="0 0 24 24" fill="none" height="24" width="24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" class="svg w-6 h-6 text-gray-800 dark:text-white">
      <path d="m17 21-5-4-5 4V3.889a.92.92 0 0 1 .244-.629.808.808 0 0 1 .59-.26h8.333a.81.81 0 0 1 .589.26.92.92 0 0 1 .244.63V21Z" stroke-width="2" stroke-linejoin="round" stroke-linecap="round" stroke="currentColor"></path>
    </svg>
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


  <div>
    <h1>{{ msg }}</h1>
    <div v-if="formOn">
      <form @submit.prevent="this.gravar()">
        <label for="name">Nome</label>
        <input type="text" id="name" v-model="nome" placeholder="Nome da Categoria..">
        <input type="submit" value="Cadastrar">
      </form>
    </div>
    <div style="display: flex; justify-content: flex-end;">
      <button @click="this.mostrarForm(true)">Nova Categoria</button>
    </div>
    <div>
      <table id="customers">
        <thead>
          <tr>
            <th>Id</th>
            <th @click="ordenarNome()">Nome</th>
            <th colspan="2">Ações</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cat in this.categorias">
            <td>{{cat.id}}</td>
            <td>{{cat.nome}}</td>
            <td><button @click="this.alterar(cat.id)">Alterar</button></td>
            <td><button @click="this.apagar(cat.id)">Apagar</button></td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'FormCategoria',
  props: {
    msg: String
  },
  data(){
    return {id:0, nome:"",formOn:false, 
    categorias:[]}
  },
  methods:{
    mostrarForm(flag)
    {
      this.formOn=flag;
    },
    gravar(){
      const url = 'http://localhost:8080/apis/categoria';
      const data = { id: this.id, nome: this.nome};
      axios.post(url, data)
      .then(response => {
        this.carregarDados();
      })
      .catch(error => {
        alert('Erro:', error);
      });
      this.mostrarForm(false);
    },
    apagar(id){
      axios.delete("http://localhost:8080/apis/categoria/"+id)
      .then(result=>{this.carregarDados()})
      .catch(error=>{alert(error)})
    },
    alterar(id){
      this.formOn=true;
      axios.get("http://localhost:8080/apis/categoria/"+id)
      .then(result=>{        
        const categoria=result.data;
        this.id=categoria.id;
        this.nome=categoria.nome;
      })
      .catch(error=>{alert(error)})

      alert('Alterando '+id);
    },
    carregarDados(){
      axios.get("http://localhost:8080/apis/categoria")
      .then(result=>{this.categorias=result.data})
      .catch(error=>{alert(error)})
    },
    ordenarNome(){
      this.categorias.sort((a,b)=>a.nome.localeCompare(b.nome));
    }
  },
  mounted(){
    this.carregarDados();
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
input[type=text],
select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  padding: 20px;
}

#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td,
#customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even) {
  background-color: #f2f2f2;
}

#customers tr:hover {
  background-color: #ddd;
}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>