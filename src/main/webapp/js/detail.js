window.addEventListener("DOMContentLoaded", function() {
    const productId = getParameterByName("id");

    getProductImage(productId);
    getProductDetail(productId);

    bindEvent();
})

function bindEvent() {
    let infoTabList = document.querySelector(".info_tab_lst");
    infoTabList.addEventListener("click", changeInfoTab);

    $(".section_store_details>.bk_more").on("click", changeDetailState);
}

function getProductImage(productId) {
    let httpRequest = new XMLHttpRequest();

    httpRequest.addEventListener("load", function() {
        let productImage = JSON.parse(httpRequest.responseText);

        setProductImage(productImage);
    })

    httpRequest.open("GET", "./api/productimage/" + productId, true);
    httpRequest.send();
}

function setProductImage(productImage) {
    let visualImageArea = document.querySelector(".container_visual>ul");
    let visualImageTemplate = document.querySelector("#visualImageList").innerText;
    let bindTemplate = Handlebars.compile(visualImageTemplate);
    let visualImage = "";

    productImage.forEach(element => {
        visualImage += bindTemplate(element);
    })

    visualImageArea.innerHTML = visualImage;
}

function getProductDetail(productId) {
    let httpRequest = new XMLHttpRequest();

    httpRequest.addEventListener("load", function() {
        let productDetail = JSON.parse(httpRequest.responseText);
        setProductDetail(productDetail);
    })

    httpRequest.open("GET", "./api/products/" + productId, true);
    httpRequest.send();
}

function setProductDetail(productDetail) {
    let descriptionParagrph = document.querySelector(".dsc");
    descriptionParagrph.innerText = productDetail.content;

    let innerDescriptionParagrph = document.querySelector(".detail_info_lst>.in_dsc");
    innerDescriptionParagrph.innerText = productDetail.content;

    let detailLocationDiv = document.querySelector(".detail_location");
    let detailLocationTemplate = document.querySelector("#detailLocation").innerText;
    let bindTemplate = Handlebars.compile(detailLocationTemplate);
    detailLocationDiv.innerHTML = bindTemplate(productDetail);
}

function changeInfoTab(event) {
    let infoLiText = event.target.closest("a").innerText;
    let infoDetail = document.querySelector(".detail_info");
    let infoLocation = document.querySelector(".detail_location");

    if (infoLiText === "상세정보") {
        infoDetail.classList.remove("hide");
        infoLocation.classList.add("hide");
    } else if (infoLiText === "오시는길") {
        infoLocation.classList.remove("hide");
        infoDetail.classList.add("hide");
    }

    changeInfoTabCss(event.target.closest("a"));
    event.preventDefault();
}

function changeInfoTabCss(infoTabAnchor) {
    let infoTabList = document.querySelectorAll(".info_tab_lst>li>a");

    infoTabList.forEach(function(target) {
        target.classList.remove("active");
    })
    infoTabAnchor.classList.add("active");
}

function changeDetailState() {
    let openButton = $(".section_store_details>._open");
    let closeButton = $(".section_store_details>._close");
    let detailArea = $(".store_details");

    if (openButton.css("display") === "block") {
        openButton.css("display", "none");
        closeButton.css("display", "block");
        detailArea.removeClass("close3");
    } else if (closeButton.css("display") === "block") {
        openButton.css("display", "block");
        closeButton.css("display", "none");
        detailArea.addClass("close3");
    }
}

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");

    let regex = new RegExp("[\\?&]" + name + "=([^&#]*)");
    let results = regex.exec(location.search);

    if (results) {
        return decodeURIComponent(results[1].replace(/\+/g, " "));
    } else {
        return "";
    }
}