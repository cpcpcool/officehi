// class="retiredIcon"버튼을 클릭시
// 해당 버튼의 id 속성을 가져오고
 

$(".retiredIcon").click(function() {
	var id = $(this).attr("id");
				
	var choice = confirm("사번 : "+ id + "님을 퇴사처리 하시겠습니까?");
	console.log('choice :', choice);
	
	// 확인창에서 확인 클릭 시
	if(choice) {

		//id = userTable인 form:form을 찾아가서 => action 속성을가져 옴
		$('#userTable').attr('action', '/officehi/admin/employees/' + id + '/retired').submit();
		console.log('id');
	}
});	