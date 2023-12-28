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
		let form = document.getElementById('approval');
		let formInput = document.createElement('input');
		
		form.setAttribute('action', context + 'approvals/status/' + approvalNo);
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
		
		form.setAttribute('action', context + 'approvals/' + approvalNo);
		
		form.submit();
	}
}

function searchApproval() {
	let searchValue = document.getElementById('searchValue');
	let search = document.getElementById('search');
	let searchOption = search.options[search.selectedIndex].value;
	let searchError = document.getElementById('searchError');
	
	searchError.style.visibility = 'hidden';
	
	if(searchOption == 'date' || searchOption == 'checkDate') {
		searchValue.setAttribute('type', 'date');
	} else {
		searchValue.setAttribute('type', 'type');
	}
}

function searchValueIsNaN() {
	let searchValue = document.getElementById('searchValue');
	let searchOption = search.options[search.selectedIndex].value;
	let form = document.getElementById('searchForm');
	let searchError = document.getElementById('searchError');
	
	if(searchOption == 'approvalNo' && isNaN(searchValue.value)) {
		searchError.style.visibility = 'visible';
		searchError.innerText = '숫자만 입력하세요.';
	} else if(searchValue.value == '') {
		searchError.style.visibility = 'visible';
		searchError.innerText = '검색어를 입력하세요.';
	} else {
		form.submit();
	}
}

function searchType(paramSearch, paramSearchValue) {
	let selectedSearch = document.querySelector("option[value=" + paramSearch + "]");
	let searchValue = document.getElementById('searchValue');

	selectedSearch.setAttribute('selected','selected');
	searchValue.value = paramSearchValue;
}
