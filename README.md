# SoulUp Society — Sprint 3 (Java)

Tradução para Java do protótipo original em Python do desafio SoulUp × FIAP,
no mesmo nível de projeto Java simples visto em aula (model + DAO + classe
de teste com main, sem frameworks).

## Estrutura

```
soulup-java/
├── sql/schema.sql                 -> script de criação do banco
└── src/br/com/fiap/soulup/
    ├── connection/ConnectionFactory.java
    ├── models/
    │   ├── Usuario.java
    │   ├── Postagem.java
    │   ├── BilheteUnico.java
    │   └── Missao.java
    ├── dao/
    │   ├── UsuarioDAO.java
    │   ├── PostagemDAO.java
    │   └── BilheteUnicoDAO.java
    └── tests/TesteSoulUp.java     -> classe com o método main
```

## Ferramentas usadas

- Java (JDK 8 ou superior)
- Oracle Database (servidor remoto da FIAP — sem instalação local)
- Oracle SQL Developer (para rodar o script SQL)
- Driver JDBC: ojdbc11.jar (ou ojdbc8.jar)
- IDE: Eclipse, NetBeans ou IntelliJ

## Como rodar

1. **Banco de dados**: abra o SQL Developer, conecte com o seu usuário/RM
   e senha da FIAP (host `oracle.fiap.com.br`, porta `1521`, SID `ORCL`),
   e rode o script `sql/schema.sql`. Isso cria as tabelas e já deixa uma
   conta de teste cadastrada:
   - usuário: `Usuario_teste`
   - senha: `senha_usuario`

2. **Importar o projeto**: crie um projeto Java na sua IDE e copie a pasta
   `src` para dentro dele.

3. **Adicionar o driver do Oracle**: baixe o `.jar` do ojdbc (ojdbc11.jar
   ou ojdbc8.jar) e adicione-o ao Build Path (Eclipse) ou às Libraries
   (NetBeans/IntelliJ) do projeto.

4. **Conferir a conexão**: em `ConnectionFactory.java`, troque `RM000000`
   e `suaSenha` pelo seu RM e senha reais do Oracle da FIAP.

5. **Executar**: rode a classe `TesteSoulUp` (ela tem o método `main`).
   Faça login com a conta de teste e navegue pelos menus.

## Métodos de lógica de negócio (na classe TesteSoulUp)

1. `conversao(pontos)` — converte pontos em dinheiro (R$ 0,0096 por ponto).
2. `conversaoPassagem(quantidade)` — converte pontos em passagens do
   bilhete único (580 pontos por passagem).
3. `conversaoDesconto(quantidade)` — converte pontos em vales de desconto
   (113 pontos por vale), liberado só depois que o limite de passagens
   chega a zero.
4. `validacaoDin(pontos, pontosAtuais)` — valida se a conversão solicitada
   é possível com o saldo de pontos atual.
