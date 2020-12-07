export default function Popup(container, titleSpan, date, noButton, yesButton, exitButton) {
    this.container = container;
    this.titleSpan = titleSpan;
    this.date = date;
    this.noButton = noButton;
    this.yesButton = yesButton;
    this.exitButton = exitButton;
    this.reservationId = null;

    this.registerEvents();
}

Popup.prototype = {
    registerEvents() {
        this.yesButton.addEventListener("click", this.cancelReservation.bind(this));

        this.noButton.addEventListener("click", this.closePopup.bind(this));

        this.exitButton.addEventListener("click", this.closePopup.bind(this));
    },

    openPopup(reservationId, title, date) {
        this.container.style.display = "block";
        this.titleSpan.innerText = title;
        this.date.innerText = date;
        this.reservationId = reservationId;
    },

    closePopup() {
        this.container.style.display = "none";
    },

    cancelReservation() {
        const httpRequest = new XMLHttpRequest();
        httpRequest.open("PUT", "./api/reservations/" + this.reservationId);
        httpRequest.send();

        httpRequest.addEventListener("load", () => {
            if (!error.alertRequestError(httpRequest.status)) {
                return;
            }

            window.location.reload();
        })
    }
}