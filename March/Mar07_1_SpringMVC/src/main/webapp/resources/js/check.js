function check() {
	let v = document.f.value;

	if (isEmpty(v)) {
		alert("입력 필수");
		v.value = "";
		v.focus();
		return false;
	}
	return true;
}