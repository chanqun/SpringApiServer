import Agreement from "./module/agreement.js";
import Tel from "./module/tel.js";
import Email from "./module/email.js";

window.addEventListener("DOMContentLoaded", function() {
    const productId = getParameterByName("id");

    displayInfo.requestDispalyInfo(productId);

    const agreementButtonList = document.querySelectorAll('.agreement .btn_agreement');
    const agreementInput = document.querySelector('#chk3');
    const agreement = new Agreement(agreementButtonList, agreementInput, activateReserveButton);

    const telElement = document.querySelector('#tel');
    const telWarningElement = telElement.parentElement.parentElement.querySelector('.inline_form .warning_msg');
    const tel = new Tel(telElement, telWarningElement, activateReserveButton);

    const emailElement = document.querySelector('#email');
    const emailWarningElement = emailElement.parentElement.parentElement.querySelector('.inline_form .warning_msg');
    const email = new Email(emailElement, emailWarningElement, activateReserveButton);
})

let activateReserveButton = function() {
}