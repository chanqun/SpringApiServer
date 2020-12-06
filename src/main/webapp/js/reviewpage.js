window.addEventListener("DOMContentLoaded", function() {
    const productId = getParameterByName("id");
    const displayInfoId = getParameterByName("display");
    const allCommentRequestNumber = 0;

    comment.requestComment(productId, allCommentRequestNumber);
    comment.requestCommentInfo(productId);

    drawProductTitle(displayInfoId);
})

function drawProductTitle(displayInfoId) {
    let httpRequest = new XMLHttpRequest();

    httpRequest.addEventListener("load", function() {
        if (!error.alertRequestError(httpRequest.status)) {
            return;
        }

        let productInfo = JSON.parse(httpRequest.responseText);
        let titleAnchor = document.querySelector(".top_title .title");

        let titleText = "";
        titleText += productInfo.placeLot;

        titleAnchor.innerText = titleText;
    })

    httpRequest.open("GET", "./api/products/" + displayInfoId, true);
    httpRequest.send();
}