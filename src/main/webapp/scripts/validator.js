
function validated(){
	let name = frmContact.name.value;
	let phone = frmContact.phone.value;
	
	if(name === "" || phone === ""){
		alert("Provide all data");
		return false;
	}
	
	document.forms["frmContact"].submit();
	
}