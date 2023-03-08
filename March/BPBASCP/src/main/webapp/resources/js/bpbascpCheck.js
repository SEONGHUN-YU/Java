function regCheck() {
	let idBox = document.f.bm_id;
	let pwBox = document.f.bm_pw;
	let pwChkBox = document.f.bm_pwChk;
	let nameBox = document.f.bm_name;
	let addr1Box = document.f.bm_addr1;
	let addr2Box = document.f.bm_addr2;
	let addr3Box = document.f.bm_addr3;
	let photoBox = document.f.bm_photo;

	if (isEmpty(idBox) || notAllowedLetter(idBox)) {
		alert("id 확인");
		idBox.value = "";
		idBox.focus();
		return false;
	}

	if (isEmpty(pwBox) || notContainsLetter(pwBox, "1234567890")
			|| notEquals(pwBox, pwChkBox)) {
		alert("pw 확인");
		pwBox.value = "";
		pwChkBox.value = "";
		pwBox.focus();
		return false;
	}

	if (isEmpty(nameBox)) {
		alert("id 확인");
		nameBox.value = "";
		nameBox.focus();
		return false;
	}

	if (isEmpty(addr1Box) || isEmpty(addr2Box) || isEmpty(addr3Box)) {
		alert("주소 확인");
		addr1Box.value = "";
		addr2Box.value = "";
		addr3Box.value = "";
		addr1Box.focus();
		return false;
	}

	if (isEmpty(photoBox)
			|| (compareType(photoBox, "png") && compareType(photoBox, "jpg") && compareType(
					photoBox, "gif"))) {
		alert("프사 확인");
		photoBox.value = "";
		return false;
	}

	return true;
}