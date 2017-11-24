var Mozirs = Mozirs || {};

Mozirs.ComboDistrito = (function() {
	
	function ComboDistrito() {
		this.combo = $('#distrito');
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	}
	
	ComboDistrito.prototype.iniciar = function() {
		this.combo.on('change', onDistritoAlterado.bind(this));
	}
	
	function onDistritoAlterado() {
		this.emitter.trigger('alterado', this.combo.val());
	}
	
	return ComboDistrito;
	
}());

Mozirs.ComboLocalidade = (function() {
	
	function ComboLocalidade(comboDistrito) {
		this.comboDistrito = comboDistrito;
		this.combo = $('#localidade');
		this.emitterLocalidade = $({});
		this.on = this.emitterLocalidade.on.bind(this.emitterLocalidade);
		this.imgLoading = $('.js-img-loading');
		this.inputHiddenLocalidadeSelecionada = $('#inputHiddenLocalidadeSelecionada');
	}
	
	ComboLocalidade.prototype.iniciar = function() {
		reset.call(this);
		this.combo.on('change', onLocalidadeAlterado.bind(this));
		this.comboDistrito.on('alterado', onDistritoAlterado.bind(this));
		var codigoDistrito = this.comboDistrito.combo.val();
		inicializarLocalidades.call(this, codigoDistrito);
	}
	
	function onLocalidadeAlterado(){
		this.emitterLocalidade.trigger('alterado', this.combo.val());
		console.log('Localidade Selecionada:', this.combo.val());
	}
	
	function onDistritoAlterado(evento, codigoDistrito) {
		this.inputHiddenLocalidadeSelecionada.val('');
		inicializarLocalidades.call(this, codigoDistrito);
	}
	
	function inicializarLocalidades(codigoDistrito) {
		if (codigoDistrito) {
			var resposta = $.ajax({
				url: this.combo.data('url'),
				method: 'GET',
				contentType: 'application/json',
				data: { 'distrito': codigoDistrito }, 
				beforeSend: iniciarRequisicao.bind(this),
				complete: finalizarRequisicao.bind(this)
			});
			resposta.done(onBuscarLocalidadesFinalizado.bind(this));
		} else {
			reset.call(this);
		}
	}
	
	function onBuscarLocalidadesFinalizado(localidades) {
		var options = [];
		localidades.forEach(function(localidade) {
			options.push('<option value="' + localidade.codigo + '">' + localidade.nome + '</option>');
		});
		
		this.combo.html(options.join(''));
		this.combo.removeAttr('disabled');
		
		var codigoLocalidadeSelecionada = this.inputHiddenLocalidadeSelecionada.val();
		if (codigoLocalidadeSelecionada) {
			this.combo.val(codigoLocalidadeSelecionada);
		}
	}
	
	function reset() {
		this.combo.html('<option value="">Selecione a localidade</option>');
		this.combo.val('');
		this.combo.attr('disabled', 'disabled');
	}
	
	function iniciarRequisicao() {
		reset.call(this);
		this.imgLoading.show();
	}
	
	function finalizarRequisicao() {
		this.imgLoading.hide();
	}
	
	return ComboLocalidade;
	
}());

Mozirs.ComboBairro = (function() {
	
	function ComboBairro(comboLocalidade) {
		this.comboLocalidade = comboLocalidade;
		this.combo = $('#bairro');
		this.imgLoading = $('.js-img-loading');
		this.inputHiddenBairroSelecionado = $('#inputHiddenBairroSelecionado');
	}
	
	ComboBairro.prototype.iniciar = function() {
		resetBairro.call(this);
		this.comboLocalidade.on('alterado', onLocalidadeAlterado.bind(this));
		var codigoLocalidade = this.comboLocalidade.combo.val();
		inicializarBairros.call(this, codigoLocalidade);
		
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



$(function() {
	
	var comboDistrito = new Mozirs.ComboDistrito();
	comboDistrito.iniciar();
	
	var comboLocalidade = new Mozirs.ComboLocalidade(comboDistrito);
	comboLocalidade.iniciar();
	
	var comboBairro = new Mozirs.ComboBairro(comboLocalidade);
	comboBairro.iniciar();
	
});

