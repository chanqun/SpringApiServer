let displayInfo = {
    requestDispalyInfo(displayInfoId, productId) {
        let httpRequest = new XMLHttpRequest();

        httpRequest.addEventListener("load", function() {
            if (!error.alertRequestError(httpRequest.status)) {
                return;
            }

            let displayInformation = JSON.parse(httpRequest.responseText);
            displayInfo.showDisplayImage(displayInformation);
            displayInfo.showDisplayInfo(displayInformation);

            displayInfo.requestProductPrice(productId);
        })

        httpRequest.open("GET", "./api/displayinfo/" + displayInfoId, true);
        httpRequest.send();
    },

    showDisplayImage(displayInformation) {
        let displayImageArea = document.querySelector(".group_visual");
        let displayImageTemplate = document.querySelector("#displayImage").innerText;
        let bindTemplate = Handlebars.compile(displayImageTemplate);
        let displayImage = "";

        displayImage += bindTemplate(displayInformation);

        displayImageArea.innerHTML += displayImage;
    },

    showDisplayInfo(displayInformation) {
        let bookButton = document.querySelector(".bk_btn_wrap");
        bookButton.dataset.productId = displayInformation.productId;
        bookButton.dataset.displayInfoId = displayInformation.id;

        let topTitleArea = document.querySelector(".title");
        topTitleArea.innerText = displayInformation.description;

        let displayInfoArea = document.querySelector(".store_details");
        let displayInfoTemplate = document.querySelector("#displayInfoDetail").innerText;
        let bindTemplate = Handlebars.compile(displayInfoTemplate);
        let displayInfo = "";

        displayInfo += bindTemplate(displayInformation);

        displayInfoArea.innerHTML += displayInfo;
    },

    requestProductPrice(productId) {
        let httpRequest = new XMLHttpRequest();

        httpRequest.addEventListener("load", function() {
            if (!error.alertRequestError(httpRequest.status)) {
                return;
            }

            let productPrice = JSON.parse(httpRequest.responseText);
            displayInfo.showProductPrice(productPrice);
            displayInfo.showDisplayPrice(productPrice);
        })

        httpRequest.open("GET", "./api/productprice/" + productId, true);
        httpRequest.send();
    },

    showDisplayPrice(productPrice) {
        let displayInfoArea = document.querySelector(".store_details");
        let displayPriceTemplate = document.querySelector("#feeInfo").innerText;
        let bindTemplate = Handlebars.compile(displayPriceTemplate);
        let displayPriceInfo = "";

        productPrice.forEach(element => {
            displayPriceInfo += bindTemplate(element);
        })

        displayInfoArea.innerHTML += displayPriceInfo;
    },

    showProductPrice(productPrice) {
        let bookingTicketArea = document.querySelector(".ticket_body");
        let ticketTemplate = document.querySelector("#ticketPrice").innerText;
        let bindTemplate = Handlebars.compile(ticketTemplate);
        let ticketInfo = "";

        productPrice.forEach(element => {
            ticketInfo += bindTemplate(element);
        });

        bookingTicketArea.innerHTML += ticketInfo;
    }
}