/************************************************************************** 
* Verity TI
* --------------------------- 
* Criado por...:           lovelace
* Em...........:           21/10/2017
* Projeto......:           HackInDebt
* Descrição....:           Script para criação do banco Inadimplencia
* Tabelas envoldidas:      todas
**************************************************************************/ 

CREATE DATABASE INADIMPLENCIA

GO
USE INADIMPLENCIA

CREATE TABLE Usuario(
 ID INT not null IDENTITY(1,1) PRIMARY KEY,
 CPF VARCHAR (11) NOT NULL,
 Senha VARCHAR (20) NOT NULL,
 email VARCHAR(30)
)

CREATE TABLE Pessoa(
 ID INT not null IDENTITY(1,1) PRIMARY KEY,
 CPF VARCHAR (11) NOT NULL,
 situacao VARCHAR(30),
 renda float,
 saldo float,
 vl_GastosFixo float NOT NULL,
 vl_Gastos float NOT NULL,
 vl_DividaTotal float NOT NULL,	
 Parcelas INT,
 vl_Parcelas float
)

--INSERT NAS TABELAS

USE INADIMPLENCIA

INSERT INTO Usuario VALUES ('42016714883',1,'igor.almeida@verity.com.br');

INSERT INTO Pessoa VALUES ('42016714883',inadimplente,4000,2100,1000,1500,6000);
