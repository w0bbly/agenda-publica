Agenda Publica

A agenda publica é um projeto desenvolvido em Java que pretende simular a existência de uma agenda global. O projeto foi realizado em Java com framework de Spring Boot.

Para o funcionamento desta aplicação precisamos de seguir alguns passos simples:

- Ter o Postgres instalado no sistema (pois foi a BD usada). O username/password usados foram postgres/admin mas podem ser configurados via o ficheiro application.properties. O nome da BD usado foi agenda mas tambem é possivel configurar o mesmo no mesmo ficheiro.

- Seguir o protocolo explicado adiante neste Readme. Os endpoints e objectos usados foram feitos para serem usados de acordo com as normas establecidas aqui.

- A aplicação com a configuração atual corre em ambiente local (não é necessário deploy em nenhum servidor aplicacional, pois o Spring Boot já fornece esse Servidor), ou seja, basta fazer clone do projeto para o IDE e configurar a BD

A aplicação consiste de uma agenda publica. Nao existem controlos de acesso de qualquer modo. Nao existem qualquer tipo de restrições ao nivel da BD para moradas e numeros de telefone repetidos. Tentou-se ao máximo manter a simplicidade para não tornar a aplicação demasiado complexa.

As entidades do sistema são:

Contact, Address e TelephoneNumber. 

Sendo que um # Contact possui apenas um #Address e pode possuir N # TelephoneNumbers
