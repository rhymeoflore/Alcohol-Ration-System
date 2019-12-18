

function AA(){
alert("pppppppp");
}

function registration() {
	alert("messageeee");
	var errosmessage = "";
	if (document.form1.bvid.value == "") {
		 alert("blank");
		errosmessage = errosmessage + "* please provide  Beverage ID\n";
		// document.form1.Username.focus() ;
		// return false;
	}

	if (document.form1.place.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide location\n";
		// document.form1.Username.focus() ;
		// return false;
	}
	
	if (document.form1.vill.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide Village\n";
		// document.form1.Username.focus() ;
		// return false;
	}
	if (document.form1.tlk.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide Taluk\n";
		// document.form1.Username.focus() ;
		// return false;
	}
	if (document.form1.dis.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide district\n";
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

	var emailpattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var email = document.form1.email.value;
	if (document.form1.em.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide Email\n";
		// document.form1.Username.focus() ;

	} else if (!emailpattern.test(email)) {
		// alert("blank");
		errosmessage = errosmessage + "It is not valid email!\n";
	}
	if (document.form1.un.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide username\n";
		// document.form1.Username.focus() ;
		// return false;
	}
	if (document.form1.pass.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide password\n";
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

function login() {

	 alert("fdf");
	var errosmessage = "";
	if (document.form1.companyname.value == "--SELECT COMPANY--") {
		// alert("blank");
		errosmessage = errosmessage + "* please selectttttttttttttttttt your company\n";
		// document.form1.Username.focus() ;
		// return false;
	}

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

function changepass() {
	// alert("lll");
	// alert("fdf");
	var errosmessage = "";

	if (document.form1.cpass.value == "") {
		// alert("blank");
		errosmessage = errosmessage
				+ "* please provide your current passwrod\n";
		// document.form1.Username.focus() ;
		// return false;
	}

	var npass=document.form1.newpass.value;
	if (document.form1.newpass.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please provide your new password\n";
		// document.form1.Username.focus() ;

	}
	var conpass=document.form1.confirmcpass.value;
	if (document.form1.confirmcpass.value == "") {
		// alert("blank");
		errosmessage = errosmessage + "* please re-enter the password\n";
		// document.form1.Username.focus() ;

	}
	alert(npass+"="+conpass);
	if (npass!=conpass) {
		 alert("not match");
		errosmessage = errosmessage + "* password doesn't match\n";
		// document.form1.Username.focus() ;

	}

	if (errosmessage != "") {
		// alert("NOt NUll");
		alert(errosmessage);
		return false;
	}
	return true;

}
