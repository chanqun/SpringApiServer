window.addEventListener("DOMContentLoaded", function() {
    const productId = getParameterByName("id");
    const allCommentRequestNumber = 0;

    comment.requestComment(productId, allCommentRequestNumber);
    comment.requestCommentInfo(productId);

    drawProductTitle(productId);
})

function drawProductTitle(productId) {
    let httpRequest = new XMLHttpRequest();

    httpRequest.addEventListener("load", function() {
<<<<<<< HEAD
        if (!error.alertRequestError(httpRequest.status)) {
            return;
        }

=======
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e
        let productInfo = JSON.parse(httpRequest.responseText);
        let titleAnchor = document.querySelector(".top_title .title");

        let titleText = "";
<<<<<<< HEAD
        titleText += productInfo.placeLot;
=======
        titleText += productInfo.description;
>>>>>>> bfd249f7d67ddcebe5c4caeb50018da9619fee7e

        titleAnchor.innerText = titleText;
    })

    httpRequest.open("GET", "./api/products/" + productId, true);
    httpRequest.send();
}