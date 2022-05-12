const signup=document.forms["signup"];
const checkId=document.getElementById("checkId");
const checkPhone=document.getElementById("checkPhone");
const checkEmail=document.getElementById("checkEmail");

signup["id"].addEventListener("blur",async(e)=>{
	let v=e.target.value;
	if(v.length>=4){
		///mem/ajax/findId/{id}
		let res=await fetch("/mem/ajax/findId/"+v);
		let json=await res.json();
		if(json){
			checkId.classList.remove("text-primary");
			checkId.classList.add("text-danger");
			checkId.innerText="존재하는 id";
		}else{
			checkId.classList.remove("text-danger");
			checkId.classList.add("text-primary");
			checkId.innerText="사용가능";
		}
	}else{
		checkId.classList.remove("text-primary");
		checkId.classList.add("text-danger");
		checkId.innerText="id의 길이는 4이상입니다.";
	}
});
signup["phone"].addEventListener("blur",async(e)=>{
	let v=e.target.value;
	if(v.length==13){
		let res=await fetch("/mem/ajax/findPhone/"+v);
		let json=await res.json();
		if(json){
			checkPhone.classList.remove("text-primary");
			checkPhone.classList.add("text-danger");
			checkPhone.innerText="존재하는 폰번호 입니다.";
		}else{
			checkPhone.classList.remove("text-danger");
			checkPhone.classList.add("text-primary");
			checkPhone.innerText="사용가능";
		}
	}else{
		checkPhone.classList.remove("text-primary");
		checkPhone.classList.add("text-danger");
		checkPhone.innerText="폰의 길이는 13입니다";
	}
});

signup["email"].addEventListener("blur",async(e)=>{
	let v=e.target.value;
	if(v.length>5){
		let res=await fetch("/mem/ajax/findEmail/"+v);
		let json=await res.json();
		if(json){
			checkEmail.classList.remove("text-primary");
			checkEmail.classList.add("text-danger");
			checkEmail.innerText="존재하는 이메일 입니다.";
		}else{
			checkEmail.classList.remove("text-danger");
			checkEmail.classList.add("text-primary");
			checkEmail.innerText="사용가능";
		}
	}else{
		checkEmail.classList.remove("text-primary");
		checkEmail.classList.add("text-danger");
		checkEmail.innerText="이메일의 길이는 5입니다";
	}
});
