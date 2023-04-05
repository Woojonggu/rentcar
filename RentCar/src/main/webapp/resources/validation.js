function checkValues(htmlForm) {
	// alert(htmlForm);

	let url = "join?";


	const custno = document.getElementById("usernum").value;
	const custname = document.getElementById("username").value;
	const phone = document.getElementById("phone").value;
	const id = document.getElementById("id").value;
	const password = document.getElementById("password").value;
	const age = document.getElementById("age").value;
	

	if (custno !== "") {
		url += "custno=" + custno + "&";
	}
	if (custname !== "") {
		url += "custname=" + custname + "&";
	}
	if (phone !== "") {
		url += "phone=" + phone + "&";
	}
	if (id !== "") {
		url += "id=" + id + "&";
	}
	if (password !== "") {
		url += "password=" + password + "&";
	}
	if (age !== "") {
		url += "age=" + age + "&";
	}

	console.log(custno);
	console.log(custname);
	console.log(phone);
	console.log(id);
	console.log(password);
	console.log(age);

	// 항목값이 없으면 -> 페이지유지 
	// ㄴ 입력되지 않은 항목에 대해 alert() & join.jsp로 이동하면서 focus 넘기기
	// 모든 항목이 입력되어 있으면 -> submit
	// htmlForm.submit();


	let check = true;

	if (custno === "") {
		alert('빈 칸이 있습니다');
		check = false;
	}
	else if (custname === "") {
		alert('빈 칸이 있습니다');
		check = false;
	}
	else if (phone === "") {
		alert('빈 칸이 있습니다');
		check = false;
	}
	else if (id === "") {
		alert('빈 칸이 있습니다');
		check = false;
	}
	else if (password === "") {
		alert('빈 칸이 있습니다');
		check = false;
	}
	else if (age === "") {
		alert('빈 칸이 있습니다');
		check = false;
	}
	
	if (check === false) {
		location.href = url;
	}
	else {
		htmlForm.submit();
	}
}