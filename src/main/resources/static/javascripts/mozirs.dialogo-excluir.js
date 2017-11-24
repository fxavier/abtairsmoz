var mozirs = mozirs || {};

mozirs.DialogoExcluir = (function(){
	
	function DialogoExcluir(){	
		this.excluirBtn = $('.js-exclusao-btn');
		
	}
	
	DialogoExcluir.prototype.iniciar = function(){		
		this.excluirBtn.on('click', onExcluirClicado.bind(this));
		if (window.location.search.indexOf('excluido') > -1) {
			swal('Pronto!', 'Excluído com sucesso!', 'success');
		}
		
	}
	
	function onExcluirClicado(evento){
		evento.preventDefault();
		var botaoClicado = $(evento.currentTarget);
		var url = botaoClicado.data('url');
		var objecto = botaoClicado.data('objecto');
		
		swal({
			title: 'Tem certeza?',
			text: 'Excluir "' + objecto + '"? Você não poderá recuperar depois.',
			showCancelButton: true,
			confirmButtonColor: '#DD6B55',
			confirmButtonText: 'Sim, exclua agora!',
			closeOnConfirm: false
		}, onExcluirConfirmado.bind(this, url));
	}
	
	function onExcluirConfirmado(url) {
		$.ajax({
			url: url,
			method: 'DELETE',
			success: onExcluidoSucesso.bind(this),
			error: onErroExcluir.bind(this)
		});
		
	
				
	}
	
	function onExcluidoSucesso() {
		var urlAtual = window.location.href;
		var separador = urlAtual.indexOf('?') > -1 ? '&' : '?';
		var novaUrl = urlAtual.indexOf('excluido') > -1 ? urlAtual : urlAtual + separador + 'excluido';
		
		window.location = novaUrl;
		
	/*	window.location.reload();*/
		
	}
	
	function onErroExcluir(e) {
		console.log('ahahahah', e.responseText);
		swal('Oops!', e.responseText, 'error');
	}
	return DialogoExcluir;
	
	
	
}());

$(function(){
	var dialogoExcluir = new mozirs.DialogoExcluir();
	dialogoExcluir.iniciar();
	
})