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
                    <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"
                        stroke-width="0" fill="currentColor" stroke="currentColor" class="icon">
                        <path
                            d="M12 2.5a5.5 5.5 0 0 1 3.096 10.047 9.005 9.005 0 0 1 5.9 8.181.75.75 0 1 1-1.499.044 7.5 7.5 0 0 0-14.993 0 .75.75 0 0 1-1.5-.045 9.005 9.005 0 0 1 5.9-8.18A5.5 5.5 0 0 1 12 2.5ZM8 8a4 4 0 1 0 8 0 4 4 0 0 0-8 0Z">
                        </path>
                    </svg>
                </router-link>
            </button>

            <!-- Menu (casinha) -->
            <button class="button">
                <router-link to="/menu" class="button">
                    <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 1024 1024"
                        stroke-width="0" fill="currentColor" stroke="currentColor" class="icon">
                        <path
                            d="M946.5 505L560.1 118.8l-25.9-25.9a31.5 31.5 0 0 0-44.4 0L77.5 505a63.9 63.9 0 0 0-18.8 46c.4 35.2 29.7 63.3 64.9 63.3h42.5V940h691.8V614.3h43.4c17.1 0 33.2-6.7 45.3-18.8a63.6 63.6 0 0 0 18.7-45.3c0-17-6.7-33.1-18.8-45.2zM568 868H456V664h112v204zm217.9-325.7V868H632V640c0-22.1-17.9-40-40-40H432c-22.1 0-40 17.9-40 40v228H238.1V542.3h-96l370-369.7 23.1 23.1L882 542.3h-96.1z">
                        </path>
                    </svg>
                </router-link>
            </button>

            <!-- Categorias (mais) -->
            <button id="toggleMenu" class="button">
                <router-link to="/form-anuncio/Anuncio" class="button">
                    <svg viewBox="0 0 24 24" fill="none" width="1em" height="1em" xmlns="http://www.w3.org/2000/svg"
                        class="icon">
                        <path
                            d="m17 21-5-4-5 4V3.889a.92.92 0 0 1 .244-.629.808.808 0 0 1 .59-.26h8.333a.81.81 0 0 1 .589.26.92.92 0 0 1 .244.63V21Z"
                            stroke-width="2" stroke-linejoin="round" stroke-linecap="round" stroke="currentColor">
                        </path>
                    </svg>
                </router-link>
            </button>



            <!-- Carrinho (carrinho) -->
            <button class="button">
                <router-link to="/form-categoria/Categoria" class="button">
                    <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" stroke-linejoin="round"
                        stroke-linecap="round" viewBox="0 0 24 24" stroke-width="2" fill="none" stroke="currentColor"
                        class="icon">
                        <circle r="1" cy="21" cx="9"></circle>
                        <circle r="1" cy="21" cx="20"></circle>
                        <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path>
                    </svg>
                </router-link>
            </button>
        </div>
    </div>

</template>

<script>

export default {
    name: 'TelaAnuncio',

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
        else {
            this.usuarioLogado = JSON.parse(this.usuarioLogado);
            if (this.usuarioLogado.nivel != 1) {
                this.$router.push('/menu');
            }
        }
    },
    methods: {
        logout() {
            localStorage.removeItem('usuarioLogado')
            this.$router.push('/')
        }
    }
}
</script>

<style></style>