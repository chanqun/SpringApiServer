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
            element.addEventListener('click', (event) => {
                this.toggleAgreement(event);
            })
        })
        this.agreementInput.addEventListener('click', function() {
            this.inputValue = !this.inputValue;
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