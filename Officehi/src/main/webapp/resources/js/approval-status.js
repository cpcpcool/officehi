function updateStatus(context, approvalNo, status) {
  let form = document.getElementById('approvalForm');
  let formInput = document.createElement('input');

  form.setAttribute('action', context + 'approvals/' + approvalNo + '/status');
  formInput.setAttribute('name', 'status');
  formInput.setAttribute('value', status);

  form.appendChild(formInput);

  form.submit();
  formInput.remove();
}