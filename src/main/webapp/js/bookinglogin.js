window.addEventListener("DOMContentLoaded", function() {
    const emailElement = document.querySelector("#resrv_id");
    const warningElement = document.querySelector(".warning_msg");
    const email = new Email(emailElement, warningElement);

    const loginButton = document.querySelector(".login_btn");

    loginButton.addEventListener("click", function() {
        if (!email.validateEmail()) {
            alert("이메일을 확인해주세요");
            return;
        }

        let emailForm = document.querySelector("#form1");
        emailForm.submit();
    })
})

Email.prototype = {
    registerEvent() {
        this.emailElement.addEventListener("input", (event) => {
            this.inputValue = event.target.value;

            if (this.validateEmail()) {
                this.warningElement.style.display = "none";
            } else {
                this.warningElement.style.display = "block";
            }
        })
    },

    validateEmail() {
        const emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;

        return emailRegExp.test(this.inputValue);
    }
}

function Email(emailElement, warningElement) {
    this.emailElement = emailElement;
    this.warningElement = warningElement;
    this.inputValue = false;

    this.registerEvent();
}