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
		alert("ID 확인");
		idBox.value = "";
		idBox.focus();
		return false;
	}

	if (isEmpty(pwBox) || notContainsLetter(pwBox, "1234567890")
			|| notEquals(pwBox, pwChkBox)) {
		alert("PW 확인");
		pwBox.value = "";
		pwChkBox.value = "";
		pwBox.focus();
		return false;
	}

	if (isEmpty(nameBox)) {
		alert("이름 확인");
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
		alert("사진 확인");
		photoBox.value = "";
		return false;
	}
	return true;
}

function loginCheck() {
	let idField = document.loginForm.bm_id;
	let pwField = document.loginForm.bm_pw;

	if (isEmpty(idField) || isEmpty(pwField)) {
		alert("로그인 시 ID, PW 입력 필수");
		idField.value = "";
		pwField.value = "";
		idField.focus();
		return false;
	}
	return true;
}

function memberUpdateCheck() {
	let u_pwBox = document.memberUpdateForm.bm_pw;
	let u_pwChkBox = document.memberUpdateForm.bm_pwChk;
	let u_name = document.memberUpdateForm.bm_name;
	let u_addr1 = document.memberUpdateForm.bm_addr1;
	let u_addr2 = document.memberUpdateForm.bm_addr2;
	let u_addr3 = document.memberUpdateForm.bm_addr3;
	let u_photo = document.memberUpdateForm.bm_photo;

	if (isEmpty(u_pwBox) || notContainsLetter(u_pwBox, "1234567890")
			|| notEquals(u_pwBox, u_pwChkBox)) {
		alert("PW 확인");
		u_pwBox.value = "";
		u_pwChkBox.value = "";
		u_pwBox.focus();
		return false;
	}

	if (isEmpty(u_name)) {
		alert("이름 확인");
		u_name.value = "";
		u_name.focus();
		return false;
	}

	if (isEmpty(u_addr1) || isEmpty(u_addr2) || isEmpty(u_addr3)) {
		alert("주소 확인");
		u_addr1.value = "";
		u_addr2.value = "";
		u_addr3.value = "";
		u_addr1.focus();
		return false;
	}

	if (isEmpty(photoField)) {
		return true;
	}

	if (compareType(u_photo, "png") && compareType(u_photo, "jpg")
			&& compareType(u_photo, "gif")) {
		alert("사진 확인");
		u_photo.value = "";
		return false;
	}
	return true;
}

function snsPostWriteCheck() {
	let txtBox = document.snsPostWriteForm.bs_txt;

	if (isEmpty(txtBox)) {
		alert("1글자 이상 필수");
		txtBox.focus();
		return false;
	}
	return true;
}

function snsSearchCheck() {
	let searchBox = document.snsSearchForm.search;

	if (isEmpty(searchBox)) {
		alert("1글자 이상 필수");
		searchBox.focus();
		return false;
	}
	return true;
}