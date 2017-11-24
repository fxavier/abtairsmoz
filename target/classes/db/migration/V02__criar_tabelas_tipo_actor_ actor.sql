CREATE TABLE tipo_actor (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE actor (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    sexo VARCHAR(20) NOT NULL,
    codigo_tipo_actor BIGINT(20) NOT NULL,
    codigo_distrito BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_tipo_actor) REFERENCES tipo_actor(codigo),
    FOREIGN KEY (codigo_distrito) REFERENCES distrito(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

