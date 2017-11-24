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
		this.imgLoading = $('.js-img-loading');
		this.inputHiddenLocalidadeSelecionada = $('#inputHiddenLocalidadeSelecionada');
	}
	
	ComboLocalidade.prototype.iniciar = function() {
		reset.call(this);
		this.comboDistrito.on('alterado', onDistritoAlterado.bind(this));
		var codigoDistrito = this.comboDistrito.combo.val();
		inicializarLocalidades.call(this, codigoDistrito);
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

$(function() {
	
	var comboDistrito = new Mozirs.ComboDistrito();
	comboDistrito.iniciar();
	
	var comboLocalidade = new Mozirs.ComboLocalidade(comboDistrito);
	comboLocalidade.iniciar();
	
});

