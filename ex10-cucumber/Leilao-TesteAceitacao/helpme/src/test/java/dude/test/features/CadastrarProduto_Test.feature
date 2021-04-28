Feature: Cadastrar Produto
    Cadastrar Produtos

Background:
Given O cadastro do usuario Ernani Cesar foi realizado

@CadastrarProdutoSucesso
Scenario: Cadastrar um produto novo
Given O nome de Produto "Bitcoin"
And a descricao "Reserva de valor digital"
And o lance minimo de 270000.00
And o cpf do leiloador é o do Ernani Cesar "055.761.919-00"
And a data limite é 2731982
When O produto é cadastrado
Then o sistema avisa que o cadastro teve sucesso

@CadastrarProdutoFalha
Scenario: Cadastrar um produto com um mesmo nome
Given O nome de Produto "Bitcoin"
And a descricao "Reserva de valor digital"
And o lance minimo de 270000.00
And o cpf do leiloador é o do Ernani Cesar "055.761.919-00"
And a data limite é 2731982
And O produto é cadastrado pela primeira vez
When O produto é cadastrado pela segunda vez
Then o sistema avisa que o cadastro falhou "O  produto  ja  existe  ou  o  leiloador  nao  esta cadastrado."
