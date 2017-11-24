Mozirs = Mozirs || {};

Mozirs.BotaoSubmit = (function() {
	
	function BotaoSubmit() {
		this.submitBtn = $('.js-submit-btn');
		this.formulario = $('.js-formulario-principal');
	}
	
	BotaoSubmit.prototype.iniciar = function() {
		this.submitBtn.on('click', onSubmit.bind(this));
	}
	
	function onSubmit(evento) {
		evento.preventDefault();
		
		var botaoClicado = $(evento.target);
		var accao = botaoClicado.data('accao');
				
		var accaoInput = $('<input>');
		accaoInput.attr('name', accao);
		
		this.formulario.append(accaoInput);
		this.formulario.submit();
	}
	
	return BotaoSubmit
	
}());

$(function() {
	
	var botaoSubmit = new Mozirs.BotaoSubmit();
	botaoSubmit.iniciar();
	
});