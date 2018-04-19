# Webservice REST 1.0.0 (BETA)

##Objetivo
O projeto tem como objetivo mostrar ao t�cnico ou ao analista de desempenho como uma aplica��o
de backend que j� � da nova gera��o funciona de maneira simples.

##Escopo da aplica��o e sua arquitetura
Esta aplica��o traz o uso de v�rias t�nicas de documenta��o e de medi��o de resultados em tempo de execu��o.

###Dropwizard Metrics 4.0.2:
Para reduzir a utiliza��o de ferramentas externas de instrumenta��o, foi utilizada essa biblioteca que ajuda a mensurar a utiliza��o das APIs e suas taxa de respostas.

###Jersey 2.26-b03:
Inclu�mos nessa arquitetura a implementa��o padr�o REST do Java EE para demonstra a sua eficiencia e praticidade.

###Hibernate 5:
Estamos utilizando a �ltima vers�o do framework mais conhecido para demonstrar o quanto estamos evoluindo na quest�o de estabilidade e desempenho.

###Swagger CORE 2.0.0-rc4 e Swagger UI:
O Swagger centraliza a documenta��o das APIs e ajuda nos testes funcionais, ajuda muito nos testes funcionais, mas n�o automatiza eles.

###PostgreSQL 10
Utilizei o banco de dados relacional PostgreSQL em sua vers�o 10.0, por�m fique a vontade em editar o JPA/Hibernate para utilizar outro RDBMS.

###Tomcat 8.5
Utilizei esse container n�o somente para simplificar a demanda de stop/start do desenvolvimento mais tamb�m por outros motivos de escala do projeto, em outros momentos voc� ver� que um AS da vida n�o � necess�rio para uma aplica��o REST.

Em um ambiente CLOUD n�o tem beneficios voc� deixar m�quinas com maior poder de processamento o tempo todo ligadas!
O correto � voc� ter m�quinas com menor poder de processamento, e ir subindo r�plicas de sua aplica��o em m�quinas iguais de acordo com a sua demanda de neg�cio!

Exemplos:

Requisitos do JBoss EAP 10
2GB RAM
1GB Disco
1 vCPU 2Ghz
Total Dia	: USD 2,00
Total M�s	: USD 62,00

Requisitos do Tomcat 8.5
512mb RAM
1GB Disco
1 vCPU 2Ghz
Total Dia	: USD 0,50
Total M�s	: USD 15,50