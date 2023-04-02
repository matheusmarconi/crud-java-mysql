CREATE DATABASE mercado;

CREATE TABLE produtos (
    id int not null auto_increment primary key,
    produto varchar(30),
    marca varchar(20),
    dataCadastro date)