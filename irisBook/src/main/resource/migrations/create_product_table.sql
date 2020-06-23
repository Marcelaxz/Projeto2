--liquibase formatted sql

      create table product (
          id int not null auto_increment primary key,
          qtd int not null,
          week DATE not null
      );