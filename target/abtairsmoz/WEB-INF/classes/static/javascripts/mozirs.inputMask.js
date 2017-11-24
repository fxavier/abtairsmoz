var Mozirs = Mozirs || {};

Mozirs.MaskMoney = (function() {
	
	function MaskMoney() {
		this.plain = $('.js-plain');
	}
	
	MaskMoney.prototype.enable = function() {
	//	this.plain.maskMoney({ precision: 0, thousands: '.' });
		this.plain.maskNumber({ integer: true, thousands: '.' });
	}
	
	return MaskMoney;
	
}());

Mozirs.MaskDate = (function(){
	
	function MaskDate(){
		this.inputDate = $('.js-Date');
	}
	
	MaskDate.prototype.enable = function(){
		this.inputDate.mask('00/00/0000');
	}
	
	return MaskDate;

$(function(){
	/*var maskMoney = new Mozirs.MaskMoney();
	maskMoney.enable();*/
	var maskNumber = new Mozirs.MaskNumber();
	maskNumber.enable();
	
	var maskDate = new Mozirs.MaskDate();
	maskdate.enable();
})