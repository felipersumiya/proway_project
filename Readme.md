# Sistema de crédito pessoal - Proway
Este sistema tem como finalidade oferecer propostas de crédito aos clientes. O foco é fornecer propostas adequadas a saúde financeira de cada cliente.

### Começando

Para executar o projeto, será necessário instalar os seguintes programas:

- [JDK 10: Necessário para executar o projeto Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html)

- [Sts - Spring Suite Tools: Para desenvolvimento do projeto](https://spring.io/tools)

- [Postman](https://www.postman.com/downloads/)

## Desenvolvimento

Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:

```shell
cd "diretorio de sua preferencia"
git clone https://github.com/condessalovelace/mavenquickstart
```
### Construção

Para construir o projeto com o Maven, executar os comando abaixo:

```shell
mvn clean install
```

O comando irá baixar todas as dependências do projeto e criar um diretório *target* com os artefatos construídos, que incluem o arquivo jar do projeto. Além disso, serão executados os testes unitários, e se algum falhar, o Maven

## Features

O projeto pode ser usado como modelo para iniciar o desenvolvimento de um projeto Java usando o Maven. Ele também demonstra de forma prática como configurar o Maven em um projeto Java.

## Configuração

Para executar o projeto, é necessário utilizar o Eclipse, para que o mesmo identifique as dependências necessárias para a execução no repositório .m2 do Maven. Uma vez importado o projeto, será criado um arquivo *.classpath* que irá informar qual a classe principal para a execução.

## Testes

Para rodar os testes, utilize o comando abaixo:

```
mvn test
```

## Contribuições

Contribuições são sempre bem-vindas! Para contribuir lembre-se sempre de adicionar testes unitários para as novas classes com a devida documentação.

## Links

- [Post de desenvolvimento](https://medium.com/@giu.drawer/criando-um-arquivo-readme-para-o-seu-projeto-afd66ce1af40)

## Licença

Não se aplica.
