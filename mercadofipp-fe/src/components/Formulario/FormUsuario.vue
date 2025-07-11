<template>

  <div id="menu">
    <img src="@/assets/logo.png" class="logo">
    
    
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


  <div class="container-usuario">
    <div>
    <h1 class="titulo" style="color: white">{{ msg }}</h1>

    <div v-if="formOn" class="form-box">
      <form @submit.prevent="this.gravar()" class="formulario">
        <label for="name">Nome</label>
        <input type="text" id="name" v-model="nome" placeholder="Nome do Usuário..." />

        <label for="senha">Senha</label>
        <input type="password" id="senha" v-model="senha" placeholder="Senha ..." />

        <label for="nivel">Nível</label>
        <select id="nivel" v-model="nivel" placeholder="Nível...">
          <option value="1">Administrador</option>
          <option value="2">Comum</option>
        </select>

        <input type="submit" value="Confirmar" class="btn-confirmar" />
      </form>
      <button @click="this.fecharForm(false)" class="btn-novo" style="position: relative; left: 115%; top: 64.5px">
        Fechar
      </button>
    </div>

    <div class="btn-novo-container">
      <button @click="this.mostrarForm(true)" class="btn-novo">
        Novo Usuário
      </button>

    </div>
  </div>
    
      <table id="customers">
        <thead>
          <tr>
            <th >Id</th>
            <th @click="ordenarNome()">Nome</th>
            <th>Senha</th>
            <th>Nivel</th>
            <th colspan="2">Ações</th>
          </tr>
        </thead>
        <tbody style="color: black">
          <tr v-for="usu in this.usuarios">
            
            <td>{{ usu.id }}</td>
            <td>{{ usu.nome }}</td>
            <td>{{ usu.senha }}</td>
            <td>{{ usu.nivel }}</td>
            <td style="justify-items: center;">
              <button @click="this.alterar(usu.id)" class="button" style="top: 4px">
                <span class="shadow"></span>
                <span class="edge"></span>
                <div class="front">
                  <span>Alterar</span>
                </div>
              </button>
            </td>
            <td style="justify-items: center;">
              <button @click="this.apagar(usu.id)" class="button" style="top: 4px">
                <span class="edge"></span>
                <div class="front">
                  <span>Excluir</span>
                </div>
              </button>
            </td>
          </tr>
        </tbody>
      </table>
  </div>

</template>

<!-- ////////////////////////////////////// -->

<script>
import axios from 'axios'

export default {
  name: 'FormUsuario',
  props: {
    msg: String
  },
  data() {
    return {
      id: 0, nome: "", senha: "", nivel: 0, formOn: false, alterarando: false ,
      usuarios: [],usuarioLogado:{}
    }
  },
  created() {
    this.usuarioLogado = localStorage.getItem('usuarioLogado')
    if (!this.usuarioLogado) {
      this.$router.push('/') // Redireciona se não estiver logado
    }
    else {
      this.usuarioLogado = JSON.parse(this.usuarioLogado);
      if(this.usuarioLogado.nivel != 1)
      {
        this.$router.push('/menu');
      }
    }
  },
  methods: {
    logout() {
      localStorage.removeItem('usuarioLogado')
      this.$router.push('/')
    },
    mostrarForm(flag) {
      this.formOn = flag;
    },
    fecharForm() {
      this.formOn = false;
    },
    gravar() {
      const url = 'http://localhost:8080/apis/usuario';
      let data;
      if(!this.alterarando)
        data = {  nome: this.nome, senha: this.senha, nivel: this.nivel };
      else
        data = {id:this.id  ,nome: this.nome, senha: this.senha, nivel: this.nivel };
      axios.post(url, data)
        .then(response => {
          this.carregarDados();
        })
        .catch(error => {
          alert('Erro:', error);
        });
      this.mostrarForm(false);
      this.nome="";
      this.senha="";
      this.nivel=0;
      this.alterarando=false;
    },
    apagar(id) {
      axios.delete("http://localhost:8080/apis/usuario/" + id)
        .then(result => { this.carregarDados() })
        .catch(error => { alert(error) })
    },
    alterar(id) {
      this.formOn = true;
      this.alterarando=true;
      axios.get("http://localhost:8080/apis/usuario/" + id)
        .then(result => {
          const usuario = result.data;
          this.id = usuario.id;
          this.nome = usuario.nome;
          this.senha = usuario.senha;
          this.nivel = usuario.nivel;
        })
        .catch(error => { alert(error) })

    },
    carregarDados() {
      axios.get("http://localhost:8080/apis/usuario")
        .then(result => { this.usuarios = result.data })
        .catch(error => { alert(error) });
    },
    ordenarNome() {
      this.usuarios.sort((a, b) => a.nome.localeCompare(b.nome));
    }
  },
  mounted() {
    this.carregarDados();
  }
}
</script>

