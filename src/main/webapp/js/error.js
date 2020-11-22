let error = {
    errorCount: 0,

    alertRequestError(requestStatus) {
        if (requestStatus === 200) {
            return true;
        } else {
            if (error.errorCount === 0) {
                alert("요청하신 처리 과정에서 에러가 발생했습니다. 빠른 시간 내에 처리하겠습니다.");
                error.errorCount = 1;
            }

            return false;
        }
    }
}