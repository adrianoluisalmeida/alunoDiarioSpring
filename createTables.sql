CREATE TABLE turma(
	id serial,
	nome varchar(50),
	primary key(id)
);


CREATE TABLE aluno(
	id serial,
	nome varchar(50),
	plano_saude varchar(50),
	plano_numero varchar(50),
	sexo char(1),
	nascimento date,
	turma_id int,
	foreign key (turma_id) references turma(id),
	primary key(id)
);

CREATE TABLE aluno_medicamento(
	id serial,
	nome varchar(50),
	descricao varchar(255),
	aluno_id int,
	primary key (id),
	foreign key (aluno_id) references aluno(id)
);

CREATE TABLE profissional(
	id serial,
	nome varchar(50),
	sexo char(1),
	email varchar(50),
	funcao varchar(50)
	primary key(id)
);

CREATE TABLE profissional_turma(
	turma_id int,
	profissional_id int,
	primary key(turma_id, profissional_id),
	foreign key (turma_id) references turma(id),
	foreign key (profissional_id) references profissional(id)
);


CREATE TABLE atividade(
	id serial,
	turma_id int,
	descricao text,
	data date,
	hora time null,
	primary key(id),
	foreign key (turma_id) references turma(id)
);

