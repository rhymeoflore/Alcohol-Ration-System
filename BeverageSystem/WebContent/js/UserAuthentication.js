/**
 * 
 */

function userregistration() {
	alert("messageeee");
	var errosmessage = "";
	if (document.form1.fn.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide  firsname ID\n";
		// document.form1.Username.focus() ;
		// return false;
	}

	if (document.form1.ln.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide lastname\n";
		// document.form1.Username.focus() ;
		// return false;
	}
	
	if (document.form1.ag.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide age\n";
		// document.form1.Username.focus() ;
		// return false;
	}
	
var agee = document.form1.ag.value;
	alert("test");
	if (agee < 23) {
		// alert("blank");
		errosmessage = errosmessage + "* please validate age\n";
		// document.form1.Username.focus() ;
		// return false;
	}
	
	if (document.form1.addr.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide address\n";
		// document.form1.Username.focus() ;
		// return false;
	}
	

	
	var mob = document.form1.ph.value;
	var pattern = /^(7|8|9)[\d]{9,9}$/;
	if (mob == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide MobileNo\n";
		// document.form1.Username.focus() ;
	}

	else if (!pattern.test(mob)) {
		// alert("blank");
		errosmessage = errosmessage + "It is not valid mobile number!\n";
	}
	if (errosmessage != "") {
		// alert("NOt NUll");
		alert(errosmessage);
		return false;
	}
	return true;

}