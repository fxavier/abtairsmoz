CREATE TABLE totais_mobilizacao (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    data DATETIME NOT NULL,
    est_el_sensibilizadaSim BIGINT(80) NOT NULL,
    est_el_sensibilizadaNao BIGINT(80) NOT NULL,
    num_adultosH BIGINT(80) NOT NULL,
    num_adultosM BIGINT(80) NOT NULL,
    aceitacao_pidomSim BIGINT(80) NOT NULL,
    aceitacao_pidomNao BIGINT(80) NOT NULL,
    codigo_mobilizador BIGINT(20) NOT NULL,
    codigo_bairro BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_mobilizador) REFERENCES mobilizador(codigo),
    FOREIGN KEY (codigo_bairro) REFERENCES bairro(codigo)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
