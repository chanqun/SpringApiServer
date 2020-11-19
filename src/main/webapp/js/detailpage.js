window.addEventListener("DOMContentLoaded", function() {
    const productId = getParameterByName("id");
    const requestCommentCount = 3;

    product.requestProductDetail(productId);

    comment.requestComment(productId, requestCommentCount);
    comment.requestCommentInfo(productId);

    bindEvent();
})

function bindEvent() {
    let nextImageButton = document.querySelector(".nxt");
    let prevImageButton = document.querySelector(".prev");
    nextImageButton.addEventListener("click", moveImageArea);
    prevImageButton.addEventListener("click", moveImageArea);

    jQuery(".section_store_details>.bk_more").on("click", toggleDetailState);

    let reserveButton = document.querySelector(".bk_btn");
    reserveButton.addEventListener("click", moveReservePage);

    let infoTabList = document.querySelector(".info_tab_lst");
    infoTabList.addEventListener("click", toggleInfoTab);
}

function moveReservePage() {
    const productId = getParameterByName("id");
    location.href = "./reserve?id=" + productId;
}

function moveImageArea(event) {
    let moveImageButton = event.target.closest("div");
    let productImageArea = document.querySelector(".visual_img");

    if (product.productImageIndex == 0) {
        product.productImageIndex = 2;
    } else if (product.productImageIndex == 3) {
        product.productImageIndex = 1;
    }
    productImageArea.style.transition = "transform 0s";
    productImageArea.style.transform = "translate(" + product.productImageIndex * -100 + "%, 0)";

    setTimeout(() => {
        productImageArea.style.transition = "transform 0.3s ease-out";

        if (moveImageButton.classList.contains("prev_inn")) {
            product.productImageIndex--;
            changeImageIndex();
        } else if (moveImageButton.classList.contains("nxt_inn")) {
            product.productImageIndex++;
            changeImageIndex();
        }

        productImageArea.style.transform = "translate(" + product.productImageIndex * -100 + "%, 0)";
    }, 10);

}

function toggleInfoTab(event) {
    let infoLi = event.target.closest("li");
    let infoDetail = document.querySelector(".detail_info");
    let infoLocation = document.querySelector(".detail_location");

    if (infoLi.classList.contains("_detail")) {
        infoDetail.classList.remove("hide");
        infoLocation.classList.add("hide");
    } else if (infoLi.classList.contains("_path")) {
        infoLocation.classList.remove("hide");
        infoDetail.classList.add("hide");
    }

    toggleInfoTabCss(event.target.closest("a"));
    event.preventDefault();
}

function toggleInfoTabCss(infoTabAnchor) {
    let infoTabList = document.querySelectorAll(".info_tab_lst>li>a");

    infoTabList.forEach(function(target) {
        target.classList.remove("active");
    })
    infoTabAnchor.classList.add("active");
}

function toggleDetailState() {
    let $openButton = jQuery(".section_store_details>._open");
    let $closeButton = jQuery(".section_store_details>._close");
    let $detailArea = jQuery(".store_details");

    if ($openButton.css("display") === "block") {
        $openButton.css("display", "none");
        $closeButton.css("display", "block");
        $detailArea.removeClass("close3");
    } else if ($closeButton.css("display") === "block") {
        $openButton.css("display", "block");
        $closeButton.css("display", "none");
        $detailArea.addClass("close3");
    }
}

function changeImageTotalCount() {
    let imageTotalCount = document.querySelector(".figure_pagination>.off");
    imageTotalCount.innerText = "/ " + 2;
}

function changeImageIndex() {
    let imageIndex = document.querySelector(".figure_pagination>.num");
    let prevButton = document.querySelector(".prev_inn>a>i");

    if (imageIndex.innerText == 1) {
        imageIndex.innerText = 2;
        prevButton.classList.remove("off");
    } else if (imageIndex.innerText == 2) {
        imageIndex.innerText = 1;
        prevButton.classList.add("off");
    }
}

function deleteMovingButton() {
    let nextButton = document.querySelector(".nxt");
    let prevButton = document.querySelector(".prev");

    nextButton.style.display = "none";
    prevButton.style.display = "none";
}