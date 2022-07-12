# Banco digital desafio DIO
Este repositório foi criado para o desafio da DIO, onde foi criado um sistema de banco digital em Java e foi solicitada a implementação de melhorias neste sistema. Não foram descritas quais melhorias deveriam ser implementadas, ficando a merce da criatividade dos alunos.

## O que é o projeto
É uma aplicação console escrita em Java, que simula o funcionamento de um banco digital, onde o sistema armazena dados de clientes e contas, permitindo ações de saque, deposito e transferência.

## Dependências 
Foi utilizada a implementação "OpenJDK" na versão 11 (sendo 11 a versão do Java, do runtime environment e da máquina virtual).

## Como executar essa aplicação?
Clone o repositório e abra o projeto no seu editor de texto ou IDE de preferência, e execute o projeto tendo a classe "Main" como ponto de entrada

## Alterações
1. **Criação do pacote "Entities**: Todas as classes, com exceção da Main, foram inseridas dentro de um pacote denominado "Entities". Isso foi feito para melhorar a organização do código, categorizando as classes por tipos.
2. **Criação do pacote "Entities.Exceptions"**: Devido a implementação de regras de negócio, foi necessária a criação de exceções personalizadas, que são alocadas dentro do pacote "Entities.Exceptions". Essas exceções customizadas são: DomainException (Erro dem uma regra de negócio) e CancelarAcaoException (Quando o usuário cancela uma ação em uma "tela" - mais explicações a frente - da aplicação).
3. **Remoção da interface "IConta"**: Essa interface foi criada durante o desafio apenas a título de exemplo, ela não trazia nenhum benefócio para o código.
4. **Classe abstrata "Conta" faz a impressão do extrato**: Essa ação antes tinha implementação apenas nas classes concretas, mas agora possui uma implementação padrão na classe base, reduzindo a duplicidade de código.
5. **Impedir saque/transferência maior que saldo da conta**: Foi implementada uma regra de negócio que impede o cliente de sacar/transferir um valor maior que o disponível no saque da conta.
6. **Criado uma factory de contas**: Como existe uma regra de negócio para decidir o tipo de conta que será criado, essa regra foi abstraída para uma classe chamada "ContaFactory". A técnica de criar factories (fábricas) para instanciação de objetos é um desing pattern chamado "factory pattern".
7. **Adicionado propriedade id para a classe de cliente**: O usuário agora pode interagir diretamente com os clientes cadastrados, e isso é feito através de uma nova propriedade, o "id".
8. **O usuário pode cadastrar clientes, abrir contas, fazer depositos, saques e transferências e listar todas as contas e clientes**: Agora o usuário poderá realizar todas essas ações através do terminal, sem a necessidade de fazer nenhuma alteração no código.
9. **Adicionadas 8 "telas" para a aplicação**: Através de 8 classes de implementação e 1 abstrata, foram criadas 8 interfaces que simulam 8 telas distintas para o sistema. Através dessas 8 telas, o usuário poderá fazer todas as ações descritas no item número "8".