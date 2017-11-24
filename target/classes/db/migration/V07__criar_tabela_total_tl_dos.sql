CREATE TABLE totais_tldos (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    data DATETIME NOT NULL,
    UUID VARCHAR(200) NOT NULL,
    SOPMixFor75Sim BIGINT(80) Default 0,
    SOPMixFor75Nao BIGINT(80) Default 0,
    SOPEnxaugou3vezesSim BIGINT(80) Default 0,
    SOPEnxaugou3vezesNao BIGINT(80) Default 0,
    SOPTemEPICompletoSim BIGINT(80) Default 0,
    SOPTemEPICompletoNao BIGINT(80) Default 0,
    SOPPulvComBombaComCntFluxoSim BIGINT(80) Default 0,
    SOPPulvComBombaComCntFluxoNao BIGINT(80) Default 0,
    todosPertencesForaCasaSim BIGINT(80) Default 0,
    todosPertencesForaCasaNao BIGINT(80) Default 0,
    todosPertencesNTiradosCobertosSim BIGINT(80) Default 0,
    todosPertencesNTiradosCobertosNao BIGINT(80) Default 0,
    existeVazamentoBombaSim BIGINT(80) Default 0,
    existeVazamentoBombaNao BIGINT(80) Default 0,
    SOPPulvComDist45cmParedeSim BIGINT(80) Default 0,
    SOPPulvComDist45cmParedeNao BIGINT(80) Default 0,
    SOPMantemVelocCorrectaSim BIGINT(80) Default 0,
    SOPMantemVelocCorrectaNao BIGINT(80) Default 0,
    existeSubreposicao5cmSim BIGINT(80) Default 0,
    existeSubreposicao5cmNao BIGINT(80) Default 0,
    codigo_tlOusupBrigada BIGINT(20) NOT NULL,
    codigo_bairro BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_tlOusupBrigada) REFERENCES actor(codigo),
    FOREIGN KEY (codigo_bairro) REFERENCES bairro(codigo)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
