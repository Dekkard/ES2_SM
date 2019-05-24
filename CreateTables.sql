CREATE TABLE LocalArmazenamento(
	id SERIAL NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	qtdMax INTEGER NOT NULL,
	PRIMARY KEY(id)
);
CREATE TABLE Produto(
	id SERIAL NOT NULL,
	localArm_id INTEGER NOT NULL, --FOREIGN KEY
	nome VARCHAR(255) NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	marca VARCHAR(50) NOT NULL,
	valorUnitario NUMERIC NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(localArm_id) references LocalArmazenamento(id)
);
CREATE TABLE Funcionario(
	id SERIAL NOT NULL,
	cpf INTEGER NOT NULL,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(20) NOT NULL,
	endereco VARCHAR(50),
	telefone VARCHAR(15),
	perfil VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
);
CREATE TABLE Contato(
	id SERIAL NOT NULL,
	cpfCnpj integer not null,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	tipo VARCHAR(20) NOT NULL,
	endereco VARCHAR(50),
	telefone INTEGER,
	PRIMARY KEY(id)
);
CREATE TABLE Movimentacao(
	id SERIAL NOT NULL,
	produto_id INTEGER NOT NULL, --FOREIGN KEY
	data date NOT NULL,
	qtd integer NOT NULL,
	valor NUMERIC NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(produto_id) REFERENCES Produto(id)
	FOREIGN KEY(contato_id) REFERENCES Contato(id)
	FOREIGN KEY(funcionario_id) REFERENCES Funcionario(id)
);

