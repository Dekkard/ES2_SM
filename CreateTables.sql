DROP TABLE produto CASCADE;
DROP TABLE localArmazenamento CASCADE;
DROP TABLE fornecedor CASCADE;
DROP TABLE funcionario CASCADE;
DROP TABLE administrador CASCADE;
DROP TABLE estoqueEntrada CASCADE;
DROP TABLE estoqueSaida CASCADE;
DROP TABLE formaPagamento CASCADE;
DROP TABLE tipoUnidade CASCADE;
DROP TABLE categoria CASCADE;
DROP TABLE compra CASCADE;
DROP TABLE tipoDoc CASCADE;
DROP TABLE cliente CASCADE;

CREATE TABLE produto(
	id SERIAL NOT NULL,
	nome VARCHAR(255) NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	categoria_id INTEGER NOT NULL, --FOREIGN KEY
	fornecedor_id INTEGER NOT NULL, --FOREIGN KEY
	localArm_id INTEGER NOT NULL, --FOREIGN KEY
	tipoUnidade_id INTEGER NOT NULL, --FOREIGN KEY
	marca VARCHAR(50) NOT NULL,
	valorUnitario NUMERIC NOT NULL,
	dataValidade DATE NOT NULL,
	PRIMARY KEY(id)
);
CREATE TABLE localArmazenamento(
	id SERIAL NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	qtdMax INTEGER NOT NULL,
	PRIMARY KEY(id)
);
CREATE TABLE fornecedor(
	id SERIAL NOT NULL,
	nome VARCHAR(50) NOT NULL,
	telefone INTEGER NOT NULL,
	email VARCHAR(50) NOT NULL,
	cpfCnpj INTEGER NOT NULL,
	telefoneReserva INTEGER NOT NULL,
	PRIMARY KEY (id)
);
CREATE TABLE funcionario(
	id SERIAL NOT NULL,
	nome VARCHAR(50) NOT NULL,
	perfil VARCHAR(255) NOT NULL,
	senha VARCHAR(20) NOT NULL,
	email VARCHAR(50) NOT NULL,
	PRIMARY KEY(id)
);
CREATE TABLE administrador(
	id SERIAL NOT NULL,
	funcionario_id INTEGER NOT NULL, --FOREIGN KEY
	PRIMARY KEY(id),
	FOREIGN KEY (funcionario_id) REFERENCES funcionario(id)
);
CREATE TABLE estoqueEntrada(
	id SERIAL NOT NULL,
	produto_id INTEGER NOT NULL, --FOREIGN KEY
	data date NOT NULL,
	qtdEntrada integer NOT NULL,
	valorPago NUMERIC NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(produto_id) REFERENCES produto(id)
);
CREATE TABLE estoqueSaida(
	id SERIAL NOT NULL,
	produto_id INTEGER NOT NULL, -- FOREIGN KEY
	funcionario_id INTEGER NOT NULL, -- FOREIGN KEY
	data date NOT NULL,
	qtdSaida integer NOT NULL,
	valorPago NUMERIC NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(produto_id) REFERENCES produto(id),
	FOREIGN KEY(funcionario_id) REFERENCES funcionario(id)
);
CREATE TABLE formaPagamento(
	id SERIAL NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
);
CREATE TABLE tipoUnidade(
	id SERIAL NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
);
CREATE TABLE categoria(
	id SERIAL NOT NULL,
	formaPagam_id INTEGER NOT NULL, -- FOREIGN KEY
	totalPago NUMERIC NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(formaPagam_id) REFERENCES formaPagamento(id)
);
CREATE TABLE compra(
	id SERIAL NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
);
CREATE TABLE tipoDoc(
	id SERIAL NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
);
CREATE TABLE cliente(
	id SERIAL NOT NULL,
	nome VARCHAR(50) NOT NULL,
	doc_id INTEGER NOT NULL, --FOREIGN KEY
	email VARCHAR(50) NOT NULL,
	telefone INTEGER NOT NULL,
	dataNascimento date NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(doc_id) REFERENCES tipoDoc(id)
);

ALTER TABLE produto
	ADD CONSTRAINT categoria_FK FOREIGN KEY (categoria_id) REFERENCES categoria(id),
	ADD CONSTRAINT fornecedor_FK FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id) ,
	ADD CONSTRAINT localArm_FK FOREIGN KEY (localArm_id) REFERENCES localArmazenamento(id),
	ADD CONSTRAINT tipoUnidade_FK FOREIGN KEY (tipoUnidade_id) REFERENCES tipoUnidade(id);