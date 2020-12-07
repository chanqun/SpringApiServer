export default function Agreement(agreementBtnList, agreementInput, activateReserveButton) {
    this.agreementBtnList = agreementBtnList;
    this.agreementInput = agreementInput;
    this.inputValue = false;
    this.activateReserveButton = activateReserveButton;

    this.registerEvent();
}

Agreement.prototype = {
    registerEvent() {
        this.agreementBtnList.forEach((element) => {
            element.addEventListener("click", this.toggleAgreement.bind(this), event);
        })

        this.agreementInput.addEventListener("click", () => {
            this.inputValue = !this.inputValue;
            this.activateReserveButton();
        })
    },

    isAgreementTrue() {
        return this.inputValue;
    },

    toggleAgreement(event) {
        let agreement = event.target.closest(".terms");

        if (agreement) {
            agreement.classList.toggle("open");
            return;
        }
    }
}