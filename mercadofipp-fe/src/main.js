import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'

import App from './components/telas/App.vue'
import Login from './components/telas/Login.vue'
import FormCategoria from './components/Formulario/FormCategoria.vue'
import FormUsuario from './components/Formulario/FormUsuario.vue'


const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', component: Login, props: true },
    { path: '/form-categoria/:msg', component: FormCategoria, props: true },
    { path: '/form-usuario/:msg', component: FormUsuario, props: true }
  ]
})


const app = createApp(Login) 
app.use(router)
app.mount('#app')
