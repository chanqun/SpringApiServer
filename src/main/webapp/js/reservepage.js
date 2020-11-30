import Agreement from "./module/agreement.js";
import Tel from "./module/tel.js";
import Email from "./module/email.js";
import Ticket from "./module/ticket.js";

window.addEventListener("DOMContentLoaded", function() {
    const displayInfoId = getParameterByName("display");
    const productId = getParameterByName("display");

    displayInfo.requestDispalyInfo(displayInfoId, productId);

    const telElement = document.querySelector("#tel");
    const telWarningElement = telElement.parentElement.parentElement.querySelector(".inline_form .warning_msg");
    const tel = new Tel(telElement, telWarningElement, activateReserveButton);

    const emailElement = document.querySelector("#email");
    const emailWarningElement = emailElement.parentElement.parentElement.querySelector(".inline_form .warning_msg");
    const email = new Email(emailElement, emailWarningElement, activateReserveButton);

    const agreementButtonList = document.querySelectorAll(".agreement .btn_agreement");
    const agreementInput = document.querySelector("#chk3");
    const agreement = new Agreement(agreementButtonList, agreementInput, activateReserveButton);

    const bookButton = document.querySelector(".bk_btn_wrap");
    bookButton.addEventListener("click", reserveTicket);

    document.querySelector("#name").addEventListener("input", (event) => {
        name = event.target.value;
        activateReserveButton();
    })

    let addTicketButtonEventTimer = setTimeout(function addTicketEvent() {
        document.querySelectorAll(".qty").forEach(element => {
            const plusButton = element.querySelector(".ico_plus3");
            const minusButton = element.querySelector(".ico_minus3");
            const ticket = new Ticket(element, plusButton, minusButton, activateReserveButton);
        });

        if (document.querySelectorAll(".qty").length != 0) {
            clearTimeout(addTicketButtonEventTimer)
            return;
        }

        addTicketButtonEventTimer = setTimeout(addTicketEvent, 200);
    }, 0);

    function reserveTicket() {
        if (bookButton.classList.contains("disable")) {
            alert("예약을 위한 내용을 확인해주세요");
            return;
        }

        const ticketPrice = document.querySelectorAll('.qty');
        const price = [];
        ticketPrice.forEach((element) => {
            const ticketCount = parseInt(element.querySelector('.count_control_input').value);

            if (ticketCount) {
                price.push({
                    "count": ticketCount,
                    "productPriceId": parseInt(element.dataset.productPriceId),
                })
            }
        })

        const requestBody = {
            displayInfoId: parseInt(bookButton.dataset.displayInfoId),
            price: price,
            productId: parseInt(bookButton.dataset.productId),
            reservationEmail: document.querySelector('#email').value,
            reservationName: document.querySelector('#name').value,
            reservationTel: document.querySelector('#tel').value
        }

        const httpRequest = new XMLHttpRequest();

        httpRequest.open("POST", "./api/reservations");
        httpRequest.setRequestHeader("Content-Type", "application/json");
        httpRequest.send(JSON.stringify(requestBody));

        httpRequest.addEventListener("load", () => {
            if (!error.alertRequestError(httpRequest.status)) {
                return;
            }

            alert("예약이 완료되었습니다.");
            location.href = "./main";
        })
    }

    function activateReserveButton() {
        const totalCount = parseInt(document.querySelector("#totalCount").innerText);
        const name = document.querySelector("#name").value;

        if (name && tel.validateTel() && email.validateEmail() && agreement.isAgreementTrue() && totalCount) {
            bookButton.classList.remove("disable");
        } else {
            bookButton.classList.add("disable");
        }
    }
})