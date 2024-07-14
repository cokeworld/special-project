$(document).ready(function() {
    // 초기 로그인 상태 확인 (여기서는 간단하게 로컬 스토리지 사용)
    const loggedInUser = localStorage.getItem('loggedInUser');
    if (loggedInUser) {
        $('#userName').text(loggedInUser);
        $('#loginBtnContainer').addClass('d-none');
        $('#userContainer').removeClass('d-none');
    }

    // 로그인 폼 제출 이벤트
    $('#loginForm').on('submit', function(event) {
        event.preventDefault(); // 폼 제출 기본 동작 방지
        const userId = $('#loginId').val();
        const password = $('#loginPassword').val();

        // 여기에 실제 인증 로직을 추가해야 합니다.
        // 예시로 간단히 사용자 이름을 저장
        if (userId && password) {
            localStorage.setItem('loggedInUser', userId);
            $('#userName').text(userId);
            $('#loginBtnContainer').addClass('d-none');
            $('#userContainer').removeClass('d-none');
            $('#loginModal').modal('hide');
            $('#loginForm')[0].reset();
        }
    });

    // 로그아웃 버튼 클릭 이벤트
    $('#logoutBtn').on('click', function() {
        localStorage.removeItem('loggedInUser');
        $('#loginBtnContainer').removeClass('d-none');
        $('#userContainer').addClass('d-none');
    });

    // 행 삭제 버튼 클릭 이벤트
    $(document).on('click', '.delete-row', function() {
        $(this).closest('tr').remove();
    });

    // 행 추가 버튼 클릭 이벤트
    // $('#addRow').on('click', function() {
    //     const newRow = `
    // <tr>
    //   <td><input type="text" class="form-control" placeholder="Enter name"></td>
    //   <td>
    //     <select class="form-select">
    //       <option value="DHL">DHL</option>
    //       <option value="FedEx">FedEx</option>
    //       <option value="UPS">UPS</option>
    //       <option value="USPS">USPS</option>
    //     </select>
    //   </td>
    //   <td>
    //     <select class="form-select">
    //       <option value="Visible">Visible</option>
    //       <option value="Hidden">Hidden</option>
    //     </select>
    //   </td>
    //   <td><input type="text" class="form-control" placeholder="Enter tracking number"></td>
    //   <td>
    //     <button class="btn btn-primary btn-sm save-row">완료</button>
    //     <button class="btn btn-light btn-sm connect-row">운송장조회</button>
    //     <button class="btn btn-danger btn-sm delete-row">삭제</button>
    //   </td>
    // </tr>`;
    //     $('#tableBody').append(newRow);
    // });

    // 저장 버튼
    $('#saveDelivery').on('click', function(event) {
        event.preventDefault();

        const toastElement = $('#saveToast');
        let toast = new bootstrap.Toast(toastElement, {
            delay: 3000
        });

        const deliveryTitle = $('#saveDeliveryTitle').val();
        const deliveryCompanyId = $('#saveDeliveryCompanyId').val();
        const deliveryNumber = $('#saveDeliveryNumber').val();

        // 유효성 체크
        if (deliveryTitle === '') {
            alert('택배 상품명을 입력해주세요');
            return;
        }
        if (deliveryCompanyId === '0') {
            alert('택배사를 선택해주세요');
            return;
        }
        if (deliveryNumber === '') {
            alert('운송장번호를 입력해주세요');
            return;
        }

        const requestData = {
            title : deliveryTitle,
            deliveryCompanyId : deliveryCompanyId,
            deliveryNumber : deliveryNumber,
            status : 1,
            memberId: 1
        };

        // TODO: promise로 변경
        $.ajax({
            url: '/api/v1/delivery',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(requestData),
            success: function(response) {
                // 모달 닫기
                const modal = $('#saveModal');
                const modalInstance = bootstrap.Modal.getInstance(modal);
                if (modalInstance) {
                    modalInstance.hide();
                }

                // 알림 노출
                toastElement.find('.toast-body').text('저장 완료');
                toast.show();

                // 택배 목록 갱신
            },
            error: function(error) {
                toastElement.find('.toast-body').text('저장 실패. 다시 시도해주세요.');
                toast.show();

                console.log(error);
            }
        });
    });

    // 운송장 조회
    // 현재 CJ대한통운만 구현 완료
    $('.connectDeliveryButton').on('click', function() {
        const row = $(this).closest('tr');

        const deliveryCompanyId = row.find('.deliveryCompanyId').attr('data-deliverycompanyid');
        const deliveryNumber = row.find('.deliveryNumber').text();

        // todo: deliveryCompanyId에 따라 url, params 분기처리
        const url = `https://trace.cjlogistics.com/web/info.jsp`;
        const params = {
            slipno: deliveryNumber
        };

        const queryParams = new URLSearchParams(params);
        const query = queryParams.toString();

        window.open(`${url}?${query}`, '_blank');
    });

    // 수정 버튼을 통한 수정모달 열기
    $('.openDeliveryEditModalButton').on('click', (event) => {
        const row = $(event.currentTarget).closest('tr');

        const deliveryId = row.find('.deliveryId').text();
        const deliveryTitle = row.find('.deliveryTitle').text();
        const deliveryCompanyId = row.find('.deliveryCompanyId').attr('data-deliverycompanyid');
        const deliveryNumber = row.find('.deliveryNumber').text();

        // 수정 모달 정보 수정
        const modal = $('#editModal');
        $('#editDeliveryId').val(deliveryId);
        $('#editDeliveryTitle').val(deliveryTitle);
        $('#editDeliveryCompanyId').val(deliveryCompanyId);
        $('#editDeliveryNumber').val(deliveryNumber);


        // const modalInstance = bootstrap.Modal.getInstance(modal);
        // if (modalInstance) {
        //     modalInstance.show();
        // }

    });

    // 수정 모달 내에서 수정 실행
    $('#editDelivery').on('click', (event) => {
        event.preventDefault();

        const toastElement = $('#saveToast');
        let toast = new bootstrap.Toast(toastElement, {
            delay: 3000
        });

        // ajax 호출
        // 데이터 가져오기
        const modal = $('#editModal');

        const deliveryId = $('#editDeliveryId').val();
        const deliveryTitle = $('#editDeliveryTitle').val();
        const deliveryCompanyId = $('#editDeliveryCompanyId').val();
        const deliveryNumber = $('#editDeliveryNumber').val();


        const requestData = {
            title : deliveryTitle,
            deliveryCompanyId : deliveryCompanyId,
            deliveryNumber : deliveryNumber,
            status : 1,
            memberId: 1
        };

        // TODO: promise로 변경
        $.ajax({
            url: `/api/v1/delivery/${deliveryId}`,
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(requestData),
            success: function(response) {
                // 모달 닫기
                const modal = $('#saveModal');
                const modalInstance = bootstrap.Modal.getInstance(modal);
                if (modalInstance) {
                    modalInstance.hide();
                }

                // 토스트 노출
                toastElement.find('.toast-body').text('수정 완료');
                toast.show();

                // 택배 목록 갱신
            },
            error: function(error) {
                toastElement.find('.toast-body').text('수정 실패. 다시 시도해주세요.');
                toast.show();

                console.log(error);
            }
        });
    });

});