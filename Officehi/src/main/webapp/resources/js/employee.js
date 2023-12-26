/**
 * @author 박재용
 * @editDate 23.12.20 ~ 23.12.22
 */

$(".retiredIcon").click(function() {
	var id = $(this).attr("id");
	var name = $(this).attr("name");
				
	var choice = confirm("사번 : "+ id + " / " + name + "님을 퇴사처리 하시겠습니까?");
	console.log('choice :', choice);
	
	// 확인창에서 확인 클릭 시
	if(choice) {

		// id = userTable인 form:form을 찾아가서 => action 속성을가져 옴
		$('#userTable').attr('action', '/officehi/admin/employees/' + id + '/retired').submit();
		console.log('id');
	}
});			