$(".editButton").click(function() {
	
	var id = $(this).attr("id");

	$('#employeeInfo').attr('action', '/officehi/admin/employees/' + id).submit();

});