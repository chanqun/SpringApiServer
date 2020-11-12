const MORE_PRODUCT_COUNT = 4;
const INITIAL_CATEGORY_ID = 0;
let nowProductId = 0;

window.addEventListener("DOMContentLoaded", function() {
    getPromotion();
    getCategoryTab();
    getProduct(INITIAL_CATEGORY_ID, nowProductId);

    bindEvent();
})

function bindEvent() {
    let eventTabList = document.querySelector(".event_tab_lst");
    eventTabList.addEventListener("click", changeCategory);

    let getMoreProductButton = document.querySelector(".more>.btn");
    getMoreProductButton.addEventListener("click", getMoreProduct);

    let topButton = document.querySelector(".lnk_top_text");
    topButton.addEventListener("click", function() {
        window.scrollTo(0, 0);
    })
}

function changeCategory(event) {
    let categoryEventLi = event.target.closest("li");
    nowProductId = 0;

    changeCategoryCss(event.target.closest("a"));
    clearProductUl();
    getCategory(categoryEventLi);
    getProduct(categoryEventLi.dataset.category, nowProductId);
}

function getMoreProduct() {
    let categoryEventLi = document.querySelector(".active").closest("li");
    nowProductId += MORE_PRODUCT_COUNT;

    getProduct(categoryEventLi.dataset.category, nowProductId);
    showMoreButton();
}

function getPromotion() {
    let httpRequest = new XMLHttpRequest();

    httpRequest.addEventListener("load", function() {
        let promotions = JSON.parse(httpRequest.responseText);
        addSliding(promotions);
        setSlideShow();
    })

    httpRequest.open("GET", "./api/promotions", true);
    httpRequest.send();
}

function addSliding(promotions) {
    let promotionUl = document.querySelector("ul.visual_img");
    let promotionLi = "";

    promotions.forEach(element => {
        promotionLi += makePromotionItem(element);
    });
    if (promotions[0]) {
        promotionLi += makePromotionItem(promotions[0]);
    }

    promotionUl.innerHTML = promotionLi;
}

function makePromotionItem(element) {
    let promotionItemTemplate = document.querySelector("#promotionItem").innerText;
    let promotionItem = promotionItemTemplate
        .replace("{id}", element.id)
        .replace("{productId}", element.productId)
        .replace("{content}", element.content)
        .replace("{description}", element.description)
        .replace("{placeName}", element.placeName)

    return promotionItem;
}

function setSlideShow() {
    let promotionUl = document.querySelector(".visual_img");
    let imgCount = promotionUl.querySelectorAll("li").length;

    slideShow(promotionUl, imgCount);
}

function slideShow(promotionUl, imgCount) {
    let imageIndex = 0;

    setInterval(() => {
        promotionUl.style.transition = "transform 1s ease-out";
        promotionUl.style.transform = "translate(-" + 414 * (imageIndex + 1) + "px, 0)";
        imageIndex++;

        if (imageIndex === imgCount) {
            promotionUl.style.transition = "0s";
            promotionUl.style.transform = "translate(0, 0)";
            imageIndex = -1;
        }
    }, 1000)
}

function getCategoryTab() {
    let httpRequest = new XMLHttpRequest();

    httpRequest.addEventListener("load", function() {
        let categories = JSON.parse(httpRequest.responseText);
        let categoryTabList = "";
        let categoryTab = document.querySelector("#categoryTabLi").innerHTML;

        for (let category of categories) {
            categoryTabList += categoryTab
                .replace("{id}", category.id)
                .replace("{name}", category.name);
        }

        let categoryArea = document.querySelector("ul.event_tab_lst");
        categoryArea.innerHTML += categoryTabList;

        let totalCategoryLi = document.querySelector(".event_tab_lst>li");
        getCategory(totalCategoryLi);
    })

    httpRequest.open("GET", "./api/categories", true);
    httpRequest.send();
}

function getCategory(categoryEventLi) {
    let dataCategory = categoryEventLi.dataset.category;
    let httpRequest = new XMLHttpRequest();

    httpRequest.addEventListener("load", function() {
        let categories = JSON.parse(httpRequest.responseText);
        let totalCategory = 0;
        let countArea = document.querySelector(".event_lst_txt>span");

        for (let category of categories) {
            let categoryCount = category.count;
            totalCategory += categoryCount;
            if (category.id == dataCategory) {
                countArea.innerText = categoryCount + "개";
                countArea.dataset.count = categoryCount;
                break;
            }
        }

        if (dataCategory == 0) {
            countArea.innerText = totalCategory + "개";
            countArea.dataset.count = totalCategory;
        }

        showMoreButton();
    })

    httpRequest.open("GET", "./api/categories", true);
    httpRequest.send();
}

function showMoreButton() {
    let typeTotalCount = document.querySelector(".event_lst_txt>span").dataset.count;
    let productArea = document.querySelector(".more");

    if (typeTotalCount > nowProductId + MORE_PRODUCT_COUNT) {
        productArea.style.display = "block";
    } else {
        productArea.style.display = "none";
    }
}

function clearProductUl() {
    let productUl = document.querySelectorAll("ul.lst_event_box");
    productUl[0].innerText = "";
    productUl[1].innerText = "";
}

function changeCategoryCss(categoryEventAnchor) {
    let eventTabList = document.querySelectorAll(".event_tab_lst>li>a");
    eventTabList.forEach(function(target) {
        target.classList.remove("active");
    })
    categoryEventAnchor.classList.add("active");
}

function getProduct(categoryId, start) {
    let httpRequest = new XMLHttpRequest();

    httpRequest.addEventListener("load", function() {
        let products = JSON.parse(httpRequest.responseText);
        addProduct(products);
    })

    httpRequest.open("GET", "./api/products?categoryId=" + categoryId + "&start=" + start, true);
    httpRequest.send();
}

function addProduct(products) {
    let productUl = document.querySelectorAll("ul.lst_event_box");
    let productItem = document.querySelector("#itemList").innerText;
    let productLiLeft = productUl[0].innerHTML;
    let productLiRight = productUl[1].innerHTML;
    let isLeft = true;

    products.forEach(element => {
        let productContent = productItem
            .replace("{detailId}", element.id)
            .replace("{id}", element.id)
            .replace("{imageId}", element.imageId)
            .replace("{description}", element.description)
            .replace("{descriptionText}", element.description)
            .replace("{placeName}", element.placeName)
            .replace("{content}", element.content)

        if (isLeft) {
            productLiLeft += productContent;
            isLeft = false;
        } else {
            productLiRight += productContent;
            isLeft = true;
        }
    });

    productUl[0].innerHTML = productLiLeft;
    productUl[1].innerHTML = productLiRight;
}