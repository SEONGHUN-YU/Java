function check() {
	let nameBox = document.f.name;
	let moneyBox = document.f.money;

	if (isEmpty(nameBox) || isEmpty(moneyBox)) {
		alert("입력 필수");
		nameBox.value = "";
		moneyBox.value = "";
		nameBox.focus();
		return false;
	}
	return true;
}