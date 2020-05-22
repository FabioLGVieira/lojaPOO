CREATE TABLE cadastroFuncionario (
    id iNT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) NOT NULL,
    rg VARCHAR(255),
    sexo VARCHAR(20),
    estadoCivil VARCHAR(255) NOT NULL,
    dataNascimento VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    numero int NOT NULL,
    complemento VARCHAR(255),
    bairro VARCHAR(255),
    telefone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    situacao VARCHAR(30),
    senha VARCHAR(255) NOT NULL,
    cargo VARCHAR(255),
    filial VARCHAR(255),
    departamento VARCHAR(255),
    PRIMARY KEY(id)
    );

CREATE TABLE cadastroCliente (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) NOT NULL,
    rg VARCHAR(255),
	sexo VARCHAR(20),
    estadoCivil VARCHAR(255) NOT NULL,
    dataNascimento VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    numero int NOT NULL,
    complemento VARCHAR(255),
    bairro VARCHAR(255),
    telefone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    situacao varchar(20) not null,
    PRIMARY KEY(id)
    );
    
    CREATE TABLE cadastroProduto (
    idProduto iNT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nome VARCHAR(255) NOT NULL,
    preco float not null,
    quantidade int not null,
    descricao varchar(255) not null,
    categoria varchar(255) not null,
    situacao varchar(30) not null,
    qtdItem int,
    primary key(idProduto)
    );
   
CREATE TABLE Venda (
    idVenda iNT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    data VARCHAR(10) not null,
    pagamento varchar(255),
    parcela int,
    subTotal float not null,
    idCliente int,
    idFuncionario int,
    idProduto int,
    primary key(idProduto)
    );
    
    alter table venda
    add foreign key(idCliente)
    references cadastrocliente(id);
    
     alter table venda
    add foreign key(idFuncionario)
    references cadastrofuncionario(id);
    
     alter table venda
    add foreign key(idProduto)
    references cadastroproduto(idProduto);