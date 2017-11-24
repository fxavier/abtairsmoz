
CREATE TABLE detalhes_mobilizacao (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    data DATETIME NOT NULL,
    nome_familia VARCHAR(50) NOT NULL,
    codigo_pidom VARCHAR(50) NOT NULL,
    est_el_sensibilizada VARCHAR(20) NOT NULL,
    motivo_nao_sensibilizacao VARCHAR(80),
    num_adultosH BIGINT(80) NOT NULL,
    num_adultosM BIGINT(80) NOT NULL,
    aceitacao_pidom VARCHAR(20) NOT NULL,
    codigo_mobilizador BIGINT(20) NOT NULL,
    codigo_bairro BIGINT(20) NOT NULL,
    motivo_nao_aceitacao VARCHAR(80),
    FOREIGN KEY (codigo_mobilizador) REFERENCES mobilizador(codigo),
    FOREIGN KEY (codigo_bairro) REFERENCES bairro(codigo)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

