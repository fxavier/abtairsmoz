var Abtairsmoz = Abtairsmoz || {};

Abtairsmoz.GraficoAlertaVermelhas = (function() {
	
	function GraficoAlertasVermelhas() {
	//	this.ctx = $('#graficoAlertasVermelhas')[0].getContext('2d');
	}
	
	GraficoAlertasVermelhas.prototype.iniciar = function() {
		
	}
	return GraficoAlertasVermelhas;
	
}());

$(function() {
	var graficoAlertasVermelhas = new Abtairsmoz.GraficoAlertasVermelhas();
	graficoAlertasVermelhas.iniciar();
});
