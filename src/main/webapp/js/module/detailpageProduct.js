let product = {
    productImageIndex: 0,

    requestProductImage(productId) {
        let httpRequest = new XMLHttpRequest();

        httpRequest.addEventListener("load", function() {
            if (!error.alertRequestError(httpRequest.status)) {
                return;
            }

            let productImage = JSON.parse(httpRequest.responseText);

            product.showProductImage(productImage[0]);
            if (productImage.length >= 2) {
                product.showMoreProductImage(productImage[1]);
            } else {
                product.showMoreProductImage();
            }
        })

        httpRequest.open("GET", "./api/productimage/" + productId, true);
        httpRequest.send();
    },

    showMoreProductImage(productImage) {
        if (!productImage) {
            deleteMovingButton();
            return;
        }

        changeImageTotalCount();

        let firstImage = document.querySelector(".visual_img").innerHTML;

        let visualImageArea = document.querySelector(".container_visual>ul");
        let visualImageTemplate = document.querySelector("#visualImageList").innerText;
        let bindTemplate = Handlebars.compile(visualImageTemplate);
        let visualImage = "";

        visualImage += bindTemplate(productImage);

        visualImageArea.innerHTML += visualImage;
        visualImageArea.innerHTML += firstImage;
        visualImageArea.innerHTML += visualImage;
    },

    requestProductDetail(productId, displayInfoId) {
        let httpRequest = new XMLHttpRequest();

        httpRequest.addEventListener("load", function() {
            if (!error.alertRequestError(httpRequest.status)) {
                return;
            }

            let productDetail = JSON.parse(httpRequest.responseText);
            product.showProductDetail(productDetail);
            product.showProductEvent(productDetail);
            product.requestProductImage(productId);
        })

        httpRequest.open("GET", "./api/products/" + displayInfoId, true);
        httpRequest.send();
    },

    showProductDetail(productDetail) {
        let descriptionParagrph = document.querySelector(".dsc");
        descriptionParagrph.innerText = productDetail.content;

        let innerDescriptionParagrph = document.querySelector(".detail_info_lst>.in_dsc");
        innerDescriptionParagrph.innerText = productDetail.content;

        let detailLocationDiv = document.querySelector(".detail_location");
        let detailLocationTemplate = document.querySelector("#detailLocation").innerText;
        let bindTemplate = Handlebars.compile(detailLocationTemplate);
        detailLocationDiv.innerHTML = bindTemplate(productDetail);
    },

    showProductEvent(productDetail) {
        if (productDetail.event) {
            let eventInfoTextArea = document.querySelector(".in_dsc");

            eventInfoTextArea.innerText += productDetail.event;
        } else {
            let eventInfoArea = document.querySelector(".event_info_box");

            eventInfoArea.style.display = "none";
        }
    },

    showProductImage(productImage) {
        let visualImageArea = document.querySelector(".container_visual>ul");
        let visualImageTemplate = document.querySelector("#visualImageList").innerText;
        let bindTemplate = Handlebars.compile(visualImageTemplate);
        let visualImage = "";

        visualImage += bindTemplate(productImage);

        visualImageArea.innerHTML += visualImage;
    }
}