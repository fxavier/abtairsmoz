Mozirs.ComboBairro = (function(){
	function ComboBairro(comboLocalidade) {
		this.comboLocalidade = comboLocalidade;
		this.combo = $('#localidade');
		this.imgLoading = $('.js-img-loading');
		this.inputHiddenBairroSelecionado = $('#inputHiddenBairroSelecionado');
	}
	
	ComboBairro.prototype.iniciar = function() {
		resetBairro.call(this);
//		this.comboLocalidade.on('alterado', onLocalidadeAlterado.bind(this));
		var codigoLocalidade = this.comboLocalidade.combo.val();
		inicializarBairros.call(this, codigoLocalidade);
		console.log('Distrito', this.comboLocalidade.combo.val());
	}
	
	function onLocalidadeAlterado(evento, codigoLocalidade) {
		this.inputHiddenLocalidadeSelecionada.val('');
		inicializarLocalidades.call(this, codigoLocalidade);
	}
	
	function inicializarBairros(codigoLocalidade) {
		if (codigoLocalidade) {
			var resposta = $.ajax({
				url: this.combo.data('url'),
				method: 'GET',
				contentType: 'application/json',
				data: { 'localidade': codigoLocalidade }, 
				beforeSend: iniciarRequisicao.bind(this),
				complete: finalizarRequisicao.bind(this)
			});
			resposta.done(onBuscarBairrosFinalizado.bind(this));
		} else {
			resetBairro.call(this);
		}
	}
	
	function onBuscarBairrosFinalizado(bairros) {
		var options = [];
		bairros.forEach(function(bairro) {
			options.push('<option value="' + bairro.codigo + '">' + bairro.nome + '</option>');
		});
		
		this.combo.html(options.join(''));
		this.combo.removeAttr('disabled');
		
		var codigoBairroSelecionado = this.inputHiddenBairroSelecionado.val();
		if (codigoBairroSelecionado) {
			this.combo.val(codigoBairroSelecionado);
		}
	}
	
	function resetBairro() {
		this.combo.html('<option value="">Selecione o bairro</option>');
		this.combo.val('');
		this.combo.attr('disabled', 'disabled');
	}
	
	function iniciarRequisicao() {
		resetBairro.call(this);
		this.imgLoading.show();
	}
	
	function finalizarRequisicao() {
		this.imgLoading.hide();
	}
	
	return ComboBairro;
	
	
}());

/*Mozirs.ComboBairro = (function() {
	function ComboBairro(comboLocalidade) {
		this.comboLocalidade = comboLocalidade;
		this.combo = $('#bairro');
		this.imgLoading = $('.js-img-loading');
		this.inputHiddenBairroSelecionado = $('#inputHiddenBairroSelecionado');
	}
	
	ComboBairro.prototype.iniciar = function() {
		resetBairro.call(this);
		console.log('ComboLocalidade:', this.comboLocalidade);
		console.log('Combo:', this.combo);
		this.comboLocalidade.on('alterado', onLocalidadeAlterado.bind(this));
		var codigoLocalidade = this.combo.val();
		inicializarBairros.call(this, codigoLocalidade);
		
	//	console.log('Welcome');
	}
	
	function onLocalidadeAlterado(evento, codigoLocalidade) {
		this.inputHiddenBairroSelecionado.val('');
		inicializarBairros.call(this, codigoLocalidade);
	}
	
	function inicializarBairros(codigoLocalidade) {
		if (codigoLocalidade) {
			var resposta = $.ajax({
				url: this.combo.data('url'),
				method: 'GET',
				contentType: 'application/json',
				data: { 'localidade': codigoLocaliade }, 
				beforeSend: iniciarRequisicao.bind(this),
				complete: finalizarRequisicao.bind(this)
			});
			resposta.done(onBuscarBairrosFinalizado.bind(this));
		} else {
			resetBairro.call(this);
		}
	}
	
	function onBuscarBairrosFinalizado(bairros) {
		var options = [];
		bairros.forEach(function(bairro) {
			options.push('<option value="' + bairro.codigo + '">' + bairro.nome + '</option>');
		});
		
		this.combo.html(options.join(''));
		this.combo.removeAttr('disabled');
		
		var codigoBairroSelecionado = this.inputHiddenBairroSelecionado.val();
		if (codigoBairroSelecionado) {
			this.combo.val(codigoBairroSelecionado);
		}
	}
	
	function resetBairro() {
		this.combo.html('<option value="">Selecione o bairro</option>');
		this.combo.val('');
		this.combo.attr('disabled', 'disabled');
	}
	
	function iniciarRequisicao() {
		resetBairro.call(this);
		this.imgLoading.show();
	}
	
	function finalizarRequisicao() {
		this.imgLoading.hide();
	}
	
	return ComboBairro;
	
}());
*/

$(function() {
	
	var comboDistrito = new Mozirs.ComboDistrito();
	comboDistrito.iniciar();
	
	var comboLocalidade = new Mozirs.ComboLocalidade(comboDistrito);
	comboLocalidade.iniciar();
	
	var comboBairro = new Mozirs.ComboBairro(comboLocalidade);
	comboBairro.iniciar();
	
});

