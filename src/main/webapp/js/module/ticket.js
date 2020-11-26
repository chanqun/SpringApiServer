export default function Ticket(ticketBody, plusButton, minusButton, activateReserveButton) {
    this.ticketPrice = Number(ticketBody.querySelector(".price").innerText.replace(",", ""));
    this.ticketBody = ticketBody;
    this.plusButton = plusButton;
    this.minusButton = minusButton;
    this.activateReserveButton = activateReserveButton;

    this.registerEvent();
    this.setTotalTicketCount();
}

Ticket.prototype = {
    registerEvent() {
        this.minusButton.addEventListener("click", this.ticketCountHandler.bind(this));
        this.plusButton.addEventListener("click", this.ticketCountHandler.bind(this));
    },

    ticketCountHandler(event) {
        const countElement = this.ticketBody.querySelector(".count_control_input");
        let count = 0;

        if (event.target.className.includes("ico_minus3")) {
            count = Number(countElement.getAttribute("value")) - 1;
        } else if (event.target.className.includes("ico_plus3")) {
            count = Number(countElement.getAttribute("value")) + 1;
        }

        if (count < 0) {
            count = 0;
            return;
        }

        if (count <= 0) {
            countElement.classList.add("disabled");
            this.ticketBody.querySelector(".ico_minus3").classList.add("disabled");
        } else if (count >= 1) {
            countElement.classList.remove("disabled");
            this.ticketBody.querySelector(".ico_minus3").classList.remove("disabled");
        }

        this.ticketBody.querySelector(".count_control_input").setAttribute("value", count);
        this.ticketBody.querySelector(".total_price").innerText = (this.ticketPrice * count).toLocaleString();
        this.setTotalTicketCount();
    },

    setTotalTicketCount() {
        const ticketCountList = document.querySelectorAll(".count_control_input");
        let totalCount = 0;

        for (let ticketCount of ticketCountList) {
            totalCount += Number(ticketCount.getAttribute("value"));
        }

        document.querySelector("#totalCount").innerText = totalCount;
        this.activateReserveButton();
    }
}