var Abtairsmoz = Abtairsmoz || {};

Abtairsmoz.GraficoAlertasPorDistrito = (function() {
	
	function GraficoAlertasPorDistrito() {
		this.ctx = $('#graficoAlertas')[0].getContext('2d');
	}
	
	GraficoAlertasPorDistrito.prototype.iniciar = function() {
		$.ajax({
			url: 'totaisDos/porDistrito',
			method: 'GET', 
			success: onDadosRecebidos.bind(this)
		});
	}
	
	function onDadosRecebidos(alertasVermelhasDistrito) {
		var distritos = [];
		var totaisAlertas = [];
		
		
		alertasVermelhasDistrito.forEach(function(obj) {
			distritos.unshift(obj.distrito);
			totaisAlertas.unshift(obj.total);
			
		});
		
		var graficoAlertasPorDistrito = new Chart(this.ctx, {
		    type: 'bar',
		    data: {
		    	labels: distritos,
		    	datasets: [{
		    		label: 'Total de alertas vermelhas Por Distrito',
		    		backgroundColor: "rgba(26,179,148,0.5)",
	                data: totaisAlertas
		    	}]

		    },
		});
	}
	
	return GraficoAlertasPorDistrito;
	
}());


Abtairsmoz.GraficoAlertasPorIndicador = (function() {
	
	function GraficoAlertasPorIndicador() {
		this.ctx = $('#graficoAlertasPorIndicador')[0].getContext('2d');
	}
	
	GraficoAlertasPorIndicador.prototype.iniciar = function() {
		$.ajax({
			url: 'totaisDos/porIndicador',
			method: 'GET', 
			success: onDadosRecebidos.bind(this)
		});
	}
	
	function onDadosRecebidos(alertasVermelhas) {
	//	var distritos = [];
		var totaisAlertasPorIndicador = [];
		
		
		alertasVermelhas.forEach(function(obj) {
			totaisAlertasPorIndicador.unshift(obj.sopMixFor75Nao);
			totaisAlertasPorIndicador.unshift(obj.sopEnxaugou3vezesNao);
			totaisAlertasPorIndicador.unshift(obj.sopTemEPICompletoNao);
			totaisAlertasPorIndicador.unshift(obj.sopPulvComBombaComCntFluxoNao);
			totaisAlertasPorIndicador.unshift(obj.todosPertencesForaCasaNao);
			totaisAlertasPorIndicador.unshift(obj.todosPertencesNTiradosCobertosNao);
			totaisAlertasPorIndicador.unshift(obj.existeVazamentoBombaSim);
			totaisAlertasPorIndicador.unshift(obj.sopPulvComDist45cmParedeNao);
			totaisAlertasPorIndicador.unshift(obj.sopMantemVelocCorrectaNao);
			totaisAlertasPorIndicador.unshift(obj.existeSubreposicao5cmNao);
			
		});
		
		var graficoAlertasPorIndicador = new Chart(this.ctx, {
		    type: 'bar',
		    data: {
		    	labels: ['sopMixFor75l','sopEnxaugou3vezes','sopTemEPICompleto',
		    		     'sopPulvComBombaComCntFluxo','todosPertencesForaCasa',
		    		     'todosPertencesNTiradosCobertos','existeVazamentoBomba',
		    		     'sopPulvComDist45cmParede','sopMantemVelocCorrecta','existeSubreposicao5cm'],
		    	datasets: [{
		    		label: 'Totais de Alertas Vermelhas por indicador',
		    		backgroundColor: "rgba(26,179,148,0.5)",
		    		
	                data: totaisAlertasPorIndicador
		    	}]

		    },
		});
	}
	
	return GraficoAlertasPorIndicador;
	
}());

Abtairsmoz.GraficoSupervisoesPorMes = (function() {
	
	function GraficoSupervisoesPorMes() {
		this.ctx = $('#graficoSupervisoesPorMes')[0].getContext('2d');
	}
	
	GraficoSupervisoesPorMes.prototype.iniciar = function() {
		$.ajax({
			url: 'totaisDos/porSupervisao',
			method: 'GET', 
			success: onDadosRecebidos.bind(this)
		});
	}
	
	function onDadosRecebidos(vendaMes) {
		var meses = [];
		var valores = [];
		supervisoesPorMes.forEach(function(obj) {
			meses.unshift(obj.mes);
			valores.unshift(obj.total);
		});
		
		var graficoSupervisoesPorMes = new Chart(this.ctx, {
		    type: 'line',
		    data: {
		    	labels: meses,
		    	datasets: [{
		    		label: 'Supervisoes por mês',
		    		backgroundColor: "rgba(26,179,148,0.5)",
	                pointBorderColor: "rgba(26,179,148,1)",
	                pointBackgroundColor: "#fff",
	                data: valores
		    	}]
		    },
		});
	}
	
	return GraficoSupervisoesPorMes;
	
}());


$(function() {
	var graficoAlertasPorDistrito = new Abtairsmoz.GraficoAlertasPorDistrito();
	graficoAlertasPorDistrito.iniciar();
	
	var graficoAlertasPorIndicador = new Abtairsmoz.GraficoAlertasPorIndicador();
	graficoAlertasPorIndicador.iniciar();	
	
	var graficoSupervisoesPorMes = new Abtairsmoz.GraficoSupervisoesPorMes();
	graficoSupervisoesPorMes.iniciar();
	
	
});
