Feature: Cadastrar Usuario
    Cadastrar usuarios

@CadastrarUsuarioSucesso
Scenario: Cadastrar Usuario com Sucesso
Given O nome de usuario "Ernani Cesar"
And o enderco "Campus Universitario"
And e o CPF "055.761.919-00"
And e o e-mail "ernani.santos@posgrad.ufsc.br"
When O usuario é cadastrado
Then o sistema avisa que o cadastro do usuario teve sucesso