# Simples Dental

##OBJETIVO

Desenvolva uma API que execute o CRUD completo atráves de uma interface REST e que atenda aos requisitos descritos na seção [teste](#TESTE). A api deve ser desenvolvida em JAVA utilizando o framework [Play Framework](https://www.playframework.com/documentation/2.4.x/NewApplication) e banco de dados [Postgresql](http://www.postgresql.org/) utilize Hibernate ou queries nativas para manipular o banco de dados.

##ENTREGA

Faça um fork deste repositório e suba seu código nele. Depois abra um pull-request.

Obrigado e bom divertimento 💪💪.





##TESTE

####Contatos

```
SCHEMA DE CONTATO
  nome: String
  contato: String
```

#####Api http interface
```
GET /contacts
  params
    q: Busca
      RETURN Lista de contatos que contenham o texto passado em qualquer um dos seus atributos.
    fields: List<String>
      RETURN Lista de contatos apenas com os fields passados.
RETURN Lista de profissionais.

GET /contacts/:id
RETURN Recupera os contato que atende ao ID indicado.

POST /contacts
RETURN Sucesso contato cadastrado.

PUT /contacts/:id
RETURN Altera o contato que atende ao ID indicado.

DELETE /contacts/:id
RETURN Sucesso contato excluído
````




####Profissionais

```
SCHEMA DE PROFISSIONAL
  nome: String
  cargo: ENUM
    0: Desenvolvedor
    1: Designer
    2: Suporte
    3: Tester
  nascimento: Date
  create_data: Date
  contatos: List<SCHEMA DE CONTATO>
```

#####Api http interface
```
GET /professionals
  params
    q: Busca
      RETURN Lista de profissionais que contenham o texto passado em qualquer um dos seus atributos.
    fields: List<String>
      RETURN Lista de profissionais apenas com os fields passados.
RETURN Lista de profissionais.

GET /professionals/:id
RETURN O profissional que atende ao ID indicado.

POST /professionals
RETURN Sucesso profissional cadastrado.

PUT /professionals/:id
RETURN Altera o profissional que atende ao ID indicado.

DELETE /professionals/:id
RETURN Sucesso profissional excluído

/**
* Ao criar um profissional os contatos também são criados.
 * Ao editar um profissional os contatos também são editados.
 */
```
