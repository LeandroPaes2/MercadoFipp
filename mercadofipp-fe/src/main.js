import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'

import App from './App.vue'
import Menu from './components/telas/Menu.vue'
import Login from './components/telas/Login.vue'
import FormCategoria from './components/Formulario/FormCategoria.vue'
import FormUsuario from './components/Formulario/FormUsuario.vue'
import FormAnuncio from './components/Formulario/FormAnuncio.vue'

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', component: Login, props: true },
    { path: '/menu', component: Menu, props: true },
    { path: '/form-categoria/:msg', component: FormCategoria, props: true },
    { path: '/form-usuario/:msg', component: FormUsuario, props: true },
    { path: '/form-anuncio/:msg', component: FormAnuncio, props: true },
  ]
})


const app = createApp(App) 
app.use(router)
app.mount('#app')
