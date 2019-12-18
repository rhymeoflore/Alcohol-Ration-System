/**
 * 
 */
function login() {

	 alert("fdf");
	var errosmessage = "";

	if (document.form1.uname.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide your username\n";
		// document.form1.Username.focus() ;
		// return false;
	}

	if (document.form1.pword.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide your password\n";
		// document.form1.Username.focus() ;

	}

	if (errosmessage != "") {
		// alert("NOt NUll");
		alert(errosmessage);
		return false;
	}
	return true;

}