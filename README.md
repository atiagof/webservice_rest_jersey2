# Webservice REST 1.0.0 (BETA)

##Objetivo
O projeto tem como objetivo mostrar ao técnico ou ao analista de desempenho como uma aplicação
de backend que já é da nova geração funciona de maneira simples.

##Escopo da aplicação e sua arquitetura
Esta aplicação traz o uso de várias ténicas de documentação e de medição de resultados em tempo de execução.

###Dropwizard Metrics 4.0.2:
Para reduzir a utilização de ferramentas externas de instrumentação, foi utilizada essa biblioteca que ajuda a mensurar a utilização das APIs e suas taxa de respostas.

###Jersey 2.26-b03:
Incluímos nessa arquitetura a implementação padrão REST do Java EE para demonstra a sua eficiencia e praticidade.

###Hibernate 5:
Estamos utilizando a última versão do framework mais conhecido para demonstrar o quanto estamos evoluindo na questão de estabilidade e desempenho.

###Swagger CORE 2.0.0-rc4 e Swagger UI:
O Swagger centraliza a documentação das APIs e ajuda nos testes funcionais, ajuda muito nos testes funcionais, mas não automatiza eles.

###PostgreSQL 10
Utilizei o banco de dados relacional PostgreSQL em sua versão 10.0, porém fique a vontade em editar o JPA/Hibernate para utilizar outro RDBMS.

###Tomcat 8.5
Utilizei esse container não somente para simplificar a demanda de stop/start do desenvolvimento mais também por outros motivos de escala do projeto, em outros momentos você verá que um AS da vida não é necessário para uma aplicação REST.

Em um ambiente CLOUD não tem beneficios você deixar máquinas com maior poder de processamento o tempo todo ligadas!
O correto é você ter máquinas com menor poder de processamento, e ir subindo réplicas de sua aplicação em máquinas iguais de acordo com a sua demanda de negócio!

Exemplos:

Requisitos do JBoss EAP 10
2GB RAM
1GB Disco
1 vCPU 2Ghz
Total Dia	: USD 2,00
Total Mês	: USD 62,00

Requisitos do Tomcat 8.5
512mb RAM
1GB Disco
1 vCPU 2Ghz
Total Dia	: USD 0,50
Total Mês	: USD 15,50