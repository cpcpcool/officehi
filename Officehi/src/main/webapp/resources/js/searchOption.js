// HTML 로드가 완료된 후 실행되는 함수
document.addEventListener("DOMContentLoaded", function () {
    // select 요소 가져오기
    var selectElement = document.querySelector('select[name="searchType"]');

    // select 요소에 change 이벤트 리스너 추가
    selectElement.addEventListener('change', function () {
        // 선택된 옵션 값 가져오기
        var selectedOption = selectElement.value;

        // 입력 필드 가져오기
        var inputElement = document.querySelector('input[name="name"]');

        // 선택된 옵션 값에 따라 입력 필드의 name 변경
        if (selectedOption === 'name') {
            inputElement.setAttribute('name', 'name');
        } else if (selectedOption === 'userNo') {
            inputElement.setAttribute('name', 'userNo');
        } else if (selectedOption === 'deptName') {
            inputElement.setAttribute('name', 'deptName');
        }
    });
});