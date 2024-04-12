<h1 align="center">
 Password Validator API
</h1>
<h4 align="center">
 Autor: Luiz Roberto Oliveira
</h4>


## Descrição

API para validação de senhas desenvolvido como [teste](https://github.com/itidigital/backend-challenge) para vaga de desenvolvedor backend júnior.

## Como Executar:

### Requisitos:
- Java 17
- Maven
- Git
- Um navegador web

Siga os passos abaixo para executar o projeto:

1. **Clonar o Repositório**: <br/>Primeiro, você precisa clonar o repositório do GitHub para a sua máquina local. Você pode fazer isso usando o comando `git clone` seguido da URL do repositório. Por exemplo:

```bash
git clone https://github.com/luizrobertoao/itau-backend-challenge.git
```
2. **Construir o Projeto**: <br/>Em seguida, você precisa construir o projeto, você pode fazer isso usando o comando `mvn clean package`:

```bash
./mvn clean package
```
3. **Executar a Aplicação**: <br/>Por fim, você pode executar a aplicação usando o comando `java -jar target/pasword-validator-0.0.1-SNAPSHOT.jar`:

```bash
java -jar target/pasword-validator-0.0.1-SNAPSHOT.jar
```
Agora, a sua aplicação deve estar rodando e você pode visualizar sua documentação em: http://localhost:8080/swagger-ui/index.html.
## Tecnologias Utilizadas

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Web](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Lombok](https://projectlombok.org/)
- [JUnit 5](https://junit.org/junit5/)

## Práticas adotadas

- SOLID
- API REST
- Design de API
- Clean Code
- Injeção de Dependências
- Tratamento de exceções global através de classe `@ControllerAdvice`
- Testes Unitários
- Geração automática de documentação Swagger com a OpenAPI 3

## API Endpoints

- Validar senha
```
Request:
http POST localhost:8080/v01/password-validations

Body:
  {
    "password": "exemplodesenha",
  }

```
## Detalhes sobre a solução:
Procurei pautar as decisões da minha solução nos princípios das boas práticas de desenvolvimento de software, como SOLID,
Clean Code, Design de API e API REST. A solução foi desenvolvida utilizando o Spring Boot, que é um framework que facilita
a criação de aplicações Java, sua estrutura bem organizada e documentação abrangente tem ampla aceitação de desenvolvedores 
e empresas contando com uma grande comunidade que suporta o framework e suas bibliotecas.
<br/><br/>
Respeitando a premissa de boas práticas, optei pelo uso de uma arquitetura em camadas que favorece o desacoplamento promove
a organização, estruturação e reusabilidade do código.
<br/><br/>
A escolha das dependências também foi baseada na simplicidade e eficiência, optei por utilizar o SpringDoc OpenAPI 3 para a
geração automática da documentação da API, o Lombok para reduzir a verbosidade do código e o Spring Web para facilitar a
criação de endpoints REST.
<br/><br/>
Destaco aqui o cuidado com a escolha do endpoint que inclui o versionamento da API, isso é importante para garantir a compatibilidade
com versões futuras e evitar que mudanças em endpoints existentes quebrem a integração de consumidores que dependem da API.
<br/><br/>
Para a validação da senha, optei por criar um serviço específico para essa finalidade que recebe a senha e retorna um booleano
indicando se a senha é válida ou não. A validação da senha é feita através de expressões regulares que verificam se a senha
atende aos critérios estabelecidos no desafio, tornando a solução mais elegante, com ganhos em legibilidade, flexibilidade e eficiência..
<br/><br/>
Por fim, a solução conta com testes unitários que garantem a qualidade do código e a correta execução da lógica de validação.
Quanto aos testes de integração, optei por não incluí-los devido ao alto custo de implementação e manutenção, mas não descarto
a possibilidade de incluí-los em versões futuras da aplicação. Mesmo assim, a solução foi amplamente testada utilizando o Postman e
validada com sucesso.
<br/><br/>
A conclusão deste projeto me proporcionou um grande ganho de aprendizado, especialmente no que diz respeito ao uso eficaz de
expressões regulares, testes unitários e documentação de APIs.

### Algumas referências utilizadas:
- https://www.linkedin.com/pulse/spring-framework-historia-e-sua-estrutura-jean-victor/
- https://awari.com.br/arquitetura-de-software-em-camadas-organizando-e-gerenciando-a-estrutura-de-aplicacoes/
- https://rivaildojunior.medium.com/modelo-de-maturidade-de-richardson-para-apis-rest-8845f93b288
- https://www.baeldung.com/exception-handling-for-rest-with-spring


