function finalizarCadastro(event, form) {
    
    event.preventDefault();
  
    const obj = {
        nome: form.nome.value,
        email: form.email.value,
        CPF: form.cpf.value,
        preferencia: Number(form.preferencia.value)
    }

    alert (obj)
       
    const URL = `http://localhost:8080/pessoa`;
    axios.post(URL, obj)
        .then(response => mostrarResposta(response.data))
        .catch(erro => console.error(erro));
        
    
}


function enviarEmail() {

       
    const URL = `http://localhost:8080/email`;
    axios.get(URL)
        .then(response => mostrarRespostaEmail(response.data))
        .catch(erro => console.error(erro));
        
    
}

function mostrarResposta(response) {
    const mensagem = `
        Email: ${response.email} cadastrado com sucesso! 
    `;
    alert(mensagem);
}

function mostrarRespostaEmail(response) {
    const mensagem = `
        Ação: Disparo realizado com sucesso! 
    `;
    alert(mensagem);
}