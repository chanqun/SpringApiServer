export default function Email(emailElement, warningElement, activateReserveButton) {
    this.emailElement = emailElement;
    this.warningElement = warningElement;
    this.inputValue = false;
    this.activateReserveButton = activateReserveButton;

    this.registerEvent();
}

Email.prototype = {
    registerEvent() {
        this.emailElement.addEventListener("input", (event) => {
            this.inputValue = event.target.value;
            this.activateReserveButton();

            if (this.validateEmail()) {
                this.warningElement.classList.add("warning_msg");
            } else {
                this.warningElement.classList.remove("warning_msg");
            }
        })
    },

    validateEmail() {
        const emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;

        return emailRegExp.test(this.inputValue);
    }
}