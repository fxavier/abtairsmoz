CREATE TABLE distrito (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE localidade (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    codigo_distrito BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_distrito) REFERENCES distrito(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE bairro (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    codigo_localidade BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_localidade) REFERENCES localidade(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



