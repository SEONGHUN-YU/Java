function regCheck() {
	let idBox = document.f.bm_id;
	let pwBox = document.f.bm_pw;
	let pwChkBox = document.f.bm_pwChk;
	let nameBox = document.f.bm_name;
	let addr1Box = document.f.bm_addr1;
	let addr2Box = document.f.bm_addr2;
	let addr3Box = document.f.bm_addr3;
	let photoBox = document.f.bm_photo;

	$("#joinID").css("color")
	if (isEmpty(idBox) 
			|| notAllowedLetter(idBox) 
			|| $("#joinID").css("color") == "rgb(255, 0, 0)") { // 중복이라서 color가 red가 되어있으면 걸림
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

// <form> * 여러개가 snsReplyWriteCheck에 연결된 상태
// f : 여러개 중에서 submit시도하는 바로 그 <form> -> snsReplyWriteCheck()를 호출한 <form>
function snsReplyWriteCheck(f) {
	// 이 html. 이름이 snsReplyWriteForm인 <form>. 이름이 bsr_txt인 <input>
	// jstl for문이 돌고 있어서 이름이 snsReplyWriteForm인게 여러개 생겨버리고 중복되어버려서 문제가 생김
	// let txtBox = document.snsReplyWriteForm.bsr_txt; <- 이 방식으로 불가능함
	let txtBox = f.bsr_txt; // <- 이 방식으로 가능

	if (isEmpty(txtBox)) {
		alert("1글자 이상 필수");
		txtBox.focus();
		return false;
	}
	return true;
}

function drUploadCheck(f) {
	let titleBox = f.bd_title;
	let fileBox = f.bd_file;

	if (isEmpty(titleBox) || isEmpty(fileBox)) {
		alert("입력 필수");
		titleBox.value = "";
		fileBox.value = "";
		titleBox.focus();
		return false;
	}
	return true;
}
