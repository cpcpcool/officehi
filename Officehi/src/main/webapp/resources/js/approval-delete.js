function delApprovl(context, approvalNo) {
	let form = document.createElement('form');
	let formInput = document.createElement('input');

	form.setAttribute('action', context + 'approvals/' + approvalNo + '/delete');
	form.setAttribute('method', 'post');

	formInput.setAttribute('type', 'input');
	formInput.setAttribute('name', 'approvalNo');
	formInput.setAttribute('value', approvalNo);

	form.appendChild(formInput);
	document.body.appendChild(form);
		
	form.submit();
	form.remove();
}
