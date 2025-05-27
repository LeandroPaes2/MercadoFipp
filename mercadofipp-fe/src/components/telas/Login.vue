<template>
    <div class="container">
        <div class="switcher">
            <span :class="{ active: !isSignup }">Login</span>
            <label class="switch">
                <input type="checkbox" v-model="isSignup">
                <span class="slider"></span>
            </label>
            <span :class="{ active: isSignup }">Cadastro</span>
        </div>

        <div class="card" :class="{ flipped: isSignup }">
            <!-- Login -->
            <div v-if="!isSignup" class="form">
                <h2>Login</h2>
                <input type="text" v-model="name" placeholder="Digite seu nome" />
                <input type="password" v-model="senha" placeholder="Digite sua senha" />
                <button @click="this.login()">Entrar</button>
            </div>
            <!-- Cadastro -->
            <div v-else class="form">
                <h2>Cadastro</h2>
                <input type="text" v-model="CadName" placeholder="Digite seu nome" />
                <input type="password" v-model="CadSenha" placeholder="Digite sua senha" />
                <button @click="this.gravar()">Cadastrar</button>
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
            id: 0,
            name: '',
            senha: '',
            CadName: '',
            CadSenha: '',
            CadLevel: 2,
            isSignup: false,
            usuarios: []
        };
    },
    methods: {
        login() {
            axios.get(`http://localhost:8080/apis/usuario/teste/${this.name}`)
                .then(response => {
                    const usuario = response.data;
                    if (usuario.senha === this.senha) {
                        this.$router.push('/menu');
                    } else {
                        alert('Senha incorreta');
                    }
                })
                .catch(() => {
                    alert('Usuário não encontrado');
                });
        }
        ,
        gravar() {
            const url = 'http://localhost:8080/apis/usuario';
            const data = { CadName: this.CadName, Cadsenha: this.Cadsenha, };
            axios.post(url, data)
                .then(response => {
                    alert('Usuário cadastrado com sucesso!');
                    this.carregarDados();
                })
                .catch(error => {
                    alert('Erro:', error);
                });
        },
        carregarDados() {
            axios.get("http://localhost:8080/apis/usuario")
                .then(result => { this.usuarios = result.data })
                .catch(error => { alert(error) })
        }
    },
    mounted() {
        this.carregarDados();
    }
};
</script>

<style scoped>
.container {
    background: #f8f6f2;
    height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

}

.switcher {
    display: flex;
    align-items: center;
    gap: 10px;
    margin-bottom: 20px;
}

.switcher span {
    font-weight: 600;
    color: #333;
    transition: 0.3s;
}

.switcher span.active {
    color: #007BFF;
}

.switch {
    position: relative;
    display: inline-block;
    width: 50px;
    height: 24px;
}

.switch input {
    opacity: 0;
    width: 0;
    height: 0;
}

.slider {
    position: absolute;
    cursor: pointer;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: #ccc;
    border-radius: 34px;
    transition: 0.4s;
}

.slider:before {
    position: absolute;
    content: "";
    height: 18px;
    width: 18px;
    left: 3px;
    bottom: 3px;
    background-color: white;
    border-radius: 50%;
    transition: 0.4s;
}

.switch input:checked+.slider {
    background-color: #007BFF;
}

.switch input:checked+.slider:before {
    transform: translateX(26px);
}

.card {
    width: 300px;
    background: #1c1c1c;
    border-radius: 15px;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.3);
    padding: 20px;
    display: grid;
    transition: transform 0.8s ease-in-out;
    transform-style: preserve-3d;
    position: relative;
}

.card.flipped {
    transform: rotateY(360deg);
}

.form {
    display: flex;
    flex-direction: column;
    gap: 15px;
    backface-visibility: hidden;
}

.form h2 {
    color: white;
    text-align: center;
}

.form input {
    padding: 10px;
    border-radius: 8px;
    border: none;
    outline: none;
    background: #333;
    color: #fff;
}

.form button {
    padding: 10px;
    border: none;
    border-radius: 8px;
    background: #007BFF;
    color: white;
    font-weight: bold;
    cursor: pointer;
}

.form button:hover {
    background: #0056b3;
}

/* Flip */
.card .form:nth-child(2) {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
}
</style>