<!-- ////////////////////////////////////// -->

<style scoped>

.container-usuario {
  padding: 30px;
  color: white;
}

.titulo {
  text-align: center;
  margin-bottom: 30px;
  font-size: 2rem;
}

.form-box {
  max-width: 600px;
  margin: 0 auto;
}

.formulario {
  display: flex;
  flex-direction: column;
  gap: 15px;
}

.formulario input,
.formulario select {
  padding: 12px;
  border-radius: 6px;
  border: none;
  font-size: 1rem;
}

.btn-confirmar {
  background-color: #28a745;
  color: white;
  cursor: pointer;
  font-weight: bold;
  transition: background-color 0.3s;
}

.btn-confirmar:hover {
  background-color: #218838;
}

.btn-novo-container {
  display: flex;
  justify-content: flex-end;
  padding: 20px;
}

.btn-novo {
  background-color: #1c1f3f;
  color: white;
  padding: 10px 16px;
  border: none;
  border-radius: 8px;
  font-weight: bold;
  cursor: pointer;
  transition: background-color 0.3s;
}

.btn-novo:hover {
  background-color: #2e3255;
}


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


#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 70%;
  position: relative;
  justify-self: center;
  background-color: white;
}

#customers td,
#customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #2F4F4F;
}

/* button */

.button {
  position: relative;
  border: none;
  background: transparent;
  padding: 0;
  outline: none;
  cursor: pointer;
  font-family: sans-serif;


}

/* Shadow layer */
.button .shadow {
  position: absolute;
  top: 0;
  left: 0px;
  width: 50%;
  height: 50%;
  background: rgba(0, 0, 0, 0.25);
  border-radius: 8px;
  transform: translateY(2px);
  transition: transform 600ms cubic-bezier(0.3, 0.7, 0.4, 1);
}

/* Edge layer */
.button .edge {
  position: absolute;
  top: 0p;
  left: 0;
  width: 50%;
  height: 50%;
  border-radius: 8px;
  background: linear-gradient(to left,
      hsl(217, 33%, 16%) 0%,
      hsl(217, 33%, 32%) 8%,
      hsl(217, 33%, 32%) 92%,
      hsl(217, 33%, 16%) 100%);
}

/* Front layer */
.button .front {
  
  padding: 10px 20px;
  color: white;
  background: hsl(217, 33%, 17%);
  border-radius: 8px;
  transform: translateY(-4px);
  transition: transform 600ms cubic-bezier(0.3, 0.7, 0.4, 1);
}

/* Hover and active states */
.button:hover .shadow {
  transform: translateY(4px);
  transition: transform 250ms cubic-bezier(0.3, 0.7, 0.4, 1.5);
}

.button:hover .front {
  transform: translateY(-6px);
  transition: transform 250ms cubic-bezier(0.3, 0.7, 0.4, 1.5);
}

.button:active .shadow {
  transform: translateY(1px);
  transition: transform 34ms;
}

.button:active .front {
  transform: translateY(-2px);
  transition: transform 34ms;
}

/* Disable text selection */
.button .front span {
  user-select: none;
}
</style>