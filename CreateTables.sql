create database StoreManager;
#SET @@global.time_zone = '-03:00';
#SET @@session.time_zone = '-03:00';
#SELECT @@global.time_zone, @@session.time_zone;
#ALTER USER 'root'@'localhost' IDENTIFIED BY 'mysqlbd';
CREATE TABLE localArmazenamento(
	id INTEGER NOT NULL auto_increment,
	descricao VARCHAR(255) NOT NULL,
	qtdMax INTEGER NOT NULL,
    endereco varchar(100),
    lote varchar(50),
	PRIMARY KEY(id)
);
select * from localArmazenamento;
CREATE TABLE produto(
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
CREATE TABLE funcionario(
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
CREATE TABLE contato(
	id INTEGER NOT NULL auto_increment,
	cpfCnpj integer not null,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	tipo VARCHAR(20) NOT NULL,
	endereco VARCHAR(50),
	telefone INTEGER,
	PRIMARY KEY(id)
);
CREATE TABLE movimentacao(
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
before insert on movimentacao 
for each row
begin
	update produto set QTDestoque = QTDestoque - new.qtd where produto.id = new.produto_id;
end $
delimiter ;
delimiter $
create trigger tr_mov_prod_del 
before delete on movimentacao 
for each row
begin
	update produto set QTDestoque = QTDestoque + old.qtd where produto.id = old.produto_id;
end $
delimiter ;
create view vw_check_qtd as
	select count(p.id) qtd,l.id local_id, l.descricao local_desc from produto p
    join LocalArmazenamento l on l.id = p.localArm_id
    group by p.id;
select qtd from vw_check_qtd;
create view vw_mov_cli as
	select p.Descricao produto_nome,c.nome cliente_nome,f.nome funcionario_nome,m.qtd quatidade from movimentacao m
    join produto p on p.id = m.produto_id
    join contato c on c.id = m.contato_id
    join funcionario f on f.id = m.contato_id
    where f.perfil = "C";
select * from vw_movi_cli;
create view vw_mov_forn as
	select p.Descricao produto_nome,c.nome cliente_nome,f.nome funcionario_nome,m.qtd quatidade from movimentacao m
    join produto p on p.id = m.produto_id
    join contato c on c.id = m.contato_id
    join funcionario f on f.id = m.contato_id
    where f.perfil = "F";
select * from vw_movi_forn;
create view vw_prod_local as
	select p.descricao produto_nome,l.descricao local_nome,
    from produto p join localArmazenamento l on p.localArm_id = l.id

create function fc_adc_mov(prod_id integer,con_id integer,func_id integer,qtd integer) returns NULL deterministic return(
	insert into movimentacao values(null,prod_id,con_id,func_id,sysdate,qtd,(select valor from produto where produto.id = prod_id))
);
delimiter $
create procedure pc_mov_local_ck(in localArm Integer, out msg varchar(15)) 
begin
	if (select count(qtd) from localArmazenamento l join produto p on p.localArm_id = l.id
    join movimento m on p.id = m.produto_id where localArm = l.id) >= (select qtdMax from localArmazenamento where localArm = l.id)
		msg = "Capacidade Máxima atingida"
	else
		msg = "Capacidade normal"
end $
delimiter ;
call pc_mov_local_ck(1,@msg);
select @msg;