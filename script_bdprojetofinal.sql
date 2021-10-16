-- criar banco bdprojetofinal
create database bdprojetofinal;

-- use bdprojeto final
use bdprojetofinal;

-- deletar o banco bdprojetofinal
drop database bdprojetofinal;

-- exibir tabela Cliente
select * from tb_cliente;

-- inserir dados na tabela Cliente
insert into tb_cliente values (
	null,"111.111.111-1", "daniela@itau.com", "Daniela", "(11)91111-1111"
);
insert into tb_cliente values (
	null,"222.222.222-2", "fernando@itau.com", "Fernando", "(11)92222-2222"
);
insert into tb_cliente values (
	null,"333.333.333-3", "assis@itau.com", "Assis", "(11)93333-3333"
);
insert into tb_cliente values (
	null,"444.444.444-4", "erike@itau.com", "Erike", "(11)94444-4444"
);
insert into tb_cliente values (
	null,"555.555.555-5", "fabricio@itau.com", "Fabricio", "(11)95555-5555"
);
insert into tb_cliente values (
	null,"777.777.777-7", "eduardo@itau.com", "Eduardo", "(11)97777-7777"
);