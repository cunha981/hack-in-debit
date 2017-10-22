--CRIAÇÃO DAS TABELAS

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

INSERT INTO Usuario VALUES ('1',1,'igor.almeida@verity.com.br');

INSERT INTO Pessoa VALUES ('1',1500,500,null,null);
