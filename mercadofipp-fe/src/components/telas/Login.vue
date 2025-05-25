<template>
    <div class="card">
        <h4 class="title">Login</h4>
        <div class="field">
            <input type="text" id="nome" v-model="name" placeholder="Digite seu nome" class="input-field">
        </div>
        <div class="field">
            <input type="text" id="senha" v-model="senha" placeholder="Digite sua senha" class="input-field">
        </div>
        <button class="btn" type="submit">Login</button>
    </div>

</template>

<script>
export default {
    data() {
        return {
            id: 0, name: "", senha: "", nivel: 0
        }
    },

    methods:{
        
    }
}
</script>

<style>
.card {
    width: 300px;
    padding: 1.9rem 1.2rem;
    text-align: center;
    background: #2a2b38;
    position: absolute;
    margin-top: calc(10% - 10px);
    margin-left: calc(50% - 150px);
}

.title {
    margin-bottom: 1rem;
    font-size: 1.5em;
    font-weight: 500;
    color: #f5f5f5;
}

.field {
    margin-top: .5rem;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: .5em;
    background-color: #1f2029;
    border-radius: 4px;
    padding: .5em 1em;
}


.input-field {
    background: none;
    border: none;
    outline: none;
    width: 100%;
    color: #d3d3d3;
}

.field input:focus::placeholder {
    opacity: 0;
    transition: opacity .3s;
}

.btn {
    border: none;
    outline: none;
    background-color: #6c5ce7;
    padding: 10px 20px;
    font-size: 12px;
    font-weight: 700;
    color: #fff;
    border-radius: 5px;
    transition: all ease 0.1s;
    box-shadow: 0px 5px 0px 0px #a29bfe;
    margin-top: 10px;
}

button:active {
    transform: translateY(5px);
    box-shadow: 0px 0px 0px 0px #a29bfe;
}
</style>