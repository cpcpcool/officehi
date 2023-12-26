document.addEventListener("DOMContentLoaded", function () {
    // select 요소 가져오기
    var selectElement = document.querySelector('select[name="searchType"]');
    
    // 입력 필드 가져오기
    var inputElement = document.querySelector('input.searchInput');
    
    // select 요소에 change 이벤트 리스너 추가
    selectElement.addEventListener('change', function () {
        var selectedOption = selectElement.value; // 선택된 옵션 값 가져오기
        inputElement.setAttribute('name', selectedOption);
    });
});