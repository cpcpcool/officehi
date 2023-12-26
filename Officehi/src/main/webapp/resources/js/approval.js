/**
 * @author 엄다빈
 * @editDate 23.12.18 ~23.12.19
 */
 
function updateApproval(context, approvalNo, status) {
	let isFormUpdate;
	
	if(status == 2) 
		isFormUpdate = confirm("반려하시겠습니까?");
	else if(status == 3)
		isFormUpdate = confirm("승인하시겠습니까?");
		
	if(isFormUpdate) {
		let form = document.getElementById('approvalForm');
		let formInput = document.createElement('input');
		
		form.setAttribute('action', context + 'approvals/' + approvalNo + '/status');
		formInput.setAttribute('name', 'status');
		formInput.setAttribute('value', status);
		
		form.appendChild(formInput);
		
		form.submit();
		formInput.remove();
	}
}

function deleteApproval(context, approvalNo) {
	let isFormDelete = confirm("정말 삭제하시겠습니까?");
	
	if(isFormDelete) {
		let form = document.getElementById('approval');
		alert(form);
		form.submit();
	}
}

function searchApproval() {
	let searchValue = document.getElementById('searchValue');
	let search = document.getElementById('search');
	let searchOption = search.options[search.selectedIndex].value;
	
	if(searchOption == 'date' || searchOption == 'checkDate') {
		searchValue.setAttribute('type', 'date');
	} else {
		searchValue.setAttribute('type', 'type');
	}
	
}