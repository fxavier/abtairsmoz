var Mozirs = Mozirs || {};

Mozirs.ComboActorType = (function(){
	
	function ComboActorType(){
		this.combo = $('#actorType');
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	}
	
	ComboActorType.prototype.iniciar = function(){
		this.combo.on('change', onActorTypeAlterado.bind(this));
		
	}
	
	function onActorTypeAlterado(){
      this.emitter.trigger('alterado', this.combo.val());
	}
	
	return ComboActorType;
}());

Mozirs.ComboActor = (function(){
	
	function ComboActor(comboActorType){
		this.comboActorType = comboActorType;
		this.combo = $('#actor');
		this.imgLoading = $('.js-img-loading');
		this.inputHiddenActorSelecionado = $('#inputHiddenActorSelecionado');
		
	}
	
	ComboActor.prototype.iniciar = function(){
		this.comboActorType.on('alterado', onActorTypeAlterado.bind(this));
		var codigoActorType = this.comboActorType.combo.val();
		inicializarActores.call(this, codigoActorType);
	}
	
	function onActorTypeAlterado(evento, codigoActorType){
		this.inputHiddenActorSelecionado.val('');
		inicializarActores.call(this, codigoActorType);
	}
	
	function inicializarActores(codigoActorType){
		if(codigoActorType){
			var resposta = $.ajax({
				url: this.combo.data('url'),
				method: 'GET',
				contentType: 'application/json',
				data: { 'actorType': codigoActorType },
				beforeSend: iniciarRequisicao.bind(this),
				complete: finalizarRequisicao.bind(this)
			});
			resposta.done(onBuscarActoresFinalizado.bind(this));
		} else {
			reset.call(this);
		}
	}
	
	function onBuscarActoresFinalizado(actores) {
		var options = [];
		actores.forEach(function(actor) {
			options.push('<option value="' + actor.codigo + '">' + actor.nome + '</option>');
		});
		
		this.combo.html(options.join(''));
		this.combo.removeAttr('disabled');
		
		var codigoActorSelecionado = this.inputHiddenActorSelecionado.val();
		if (codigoActorSelecionado) {
			this.combo.val(codigoActorSelecionado);
		}
	}
	
	function reset() {
		this.combo.html('<option value="">Selecione O Nome</option>');
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
	
	return ComboActor;
	
}());

$(function(){
	var comboActorType = new Mozirs.ComboActorType();
	comboActorType.iniciar();
	
	var comboActor = new Mozirs.ComboActor(comboActorType);
	comboActor.iniciar();
})   



