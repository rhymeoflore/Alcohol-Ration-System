/**
 * 
 */
function liquoradd(){
	var errosmessage = "";
	if (document.form1.typ.value == "--SELECT--") {
		// alert("blank");
		errosmessage = errosmessage + "* please select  liquor type\n";
		// document.form1.Username.focus() ;
		// return false;
	}
	if (document.form1.lbnd.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide brand\n";
		// document.form1.Username.focus() ;
		// return false;
	}
	if (document.form1.lqty.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide quantity\n";
		// document.form1.Username.focus() ;
		// return false;
	}
	if (document.form1.lpr.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide price\n";
		// document.form1.Username.focus() ;
		// return false;
	}
	if (document.form1.lbot.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide number of bottles\n";
		// document.form1.Username.focus() ;
		// return false;
	}
	if (errosmessage != "") {
		// alert("NOt NUll");
		alert(errosmessage);
		return false;
	}
	return true;
}

function validpurchasehistory(){
	if (document.form1.bev.value == "--SELECT--") {
		// alert("blank");
		errosmessage = errosmessage + "* please select  Beverage\n";
		// document.form1.Username.focus() ;
		// return false;
	}
	if (errosmessage != "") {
		// alert("NOt NUll");
		alert(errosmessage);
		return false;
	}
	return true;
}










