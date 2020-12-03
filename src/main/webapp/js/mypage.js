import Popup from "./module/popup.js";

document.addEventListener("DOMContentLoaded", () => {
    setCardCount();

    const popupWrapper = document.querySelector(".popup_booking_wrapper");
    const noButton = popupWrapper.querySelector(".btn_gray");
    const yesButton = popupWrapper.querySelector(".btn_green");
    const titleSpan = popupWrapper.querySelector(".pop_tit span");
    const date = popupWrapper.querySelector(".pop_tit small");
    const exitButton = popupWrapper.querySelector(".popup_btn_close");
    const popup = new Popup(popupWrapper, titleSpan, date, noButton, yesButton, exitButton);

    document.querySelectorAll(".cancelbtn").forEach((element) => {
        element.addEventListener("click", () => {
            const cardElement = element.parentElement.parentElement;
            popup.openPopup(element.dataset.id, cardElement.querySelector(".tit").innerText, cardElement.querySelector(".detail li:nth-child(1) .item_dsc").innerText);
        })
    })

    document.querySelectorAll(".reviewBtn").forEach((element) => {
        element.addEventListener("click", () => {
            location.href = "./reviewWrite?productId=" + element.dataset.productId + "&reservationInfoId=" + element.dataset.reservationInfoId + "&description=" + element.dataset.description;
        })
    })

    function setCardCount() {
        let confirmedCount = document.querySelectorAll(".card.confirmed>article").length;
        let usedCount = document.querySelectorAll(".card.used_check>article").length;
        let cancelCount = document.querySelectorAll(".card.cancel>article").length;

        let confirmedCountArea = document.querySelector("#confirmedCount");
        let usedCountArea = document.querySelector("#usedCount");
        let cancelCountArea = document.querySelector("#cancelCount");

        confirmedCountArea.innerText = confirmedCount;
        usedCountArea.innerText = usedCount;
        cancelCountArea.innerText = cancelCount;
    }
})