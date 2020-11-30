export default function Tel(telElement, warningElement, activateReserveButton) {
    this.telElement = telElement;
    this.warningElement = warningElement;
    this.inputValue = false;
    this.activateReserveButton = activateReserveButton;

    this.registerEvent();
}

Tel.prototype = {
    registerEvent() {
        this.telElement.addEventListener("input", (event) => {
            this.inputValue = event.target.value;
            this.activateReserveButton();

            if (this.validateTel()) {
                this.warningElement.classList.add("warning_msg");
            } else {
                this.warningElement.classList.remove("warning_msg");
            }
        })
    },

    validateTel() {
        const telRegExp = /^\d{2,3}-\d{3,4}-\d{4}$/;

        return telRegExp.test(this.inputValue);
    }
}