ALTER TABLE totais_tldos 
ADD codigo_distrito BIGINT(20),
ADD codigo_localidade BIGINT(20),
ADD FOREIGN KEY (codigo_distrito) REFERENCES distrito(codigo),
ADD FOREIGN KEY (codigo_localidade) REFERENCES localidade(codigo);

ALTER TABLE detalhes_tldos
ADD codigo_distrito BIGINT(20),
ADD codigo_localidade BIGINT(20),
ADD FOREIGN KEY (codigo_distrito) REFERENCES distrito(codigo),
ADD FOREIGN KEY (codigo_localidade) REFERENCES localidade(codigo);