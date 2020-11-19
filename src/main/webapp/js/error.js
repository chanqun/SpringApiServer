let error = {
    alertRequestError(requestStatus) {
        if (requestStatus === 200) {
            return true;
        } else {
            alert("요청하신 처리 과정에서 에러가 발생했습니다. 빠른 시간 내에 처리하겠습니다.");
            return false;
        }
    }
}
