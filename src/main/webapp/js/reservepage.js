window.addEventListener("DOMContentLoaded", function() {
    const productId = getParameterByName("id");

    displayInfo.requestDispalyInfo(productId);

    bindEvent();
})

function bindEvent() {
    let bookingAgreementButton = document.querySelector(".section_booking_agreement");
    bookingAgreementButton.addEventListener("click", toggleAgreement);
}

function toggleAgreement(event) {
    
}