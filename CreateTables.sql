create database StoreManager;
#SET @@global.time_zone = '-03:00';
#SET @@session.time_zone = '-03:00';
#SELECT @@global.time_zone, @@session.time_zone;
#ALTER USER 'root'@'localhost' IDENTIFIED BY 'mysqlbd';
CREATE TABLE LocalArmazenamento(
	id INTEGER NOT NULL auto_increment,
	descricao VARCHAR(255) NOT NULL,
	qtdMax INTEGER NOT NULL,
    endereco varchar(100),
    lote varchar(50),
	PRIMARY KEY(id)
);
select * from localArmazenamento;
CREATE TABLE Produto(
	id INTEGER NOT NULL auto_increment,
	localArm_id INTEGER NOT NULL, #FOREIGN KEY
	descricao VARCHAR(255) NOT NULL,
	marca VARCHAR(50) NOT NULL,
	valorUnitario NUMERIC NOT NULL,
    QTDestoque integer not null,
	PRIMARY KEY(id),
	FOREIGN KEY(localArm_id) references LocalArmazenamento(id)
);
select * from produto;
CREATE TABLE Funcionario(
	id INTEGER NOT NULL auto_increment,
	cpf INTEGER NOT NULL,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	endereco VARCHAR(50),
	telefone VARCHAR(15),
	perfil VARCHAR(255) NOT NULL,
    senha VARCHAR(20) NOT NULL,
	PRIMARY KEY(id)
);
CREATE TABLE Contato(
	id INTEGER NOT NULL auto_increment,
	cpfCnpj integer not null,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	tipo VARCHAR(20) NOT NULL,
	endereco VARCHAR(50),
	telefone INTEGER,
	PRIMARY KEY(id)
);
CREATE TABLE Movimentacao(
	id INTEGER NOT NULL auto_increment,
	produto_id INTEGER NOT NULL, #FOREIGN KEY
    contato_id INTEGER NOT NULL,
    funcionario_id INTEGER NOT NULL,
	data date NOT NULL,
	qtd integer NOT NULL,
	valor NUMERIC NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(produto_id) REFERENCES Produto(id),
	FOREIGN KEY(contato_id) REFERENCES Contato(id),
	FOREIGN KEY(funcionario_id) REFERENCES Funcionario(id)
);
delimiter $
create trigger tr_mov_prod_ins 
before insert on Movimentacao 
for each row
begin
	update Produto set QTDestoque = QTDestoque - new.qtd where Produto.id = new.produto_id;
end $
delimiter ;
delimiter $
create trigger tr_mov_prod_del 
before delete on Movimentacao 
for each row
begin
	update Produto set QTDestoque = QTDestoque + old.qtd where Produto.id = old.produto_id;
end $
delimiter ;
create view vw_check_qtd as
	select count(p.id) qtd,l.id local_id, l.descricao local_desc from Produto p
    join LocalArmazenamento l on l.id = p.localArm_id;
select qtd from vw_check_qtd;
delimiter $
create procedure pc_adc_mov(prod_id integer,con_id integer,func_id integer,qtd integer)
begin
	insert into movimentacao values(null,prod_id,con_id,func_id,sysdate,qtd,(select valor from produto where produto.id = prod_id));
end $
delimiter ;